package com.boczar.RepositoryAPI;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {

    // no need for that I think
//    @GetMapping("/hello/")
//    public String getHello() throws IOException {
//        URL url = new URL("https://api.github.com/users/peter/repos");
//
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        InputStream response = connection.getInputStream();
//
//        return new String(response.readAllBytes());
//
//    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.github.com/users/peter/repos");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream response = connection.getInputStream();
        String body = new String(response.readAllBytes());

        JSONArray jsonArray = new JSONArray(body);
        List<String> listOfReposForParticularUser = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.optString("name");
            listOfReposForParticularUser.add(name);
        }


        for(String string : listOfReposForParticularUser){
            System.out.println("name: " + string);
        }
    }
}