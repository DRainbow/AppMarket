package com.android.sugar.appmarket.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.sugar.appmarket.R;
import com.android.sugar.appmarket.bean.SubjectInfo;
import com.android.sugar.appmarket.http.image.ImageLoader;
import com.android.sugar.appmarket.utils.UIUtils;

/**
 * @ClassName: SubjectHolder
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午11:12
 */
public class SubjectHolder extends BaseHolder<SubjectInfo> {

    private ImageView iv;
    private TextView tv;

    @Override
    protected View initView() {
        View view = UIUtils.inflate(R.layout.subject_item);
        iv = (ImageView) view.findViewById(R.id.item_icon);
        tv = (TextView) view.findViewById(R.id.item_txt);
        return view;
    }

    @Override
    public void refreshView() {
        SubjectInfo data = getData();
        String des = data.getDes();
        String url = data.getUrl();
        tv.setText(des);
        iv.setTag(url);
        ImageLoader.load(iv, url);
    }

    @Override
    public void recycle() {
        recycleImageView(iv);
    }
}
