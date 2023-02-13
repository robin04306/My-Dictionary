package com.example.my_dictionary;

import android.content.Context;
import android.widget.Toast;

import com.example.my_dictionary.Model.API_Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Request_Manager {

    Context context ;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public Request_Manager(Context context) {
        this.context = context;
    }

    public void get_word_meaning(On_fetch_Data_listener on_fetch_data_listener, String word)
    {
        Call_dictionary call_dictionary = retrofit.create(Call_dictionary.class);
        Call<List<API_Response>> call = call_dictionary.call_meaning(word);

        try {
            call.enqueue(new Callback<List<API_Response>>() {
                @Override
                public void onResponse(Call<List<API_Response>> call, Response<List<API_Response>> response) {

                    if (!response.isSuccessful())
                    {
                        Toast.makeText(context, "Error...", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    on_fetch_data_listener.on_fetch_data(response.body().get(0) , response.message());

                    on_fetch_data_listener.onError("Try again..");
                }

                @Override
                public void onFailure(Call<List<API_Response>> call, Throwable t) {

                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Error loading...", Toast.LENGTH_SHORT).show();
        }
    }

    public interface Call_dictionary{
        @GET("entries/en/{word}")
        Call<List<API_Response>> call_meaning(
                @Path("word") String word
        );
    }
}
