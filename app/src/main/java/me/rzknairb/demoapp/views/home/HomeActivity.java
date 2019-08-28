package me.rzknairb.demoapp.views.home;

import android.os.Bundle;

import javax.inject.Inject;

import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseActivity;

public class HomeActivity extends BaseActivity implements HomePresenter.View {

    @Inject
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
