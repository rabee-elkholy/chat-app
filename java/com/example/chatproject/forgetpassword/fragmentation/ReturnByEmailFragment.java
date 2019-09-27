package com.example.chatproject.forgetpassword.fragmentation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.chatproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReturnByEmailFragment extends Fragment {


    public ReturnByEmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_by_email, container, false);

    }


}
