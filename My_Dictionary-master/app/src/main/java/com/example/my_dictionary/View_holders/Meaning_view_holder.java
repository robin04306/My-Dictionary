package com.example.my_dictionary.View_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_dictionary.R;

public class Meaning_view_holder extends RecyclerView.ViewHolder {

    public TextView parts_of_speech;
    public  RecyclerView defination;

    public Meaning_view_holder(@NonNull View itemView) {
        super(itemView);

        parts_of_speech= itemView.findViewById(R.id.text_view_partsofspeech_id);
        defination= itemView.findViewById(R.id.reycler_defination_id);

    }
}
