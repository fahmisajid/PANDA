package com.example.acer.panda;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;
    private SlideAdapter slideAdapter;

    private Button mNextBtn;
    private Button mBackBtn;

    private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);//panggil dotslayout di activity main

        mNextBtn = (Button) findViewById(R.id.nextbtn);
        mBackBtn = (Button) findViewById(R.id.prevbtn);

        slideAdapter = new SlideAdapter(this);

        mSlideViewPager.setAdapter(slideAdapter);

        addDotsIndicator( 0 );

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 mSlideViewPager.setCurrentItem(mCurrentPage +1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage -1);
            }
        });
    }

    //add DOTS
    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i=0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorGrey));

            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0 ){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            mCurrentPage = i;

            if(i == 0){

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("");
            }else if (i == mDots.length -1){

                mNextBtn.setEnabled(false);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("");
                mBackBtn.setText("Back");
            }else{

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
