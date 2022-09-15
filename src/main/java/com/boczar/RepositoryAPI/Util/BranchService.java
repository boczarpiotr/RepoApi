package com.boczar.RepositoryAPI.Util;

import com.boczar.RepositoryAPI.Model.Branch;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BranchService {

    public Branch[] getBranchesByRepoName(String login, String repoName) throws IOException {

        URL url = new URL("https://api.github.com/repos/" + login + "/" + repoName + "/branches");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream response = connection.getInputStream();
        String body = new String(response.readAllBytes());

        Gson gson = new Gson();

        return gson.fromJson(body, Branch[].class);
    }

}
