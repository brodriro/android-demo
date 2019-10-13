package me.rzknairb.domain.usecases;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.repositories.UserRemoteRepository;

/**
 * Created by Brian Rodriguez on 12/10/2019
 */
@Singleton
public class FriendsUseCase {

    @Inject
    UserRemoteRepository userRemoteRepository;

    @Inject
    public FriendsUseCase() {
    }

    public Single<List<User>> getFriends() {
        return userRemoteRepository.getUsers();
    }
}
