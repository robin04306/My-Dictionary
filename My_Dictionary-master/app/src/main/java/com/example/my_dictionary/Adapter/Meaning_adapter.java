package com.example.my_dictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_dictionary.Model.Meaning;
import com.example.my_dictionary.R;
import com.example.my_dictionary.View_holders.Meaning_view_holder;

import java.util.List;

public class Meaning_adapter extends RecyclerView.Adapter<Meaning_view_holder> {

    private Context context;
    protected List<Meaning> meaningList;

    public Meaning_adapter(Context context, List<Meaning> meaningList) {
        this.context = context;
        this.meaningList = meaningList;
    }

    @NonNull
    @Override
    public Meaning_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Meaning_view_holder(LayoutInflater.from(context).inflate(R.layout.meaning_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Meaning_view_holder holder, int position) {

        holder.parts_of_speech.setText("Parts of Speech " +meaningList.get(position).getPartOfSpeech());
        holder.defination.setHasFixedSize(true);
        holder.defination.setLayoutManager(new GridLayoutManager(context , 1));

         Defination_adapter defination_adapter = new Defination_adapter(context , meaningList.get(position).getDefinitions());
         holder.defination.setAdapter(defination_adapter);
    }

    @Override
    public int getItemCount() {
        return meaningList.size();
    }
}
