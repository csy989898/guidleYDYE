package com.example.administrator.ydyeapplication.Door;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ydyeapplication.MainActivity;
import com.example.administrator.ydyeapplication.R;

/**
 * Created by Administrator on 2019/3/27.
 */

public class WhatsDoorActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.whatsdoor);

        //获取控件
        ImageView left = (ImageView) findViewById(R.id.imageLeft);
        ImageView right = (ImageView) findViewById(R.id.imageRight);
        TextView text = (TextView) findViewById(R.id.animText);



        //也可以在XML中实现
        //左边动画
        AnimationSet left_anim = new AnimationSet(true);               //动画集合，对加入的动画都有效

        TranslateAnimation left_translate = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                -1f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f);
        left_translate.setDuration(4500);

        left_anim.addAnimation(left_translate);
        left_anim.setStartOffset(800);
        left_anim.setFillAfter(true);

        left.startAnimation(left_anim);

        //右边动画
        AnimationSet right_anim = new AnimationSet(true);

        TranslateAnimation right_translate = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                +1f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f);
        right_translate.setDuration(4500);

        right_anim.addAnimation(right_translate);
        right_anim.setStartOffset(800);
        right_anim.setFillAfter(true);

        right.startAnimation(right_anim);

        //字体动画
        AnimationSet text_anim = new AnimationSet(true);

        ScaleAnimation text_scale = new ScaleAnimation(
                1f,
                3f,
                1f,
                3f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);
        text_scale.setDuration(1000);
        AlphaAnimation text_alpha = new AlphaAnimation(1,0.0001f);
        text_alpha.setDuration(4500);

        text_anim.addAnimation(text_scale);
        text_anim.addAnimation(text_alpha);
        text_anim.setFillAfter(true);
        text.startAnimation(text_anim);


        //延时一段时间后开启主界面
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(WhatsDoorActivity.this,MainActivity.class);//进入主界面，在第（七）节内容中实现该类
                startActivity(intent);
                WhatsDoorActivity.this.finish();
            }
        }, 2500);



    }

}
