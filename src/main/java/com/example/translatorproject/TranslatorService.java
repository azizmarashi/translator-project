package com.example.translatorproject;

import com.darkprograms.speech.translator.GoogleTranslate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static String getImageLinksByKeyword(String keyword) {
        String url = "https://www.peakpx.com/en/search?q=" + keyword;
        Document doc = null;
        boolean successConnect = false;
        List<String> imageLinks = new ArrayList<>();
        while (!successConnect) {
            try {
                doc = Jsoup.connect(url).get();
                successConnect = true;
            } catch (IOException e) {
            }
        }
        Elements figures = doc.select("figure");
        return figures.get(0).selectFirst("link").attr("href");
    }

}