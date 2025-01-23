package com.example.apt3060;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ReceiptAdapter extends RecyclerView.Adapter<ReceiptAdapter.ReceiptViewHolder> {

    private final ArrayList<ReceiptItem> receiptItems;

    public ReceiptAdapter(ArrayList<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
    }

    @NonNull
    @Override
    public ReceiptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receipt, parent, false);
        return new ReceiptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceiptViewHolder holder, int position) {
        ReceiptItem item = receiptItems.get(position);
        holder.txtDrinkName.setText(item.getDrinkName());
        holder.txtQuantity.setText(String.valueOf(item.getQuantity()));
        holder.txtPrice.setText("KSHS " + item.getPrice());
    }

    @Override
    public int getItemCount() {
        return receiptItems.size();
    }

    public static class ReceiptViewHolder extends RecyclerView.ViewHolder {
        TextView txtDrinkName, txtQuantity, txtPrice;

        public ReceiptViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDrinkName = itemView.findViewById(R.id.txt_drink_name);
            txtQuantity = itemView.findViewById(R.id.txt_quantity);
            txtPrice = itemView.findViewById(R.id.txt_price);
        }
    }
}
