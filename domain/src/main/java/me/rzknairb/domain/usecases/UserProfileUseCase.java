package me.rzknairb.domain.usecases;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.repositories.UserRemoteRepository;

/**
 * Created by Brian Rodriguez on 10/10/2019
 */
@Singleton
public class UserProfileUseCase {

    @Inject
    UserRemoteRepository userRemoteRepository;

    @Inject
    public UserProfileUseCase() {
    }

    public Single<User> getUserById(String id) {
        return userRemoteRepository.getUserById(id);
    }
}
