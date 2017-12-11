package com.example.zhandos.mad_lab_07;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by zhandos on 10/4/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Article> articles;
    private Context context;

    public MyAdapter(Context context, List<Article> articles) {
        this.articles = articles;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article, parent, false);
        returnA new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article curArticle = articles.get(position);

        holder.tvAuthor.setText(curArticle.getAuthor());
        holder.tvTitle.setText(curArticle.getTitle());
        holder.tvDescription.setText(curArticle.getDescription());
        holder.tvPublishedAt.setText(curArticle.getPublishedAt());
        Picasso.with(this.context)
                .load(curArticle.getImageUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAuthor;
        TextView tvTitle;
        TextView tvDescription;
        ImageView image;
        TextView tvPublishedAt;
        CardView cv;

        public ViewHolder(View v) {
            super(v);
            tvAuthor = (TextView) v.findViewById(R.id.tvAuthor);
            tvDescription = (TextView) v.findViewById(R.id.tvDescription);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            image = (ImageView) v.findViewById(R.id.ivImage);
            tvPublishedAt = (TextView) v.findViewById(R.id.tvPublishedAt);
            cv = (CardView) v.findViewById(R.id.cvArticles);
        }
    }
}
