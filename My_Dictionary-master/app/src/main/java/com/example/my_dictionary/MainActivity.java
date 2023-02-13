package com.example.my_dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_dictionary.Adapter.Meaning_adapter;
import com.example.my_dictionary.Adapter.Phonetics_ADAPTER;
import com.example.my_dictionary.Model.API_Response;

public class MainActivity extends AppCompatActivity {

    SearchView search_View;
    TextView textView_word;
    RecyclerView recyclerView_phonet , recyclerView_meaning;
    ProgressDialog pd;
    Phonetics_ADAPTER phonetics_adapter;
    Meaning_adapter meaning_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_View = findViewById(R.id.search_view_id);
        textView_word = findViewById(R.id.text_view_word_id);
        recyclerView_phonet = findViewById(R.id.recycler_phon_id);
        recyclerView_meaning = findViewById(R.id.recycler_meanings_id);
        pd = new ProgressDialog(this);

        pd.setTitle("Loading...............");
        pd.show();
        Request_Manager manager = new Request_Manager(MainActivity.this);
        manager.get_word_meaning(listener, "hello" );

        search_View.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                pd.setTitle("Searching.....");
                pd.show();
                Request_Manager manager = new Request_Manager(MainActivity.this);
                manager.get_word_meaning(listener, query );
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



    }

    private  final On_fetch_Data_listener listener = new On_fetch_Data_listener() {
        @Override
        public void on_fetch_data(API_Response api_response, String messages) {
            pd.dismiss();
            if (api_response==null)
            {
                Toast.makeText(MainActivity.this, "Nothing found", Toast.LENGTH_SHORT).show();
                return;
            }
            show_data(api_response);
        }

        private void show_data(API_Response api_response) {

            textView_word.setText("Word " +api_response.getWord());
            recyclerView_phonet.setHasFixedSize(true);
            recyclerView_phonet.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
            phonetics_adapter = new Phonetics_ADAPTER(MainActivity.this, api_response.getPhonetics());
            recyclerView_phonet.setAdapter(phonetics_adapter);

            recyclerView_meaning.setHasFixedSize(true);
            recyclerView_meaning.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
            meaning_adapter= new Meaning_adapter(MainActivity.this, api_response.getMeanings());

            recyclerView_meaning.setAdapter(meaning_adapter);


        }

        @Override
        public void onError(String messages) {
            pd.dismiss();
           // Toast.makeText(MainActivity.this, messages, Toast.LENGTH_SHORT).show();


        }
    };
}