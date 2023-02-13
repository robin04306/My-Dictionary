package com.example.my_dictionary.View_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_dictionary.R;

public class Defination_view_holder extends RecyclerView.ViewHolder {
    public TextView defination, example, synonym, antonym;

    public Defination_view_holder(@NonNull View itemView) {
        super(itemView);

        defination= itemView.findViewById(R.id.text_view_defination_id);
        example= itemView.findViewById(R.id.text_view_example_id);
        synonym= itemView.findViewById(R.id.text_view_synonym_id);
        antonym= itemView.findViewById(R.id.text_view_antonym_id);
    }
}
