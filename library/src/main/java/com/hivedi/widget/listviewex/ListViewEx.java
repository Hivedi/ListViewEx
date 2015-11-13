package com.hivedi.widget.listviewex;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Kenumir on 2015-11-07.
 *
 */
public class ListViewEx extends ListView {

    private OnItemClickListener itemClick, itemClickEx;
    private long lastItemClick = 0;
    private int clickDelay = 500;

    public ListViewEx(Context context) {
        super(context);
        init();
    }

    public ListViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ListViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ListViewEx(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        itemClickEx = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (itemClick != null && System.currentTimeMillis() - lastItemClick > getClickDelay()) {
                    lastItemClick = System.currentTimeMillis();
                    itemClick.onItemClick(parent, view, position, id);
                } else {
                    // skip click event when fired too quickly
                }
            }
        };
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.dispatchDraw(canvas);
        } else {
            try {
                super.dispatchDraw(canvas);
            } catch (Exception ignore) {
                // sometimes happens on old android
            }
        }
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClick = listener;
        super.setOnItemClickListener(itemClickEx);
    }

    public int getClickDelay() {
        return clickDelay;
    }

    public void setClickDelay(int clickDelay) {
        this.clickDelay = clickDelay;
    }
}
