package com.example.my_dictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_dictionary.Model.Defination;
import com.example.my_dictionary.R;
import com.example.my_dictionary.View_holders.Defination_view_holder;

import java.util.List;

public class Defination_adapter extends RecyclerView.Adapter<Defination_view_holder> {

    private Context context;
    private List<Defination> definationList;

    public Defination_adapter(Context context, List<Defination> definationList) {
        this.context = context;
        this.definationList = definationList;
    }

    @NonNull
    @Override
    public Defination_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Defination_view_holder(LayoutInflater.from(context).inflate(R.layout.defination_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull Defination_view_holder holder, int position) {

        holder.defination.setText("Defination: " + definationList.get(position).getDefinition());
        holder.example.setText("Example " + definationList.get(position).getExample());

        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definationList.get(position).getSynonyms());
        antonyms.append(definationList.get(position).getAntonyms());

        holder.synonym.setText(synonyms);
        holder.antonym.setText(antonyms);

        holder.synonym.setSelected(true);
        holder.antonym.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return definationList.size();
    }
}
