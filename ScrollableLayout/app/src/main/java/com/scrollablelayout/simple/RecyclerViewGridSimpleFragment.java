package com.scrollablelayout.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewGridSimpleFragment extends BaseFragment {

    private View view;
    private RecyclerView recyclerView;

    public static RecyclerViewGridSimpleFragment newInstance() {
        RecyclerViewGridSimpleFragment fragment = new RecyclerViewGridSimpleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_common_recycler, null);
        initRecyclerView(view);
        return view;
    }

    public void initRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.v_scroll);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        GridLayoutManager mLayoutMgr = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutMgr);

        PhotoAdapter recyclerAdapter = new PhotoAdapter();
        recyclerAdapter.setPhotos(createItemList());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private List<RecyclerBean> createItemList() {
        List<RecyclerBean> list = new ArrayList<>();
        list.add(new RecyclerBean("", R.drawable.g1));
        list.add(new RecyclerBean("", R.drawable.g2));
        list.add(new RecyclerBean("", R.drawable.g3));
        list.add(new RecyclerBean("", R.drawable.g4));
        list.add(new RecyclerBean("", R.drawable.g5));
        list.add(new RecyclerBean("", R.drawable.g6));
        list.add(new RecyclerBean("", R.drawable.g7));
        list.add(new RecyclerBean("", R.drawable.g8));
        list.add(new RecyclerBean("", R.drawable.g9));
        list.add(new RecyclerBean("", R.drawable.g10));
        list.add(new RecyclerBean("", R.drawable.g11));
        list.add(new RecyclerBean("", R.drawable.g12));
        list.add(new RecyclerBean("", R.drawable.g13));
        list.add(new RecyclerBean("", R.drawable.g14));
        list.add(new RecyclerBean("", R.drawable.g15));
        list.add(new RecyclerBean("", R.drawable.g16));
        list.add(new RecyclerBean("", R.drawable.g17));
        list.add(new RecyclerBean("", R.drawable.g18));
        list.add(new RecyclerBean("", R.drawable.g19));
        list.add(new RecyclerBean("", R.drawable.g20));
        list.add(new RecyclerBean("", R.drawable.g21));
        list.add(new RecyclerBean("", R.drawable.g22));
        list.add(new RecyclerBean("", R.drawable.g23));
        list.add(new RecyclerBean("", R.drawable.g24));
        list.add(new RecyclerBean("", R.drawable.g25));
        list.add(new RecyclerBean("", R.drawable.g26));
        list.add(new RecyclerBean("", R.drawable.g27));
        list.add(new RecyclerBean("", R.drawable.g28));
        list.add(new RecyclerBean("", R.drawable.g29));
        list.add(new RecyclerBean("", R.drawable.g30));
        list.add(new RecyclerBean("", R.drawable.g31));
        list.add(new RecyclerBean("", R.drawable.g32));
        list.add(new RecyclerBean("", R.drawable.g33));
        list.add(new RecyclerBean("", R.drawable.g34));
        list.add(new RecyclerBean("", R.drawable.g35));
        list.add(new RecyclerBean("", R.drawable.g36));
        list.add(new RecyclerBean("", R.drawable.g37));
        list.add(new RecyclerBean("", R.drawable.g38));
        list.add(new RecyclerBean("", R.drawable.g39));
        list.add(new RecyclerBean("", R.drawable.g40));
        list.add(new RecyclerBean("", R.drawable.g41));
        list.add(new RecyclerBean("", R.drawable.g42));
        list.add(new RecyclerBean("", R.drawable.g43));
        list.add(new RecyclerBean("", R.drawable.g44));
        list.add(new RecyclerBean("", R.drawable.g45));
        list.add(new RecyclerBean("", R.drawable.g46));
        list.add(new RecyclerBean("", R.drawable.g47));
        list.add(new RecyclerBean("", R.drawable.g48));
        list.add(new RecyclerBean("", R.drawable.g49));
        list.add(new RecyclerBean("", R.drawable.g50));
        list.add(new RecyclerBean("", R.drawable.g51));
        list.add(new RecyclerBean("", R.drawable.g52));
        list.add(new RecyclerBean("", R.drawable.g53));
        list.add(new RecyclerBean("", R.drawable.g54));
        list.add(new RecyclerBean("", R.drawable.g55));
        list.add(new RecyclerBean("", R.drawable.g56));
        list.add(new RecyclerBean("", R.drawable.g57));
        list.add(new RecyclerBean("", R.drawable.g58));
        list.add(new RecyclerBean("", R.drawable.g59));
        list.add(new RecyclerBean("", R.drawable.g60));
        list.add(new RecyclerBean("", R.drawable.g61));
        list.add(new RecyclerBean("", R.drawable.g62));
        list.add(new RecyclerBean("", R.drawable.g63));
        list.add(new RecyclerBean("", R.drawable.g64));
        list.add(new RecyclerBean("", R.drawable.g65));
        list.add(new RecyclerBean("", R.drawable.g66));
        list.add(new RecyclerBean("", R.drawable.g67));
        list.add(new RecyclerBean("", R.drawable.g68));
        list.add(new RecyclerBean("", R.drawable.g69));
        list.add(new RecyclerBean("", R.drawable.g70));
        list.add(new RecyclerBean("", R.drawable.g71));
        list.add(new RecyclerBean("", R.drawable.g72));
        list.add(new RecyclerBean("", R.drawable.g73));
        list.add(new RecyclerBean("", R.drawable.g74));
        list.add(new RecyclerBean("", R.drawable.g75));
        list.add(new RecyclerBean("", R.drawable.g76));
        list.add(new RecyclerBean("", R.drawable.g77));
        list.add(new RecyclerBean("", R.drawable.g78));
        list.add(new RecyclerBean("", R.drawable.g79));
        list.add(new RecyclerBean("", R.drawable.g80));
        list.add(new RecyclerBean("", R.drawable.g81));
        list.add(new RecyclerBean("", R.drawable.g82));
        list.add(new RecyclerBean("", R.drawable.g83));
        list.add(new RecyclerBean("", R.drawable.g84));
        list.add(new RecyclerBean("", R.drawable.g85));
        list.add(new RecyclerBean("", R.drawable.g86));
        list.add(new RecyclerBean("", R.drawable.g87));
        list.add(new RecyclerBean("", R.drawable.g88));
        list.add(new RecyclerBean("", R.drawable.g89));
        list.add(new RecyclerBean("", R.drawable.g90));
        return list;
    }

    @Override
    public View getScrollableView() {
        return recyclerView;
    }

    @Override
    public void pullToRefresh() { }

    @Override
    public void refreshComplete() { }

    public class RecyclerBean {
        public String title;
        public int icon;

        public RecyclerBean(String title, int icon) {
            this.title = title;
            this.icon = icon;
        }
    }

    public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        protected PhotoAdapter() {
            super();
        }

        List<RecyclerBean> imgLists = new ArrayList<>();

        public void setPhotos(List<RecyclerBean> photos) {
            imgLists = photos;
            notifyDataSetChanged();
        }

        @Override
        public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PhotoViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof PhotoViewHolder) {
                ((PhotoViewHolder) holder).image.setTag(R.id.tag_item, position);
                Glide.with(holder.itemView.getContext())
                        .load(imgLists.get(position).icon)
                        .centerCrop()
                        .crossFade()
                        .dontAnimate()
                        .into(((PhotoViewHolder) holder).image);
            }
        }

        @Override
        public int getItemCount() {
            return imgLists == null ? 0 : imgLists.size();
        }

        public class PhotoViewHolder extends RecyclerView.ViewHolder {
            public final ImageView image;

            public PhotoViewHolder(ViewGroup parent) {
                super(LayoutInflater.from(parent.getContext()).inflate(R.layout.griditem_image, parent, false));
                image = (ImageView) itemView;
            }
        }
    }
}
