package me.rzknairb.demoapp.views.social_app.home;

import javax.inject.Inject;

import dagger.Reusable;
import me.rzknairb.demoapp.views.BasePresenter;

@Reusable
public class HomePresenter extends BasePresenter<HomePresenter.View> {

    @Inject
    public HomePresenter(View view) {
        super(view);
    }

    public interface View extends BasePresenter.View {

    }
}
