package com.example.chatproject.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.chatproject.R;
import com.example.chatproject.signup.fragments.SignUpP1Fragment;
import com.example.chatproject.signup.fragments.SignUpP2Fragment;

public class SignupActivity extends AppCompatActivity {

    public FrameLayout fragmentContainer;
    public FragmentManager fragmentManager;
    public Button page2;
    public View view;
    public int currentPNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        page2 = findViewById(R.id.btn_p2_signup);
        fragmentContainer = findViewById(R.id.fragment_container_signUp);
        view = findViewById(R.id.view_signUp);
        Button goToNext = findViewById(R.id.btn_next_signUp);
        TextView textView = findViewById(R.id.txt_go_to_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container_signUp, new SignUpP1Fragment())
                .commit();


        goToNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPNum == 0){
                    currentPNum += 1;
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragment_container_signUp, new SignUpP2Fragment())
                            .addToBackStack(null)
                            .commit();

                }else {
                    finish();
                }

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(SignupActivity.this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        super.onBackPressed();
        page2.setBackgroundResource(R.drawable.circle_btn2);
        this.view.setBackgroundColor(getResources().getColor(R.color.disabled_btn_color));
    }


}
