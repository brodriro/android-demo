package me.rzknairb.demoapp.views.home;

import android.os.Bundle;

import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseActivity;

public class HomeActivity extends BaseActivity implements HomePresenter.View {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
