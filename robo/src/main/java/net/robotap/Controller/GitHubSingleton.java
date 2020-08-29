package net.robotap.controller;

import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.PagedIterable;


public class GitHubSingleton {
    private String username;
    private String password;
    private static GitHubSingleton single_instance = null;
    public GitHub github = null;

    public static GitHubSingleton user() {
        if (single_instance == null) {
            single_instance = new GitHubSingleton();
        }

        return single_instance;
    }

    public Boolean login(String username, String password) {
        this.username = username;
        this.password = password;
        Boolean status = false;

        try {
            this.github = new GitHubBuilder().withPassword(this.username, this.password).build();
            if (github.isCredentialValid()) {
                System.out.println("login success");
                status = true;
            } else {
                System.err.println("error loggin into github");
                status = true;
            }
        } catch (IOException e) {
            System.err.println("error trying to login to github with username or password: " + e);
            status = true;
        }

        return status;
    }

    public void getMyOrganizations(){
        try {
            System.out.println(github.getMyOrganizations());
        } catch (IOException e) {
            System.err.println("error with get my org: " + e);
        }
    }

    public GHUser getUser(){
        GHUser user = null;
        try {
            user = this.github.getMyself();
        } catch (IOException e) {
            System.err.println("could not get user: " + e);
        }
        return user;
    }

    public PagedIterable<GHRepository> listRepos() {
        PagedIterable<GHRepository> repos = getUser().listRepositories();
        for (GHRepository repo : repos) {
            System.out.println(repo.getHttpTransportUrl());
        }
        return repos;
    }

}