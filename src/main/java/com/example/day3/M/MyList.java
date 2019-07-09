package com.example.day3.M;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class MyList extends GridView {
    public MyList(Context context) {
        super(context);
    }

    public MyList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
