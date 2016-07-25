package com.android.sugar.appmarket.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.android.sugar.appmarket.R;
import com.android.sugar.appmarket.bean.CategoryInfo;
import com.android.sugar.appmarket.utils.UIUtils;

/**
 * @ClassName: CategoryTitleHolder
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午11:05
 */
public class CategoryTitleHolder extends BaseHolder<CategoryInfo> {

    private TextView mTextView;

    @Override
    protected View initView() {
        View view = UIUtils.inflate(R.layout.category_item_title);
        mTextView = (TextView) view.findViewById(R.id.tv_title);
        return view;
    }

    @Override
    public void refreshView() {
        mTextView.setText(getData().getTitle());
    }
}
