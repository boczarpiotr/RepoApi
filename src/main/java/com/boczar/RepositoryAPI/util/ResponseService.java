package com.boczar.RepositoryAPI.util;

import com.boczar.RepositoryAPI.model.Branch;
import com.boczar.RepositoryAPI.model.exceptions.NotFoundException;
import com.boczar.RepositoryAPI.model.Response;
import com.boczar.RepositoryAPI.model.SingleResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ResponseService {

    @Autowired
    BranchService branchService;
    @Autowired
    RepoService repoService;

    public String getResponseByName(String name) throws IOException {
        List<SingleResponse> listOfSingleResponses = new ArrayList<>();

        List<String> repos = repoService.getRepoNamesByUserName(name);

        if (repos.isEmpty()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "There is no such a login");
        } else {


            for (String repo : repos) {
                Branch[] branches = branchService.getBranchesByRepoName(name, repo);
                SingleResponse singleResponse = new SingleResponse();
                singleResponse.setRepositoryName(repo);
                singleResponse.setBranches(branches);

                //dodaje jednego singleResponse do listy
                listOfSingleResponses.add(singleResponse);
            }
            Response response = new Response();
            response.setLogin(name);
            response.setRepositories(listOfSingleResponses);

            return new Gson().toJson(response);
        }
    }
}

