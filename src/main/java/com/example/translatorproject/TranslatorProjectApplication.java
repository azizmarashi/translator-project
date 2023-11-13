package com.example.translatorproject;

public class TranslatorProjectApplication {

    public static void main(String[] args) {
        System.out.println(TranslatorService.translateText("اسم من علی است"));

        System.out.println(TranslatorService.getImageLinksByKeyword("book"));

    }

}