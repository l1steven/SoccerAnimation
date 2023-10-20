package com.tradan.socceranimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
public class SoccerField extends View
{
    private Paint p=new Paint();
    private int x=500;
    private int y=500;
    private int dx=(int)(Math.random()*10);
    private int dy=(int)(Math.random()*10);

    public SoccerField(Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        int maxX=canvas.getWidth();
        int maxY=canvas.getHeight();
        canvas.drawRect(20,20,maxX-20,maxY-20,p);
        int penaltyDistX=(int) maxX/5;
        int penaltyDistY=(int) maxY/7;
        canvas.drawRect(penaltyDistX,20,maxX-penaltyDistX,penaltyDistY,p);
        canvas.drawRect(penaltyDistX,maxY-penaltyDistY,maxX-penaltyDistX,maxY-20,p);
        canvas.drawLine(20,maxY/2,maxX-20,maxY/2,p);
        canvas.drawCircle(maxX/2,maxY/2,maxY/10,p);
        p.setStyle(Paint.Style.FILL);
        drawBall(canvas,p);
        invalidate();


    }
    private void drawBall(Canvas canvas,Paint p)
    {
        int r=80;
        x=x+dx;
        y=y+dy;
        if(x+r>=canvas.getWidth())
        {
            dx=dx*-1;
            x=x+dx;
        }
        if(x-r<0)
        {
            dx=dx*-1;
            x=x+dx;
        }
        if(y+r>=canvas.getHeight())
        {
            dy=dy*-1;
            y=y+dy;
        }
        if(y-r<0)
        {
            dy=dy*-1;
            y=y+dy;
        }
        canvas.drawCircle(x,y,r,p);




    }
}
