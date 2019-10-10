package me.rzknairb.demoapp.views.user_profile;

import javax.inject.Inject;

import dagger.Reusable;
import me.rzknairb.demoapp.views.BasePresenter;

/**
 * Created by Brian Rodriguez on 7/10/2019
 */
@Reusable
public class UserProfilePresenter extends BasePresenter<UserProfilePresenter.View> {

    @Inject
    public UserProfilePresenter(View view) {
        super(view);
    }


    public void start(String userId) {

    }

    public interface View extends BasePresenter.View{

    }
}
