package com.example.chatproject.signup.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.chatproject.R;
import com.example.chatproject.signup.SignupActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpP1Fragment extends Fragment {


    public SignUpP1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_sign_up_p1, container, false);
        SignupActivity activity = (SignupActivity) getActivity();
        if (activity != null && activity.currentPNum == 1) {
            activity.currentPNum = 0;
            view.setTranslationX(-800);
            view.setAlpha(0);
            view.animate().translationX(0).alpha(1).setDuration(200);
        }
        return view;
    }

}
