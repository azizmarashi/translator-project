package com.example.translatorproject;

import com.darkprograms.speech.translator.GoogleTranslate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

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
        String url = String.format("https://www.iconfinder.com/search?q=%s&price=free",keyword);
        List<String> directImageLinks = new ArrayList<>();
        Document doc = null;
        boolean successConnect = false;
        while (!successConnect) {
            try {
                doc = Jsoup.connect(url).get();
                successConnect = true;
            } catch (IOException e) {

            }
        }
        Elements images = doc.select("img");
        for (Element image : images) {
            String imageUrl = image.absUrl("src");
            if (imageUrl.endsWith("png")){
                directImageLinks.add(imageUrl);
            }
        }
        return directImageLinks.get(0);
    }

    public static List<String> separateWords(String sentence){
        sentence = sentence.replace("."," ");
        return List.of(sentence.split(" "));
    }

    public static Map getImageLinkPerWord(String firstSentence){
        String translatedSentence = translateText(firstSentence);
        List<String> separateWords = separateWords(translatedSentence);
        Map<String,String> wordAndLink = new LinkedHashMap<>();
        for (String word: separateWords){
            wordAndLink.put(word,getImageLinksByKeyword(word));
        }
        return wordAndLink;
    }

}