package com.example.administrator.ydyeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.ydyeapplication.Door.GuideDoorActivity;
import com.example.administrator.ydyeapplication.guidePage.GuideMoreActivity;
import com.example.administrator.ydyeapplication.guideVideo.GuidePagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button videoPage;
    private Button morePage;
    private Button onePage;
    private Button Page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        videoPage = (Button) findViewById(R.id.videoPage);
        morePage = (Button) findViewById(R.id.morePage);
        onePage = (Button) findViewById(R.id.onePage);
        Page = (Button) findViewById(R.id.Page);

        videoPage.setOnClickListener(this);
        morePage.setOnClickListener(this);
        onePage.setOnClickListener(this);
        Page.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.videoPage:
                startActivity(new Intent(MainActivity.this,GuidePagerActivity.class));
                finish();
                break;
            case R.id.morePage:
                startActivity(new Intent(MainActivity.this,GuideMoreActivity.class));
                finish();
                break;
            case R.id.onePage:
                startActivity(new Intent(MainActivity.this,GuidePagerActivity.class));
                finish();
                break;
            case R.id.Page:
                startActivity(new Intent(MainActivity.this,GuideDoorActivity.class));
                finish();
                break;
        }
    }
}
