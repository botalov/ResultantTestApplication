package com.test.botalov.resultanttestapplication.Main.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.test.botalov.resultanttestapplication.Main.Model.Entities.Data;
import com.test.botalov.resultanttestapplication.Main.Presenter.MainPresenter;
import com.test.botalov.resultanttestapplication.Main.View.ListAdapter.DataListAdapter;
import com.test.botalov.resultanttestapplication.R;

public class MainActivity extends AppCompatActivity implements IMainView {
    private MainPresenter presenter;
    private ProgressBar loadProgressBar;
    private RecyclerView recyclerView;

    private DataListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.attachView(this);

        initViews();

        presenter.onLoad();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void initViews(){
        loadProgressBar = findViewById(R.id.load_progress_bar);

        recyclerView = findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataListAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoader() {
        loadProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        loadProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(this, getString(R.string.error_message_load_data), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateData(Data data) {
        adapter.setData(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_update:
                if(presenter != null) {
                    presenter.onUpdate();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
