package com.example.covid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_adapter extends RecyclerView.Adapter<recycler_adapter.MyViewHolder>  {



        private LayoutInflater inflater;
        private ArrayList<cases> dataModelArrayList;
        private OnNoteList onNoteList;

        public recycler_adapter(Context ctx, ArrayList<cases> dataModelArrayList,  OnNoteList onNoteList){

            inflater = LayoutInflater.from(ctx);
            this.dataModelArrayList = dataModelArrayList;
            this.onNoteList = onNoteList;
        }

        @NonNull
        @Override
        public recycler_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.row_layout, parent, false);
            MyViewHolder holder = new MyViewHolder(view,onNoteList);

            return holder;
        }

        @Override
        public void onBindViewHolder(recycler_adapter.MyViewHolder holder, int position) {

            //Picasso.get().load(dataModelArrayList.get(position).getImgURL()).into(holder.iv);
            holder.country_name.setText(dataModelArrayList.get(position).getCountry_name());
            holder.cases.setText("Total Cases : "+dataModelArrayList.get(position).getCases());
            holder.deaths.setText("Unfortunate Deaths : "+dataModelArrayList.get(position).getDeaths());
            holder.recovered.setText("Recoveries : "+dataModelArrayList.get(position).getRecovered());
        }

        @Override
        public int getItemCount() {
            return dataModelArrayList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView country_name, cases, deaths, recovered;
            ImageView iv;
            OnNoteList onNoteList;

            public MyViewHolder(View itemView, OnNoteList onNoteList) {
                super(itemView);

                country_name = (TextView) itemView.findViewById(R.id.country_name);
                cases = (TextView) itemView.findViewById(R.id.cases);
                deaths = (TextView) itemView.findViewById(R.id.deaths);
                recovered = itemView.findViewById(R.id.recovered);
                this.onNoteList = onNoteList;
                itemView.setOnClickListener(this);
                //iv = (ImageView) itemView.findViewById(R.id.iv);
            }

            @Override
            public void onClick(View v) {
                onNoteList.OnnoteClick(getAdapterPosition()); //text
            }
        }
    public interface OnNoteList {
        void OnnoteClick(int position);


    }
    }

