package com.example.chatproject.forgetpassword.fragmentation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.chatproject.R;
import com.example.chatproject.forgetpassword.MyAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReturnByAdminFragment extends Fragment {

    private MyAdapter mAdapter;


    public ReturnByAdminFragment() {
        // Required empty public constructor
    }

    public ReturnByAdminFragment(MyAdapter mAdapter){
        this.mAdapter = mAdapter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_by_admin, container, false);
        ListView admins = (ListView) view.findViewById(R.id.admins_list);
        admins.setAdapter(mAdapter);
        return view;
    }

}
