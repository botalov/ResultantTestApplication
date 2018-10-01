package com.test.botalov.resultanttestapplication.Main.View.ListAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.botalov.resultanttestapplication.Main.Model.Entities.Stock;
import com.test.botalov.resultanttestapplication.R;

import java.util.Locale;

class DataViewHolder extends RecyclerView.ViewHolder {
    DataViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void bind(Stock stock) {
        if (stock != null) {
            TextView nameTextView = itemView.findViewById(R.id.name_text_view);
            nameTextView.setText(stock.getName());

            TextView priceTextView = itemView.findViewById(R.id.price_text_view);
            priceTextView.setText(String.valueOf(stock.getVolume()));

            if (stock.getPrice() != null) {
                TextView amountTextView = itemView.findViewById(R.id.amount_text_view);
                amountTextView.setText(String.format(Locale.getDefault(), "%.2f", stock.getPrice().getAmount()));
            }
        }
    }
}
