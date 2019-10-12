package me.rzknairb.demoapp.views.friends;

import javax.inject.Inject;

import dagger.Reusable;
import me.rzknairb.demoapp.views.BasePresenter;

/**
 * Created by Brian Rodriguez on 11/10/2019
 */

@Reusable
public class FriendsPresenter extends BasePresenter<FriendsPresenter.View> {

    @Inject
    public FriendsPresenter(View view) {
        super(view);
    }

    public void start() {

    }

    public interface View extends BasePresenter.View {

    }
}
