package com.cqsx.rgzn.smartagriculture.Activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    Paint paint;
    public MyView(Context context) {
        super(context);
        setPrint();
    }

    private void setPrint() {
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.YELLOW);
          paint.setStrokeWidth(10);
        canvas.drawLine(0,0,100,100,paint);
    }
}
