package com.example.tongson.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * @author Tongson
 */
public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout contentCLy = findViewById(R.id.cly_content);

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.TOP;

        mProgress = new ProgressBar(getActivity(), null, android.R.attr.progressBarStyleHorizontal);

        mProgress.setLayoutParams(lp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int endValue = 100;
                while (mProgressStatus < endValue) {
                    mProgressStatus = doWork();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();

        contentCLy.addView(mProgress, 1);

    }

    /**
     * 该程序模拟填充长度为100的数组
     */
    private int[] data = new int[100];
    private int hasData = 0;

    private Context getActivity() {
        return this;
    }

    private int doWork() {
        data[hasData++] = (int) (Math.random() * 100);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
