package kg.geektech.newsapp40.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kg.geektech.newsapp40.R;
import kg.geektech.newsapp40.databinding.ItemBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private final int[] images = {R.drawable.cherep, R.drawable.strtwo, R.drawable.cherep};
    private final String[] titles = {"Добро пожаловать", "Ваши данные в безопасности", "Начнем"};
    private final String[] descriptions = {
            "Это тестовое приложение  \n              NewsApp40 \nНадеюсь вам понравится ",
            "Напишите новость \nСамое уникальное приложение  \nУзнаете все новости мира",
            "Пусто\nПусто \nПусто"
    };
    private ItemBoardBinding binding;
    private OnStartClickListener clickListener;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public void setClickListener(OnStartClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemBoardBinding binding;

        public ViewHolder(@NonNull ItemBoardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(int position) {
            binding.textTitle.setText(titles[position]);
            binding.textDesc.setText(descriptions[position]);
            binding.ivBoard.setImageResource(images[position]);

            if (position == titles.length - 1) {
                binding.btn.setVisibility(View.VISIBLE);
            } else {
                binding.btn.setVisibility(View.INVISIBLE);
            }
            binding.btn.setOnClickListener(view -> {

            });
        }
    }
}