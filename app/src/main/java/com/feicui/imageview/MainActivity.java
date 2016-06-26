package com.feicui.imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.InputStream;



public class MainActivity extends Activity implements View.OnClickListener {
    public static final int WHAT = 1;
    private ImageView mImageView;
    private Button mButton;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){

                case WHAT:
                    mImageView.setImageBitmap(mBitmap);
                    break;
            }
        }
    };

    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView= (ImageView) findViewById(R.id.imageview);
        mButton= (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                InputStream inputStream=HttpUtils.getImageViewInputStream();
                mBitmap = BitmapFactory.decodeStream(inputStream);
                mHandler.sendEmptyMessage(WHAT);
            }
        }.start();

    }
}
