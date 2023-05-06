package com.example.prac10;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
public class prc12 extends AppCompatActivity {
    ImageView img;
    Canvas canvas;
    Paint paint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prc12);
        setDrawingElements();
        callDrawingThread();
    }
    private void setDrawingElements() {
        img = findViewById(R.id.imageView);
        Bitmap bp = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        img.setImageDrawable(new BitmapDrawable(getResources(),bp));
        canvas = new Canvas(bp);
        paint = new Paint();
        paint.setTextSize(100);
    }
    private void callDrawingThread() {
        drawCircle(Color.BLACK, 20);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                img.invalidate();
                drawCircle(Color.MAGENTA, 40);
            }
        }, 5000);
        final Handler handler2 = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                img.invalidate();
                drawCircle(Color.RED, 60);
            }
        }, 10000);
    }
    public void drawCircle(int color, int size) {
        paint.setColor(color);
        canvas.drawText("Circle", 220, 450, paint);
        canvas.drawCircle(360, 680, size, paint);
    }
}
