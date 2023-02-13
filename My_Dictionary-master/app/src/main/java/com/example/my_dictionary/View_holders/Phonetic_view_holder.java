package com.example.my_dictionary.View_holders;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_dictionary.R;

public class Phonetic_view_holder extends RecyclerView.ViewHolder {
    public TextView phonetics;
    public ImageView audio_button;

    public Phonetic_view_holder(@NonNull View itemView) {
        super(itemView);
        phonetics=itemView.findViewById(R.id.text_view_phon_id);
        audio_button=itemView.findViewById(R.id.volume_image_id);

    }
}
