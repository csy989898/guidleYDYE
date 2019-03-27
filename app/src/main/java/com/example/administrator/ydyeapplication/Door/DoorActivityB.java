package com.example.administrator.ydyeapplication.Door;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.ydyeapplication.R;

import java.util.Locale;

public class DoorActivityB extends AppCompatActivity {

    private Bitmap bitmap;
    private ImageView coverImage1;
    private ImageView coverImage2;
    private LinearLayout coverImageContainer;
    private DoorActivity1 CommonFunction;
    private Locale EventBus;
    private View openAContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door_b);
        // 注意这里注册在初始化Bitmap之前调用

       // EventBus.getDefault().register(this);
        // 初始化视图
        initView();
        // 获取imageView加载的bitmap


        Bitmap bmp = CommonFunction.getImageOfView(openAContainer);
       // EventBus.getDefault().postSticky(new BusEvent(2, bmp));// 发送粘性事件


        Bitmap[] bitmaps = CommonFunction.getCropBitmaps(bitmap);// 这里的bitmap为A页面通过EventBus传进来的A页面视图
        coverImage1.setImageBitmap(bitmaps[0]);
        coverImage2.setImageBitmap(bitmaps[1]);
        coverImage1.animate()
                .setDuration(1000)
                .translationX(-bitmaps[0].getWidth())
                .start();
        coverImage2.animate()
                .setDuration(1000)
                .translationX(bitmaps[1].getWidth())
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        coverImageContainer.setVisibility(View.GONE);
                    }
                })
                .start();

    }


    /**
     * 粘性事件(可以收到注册之前发送的消息)
     * @param busEvent
     */
   /* @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onBitmapRecieveEvent(BusEvent busEvent) {
        if (busEvent.getCode() == 2) {
            bitmap = (Bitmap) busEvent.getData();
        }
    }*/


    @Override
    public void onBackPressed() {
        coverImageContainer.setVisibility(View.VISIBLE);
        coverImage1.animate()
                .setDuration(1000)
                .translationX(0)
                .start();
        coverImage2.animate()
                .setDuration(1000)
                .translationX(0)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        overridePendingTransition(0, 0);
                    }
                })
                .start();

    }

    private void initView() {
        coverImage1 = (ImageView) findViewById(R.id.coverImage1);
        coverImage2 = (ImageView) findViewById(R.id.coverImage2);
        coverImageContainer = (LinearLayout) findViewById(R.id.coverImageContainer);
    }
}
