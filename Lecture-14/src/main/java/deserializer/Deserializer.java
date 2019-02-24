package deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.GitHubResponse;
import model.GitUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.PrintHelper.printInfoAboutErrorDuringDeserialization;

public class Deserializer {
    public static List<GitUser> getListUsersFromJson(GitHubResponse gitHubResponse) {
        List<GitUser> collaborators = new ArrayList<GitUser>();
        try {
            collaborators = Arrays.asList(new ObjectMapper().readValue(gitHubResponse.getBody(), GitUser[].class));
        } catch (IOException e) {
            printInfoAboutErrorDuringDeserialization(e);
        }
        return collaborators;
    }
}
