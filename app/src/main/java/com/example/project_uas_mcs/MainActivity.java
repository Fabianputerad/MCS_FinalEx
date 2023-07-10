package com.example.project_uas_mcs;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    PagerAdapter pagerAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);


        setViewPager2(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(pagerAdapter.getFragmentTitle(position))).attach();

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }

                        String token = task.getResult();
                        System.out.println("Your Token: "+token);
                    }
                });

    }
    private void setViewPager2(ViewPager2 viewPager2) {
        if(pagerAdapter == null){
            pagerAdapter = new PagerAdapter(this);
            pagerAdapter.addFragment(new HomeFragment(), "Home");
            pagerAdapter.addFragment(new NotificationFragment(), "Notification");
            viewPager2.setAdapter(pagerAdapter);
        }
    }


}