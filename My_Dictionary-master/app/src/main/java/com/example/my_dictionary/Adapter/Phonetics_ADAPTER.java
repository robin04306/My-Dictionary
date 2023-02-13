package com.example.my_dictionary.Adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_dictionary.Model.phonetics;
import com.example.my_dictionary.R;
import com.example.my_dictionary.View_holders.Phonetic_view_holder;

import java.util.List;

public class Phonetics_ADAPTER extends RecyclerView.Adapter<Phonetic_view_holder> {

    private Context context;
    private List<phonetics> phoneticsList;

    public Phonetics_ADAPTER(Context context, List<phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public Phonetic_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Phonetic_view_holder(LayoutInflater.from(context).inflate(R.layout.phon_list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull Phonetic_view_holder holder, int position) {
        holder.phonetics.setText(phoneticsList.get(position).getText());
        holder.audio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource("https:"+ phoneticsList.get(position).getAudio());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(context, "Error!",  Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
         return phoneticsList.size();
    }
}
