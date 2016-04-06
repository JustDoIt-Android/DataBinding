package com.itheima.databinderdemo.sample;

import android.app.Activity;
import android.content.ReceiverCallNotAllowedException;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.widget.TextView;

import com.itheima.databinderdemo.R;
import com.itheima.databinderdemo.databinding.RecyclerItemBinding;
import com.itheima.databinderdemo.model.ObservableUser;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jie on 2016/4/3.
 */
public class RecyclerViewActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    private List<ObservableUser> mDatas;
    private RecyclerAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private LinearLayoutManager manager;
    private int lastVisibleItem;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            Toast.makeText(RecyclerViewActivity.this,"请求网络",Toast.LENGTH_SHORT).show();
            for (int i = 0;i<5;i++){
                ObservableUser user = new ObservableUser("后续数据","yes");
                mDatas.add(user);
            }
            mSwipeRefreshWidget.setRefreshing(false);
//            mAdapter.notifyDataSetChanged();
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        initData();
        mSwipeRefreshWidget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        // 这句话是为了，第一次进入页面的时候显示加载进度条
        mSwipeRefreshWidget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));


        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter = new RecyclerAdapter());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == mAdapter.getItemCount()) {
                    mSwipeRefreshWidget.setRefreshing(true);
                    // 此处在现实项目中，请换成网络请求数据代码，sendRequest .....
                    handler.sendEmptyMessageDelayed(0, 1000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = manager.findLastVisibleItemPosition();
            }

        });
    }

    protected void initData() {
        mDatas = new ArrayList<ObservableUser>();
        for (int i = 'A'; i < 'T'; i++) {
            ObservableUser user = new ObservableUser((char)i+"","yes");
            mDatas.add(user);
        }
    }

    @Override
    public void onRefresh() {
        mDatas.clear();
        for (int i = 0;i<15;i++){
            ObservableUser user = new ObservableUser("新数据","yes");
            mDatas.add(user);
        }
        mSwipeRefreshWidget.setRefreshing(false);
//        mAdapter.notifyDataSetChanged();
    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

        private View itemview;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private final RecyclerItemBinding recycleDataBinding;

            public MyViewHolder(View itemView) {
                super(itemView);
                recycleDataBinding = DataBindingUtil.bind(itemView);
            }
            public void bind(ObservableUser user){
                recycleDataBinding.setUser(user);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            itemview = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.recycler_item, parent, false);
            return new MyViewHolder(itemview);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bind(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
    }
}
