package com.scrollablelayout.simple;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scrollablelayout.simple.recyclerloadmore.EndlessRecyclerOnScrollListener;
import com.scrollablelayout.simple.recyclerloadmore.LoadingFooter;
import com.scrollablelayout.simple.recyclerloadmore.RecyclerLoadMoreAdapater;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewSimpleFragment extends BaseFragment {

    private View view;
    private RecyclerView recyclerView;
    private final List<RecyclerBean> allDataSource = new ArrayList<>();
    private int lastPosition = 0;
    private int size = 5;
    private LoadingFooter mLoadingFooter;
    private RecyclerAdapter recyclerAdapter;

    public static RecyclerViewSimpleFragment newInstance() {
        RecyclerViewSimpleFragment fragment = new RecyclerViewSimpleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_common_recycler, null);
        initDataSource();
        initRecyclerView(view);
        return view;
    }

    public void initRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.v_scroll);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        LinearLayoutManager mLayoutMgr = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutMgr);

        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addOnScrollListener(mOnScrollListener);

        if (mLoadingFooter == null) {
            mLoadingFooter = new LoadingFooter(getContext());
            recyclerAdapter.setFooterView(mLoadingFooter);
        }

        getDataTask();
    }

    private void initDataSource() {
        allDataSource.add(new RecyclerBean("为人民服务", R.drawable.finger_1));
        allDataSource.add(new RecyclerBean("yahoo~~", R.drawable.finger_2));
        allDataSource.add(new RecyclerBean("We will give everyone a free Mi band", R.drawable.finger_3));
        allDataSource.add(new RecyclerBean("呦西呦西", R.drawable.finger_4));
        allDataSource.add(new RecyclerBean("比我聪明没我帅", R.drawable.finger_5));
        allDataSource.add(new RecyclerBean("我只拿一个人头", R.drawable.finger_6));
        allDataSource.add(new RecyclerBean("嗯哼", R.drawable.finger_7));
        allDataSource.add(new RecyclerBean("你好", R.drawable.finger_8));
        allDataSource.add(new RecyclerBean("半边天%&￥@￥", R.drawable.finger_9));
        allDataSource.add(new RecyclerBean("不想上班是全世界的最常想的事", R.drawable.finger_10));
        allDataSource.add(new RecyclerBean("!!!", R.drawable.finger_11));
    }

    @Override
    public View getScrollableView() {
        return recyclerView;
    }

    @Override
    public void pullToRefresh() {
        lastPosition = 0;
        getDataTask();
    }

    @Override
    public void refreshComplete() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).refreshComplete();
        }
    }

    private EndlessRecyclerOnScrollListener mOnScrollListener = new EndlessRecyclerOnScrollListener(2) {
        @Override
        public void onLoadMore(View view) {
            super.onLoadMore(view);
            getDataTask(false);
        }
    };

    public void getDataTask() {
        getDataTask(true);
    }

    public void getDataTask(final boolean isClear) {
        if (mLoadingFooter.getState() == LoadingFooter.State.Loading || (!isClear && mLoadingFooter.getState() == LoadingFooter.State.TheEnd)) {
            return;
        }
        mLoadingFooter.setState(LoadingFooter.State.Loading);

        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshComplete();
                recyclerAdapter.setFooterView(mLoadingFooter);
                if (isClear) {
                    recyclerAdapter.clear();
                }
                List<RecyclerBean> result = getData();
                if (result == null || result.size() < size) {
                    mLoadingFooter.setState(LoadingFooter.State.TheEnd, false);
                    recyclerAdapter.removeFooterView();
                } else {
                    mLoadingFooter.setState(LoadingFooter.State.Normal);
                }
                if (result != null && result.size() > 0) {
                    recyclerAdapter.addAll(result);
                    lastPosition = lastPosition + result.size();
                }
            }
        }, 1000);
    }

    public List<RecyclerBean> getData() {
        try {
            int end = (lastPosition + size) > allDataSource.size() ? allDataSource.size() : (lastPosition + size);
            return allDataSource.subList(lastPosition, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public class RecyclerBean {
        public String title;
        public int icon;

        public RecyclerBean(String title, int icon) {
            this.title = title;
            this.icon = icon;
        }
    }

    public class RecyclerAdapter extends RecyclerLoadMoreAdapater<RecyclerBean> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolderSuper(ViewGroup viewGroup, int viewType) {
            Context context = viewGroup.getContext();
            View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, viewGroup, false);
            return new RecyclerItemViewHolder(view);
        }

        @Override
        public void onBindViewHolderSuper(RecyclerView.ViewHolder viewHolder, int position) {
            RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
            holder.tvTitle.setText(mDataList.get(viewHolder.getLayoutPosition()).title);
            holder.ivIcon.setBackgroundResource(mDataList.get(viewHolder.getLayoutPosition()).icon);
        }

        private class RecyclerItemViewHolder extends RecyclerView.ViewHolder {

            private final TextView tvTitle;
            private final ImageView ivIcon;

            public RecyclerItemViewHolder(View itemView) {
                super(itemView);
                tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
                ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            }
        }
    }
}
