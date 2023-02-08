package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GetAdapter extends RecyclerView.Adapter<GetAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<UserResponse> getUserArrayList;

    public GetAdapter(Context context, ArrayList<UserResponse> getUserArrayList) {
        this.context = context;
        this.getUserArrayList = getUserArrayList;
    }

    @NonNull
    @Override
    public GetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetAdapter.ViewHolder holder, int position) {

        UserResponse getDataModal = getUserArrayList.get(position);

        holder.nameTv.setText(getDataModal.getUsername());
        holder.jobTv.setText(getDataModal.getJob());

    }

    @Override
    public int getItemCount() {
        return getUserArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTv;
        public TextView jobTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTxt);
            jobTv = itemView.findViewById(R.id.jobTxt);
        }
    }
}
