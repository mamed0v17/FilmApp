package kg.geektech.filmapp.ui.films;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.filmapp.data.models.Film;
import kg.geektech.filmapp.databinding.ItemFilmsBinding;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
    private List<Film> films = new ArrayList<>();
    private OnItemClick listener;

    public FilmsAdapter() {
        this.films = films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmsBinding binding = ItemFilmsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.click(films.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class FilmsViewHolder extends RecyclerView.ViewHolder {
        private ItemFilmsBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Film film) {
            binding.tittle.setText(film.getTittle());
            binding.description.setText(film.getDescription());
        }
    }
}
