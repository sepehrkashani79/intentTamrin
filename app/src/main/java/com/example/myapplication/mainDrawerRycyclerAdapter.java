package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class mainDrawerRycyclerAdapter extends RecyclerView.Adapter<mainDrawerRycyclerAdapter.mainDrawerRecyclerHolder> {


    @NonNull
    @Override
    public mainDrawerRecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_drawer_recycler_item,viewGroup,false);
        mainDrawerRecyclerHolder holder =new mainDrawerRecyclerHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull mainDrawerRecyclerHolder mainDrawerRecyclerHolder, int i) {
        final mainDrawerRecyclerHolder holder=mainDrawerRecyclerHolder;
        switch (i){
            case 0:{
                final Intent gotoPicture=new Intent(holder.itemView.getContext(),pictureActivity.class);
                holder.mainDrawerRecyclerButton.setText("picture");
                holder.mainDrawerRecyclerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.itemView.getContext().startActivity(gotoPicture);
                    }
                });
                break;
            }
            case 1:{
                final Intent gotodial=new Intent(holder.itemView.getContext(),dialActivity.class);
                holder.mainDrawerRecyclerButton.setText("dial");
                holder.mainDrawerRecyclerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.itemView.getContext().startActivity(gotodial);
                    }
                });
                break;
            }
            case 2:{
                final Intent gotoProfile=new Intent(holder.itemView.getContext(),profileActivity.class);
                holder.mainDrawerRecyclerButton.setText("Enter your data");
                holder.mainDrawerRecyclerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.itemView.getContext().startActivity(gotoProfile);
                    }
                });
                break;
            }

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class mainDrawerRecyclerHolder extends RecyclerView.ViewHolder{
        Button mainDrawerRecyclerButton;
        public mainDrawerRecyclerHolder(@NonNull View itemView) {
            super(itemView);
            mainDrawerRecyclerButton = itemView.findViewById(R.id.btnTitle);
        }
    }


}
