package com.example.zhandos.contestant;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhandos on 12/5/17.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private List<Contest> contestList;
    private Context context;

    public MainListAdapter(Context context, List<Contest> contestList) {
        this.context = context;
        this.contestList = contestList;
    }

    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contest, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainListAdapter.ViewHolder holder, int position) {
        Contest contest = contestList.get(position);
        holder.tvContestName.setText(contest.getName());
    }

    @Override
    public int getItemCount() {
        return contestList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvContestName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvContestName = (TextView) itemView.findViewById(R.id.tvContestName);
        }
    }
}
