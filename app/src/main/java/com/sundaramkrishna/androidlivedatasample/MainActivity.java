package com.sundaramkrishna.androidlivedatasample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button increment = findViewById(R.id.increment);
        final TextView count_value = findViewById(R.id.count_value);

        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getCount().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(@Nullable Object o) {
                count_value.setText(String.format("Count is %s", Objects.requireNonNull(o).toString()));
            }
        });

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.incrementValue();
            }
        });

    }
}
