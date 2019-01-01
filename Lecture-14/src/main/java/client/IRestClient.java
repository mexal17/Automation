package client;

import constant.HttpMethodType;
import constant.LibraryType;
import model.GitHubResponse;

public interface IRestClient {
    GitHubResponse executeRequest(HttpMethodType methodType);

    LibraryType getType();
}
