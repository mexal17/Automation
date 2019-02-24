package factory;

import constant.HttpMethodType;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URISyntaxException;

import static util.PrintHelper.printInfoAboutIoSyntaxException;
import static util.PrintHelper.printInfoAboutUriSyntaxException;

public class ApacheHttpResponseFactory {

    private static final String TOKEN = "2ec8d0055afbe6924a8f9ff143838a9c5c02535d";
    private static final String URI_COLLABORATORS = "https://api.github.com/repos/mexal17/Lecture-2/collaborators";
    private static final String URI_SEND_INVITATION = "https://api.github.com/repos/mexal17/Lecture-2/collaborators/user5";
    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.custom().build();

    private ApacheHttpResponseFactory() {
    }

    public static CloseableHttpResponse getResponse(HttpMethodType methodType) {
        CloseableHttpResponse httpResponse = null;
        switch (methodType) {
            case GET:
                try {
                    httpResponse = HTTP_CLIENT.execute(new HttpGet(getUriBuilder(URI_COLLABORATORS).build()));
                } catch (URISyntaxException e1) {
                    printInfoAboutUriSyntaxException(e1);
                } catch (IOException e2) {
                    printInfoAboutIoSyntaxException(e2);
                }
                return httpResponse;
            case PUT:
                try {
                    httpResponse = HTTP_CLIENT.execute(new HttpPut(getUriBuilder(URI_SEND_INVITATION).build()));
                } catch (URISyntaxException e1) {
                    printInfoAboutUriSyntaxException(e1);
                } catch (IOException e2) {
                    printInfoAboutIoSyntaxException(e2);
                }
                return httpResponse;
            default:
                throw new IllegalArgumentException("Method type is not supported");
        }
    }

    private static URIBuilder getUriBuilder(String url) throws URISyntaxException {
        URIBuilder builderColl = new URIBuilder(url);
        builderColl.setParameter("access_token", TOKEN);
        return builderColl;
    }
}
