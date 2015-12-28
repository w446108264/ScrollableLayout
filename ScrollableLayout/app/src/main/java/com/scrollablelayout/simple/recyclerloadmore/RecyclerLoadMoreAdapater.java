package com.scrollablelayout.simple.recyclerloadmore;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sj on 15/11/26.
 */
public abstract class RecyclerLoadMoreAdapater<T> extends RecyclerView.Adapter {

    private static final int TYPE_FOOTER = Integer.MIN_VALUE + 1;

    private FrameLayout footerView;
    private View footerContentView;
    protected boolean isShowFooter = false;
    protected final List<T> mDataList = new ArrayList<>();

    protected RecyclerLoadMoreAdapater() { }

    public List<T> getDataList() {
        return this.mDataList;
    }

    public void addAll(@NonNull List<T> data) {
        this.mDataList.addAll(data);
        this.notifyDataSetChanged();
    }

    public void clear() {
        this.mDataList.clear();
    }

    public int getItemCount() {
        int count = mDataList == null ? 0 : this.mDataList.size();
        return count + getFooterCount();
    }

    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            if (footerView == null) {
                footerView = new FrameLayout(parent.getContext());
                parent.addView(footerView);
                if (footerContentView != null) {
                    footerView.addView(footerContentView);
                }
            }
            return new RecyclerPlaceViewHolder(footerView);
        }
        return onCreateViewHolderSuper(parent, viewType);
    }

    @Override
    public final int getItemViewType(int position) {
        if (isShowFooter && position == getItemCount() - getFooterCount()) {
            return TYPE_FOOTER;
        }
        return getItemViewTypeSuper(position);
    }

    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position != getItemCount() - getFooterCount()) {
            onBindViewHolderSuper(holder, position);
        }
    }

    public int getFooterCount() {
        if (isShowFooter) {
            return 1;
        }
        return 0;
    }

    public void setFooterView(View view) {
        footerContentView = view;
        isShowFooter = true;
        if (footerView != null && footerView.getChildCount() == 0) {
            footerView.addView(footerContentView);
        }
    }

    public void removeFooterView() {
        isShowFooter = false;
        notifyDataSetChanged();
    }

    private class RecyclerPlaceViewHolder extends RecyclerView.ViewHolder {
        public RecyclerPlaceViewHolder(View itemView) {
            super(itemView);
        }
    }

    public abstract RecyclerView.ViewHolder onCreateViewHolderSuper(ViewGroup viewGroup, int viewType);

    public int getItemViewTypeSuper(int position) {
        return super.getItemViewType(position);
    }

    public void onBindViewHolderSuper(RecyclerView.ViewHolder holder, int position) { }
}

