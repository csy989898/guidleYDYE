package com.example.administrator.ydyeapplication.Door;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.ydyeapplication.R;

public class GuideDoorActivity extends AppCompatActivity {
    private ImageView mLeft;
    private ImageView mRight;
    private LinearLayout mAnimContainer;
    private RelativeLayout mMainContainer;
    private static final String TAG = "GuideDoorActivity";
    private Button btn_open_door;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_door);
        initView();
       // initNewData();
    }
   /* @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        initData();
    }*/

    private void initNewData() {
        int height=0;
        for (int i = 0; i < mMainContainer.getChildCount(); i++) {
            height+=mMainContainer.getChildAt(i).getHeight();
        }
        //创建对应大小的Bitmap
        Log.e(TAG, "initNewData: "+mMainContainer.getWidth()+"....."+height);
        Bitmap bitmap = Bitmap.createBitmap(300, 500, Bitmap.Config.ARGB_8888);
        Bitmap leftBitmap = getLeftBitmap(bitmap);
        mLeft.setImageBitmap(leftBitmap);

        Bitmap rightBitmap = getRightBitmap(bitmap);
        mRight.setImageBitmap(rightBitmap);
        startOpenAnim();
    }

    private void initData() {
        //缓存图像
        mMainContainer.setDrawingCacheEnabled(true);  //开启缓存
        mMainContainer.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH); //设置缓存的质量
        //        mMainContainer.buildDrawingCache();
        //        mMainContainer.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
        //                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        //        mMainContainer.layout(0, 0, mMainContainer.getMeasuredWidth(), mMainContainer.getMeasuredHeight());
        Bitmap bitmap = mMainContainer.getDrawingCache();

        Bitmap leftBitmap = getLeftBitmap(bitmap);
        mLeft.setImageBitmap(leftBitmap);

        Bitmap rightBitmap = getRightBitmap(bitmap);
        mRight.setImageBitmap(rightBitmap);

        startOpenAnim();
    }

    private void startOpenAnim() {
        mMainContainer.setVisibility(View.GONE);
        mAnimContainer.setVisibility(View.VISIBLE);
        int leftWidth = mLeft.getWidth();
        int rightWidth = mRight.getWidth();
        ObjectAnimator leftAnim = ObjectAnimator.ofFloat(mLeft, "translationX", 0, -leftWidth);
        ObjectAnimator rightAnim = ObjectAnimator.ofFloat(mRight, "translationX",0, rightWidth);
        ObjectAnimator mainAnim = ObjectAnimator.ofFloat(mAnimContainer, "alpha", 1, 0);
        AnimatorSet set=new AnimatorSet();
        set.setDuration(6*1000);
        set.playTogether(leftAnim,rightAnim,mainAnim);
        set.start();
    }

    private Bitmap getRightBitmap(Bitmap bitmap) {
        int width=(int) (bitmap.getWidth() / 2f + 0.5f);
        //画画需要白纸,Bitmap就是那张白纸
        Bitmap rightCopyBitmap = Bitmap.createBitmap(width, bitmap.getHeight(), bitmap.getConfig());
        //创建画布
        Canvas canvas=new Canvas(rightCopyBitmap);
        Matrix matrix=new Matrix();
        //要获取右半部分的图片则需要图片向左平移一半
        matrix.setTranslate(-width,0);
        //画画需要画笔,创建画笔
        Paint paint=new Paint();
        canvas.drawBitmap(bitmap,matrix,paint);
        return rightCopyBitmap;
    }

    private Bitmap getLeftBitmap(Bitmap bitmap) {
        int width=(int) (bitmap.getWidth() / 2f + 0.5f);
        //画画需要白纸,Bitmap就是那张白纸
        Bitmap leftCopyBitmap = Bitmap.createBitmap(width, bitmap.getHeight(), bitmap.getConfig());
        //创建画布
        Canvas canvas=new Canvas(leftCopyBitmap);
        Matrix matrix = new Matrix();
        //画画需要画笔,创建画笔
        Paint paint=new Paint();
        canvas.drawBitmap(bitmap,matrix,paint);
        return leftCopyBitmap;

    }

    private void initView() {
        mLeft = (ImageView) findViewById(R.id.iv_left);
        mRight = (ImageView) findViewById(R.id.iv_right);
        mAnimContainer = (LinearLayout) findViewById(R.id.anim_container);
        mMainContainer = (RelativeLayout) findViewById(R.id.main_container);
        btn_open_door=findViewById(R.id.btn_door);
        btn_open_door.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });

    }



}
