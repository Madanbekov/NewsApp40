package kg.geektech.newsapp40;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.ArrayList;

import kg.geektech.newsapp40.databinding.ItemNewsBinding;
import kg.geektech.newsapp40.ui.models.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.CountViewHolder> {
private ItemNewsBinding binding;
        ArrayList<News> news;

public NewsAdapter(ArrayList<News> news) {
        this.news = news;
        }
    public NewsAdapter() {
        news = new ArrayList<>();
    }
@NonNull
@Override
public CountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()),
            parent, false);
    return new CountViewHolder(binding);
        }

@Override
public void onBindViewHolder(@NonNull CountViewHolder holder, int position) {
        holder.bind(news.get(position));
        if (position % 2 == 0) {
        binding.container.setBackgroundResource(R.color.orange);
        }else {
        binding.container.setBackgroundResource(R.color.blue); }
        }

@Override
public int getItemCount() {
        return news.size();
        }
    public void addItem(News newss) {
        news.add(0, newss);
        notifyItemInserted(0);
    }


    static class CountViewHolder extends RecyclerView.ViewHolder {
    private ItemNewsBinding binding;

    public CountViewHolder(@NonNull ItemNewsBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }

    public void bind(News news) {
        String time = (String) android.text.format.DateFormat.format("HH:mm:ss  dd MMM yyyy", new Date(news.getCreatedAt()));
        binding.textView.setText(news.getTitle());
        binding.timeItemNews.setText(time);

    }
}
}

