package com.test.botalov.resultanttestapplication.Launch.VIew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.test.botalov.resultanttestapplication.Launch.Presenter.ILaunchPresenter;
import com.test.botalov.resultanttestapplication.Launch.Presenter.LaunchPresenter;
import com.test.botalov.resultanttestapplication.R;

public class LaunchActivity extends AppCompatActivity implements ILaunchView {

    private ILaunchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        presenter = new LaunchPresenter();
        presenter.attachView(this);

        initViews();
    }

    private void initViews() {
        ImageButton showImageButton = findViewById(R.id.show_image_button);
        showImageButton.setOnClickListener(v->{
            presenter.onShowMainView();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null) {
            presenter.detachView();
        }
    }
}
