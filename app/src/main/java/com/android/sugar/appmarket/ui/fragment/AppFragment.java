package com.android.sugar.appmarket.ui.fragment;

import android.view.View;
import android.widget.AbsListView;

import com.android.sugar.appmarket.bean.AppInfo;
import com.android.sugar.appmarket.http.protocol.AppProtocol;
import com.android.sugar.appmarket.ui.adapter.ListBaseAdapter;
import com.android.sugar.appmarket.ui.widget.BaseListView;
import com.android.sugar.appmarket.ui.widget.LoadingPage;
import com.android.sugar.appmarket.utils.UIUtils;

import java.util.List;

/**
 * @ClassName: AppFragment
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午11:32
 */
public class AppFragment extends BaseFragment {

    private BaseListView mListView;
    private AppAdapter mAdapter;
    private List<AppInfo> mDatas;

    @Override
    protected LoadingPage.LoadResult load() {
        AppProtocol protocol = new AppProtocol();
        mDatas = protocol.load(0);
        return check(mDatas);
    }

    /**
     * 可见时，需要启动监听，以便随时根据下载状态刷新页面
     */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdapter != null) {
            mAdapter.startObserver();
            mAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 不可见时，需要关闭监听
     */
    @Override
    public void onPause() {
        super.onPause();
        if (mAdapter != null) {
            mAdapter.stopObserver();
        }
    }

    /**
     * 创建加载完毕的View
     */
    @Override
    protected View createLoadedView() {
        mListView = new BaseListView(UIUtils.getContext());
        mAdapter = new AppAdapter(mListView, mDatas);
        mAdapter.startObserver();
        mListView.setAdapter(mAdapter);
        return mListView;
    }

    class AppAdapter extends ListBaseAdapter {

        public AppAdapter(AbsListView listView, List<AppInfo> datas) {
            super(listView, datas);
        }

        /**
         * 加载更多
         */
        @Override
        public List<AppInfo> onLoadMore() {
            AppProtocol protocol = new AppProtocol();
            return protocol.load(getData().size());
        }
    }
}
