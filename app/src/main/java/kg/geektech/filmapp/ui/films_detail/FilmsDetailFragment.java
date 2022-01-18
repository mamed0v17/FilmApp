package kg.geektech.filmapp.ui.films_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import kg.geektech.filmapp.App;
import kg.geektech.filmapp.R;
import kg.geektech.filmapp.data.models.Film;
import kg.geektech.filmapp.databinding.FragmentFilmsBinding;
import kg.geektech.filmapp.databinding.FragmentFilmsDetailBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsDetailFragment extends Fragment {
    private FragmentFilmsDetailBinding binding;


    public FilmsDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void cinema() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String id = getArguments().getString("id");

        App.api.getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(@NonNull Call<Film> call, @NonNull Response<Film> response) {
                if (response.isSuccessful()) {
                    Film film = response.body();
                    binding.imageTittle.setVisibility(View.GONE);
                    assert film != null;
                    binding.textTittle.setText(film.getTittle());
                    binding.Description.setText(film.getDescription());
                    Glide.with(requireActivity()).load(film.getImage()).into(binding.imageTittle);
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}