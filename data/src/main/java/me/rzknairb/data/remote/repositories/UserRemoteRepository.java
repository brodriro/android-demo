package me.rzknairb.data.repositories;

import java.util.List;

import io.reactivex.Single;
import me.rzknairb.data.remote.API;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.repositories.UserRemoteRepositoryImp;

public class UserRemoteRepository extends RetrofitRepository implements UserRemoteRepositoryImp {
    @Override
    public Single<User> getProfile() {
        API api = getRetrofit(API.BASE_URL).create(API.class);

        return null;
    }

    @Override
    public Single<List<User>> getUsers() {
        return null;
    }
}
