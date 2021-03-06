package com.example.my_future.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.my_future.MainActivity;
import com.example.my_future.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    ViewPager screenPager;
    IntroViewPager introViewPager;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);

        btnNext = findViewById(R.id.btn_next);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnGetStarted = findViewById(R.id.btn_get_start);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);

        List<IntroItem> mList = new ArrayList<>();
        mList.add(new IntroItem("Выбирай тренировку и начинай работать", "Каждый найдет свой путь", R.drawable.image_intro1));
        mList.add(new IntroItem("Спроси советов у лучших", "Появился вопрос? - задай его!", R.drawable.image_intro2));
        mList.add(new IntroItem("Следи за своим питанием", "Вперед к заветному весу!", R.drawable.image_intro3));
        mList.add(new IntroItem("Отслеживай свой прогресс", "Побей свои рекорд!", R.drawable.image_intro4));

        screenPager = findViewById(R.id.Pager1);
        introViewPager = new IntroViewPager(this, mList);
        screenPager.setAdapter(introViewPager);
        screenPager.setBackgroundColor(Color.GRAY);

        tabIndicator.setupWithViewPager(screenPager);

        btnNext.setOnClickListener(view -> {
            position = screenPager.getCurrentItem();
            if (position < mList.size()) {
                position++;
                screenPager.setCurrentItem(position);
            }
            if (position == mList.size() - 1) {
                LoadLastScreen();
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size() - 1) {
                    LoadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnGetStarted.setOnClickListener(view -> {
            startActivity(new Intent(IntroActivity.this, MainActivity.class));
            finish();
        });
    }

    private void LoadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btnGetStarted.setAnimation(btnAnim);
    }
}