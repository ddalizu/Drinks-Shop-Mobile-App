
package com.example.apt3060;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> {

    private final List<Drink> drinkList;

    public InventoryAdapter(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewinventory_recycler, parent, false);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {
        Drink drink = drinkList.get(position);
        holder.drinkId.setText(drink.getName()); // Update with actual ID field if available
        holder.drinkName.setText(drink.getName());
        holder.price.setText(String.valueOf(drink.getPrice()));
        holder.quantity.setText(String.valueOf(drink.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public static class InventoryViewHolder extends RecyclerView.ViewHolder {
        public TextView drinkId, drinkName, price, quantity;

        public InventoryViewHolder(View itemView) {
            super(itemView);
            drinkId = itemView.findViewById(R.id.drink_id);
            drinkName = itemView.findViewById(R.id.drink_name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}
