package com.example.my_dictionary.Model;

import java.util.List;

public class API_Response {

    String word= "";
    List <phonetics> phonetics = null;
    List<Meaning> meanings = null;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<com.example.my_dictionary.Model.phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<com.example.my_dictionary.Model.phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }
}
