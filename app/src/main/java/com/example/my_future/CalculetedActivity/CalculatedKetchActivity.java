
package com.example.my_future.CalculetedActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_future.R;

public class CalculatedKetchActivity extends AppCompatActivity {
    TextView text_gender_noVisible, text_activity_noVisible;
    ImageView activity1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_ketch);

        genderSelected();
        activitySelected();
        dataWrite();
    }

    private void genderSelected() {
        text_gender_noVisible = findViewById(R.id.visible_text_gender);
        ImageButton but_man = findViewById(R.id.image_click_man);
        ImageButton but_girl = findViewById(R.id.image_click_girl);
        Button next_gender = findViewById(R.id.but_gender_nextClick);

        but_man.setOnClickListener(view -> {
            text_gender_noVisible.setText("Мужской");
            but_man.setBackgroundResource(R.drawable.border_for_calc_active);
            but_girl.setBackgroundResource(R.drawable.border_for_edittext);

        });
        but_girl.setOnClickListener(view -> {
            text_gender_noVisible.setText("Женский");
            but_girl.setBackgroundResource(R.drawable.border_for_calc_active);
            but_man.setBackgroundResource(R.drawable.border_for_edittext);
        });
        next_gender.setOnClickListener(view -> {
            if (text_gender_noVisible.getText().toString().isEmpty()) {
                Toast.makeText(CalculatedKetchActivity.this, "Выберите пол", Toast.LENGTH_SHORT).show();
                return;
            }
            RelativeLayout relativeGender = findViewById(R.id.genderRel);
            relativeGender.setVisibility(View.GONE);
            RelativeLayout relativeActivity = findViewById(R.id.activityRel);
            relativeActivity.setVisibility(View.VISIBLE);
        });
    }

    private void activitySelected() {
        text_activity_noVisible = findViewById(R.id.visible_text_activity);
        ImageButton but_activity_1 = findViewById(R.id.image_click_activity_1);
        ImageButton but_activity_2 = findViewById(R.id.image_click_activity_2);
        ImageButton but_activity_3 = findViewById(R.id.image_click_activity_3);
        ImageButton but_activity_4 = findViewById(R.id.image_click_activity_4);
        ImageButton but_activity_5 = findViewById(R.id.image_click_activity_5);
        Button next_activity = findViewById(R.id.but_activity_nextClick);

        but_activity_1.setOnClickListener(view -> {
            text_activity_noVisible.setText("1.2");
            but_activity_1.setBackgroundResource(R.drawable.border_for_calc_active);
            but_activity_2.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_3.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_4.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_5.setBackgroundResource(R.drawable.border_for_calc);
        });
        but_activity_2.setOnClickListener(view -> {
            text_activity_noVisible.setText("1.375");
            but_activity_2.setBackgroundResource(R.drawable.border_for_calc_active);
            but_activity_1.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_3.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_4.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_5.setBackgroundResource(R.drawable.border_for_calc);
        });
        but_activity_3.setOnClickListener(view -> {
            text_activity_noVisible.setText("1.55");
            but_activity_3.setBackgroundResource(R.drawable.border_for_calc_active);
            but_activity_2.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_1.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_4.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_5.setBackgroundResource(R.drawable.border_for_calc);
        });
        but_activity_4.setOnClickListener(view -> {
            text_activity_noVisible.setText("1.725");
            but_activity_4.setBackgroundResource(R.drawable.border_for_calc_active);
            but_activity_2.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_3.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_1.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_5.setBackgroundResource(R.drawable.border_for_calc);
        });
        but_activity_5.setOnClickListener(view -> {
            text_activity_noVisible.setText("1.9");
            but_activity_5.setBackgroundResource(R.drawable.border_for_calc_active);
            but_activity_2.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_3.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_4.setBackgroundResource(R.drawable.border_for_calc);
            but_activity_1.setBackgroundResource(R.drawable.border_for_calc);
        });
        next_activity.setOnClickListener(view -> {
            if (text_activity_noVisible.getText().toString().isEmpty()) {
                Toast.makeText(CalculatedKetchActivity.this, "Выберите свою активность", Toast.LENGTH_SHORT).show();
                return;
            }

            RelativeLayout relativeActivity = findViewById(R.id.activityRel);
            relativeActivity.setVisibility(View.GONE);
            RelativeLayout relativeData = findViewById(R.id.dataRel);
            relativeData.setVisibility(View.VISIBLE);
        });
    }

    private void dataWrite() {
        EditText age_text = findViewById(R.id.age);
        EditText growth_text = findViewById(R.id.growth);
        EditText weight_text = findViewById(R.id.weight);
        Button calculate = findViewById(R.id.but_data_nextClick);

        calculate.setOnClickListener(view -> {
            if (age_text.getText().toString().isEmpty()) {
                Toast.makeText(CalculatedKetchActivity.this, "Введите свой возраст", Toast.LENGTH_SHORT).show();
                return;
            }
            if (growth_text.getText().toString().isEmpty()) {
                Toast.makeText(CalculatedKetchActivity.this, "Введите свой рост", Toast.LENGTH_SHORT).show();
                return;
            }
            if (weight_text.getText().toString().isEmpty()) {
                Toast.makeText(CalculatedKetchActivity.this, "Введите свой вес", Toast.LENGTH_SHORT).show();
                return;
            }

            RelativeLayout relativeData = findViewById(R.id.dataRel);
            relativeData.setVisibility(View.GONE);
            RelativeLayout relativeResult = findViewById(R.id.resultRel);
            relativeResult.setVisibility(View.VISIBLE);
            TextView result_norm_text = findViewById(R.id.result_norm);
            TextView result_kit_text = findViewById(R.id.result_kit);
            TextView result_slimming_text = findViewById(R.id.result_slimming);

            double activity = Double.parseDouble(text_activity_noVisible.getText().toString());
            double weight = Double.parseDouble(weight_text.getText().toString());
            double growth = Double.parseDouble(growth_text.getText().toString());
            int age = Integer.parseInt(age_text.getText().toString());

            double imt = weight / ((growth / 100) * (growth / 100));
            if (text_gender_noVisible.getText().toString().equals("Мужской")) {
                double fat = (1.2 * imt) + (0.23 * age) - (10.8 * 1) - 5.4;
                double lbm = (weight * (100 - fat)) / 100;
                double bmr = (370 + (21.6 * lbm)) * activity;

                result_norm_text.setText(Math.round(bmr) + " калорий");
                double kit = bmr + (bmr * 20 / 100);
                result_kit_text.setText(Math.round(kit) + " калорий");
                double slimming = bmr - (bmr * 20 / 100);
                result_slimming_text.setText(Math.round(slimming) + " калорий");
            }
            if (text_gender_noVisible.getText().toString().equals("Женский")) {
                double fat = (1.2 * imt) + (0.23 * age) - (10.8 * 0) - 5.4;
                double lbm = (weight * (100 - fat)) / 100;
                double bmr = (370 + (21.6 * lbm)) * activity;

                result_norm_text.setText(Math.round(bmr) + " калорий");
                double kit = bmr + (bmr * 20 / 100);
                result_kit_text.setText(Math.round(kit) + " калорий");
                double slimming = bmr - (bmr * 20 / 100);
                result_slimming_text.setText(Math.round(slimming) + " калорий");
            }
        });
    }

    public void onClickBack(View view) {
        onBackPressed();
    }

}