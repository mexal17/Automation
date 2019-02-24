package client;

import com.jayway.restassured.response.Response;
import constant.HttpMethodType;
import constant.LibraryType;
import factory.RestAssuredResponseFactory;
import model.GitHubResponse;

public class RestAssuredClient implements IRestClient {

    @Override
    public GitHubResponse executeRequest(HttpMethodType methodType) {
        Response response = RestAssuredResponseFactory.getResponse(methodType);
        return new GitHubResponse(response.asString(), response.statusCode());
    }

    @Override
    public LibraryType getType() {
        return LibraryType.REST_ASSURED;
    }
}
