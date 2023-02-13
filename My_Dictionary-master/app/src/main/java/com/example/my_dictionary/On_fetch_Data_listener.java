package com.example.my_dictionary;

import com.example.my_dictionary.Model.API_Response;

public interface On_fetch_Data_listener {

    void on_fetch_data(API_Response api_response, String messages);
    void onError(String messages);

}
