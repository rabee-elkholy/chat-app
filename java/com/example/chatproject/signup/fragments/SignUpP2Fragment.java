package com.example.chatproject.signup.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.chatproject.R;
import com.example.chatproject.signup.SignupActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpP2Fragment extends Fragment {


    public SignUpP2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_sign_up_p2, container, false);
//        view.setScaleX(0);
//        view.setScaleY(0);
        view.setTranslationX(500);
        view.setAlpha(0);
        view.animate().alpha(1).translationX(0).setDuration(200);

        Spinner spinner1 = view.findViewById(R.id.spinner);
        Spinner spinner2 = view.findViewById(R.id.spinner2);

        final SignupActivity activity = (SignupActivity) getActivity();
        activity.page2.setBackgroundResource(R.drawable.circle_btn1);
        activity.view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        spinner1.setPopupBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_edittext));
        spinner2.setPopupBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_edittext));
        return view;
    }
}
