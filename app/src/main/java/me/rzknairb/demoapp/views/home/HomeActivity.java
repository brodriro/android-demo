package me.rzknairb.demoapp.views.home;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseActivity;
import me.rzknairb.demoapp.views.feed.FeedFragment;
import me.rzknairb.demoapp.views.friends.FriendsFragment;
import me.rzknairb.demoapp.views.profile.ProfileFragment;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

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
        startFragment(ProfileFragment.newInstance());

        int baseColor = getResources().getColor(R.color.colorPrimary);

        MaterialTapTargetPrompt.Builder targetProfile = new MaterialTapTargetPrompt.Builder(this)
                .setTarget(R.id.action_profile)
                .setPrimaryText(getResources().getString(R.string.promp_profile_title))
                .setSecondaryText(getResources().getString(R.string.promp_profile_content))
                .setBackgroundColour(getResources().getColor(R.color.colorPrimaryDark))
                .setFocalColour(baseColor)
                .setAutoDismiss(true);

        MaterialTapTargetPrompt.Builder targetFeed = new MaterialTapTargetPrompt.Builder(this)
                .setTarget(R.id.action_feed)
                .setPrimaryText(getResources().getString(R.string.promp_feed_title))
                .setSecondaryText(getResources().getString(R.string.promp_feed_content))
                .setBackgroundColour(getResources().getColor(R.color.colorPrimaryDark))
                .setFocalColour(baseColor)
                .setAutoDismiss(true);

        MaterialTapTargetPrompt.Builder targetFriends = new MaterialTapTargetPrompt.Builder(this)
                .setTarget(R.id.action_friends)
                .setPrimaryText(getResources().getString(R.string.promp_friend_title))
                .setSecondaryText(getResources().getString(R.string.promp_friend_content))
                .setBackgroundColour(getResources().getColor(R.color.colorPrimaryDark))
                .setFocalColour(baseColor)
                .setAutoDismiss(true);

        targetProfile.setPromptStateChangeListener((prompt, state) -> {
            if (state == MaterialTapTargetPrompt.STATE_DISMISSED) {
                targetFeed.show();
            }
        }).show();

        targetFeed.setPromptStateChangeListener((prompt, state) -> {
            if (state == MaterialTapTargetPrompt.STATE_DISMISSED) {
                targetFriends.show();
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_profile:
                startFragment(ProfileFragment.newInstance());
                break;
            case R.id.action_feed:
                startFragment(FeedFragment.newInstance());
                break;
            case R.id.action_friends:
                startFragment(FriendsFragment.newInstance());
                break;
        }
        return false;
    }

    private void startFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
