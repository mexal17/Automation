package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitUser {
    private String login;

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "{" +
                "login='" + login + '\'' + '}';
    }
}