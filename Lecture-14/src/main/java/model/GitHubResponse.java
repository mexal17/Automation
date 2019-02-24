package model;

public class GitHubResponse {

    private final String body;
    private final int statusCode;

    public GitHubResponse(String body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
