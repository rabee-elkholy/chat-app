package com.example.chatproject.forgetpassword;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import com.example.chatproject.R;
import com.example.chatproject.forgetpassword.fragmentation.ReturnByAdminFragment;
import com.example.chatproject.forgetpassword.fragmentation.ReturnByEmailFragment;
import com.example.chatproject.forgetpassword.fragmentation.ReturnByPhoneFragment;

import java.util.ArrayList;

public class ForgetPasswordActivity extends AppCompatActivity {
    LinearLayout s;
    FrameLayout fragmentContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        final CardView returnByEmailCrv = findViewById(R.id.crv_by_email_forgetpass);
        CardView returnByPhone = findViewById(R.id.crv_return_by_phone_forgetpass);
        CardView returnByAdmin = findViewById(R.id.crv_return_by_admin_forgetpass);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        fragmentContainer = findViewById(R.id.fragment_container_forgetpass);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        s = findViewById(R.id.LinerL);
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin("ربيع الخولي", "ادمن"));
        admins.add(new Admin("احمد محمد", "تاجر"));
        admins.add(new Admin("محمد احمد", "ادمن"));
        admins.add(new Admin("ربيع الخولي", "تاجر"));
        admins.add(new Admin("محمود خالد", "ادمن"));
        admins.add(new Admin("ربيع الخولي", "تاجر"));
        admins.add(new Admin("ربيع سعد", "ادمن"));
        admins.add(new Admin("ربيع الخولي", "تاجر"));
        admins.add(new Admin("ربيع الخولي", "ادمن"));
        // specify an adapter (see also next example)
        final MyAdapter mAdapter = new MyAdapter(this, admins);


        returnByEmailCrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transitionSupport = getSupportFragmentManager().beginTransaction();
                transitionSupport.add(R.id.fragment_container_forgetpass, new ReturnByEmailFragment());
                transitionSupport.addToBackStack("1");
                transitionSupport.commit();
                forewordAnimation();
            }
        });

        returnByPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transitionSupport = getSupportFragmentManager().beginTransaction();
                transitionSupport.add(R.id.fragment_container_forgetpass, new ReturnByPhoneFragment());
                transitionSupport.addToBackStack("2");
                transitionSupport.commit();
                forewordAnimation();

            }
        });

        returnByAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transitionSupport = getSupportFragmentManager().beginTransaction();
                transitionSupport.add(R.id.fragment_container_forgetpass, new ReturnByAdminFragment(mAdapter));
                transitionSupport.addToBackStack("3");
                transitionSupport.commit();
                forewordAnimation();

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
            view = new View(ForgetPasswordActivity.this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }else {
            backAnimation();
        }
    }

    private void forewordAnimation() {
        s.animate().setDuration(200).translationX(-1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                s.setVisibility(View.INVISIBLE);
            }
        });
        fragmentContainer.setVisibility(View.VISIBLE);
        fragmentContainer.setScaleX(0);
        fragmentContainer.setScaleY(0);
        fragmentContainer.animate().setDuration(200).scaleY(1).scaleX(1).alpha(1);
    }

    private void backAnimation() {
        s.setVisibility(View.VISIBLE);
        s.animate().setDuration(200).translationX(0);
        fragmentContainer.animate().scaleY(0).scaleX(0).setDuration(200).alpha(0).withEndAction(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().popBackStack();
            }
        });
    }
}
