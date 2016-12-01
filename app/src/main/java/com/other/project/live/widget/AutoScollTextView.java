package com.other.project.live.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by wanghaixin on 16/11/29.
 */
public class AutoScollTextView extends TextView implements View.OnClickListener {
    public final static String TAG = AutoScollTextView.class.getSimpleName();

    private float textLength = 0f;//文本长度
    private float viewWidth = 0f;
    private float step = 0f;//文字的横坐标
    private float y = 0f;//文字的纵坐标
    private float temp_view_plus_text_length = 0.0f;//用于计算的临时变量
    private float temp_view_plus_two_text_length = 0.0f;//用于计算的临时变量
    public boolean isStarting = false;//是否开始滚动
    private Paint paint = null;//绘图样式
    private String text = "";//文本内容


    public AutoScollTextView(Context context) {
        super(context);
        initView();
    }

    public AutoScollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AutoScollTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        setOnClickListener(this);
    }

    /**
     * 文本初始化，每次更改文本内容或者文本效果等之后都需要重新初始化一下
     */
    public void init(WindowManager windowManager) {
        paint = getPaint();
        text = getText().toString();
        textLength = paint.measureText(text);
        viewWidth = getWidth();
        if (viewWidth == 0) {
            if (windowManager != null) {
                Display display = windowManager.getDefaultDisplay();
                viewWidth = display.getWidth();
            }
        }
        step = 1;
        temp_view_plus_text_length = viewWidth -10;
        temp_view_plus_two_text_length = viewWidth + textLength ;
        y = getTextSize() + getPaddingTop()+8;
    }


    /**
     * 开始滚动
     */
    public void startScroll() {
        isStarting = true;
        invalidate();
    }

    /**
     * 停止滚动
     */
    public void stopScroll() {
        isStarting = false;
        invalidate();
    }


    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawText(text, temp_view_plus_text_length - step, y, paint);
        if (!isStarting) {
            return;
        }
        step += 1;
        if (step > temp_view_plus_two_text_length)
            step = 1;
        invalidate();

    }

    @Override
    public void onClick(View v) {
        if (isStarting)
            stopScroll();
        else
            startScroll();

    }

}
