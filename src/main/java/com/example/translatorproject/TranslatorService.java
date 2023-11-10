package com.example.translatorproject;

import com.darkprograms.speech.translator.GoogleTranslate;
import java.io.IOException;

public class TranslatorService {

    public static String translateText(String text) {
        String response="";
        try {
            response = GoogleTranslate.translate(text);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return response;
    }

}