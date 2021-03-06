package com.example.gu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.listener.BannerClickListener;
import com.example.ui.BannerFlipper;
import com.example.utils.DipPxUtils;

import java.util.ArrayList;

public class BannerFlipperActivity extends AppCompatActivity implements BannerClickListener {
    private static final String TAG = "BannerFlipperActivity";

    private TextView tv_flipper;
    private BannerFlipper mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_flipper);

        tv_flipper = findViewById(R.id.tv_flipper);
        mBanner = findViewById(R.id.banner_pager);
//        LayoutParams params = (LayoutParams) mBanner.getLayoutParams();
//        Point point = DipPxUtils.getSize(this);
//        params.height = (int) (point.x * 640f / 640f);
//        mBanner.setLayoutParams(params);

        ArrayList<Integer> bannerArray = new ArrayList<>();
        bannerArray.add(Integer.valueOf(R.drawable.banner_1));
        bannerArray.add(Integer.valueOf(R.drawable.banner_2));
        bannerArray.add(Integer.valueOf(R.drawable.banner_3));
        bannerArray.add(Integer.valueOf(R.drawable.banner_4));
        bannerArray.add(Integer.valueOf(R.drawable.banner_5));
        bannerArray.add(Integer.valueOf(R.drawable.banner_6));
        bannerArray.add(Integer.valueOf(R.drawable.banner_7));
        mBanner.setImage(bannerArray);
        mBanner.setOnBannerListener(this);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBannerClick(int position) {
        String desc = String.format("你点击了第%d张图片", position + 1);
        tv_flipper.setText(desc);
    }
}
