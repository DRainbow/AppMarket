package com.android.sugar.appmarket.ui.fragment;

import android.view.View;
import android.widget.AbsListView;

import com.android.sugar.appmarket.bean.SubjectInfo;
import com.android.sugar.appmarket.http.protocol.SubjectProtocol;
import com.android.sugar.appmarket.ui.adapter.DefaultAdapter;
import com.android.sugar.appmarket.ui.holder.BaseHolder;
import com.android.sugar.appmarket.ui.holder.SubjectHolder;
import com.android.sugar.appmarket.ui.widget.BaseListView;
import com.android.sugar.appmarket.ui.widget.LoadingPage;
import com.android.sugar.appmarket.utils.UIUtils;

import java.util.List;

/**
 * @ClassName: SubjectFragment
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午11:36
 */
public class SubjectFragment extends BaseFragment {

    private BaseListView mListView;
    private List<SubjectInfo> mDatas;
    private SubjectAdapter mAdapter;

    @Override
    protected LoadingPage.LoadResult load() {
        SubjectProtocol protocol = new SubjectProtocol();
        mDatas = protocol.load(0);
        return check(mDatas);
    }

    @Override
    protected View createLoadedView() {
        mListView = new BaseListView(UIUtils.getContext());
        mAdapter = new SubjectAdapter(mListView, mDatas);
        mListView.setAdapter(mAdapter);
        return mListView;
    }

    class SubjectAdapter extends DefaultAdapter<SubjectInfo> {

        public SubjectAdapter(AbsListView listView, List<SubjectInfo> datas) {
            super(listView, datas);
        }

        @Override
        public boolean hasMore() {
            return true;
        }

        @Override
        public BaseHolder getHolder() {
            return new SubjectHolder();
        }

        /**
         * 加载更多
         */
        @Override
        public List<SubjectInfo> onLoadMore() {
            SubjectProtocol protocol = new SubjectProtocol();
            return protocol.load(getData().size());
        }

        @Override
        public void onItemClickInner(int position) {
            UIUtils.showToastSafe(getItem(position).getDes());
        }
    }
}
