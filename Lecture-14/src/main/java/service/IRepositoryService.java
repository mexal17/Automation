package service;

import model.GitUser;

import java.util.List;

public interface IRepositoryService {
    List<GitUser> getCollaborators();

    String sendInvitation();
}
