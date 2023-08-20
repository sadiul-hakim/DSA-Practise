package com.hakim.javase;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.net.InetAddress;


public class Main {
    public static void main(String[] args) {


        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("System Name: " + address.getHostName());
            System.out.println("System IP Address: " + address.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void add(String name){
        name="Hakim";
    }

    public void read(){
        try(FileOutputStream fos=new FileOutputStream("D:\\java_code\\JavaSE\\src\\main\\java\\com\\hakim\\javase\\index.html")) {
            URL url = new URL("https://stackoverflow.com/questions/51763610/how-to-fix-java-io-ioexception-server-returned-http-response-code-403#:~:text=java.io.IOException%3A%20Server%20returned%20HTTP%20response%20code%3A%20403%20for,sun.net.www.protocol.http.HttpURLConnection.getInputStream0%20%28HttpURLConnection.java%3A1894%29%20at%20sun.net.www.protocol.http.HttpURLConnection.getInputStream%20%28HttpURLConnection.java%3A1492%29%20at%20sun.net.www.protocol.https.HttpsURLConnectionImpl.getInputStream%20%28HttpsURLConnectionImpl.java%3A263%29"); // replace with the URL of the website you want to read
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuilder html = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                html.append(inputLine);
            }
            in.close();

            fos.write(html.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

enum Gender{
    MALE,
    FEMATE
}

class Person{
    private String name;
    private Gender gender;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}