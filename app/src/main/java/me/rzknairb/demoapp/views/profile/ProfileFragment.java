package me.rzknairb.demoapp.views.profile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseFragment;
import me.rzknairb.domain.entities.User;

public class ProfileFragment extends BaseFragment implements ProfilePresenter.View {

    @Inject ProfilePresenter profilePresenter;


    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        profilePresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onLoadProfile(User user) {
        Toast.makeText(this.getContext(), "Implementar Perfil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorProfile() {
        Toast.makeText(this.getContext(), "Error al cargar Perfil", Toast.LENGTH_SHORT).show();
    }
}
