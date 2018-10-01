package com.test.botalov.resultanttestapplication.Main.View.ListAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.test.botalov.resultanttestapplication.Main.Model.Entities.Data;
import com.test.botalov.resultanttestapplication.R;

public class DataListAdapter extends RecyclerView.Adapter<DataViewHolder> {
    private Data data;

    public void setData(Data data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_item_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int i) {
        dataViewHolder.bind(data.getStock().get(i));
    }

    @Override
    public int getItemCount() {
        if(data == null || data.getStock() == null) {
            return 0;
        }
        return data.getStock().size();
    }
}
