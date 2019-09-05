package me.rzknairb.demoapp.views.profile;

import javax.inject.Inject;

import dagger.Reusable;
import me.rzknairb.demoapp.views.BasePresenter;

@Reusable
public class ProfilePresenter extends BasePresenter<ProfilePresenter.View>{
    @Inject
    public ProfilePresenter(View view) {
        super(view);
    }

    public interface View extends BasePresenter.View{

    }
}
