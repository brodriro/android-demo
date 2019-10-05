package me.rzknairb.domain.usecases;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.repositories.UserRemoteRepository;

@Singleton
public class ProfileUseCase {

    @Inject
    UserRemoteRepository userRemoteRepository;

    private User session;

    @Inject
    ProfileUseCase() {
    }


    public Single<User> getProfile() {
        return userRemoteRepository.getProfile().map(user -> {
            setSession(user);
            return  user;
        });
    }

    public void setSession(User session) {
        this.session = session;
    }

    public User getSession() {
        return session;
    }
}
