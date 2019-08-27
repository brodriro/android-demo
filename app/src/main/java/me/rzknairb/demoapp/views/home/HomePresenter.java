package me.rzknairb.demoapp.views.home;

import dagger.Reusable;
import me.rzknairb.demoapp.views.BasePresenter;

@Reusable
public class HomePresenter extends BasePresenter<HomePresenter.View> {

    public HomePresenter(BasePresenter.View view) {
        super(view);
    }

    public interface View extends BasePresenter.View{

    }
}
