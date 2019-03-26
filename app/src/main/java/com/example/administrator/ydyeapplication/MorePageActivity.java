package com.example.administrator.ydyeapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MorePageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager vPager;
    private VpAdapter vpAdapter;
    private static  int[] imgs = {R.drawable.ca,R.drawable.cb, R.drawable.cc};
    private ArrayList<ImageView> imageViews;
    private ImageView[] dotViews;//小圆点

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_page);
        ViewPager.LayoutParams mParams = new ViewPager.LayoutParams();
        initImages();
        initDots();
    }

    /*
    * 把引导页要显示的图片添加到集合中，以传递给适配器，用来显示图片
    * */
   // @Override
    public void initImages(){
        //设置每一张图片都填充窗口
        ViewPager.LayoutParams mParams = new ViewPager.LayoutParams();
        imageViews = new ArrayList<ImageView>();

        for(int i=0; i<imgs.length; i++)
        {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);//设置布局
            iv.setImageResource(imgs[i]);//为ImageView添加图片资源
            iv.setScaleType(ImageView.ScaleType.FIT_XY);//这里也是一个图片的适配
            imageViews.add(iv);
            if (i == imgs.length -1 ){
                //为最后一张图片添加点击事件
                iv.setOnTouchListener(new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event){
                        Intent toMainActivity = new Intent(MorePageActivity.this, MainActivity.class);//跳转到主界面
                        startActivity(toMainActivity);
                        return true;

                    }
                });
            }
        }
    }

    /*
    * 是小圆点数量判断以及小圆点之间的间隔&小圆点默认启动显示的位置
    * */
    private void initDots(){
        LinearLayout layout = (LinearLayout)findViewById(R.id.dot_Layout);
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(20, 20);
        mParams.setMargins(10, 0, 10,0);//设置小圆点左右之间的间隔
        dotViews = new ImageView[imgs.length];
        //判断小圆点的数量，从0开始，0表示第一个
        for(int i = 0; i < imageViews.size(); i++)
        {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(mParams);
            imageView.setImageResource(R.drawable.dotselector);
            if(i== 0)
            {
                imageView.setSelected(true);//默认启动时，选中第一个小圆点
            }
            else {
                imageView.setSelected(false);
            }
            dotViews[i] = imageView;//得到每个小圆点的引用，用于滑动页面时，（onPageSelected方法中）更改它们的状态。
            layout.addView(imageView);//添加到布局里面显示
        }

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    /*
        * 根据当前页面的索引值来设置小圆点的状态
        * */
    public void onPageSelected(int arg0) {
        for (int i = 0; i < dotViews.length; i++) {
            if (arg0 == i) {
                dotViews[i].setSelected(true);
            } else {
                dotViews[i].setSelected(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

}
