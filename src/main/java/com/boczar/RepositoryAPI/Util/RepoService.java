package com.boczar.RepositoryAPI.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RepoService {

    public List<String> getRepoNamesByUserName(String username) throws IOException {
        URL url = new URL("https://api.github.com/users/" + username + "/repos");

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

        return listOfReposForParticularUser;
    }
}
