package com.boczar.RepositoryAPI;

import com.boczar.RepositoryAPI.Model.Branch;
import com.boczar.RepositoryAPI.Model.Response;
import com.boczar.RepositoryAPI.Util.BranchService;
import com.boczar.RepositoryAPI.Util.RepoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class newMain {

    public static void main(String[] args) throws IOException {
        BranchService branchService = new BranchService();
        RepoService repoService = new RepoService();
        List<Branch[]> listOfLists = new ArrayList<>();

        List<String> repos = repoService.getRepoNamesByUserName("peter");

        for (String repo : repos) {
            Branch[] branches = branchService.getBranchesByRepoName("peter", repo);
            listOfLists.add(branches);

        }
        List<Branch> finalList = listOfLists.stream()
                .flatMap(Stream::of)
                .toList();

        Response response = new Response();
        response.setLogin("Peter");
        List<Branch> listOfBranches = new ArrayList<>();

        for(Branch branch : finalList){

            listOfBranches.add(branch);
        }
        response.setBranches(listOfBranches);

        System.out.println(response); // raczej trzeba bedzie zmienic to co tutaj zwracamy. jak na razie zwracamy obiekt Response czyli branch name i wszystkie informacje o commicie
    }
}
