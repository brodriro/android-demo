package me.rzknairb.data.local.repositories;

import javax.inject.Inject;

import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import me.rzknairb.data.Utils;
import me.rzknairb.data.local.entities.UserDatabase;
import me.rzknairb.domain.entities.User;


public class UserLocalRepositoryImp implements me.rzknairb.domain.repositories.UserLocalRepositoryImp {

    private final RealmConfiguration realmConfiguration;

    @Inject
    public UserLocalRepositoryImp(RealmConfiguration realmConfiguration) {
        this.realmConfiguration = realmConfiguration;
    }

    @Override
    public Single<Boolean> findUser(String username) throws Exception {
        try (Realm realm = Realm.getInstance(realmConfiguration)) {
            UserDatabase result = realm.where(UserDatabase.class).equalTo("username", username).findFirst();
            return Single.just(result != null);
        }
    }

    @Override
    public Single<User> loginUser(String username, String password) throws Exception {
        try (Realm realm = Realm.getInstance(realmConfiguration)) {
            UserDatabase userDatabase = realm.where(UserDatabase.class)
                    .equalTo("username", username)
                    .equalTo("password", password)
                    .findFirst();
            if (userDatabase == null) return null;
            return Single.just(userDatabase.toUser());
        }
    }

    @Override
    public Single<User> getUser(User user) throws Exception {
        try (Realm realm = Realm.getInstance(realmConfiguration)) {
            UserDatabase userEntity = realm.where(UserDatabase.class).equalTo("username", user.getUsername()).findFirst();
            if (userEntity == null) return null;
            return Single.just(userEntity.toUser());
        }
    }

    @Override
    public Single<User> createUser(User user) throws Exception {
        try (Realm realmInstance = Realm.getInstance(realmConfiguration)) {
            Number id = realmInstance.where(UserDatabase.class).max("id");
            int nextId = Utils.generateId(id);
            user.setId(nextId);
            realmInstance.executeTransaction(realm -> realm.insertOrUpdate(new UserDatabase(user)));
            return Single.just(user);
        }
    }

    @Override
    public boolean deleteAllUser() throws Exception {
        try (Realm realmInstance = Realm.getInstance(realmConfiguration)) {
            realmInstance.executeTransaction(realm -> realm.delete(UserDatabase.class));
            return true;
        }
    }
}