package com.android.sugar.appmarket.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.android.sugar.appmarket.R;
import com.android.sugar.appmarket.utils.UIUtils;

/**
 * @ClassName: BaseListView
 * @Description:
 * @author: SugarT
 * @date: 16/7/22 下午6:23
 */
public class BaseListView extends ListView {

    public BaseListView(Context context) {
        this(context, null);
    }

    public BaseListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setDivider(UIUtils.getResources().getDrawable(R.drawable.nothing));
        setCacheColorHint(UIUtils.getColor(R.color.bg_page));
        setSelector(UIUtils.getResources().getDrawable(R.drawable.nothing));
    }
}