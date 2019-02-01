package swaroop.android.newsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import swaroop.android.newsapp.R;
import swaroop.android.newsapp.room.entity.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<News> newsList = new ArrayList<>();

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item_list, parent, false);
        return new NewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News currentNews = newsList.get(position);

        holder.newsTitle.setText(currentNews.getTitle());
        holder.newsDesc.setText(currentNews.getDesc());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setNewsList(List<News> news) {
        this.newsList = news;
        notifyDataSetChanged();
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        private TextView newsTitle;
        private TextView newsDesc;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.news_heading_tilte);
            newsDesc = itemView.findViewById(R.id.news_heading_desc);
        }
    }

}
