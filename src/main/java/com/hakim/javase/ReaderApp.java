package com.hakim.javase;

import java.io.IOException;
import java.util.Scanner;

public class ReaderApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter text what you want to pronounce: ");
        Scanner input=new Scanner(System.in);
        while(true){
            String text=input.nextLine();
            if(text.equals("exit")) break;
            Runtime.getRuntime().exec(String.format("PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('%s')\"\n",text));
        }
    }
}
