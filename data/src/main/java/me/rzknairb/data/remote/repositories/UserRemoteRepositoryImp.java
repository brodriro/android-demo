package me.rzknairb.data.remote.repositories;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import me.rzknairb.data.remote.API;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.repositories.UserRemoteRepositoryImp;

public class UserRemoteRepository extends RetrofitRepository implements UserRemoteRepositoryImp {
    @Override
    public Single<User> getProfile() {
        API api = getRetrofit(API.BASE_URL).create(API.class);

        return api.getProfile().map(userResponse -> {
            User user = null;

            if (userResponse != null) {
                //TODO IMPLEMENT
            }
            return user;
        });
    }

    @Override
    public Single<List<User>> getUsers() {
        API api = getRetrofit(API.BASE_URL).create(API.class);

        return api.getUsers().map(userResponses -> {
            List<User> userList = new ArrayList<>();

            if (userResponses != null){
                //TODO IMPLEMENT
            }
            return userList;
        });
    }
}
