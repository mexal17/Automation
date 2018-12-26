package factory;

import client.ApacheClient;
import client.IRestClient;
import client.RestAssuredClient;
import constant.LibraryType;

public class ClientFactory {

    private ClientFactory() {
    }

    public static IRestClient getInstance(LibraryType libraryType) {
        switch (libraryType) {
            case APACHE_HTTP: {
                return new ApacheClient();
            }
            case REST_ASSURED: {
                return new RestAssuredClient();
            }
            default: {
                return null;
            }
        }
    }
}
