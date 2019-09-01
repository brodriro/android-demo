package me.rzknairb.demoapp.views.home;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseActivity;
import me.rzknairb.demoapp.views.profile.ProfileFragment;

public class HomeActivity extends BaseActivity implements HomePresenter.View, BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    HomePresenter homePresenter;

    @BindView(R.id.bottom_navigation_main)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_profile:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ProfileFragment())
                        .commit();
                break;
        }
        return false;
    }
}
