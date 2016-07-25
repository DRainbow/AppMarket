package com.android.sugar.appmarket.ui.fragment;

import android.view.View;
import android.widget.AbsListView;

import com.android.sugar.appmarket.bean.AppInfo;
import com.android.sugar.appmarket.http.protocol.GameProtocol;
import com.android.sugar.appmarket.ui.adapter.ListBaseAdapter;
import com.android.sugar.appmarket.ui.widget.BaseListView;
import com.android.sugar.appmarket.ui.widget.LoadingPage;
import com.android.sugar.appmarket.utils.UIUtils;

import java.util.List;

/**
 * @ClassName: GameFragment
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午11:34
 */
public class GameFragment extends BaseFragment {
    private BaseListView mListView;
    private GameAdapter mAdapter;
    private List<AppInfo> mDatas;

    @Override
    protected LoadingPage.LoadResult load() {
        GameProtocol protocol = new GameProtocol();
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

    @Override
    protected View createLoadedView() {
        mListView = new BaseListView(UIUtils.getContext());
        mAdapter = new GameAdapter(mListView, mDatas);
        mAdapter.startObserver();
        mListView.setAdapter(mAdapter);
        return mListView;
    }

    class GameAdapter extends ListBaseAdapter {

        public GameAdapter(AbsListView listView, List<AppInfo> datas) {
            super(listView, datas);
        }

        /**
         * 加载更多
         */
        @Override
        public List<AppInfo> onLoadMore() {
            GameProtocol protocol = new GameProtocol();
            return protocol.load(getData().size());
        }
    }
}
