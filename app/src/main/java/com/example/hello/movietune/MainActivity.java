package com.example.hello.movietune;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hello.movietune.adapter.TabAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewName;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabAdapter mTabAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initActiion();

    }

    private void init(){
        //mTextViewName = findViewById(R.id.textViewName);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.slidingTabs);

        mTabAdapter = new TabAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mTabAdapter);
        mTabLayout.setupWithViewPager(mViewPager);



    }

    private void initActiion(){
        /*mTextViewName.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mTextViewName.setText("Hello Piash");
                    }
                }
        );*/
    }
}
