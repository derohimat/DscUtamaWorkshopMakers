package com.dscutama.readapi.features.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dscutama.readapi.R;
import com.dscutama.readapi.data.model.response.Record;
import com.dscutama.readapi.features.detail.DetailActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Record> list;

    MainAdapter(Context context){
        this.context = context;
    }

    void setData(List<Record> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_user, null);
        // create ViewHolder
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            itemView.setOnClickListener(v->{
                int position = getAdapterPosition();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("user", list.get(position));

                context.startActivity(intent);
            });
        }

        void bind(Record record){
            txtName.setText(record.getName());
        }
    }
}
