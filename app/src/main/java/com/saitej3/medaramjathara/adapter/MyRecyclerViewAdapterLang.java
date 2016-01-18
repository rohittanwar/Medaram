package com.saitej3.medaramjathara.adapter;

/**
 * Created by Rohts on 1/11/2016.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saitej3.medaramjathara.R;
import com.saitej3.medaramjathara.model.DataObject;
import com.saitej3.medaramjathara.model.Lang;

import java.util.ArrayList;

public class MyRecyclerViewAdapterLang extends RecyclerView
        .Adapter<MyRecyclerViewAdapterLang.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Lang> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        ImageView mimg;
        TextView dateTime;

        public DataObjectHolder(View itemView) {
            super(itemView);
            mimg = (ImageView) itemView.findViewById(R.id.img);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {



           // myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        MyRecyclerViewAdapterLang.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapterLang(ArrayList<Lang> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_lang, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.mimg.setImageResource(mDataset.get(position).getimg());
        holder.dateTime.setText(mDataset.get(position).getmText2());
    }

    public void addItem(Lang dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}