package me.rzknairb.demoapp.views.profile;

import dagger.Reusable;
import me.rzknairb.demoapp.views.BasePresenter;

@Reusable
public class ProfilePresenter extends BasePresenter<ProfilePresenter.View>{
    public ProfilePresenter(View view) {
        super(view);
    }

    public interface View extends BasePresenter.View{

    }
}
