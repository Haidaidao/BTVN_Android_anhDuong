package com.example.btvn_fragment_navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.example.btvn_fragment_navbar.Fragment.CartFragment;
import com.example.btvn_fragment_navbar.Fragment.HomeFragment;
import com.example.btvn_fragment_navbar.Fragment.PageFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements HomeFragment.ISendDataListener {
    TabLayout tabLayout;
    ViewPager2 vp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mapView();

        vp2.setAdapter(new PageFragment(MainActivity.this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, vp2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Home");
                        tab.setIcon(R.drawable.baseline_home_24);

                        break;
                    case 1:
                        tab.setText("Cart");
                        tab.setIcon(R.drawable.baseline_shopping_cart_24);
                        BadgeDrawable badgeDrawable1 = tab.getOrCreateBadge();
                        badgeDrawable1.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.purple_200)
                        );
                        badgeDrawable1.setVisible(true);
                        badgeDrawable1.setNumber(3);
                        badgeDrawable1.setMaxCharacterCount(3);
                        break;
                    case 2:
                        tab.setText("Me");
                        tab.setIcon(R.drawable.baseline_sentiment_very_satisfied_24);

                        break;
                }
            }
        });
        tabLayoutMediator.attach();

        vp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });

    }

    private void mapView() {
        tabLayout = findViewById(R.id.tab_layout);
        vp2 = findViewById(R.id.vp2);
    }

    @Override
    public void sendData(String data) {
        CartFragment cartFragment= new CartFragment();
        Log.i("data","==="+data);
        cartFragment.receiveDatafromHomeFragment(data);
        //cartFragment.dataReceive=data;
    }
}