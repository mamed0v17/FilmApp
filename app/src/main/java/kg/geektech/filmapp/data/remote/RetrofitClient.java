package kg.geektech.filmapp.data.remote;

import javax.crypto.spec.GCMParameterSpec;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public FilmApi provideFilmApi(){
        return retrofit.create(FilmApi.class);
    }
}
