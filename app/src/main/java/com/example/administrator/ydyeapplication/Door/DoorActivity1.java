package com.example.administrator.ydyeapplication.Door;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.ydyeapplication.R;

public class DoorActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door1);

    }

    /**
     * 获取指定View的截图
     * @param view
     */
    public static Bitmap getImageOfView(View view) {
        int width1 = view.getMeasuredWidth();
        int height1 = view.getMeasuredHeight();
        Bitmap bmp1 = Bitmap.createBitmap(width1, height1,
                Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bmp1));
        Canvas canvas = new Canvas(bmp1);
        Paint paint = new Paint();
        paint.setColor(Color.TRANSPARENT);
        canvas.drawBitmap(bmp1, 0, 0, null);
        return bmp1;
    }


    /**
     * 实现bitmap一分为二的效果
     * @param bitmap
     * @return
     */
    public static Bitmap[] getCropBitmaps(Bitmap bitmap){
        if (bitmap == null) {
            return null;
        }

        int with = bitmap.getWidth(); // 得到图片的宽，高
        int height = bitmap.getHeight();

        int nw, nh, retX;
        nw = with / 2;
        nh = height;
        retX = with / 2;

        // 两张图片的容器
        Bitmap[] bitmaps = new Bitmap[2];
        // 第一张图片从X坐标0的地方开始截取一半的宽度
        Bitmap bmp = Bitmap.createBitmap(bitmap, 0, 0, nw, nh, null,
                false);
        // 第二张图片从X坐标为width一半的的地方开始截取一半的宽度
        Bitmap bmp1 = Bitmap.createBitmap(bitmap, retX, 0, nw, nh, null,
                false);

        bitmaps[0] = bmp;// 左边图片
        bitmaps[1] = bmp1;// 右边图片
        if (bitmap != null && !bitmap.equals(bmp) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmaps;
    }

}
