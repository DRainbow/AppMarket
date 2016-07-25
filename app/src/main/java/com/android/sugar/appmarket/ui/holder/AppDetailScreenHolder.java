package com.android.sugar.appmarket.ui.holder;

import android.view.View;
import android.widget.ImageView;

import com.android.sugar.appmarket.R;
import com.android.sugar.appmarket.bean.AppInfo;
import com.android.sugar.appmarket.http.image.ImageLoader;
import com.android.sugar.appmarket.utils.UIUtils;

/**
 * @ClassName: AppDetailScreenHolder
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午11:04
 */
public class AppDetailScreenHolder extends BaseHolder<AppInfo> {

    private ImageView[] mIv;

    @Override
    protected View initView() {
        View view = UIUtils.inflate(R.layout.app_detail_screen);
        mIv = new ImageView[5];
        mIv[0] = (ImageView) view.findViewById(R.id.screen_1);
        mIv[1] = (ImageView) view.findViewById(R.id.screen_2);
        mIv[2] = (ImageView) view.findViewById(R.id.screen_3);
        mIv[3] = (ImageView) view.findViewById(R.id.screen_4);
        mIv[4] = (ImageView) view.findViewById(R.id.screen_5);
        return view;
    }

    @Override
    public void refreshView() {
        AppInfo info = getData();
        for (int i = 0; i < 5; i++) {
            if (i < info.getScreen().size()) {
                ImageLoader.load(mIv[i], info.getScreen().get(i));
                mIv[i].setVisibility(View.VISIBLE);
            } else {
                mIv[i].setVisibility(View.GONE);
            }
        }
    }
}
