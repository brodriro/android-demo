package me.rzknairb.demoapp.views.friends;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseFragment;
import me.rzknairb.demoapp.views.user_profile.UserProfileActivity;
import me.rzknairb.domain.entities.User;

public class FriendsFragment extends BaseFragment implements FriendsPresenter.View, FriendsAdapter.FriendAdapterListener {

    @Inject
    FriendsPresenter presenter;
    @Inject
    FriendsAdapter friendsAdapter;
    @Inject
    Context context;

    public FriendsFragment() {
        // Required empty public constructor
    }

    public static FriendsFragment newInstance() {
        FriendsFragment fragment = new FriendsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.recycler_friends)
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        ButterKnife.bind(this, view);

        friendsAdapter.addListener(this);
        recyclerView.setAdapter(friendsAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.start();
    }

    @Override
    public void onDataReady(List<User> list) {
        this.friendsAdapter.updateList(list);
    }

    @Override
    public void onError() {
        if (getView() != null)
            Snackbar.make(getView(), "Error al obtener la lista de Amigos", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        showProgressBar();
    }

    @Override
    public void hideLoading() {
        hideProgressBar();
    }

    @Override
    public void onClickItemListener(String idUser) {
        startActivity(UserProfileActivity.getCallIntent(this.getContext(), idUser));
    }
}
