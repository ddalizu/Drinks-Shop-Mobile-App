package com.example.apt3060;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.SaleViewHolder> {

    private final List<Sale> saleList;

    public recyclerAdapter(List<Sale> saleList) {
        this.saleList = saleList;
    }

    @NonNull
    @Override
    public SaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vieworder_recycler, parent, false);
        return new SaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleViewHolder holder, int position) {
        Sale sale = saleList.get(position);
        SaleItem item = sale.getItems().get(0); // Assumes at least one item per sale

        holder.customerId.setText(sale.getCustomerId());
        holder.drinkId.setText(item.getDrinkId());
        holder.price.setText(String.valueOf(item.getPrice()));
        holder.quantity.setText(String.valueOf(item.getQuantity()));
        holder.branch.setText(sale.getBranch());
        holder.totalAmount.setText(String.valueOf(sale.getTotal())); // Assuming `total` is the correct field name
    }

    @Override
    public int getItemCount() {
        return saleList.size();
    }

    public static class SaleViewHolder extends RecyclerView.ViewHolder {
        public TextView customerId, drinkId, price, quantity, branch, totalAmount;

        public SaleViewHolder(View itemView) {
            super(itemView);
            customerId = itemView.findViewById(R.id.customer_id);
            drinkId = itemView.findViewById(R.id.drink_id);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            branch = itemView.findViewById(R.id.branch);
            totalAmount = itemView.findViewById(R.id.total_amount);
        }
    }
}
