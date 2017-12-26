package com.simon.widget.slideView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.simon.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/20 09:51
 */

public class ShowView extends ViewPager {

    private static final int ACTION_PLAY = 0;
    private static final int mDuration = 1500;// 轮播图片的时间间隔


    private Context mContext;
    private int mFocus;// 焦点图片的索引
    private Handler mHandler;// 用于播放图片动画的Handler
    private FlowIndicator mFlowIndicator;// 指示器view
    private boolean autoSwitch;// true 自动播放 false 手动切换
    private int mCount;// 播放图片的数量
    private Timer mTimer;
    private SlideShowViewAdapter mAdapter;
    private boolean isRunning;// true 表示正在播放 false 表示没有播放
    private boolean isAutoPly;//是否允许自动播放

    public ShowView(Context context) {
        this(context, null);
    }

    public ShowView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        initHandler();// 初始化Handler,接收消息播放动画
        setListener();// 设置监听器
    }


    /**
     * 初始化Handler,接收消息播放动画
     */
    private void initHandler() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case ACTION_PLAY:
                        // 若是手动滑动ViewPager时
                        if (!autoSwitch) {
                            autoSwitch = true;
                        } else {
                            int pos = ShowView.this.getCurrentItem();// 获取ViewPager中正在播放的索引
                            pos++;
                            // 设置下一个页面为当前的页面
                            ShowView.this.setCurrentItem(pos);
                        }
                        break;
                }
            }
        };
    }


    /**
     * 设置监听器
     */
    private void setListener() {
        // 设置手指触摸监听器
        setOnTouch();
    }

    /**
     * 设置手指触摸监听器
     */
    private void setOnTouch() {
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        autoSwitch = false;// 设置不自动播放
                        break;
                }
                return false;
            }
        });
    }


    /**
     * 由MainActivity调用
     *
     * @param flowIndicator FlowIndicator对象
     * @param showGoods     轮播图片的网络地址
     */
    public void initData(FlowIndicator flowIndicator, ArrayList<String> showGoods) {
        // 设置ViewPager页面改变的监听器
        mFlowIndicator = flowIndicator;
        if (showGoods == null || showGoods.isEmpty()) {
            mCount = 0;
        } else {
            mCount = showGoods.size();
        }
        setOnPagerChangeListener();
        mAdapter = new SlideShowViewAdapter(mContext, showGoods);
        this.setAdapter(mAdapter);
        if (mFlowIndicator != null) {
            mFlowIndicator.setCount(mCount);
        }
    }


    /**
     * 设置ViewPager页面改变的监听器
     */
    private void setOnPagerChangeListener() {
        this.setOnPageChangeListener(new OnPageChangeListener() {
            boolean scrollLast = false;
            int pageNum = 0;

            @Override
            public void onPageSelected(int position) {
                autoSwitch = false;
                if (mCount != 0) {
                    mFocus = position % mCount;
                    mFlowIndicator.setFocus(mFocus);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                //arg0 :当前页面，及你点击滑动的页面  arg1:当前页面偏移的百分比  arg2:当前页面偏移的像素位置

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }


    /**
     * auto play picture
     */
    public void playLoop() {
        if (isAutoPly) {
            if (mTimer == null) {
                mTimer = new Timer();
            }
            if (!isRunning) {// 如果图片没有不在播放则，开始播放
                isRunning = true;//set playing
                // 设置计划任务立即执行，每隔3000毫秒发送一次轮播消息
                mTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mHandler.sendEmptyMessage(ACTION_PLAY);
                    }
                }, 0, mDuration);
            }
        }
    }

    /**
     * stop auto play
     */
    public void stopPlay() {
        if (mTimer == null) {
            return;
        }
        isRunning = false;//set pausing
        // if timer exit,timer set null
        mTimer.cancel();
        mTimer = null;
    }

    public void setAutoPlay(boolean auto) {
        this.isAutoPly = auto;
    }


    private static final ViewGroup.LayoutParams M_M = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


    /**
     * custom ViewPager adapter
     */
    class SlideShowViewAdapter extends PagerAdapter {

        private Context context;
        private ArrayList<String> data;
        private int currentIndex;

        public SlideShowViewAdapter(Context context, ArrayList<String> data) {
            this.context = context;
            this.data = data;
            this.notifyDataSetChanged();
        }


        @Override
        public int getCount() {
            if (data == null || data.isEmpty()) {
                return 1;
            }
            if (data.size() == 1) {
                return 1;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View rootView;
            rootView = View.inflate(mContext, R.layout.item_slide, null);
            ImageView imgView = rootView.findViewById(R.id.item_image);
            String url;
            currentIndex = position % data.size();
            url = data.get(currentIndex);
            Glide.with(context).load(url).into(imgView);
            if (data.size() != 0) {
                rootView.setTag(position % data.size());
            }
//            rootView.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                }
//            });

            container.addView(rootView, M_M);
            return rootView;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }

        public ArrayList<String> getData() {
            return data;
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeAllViews();
    }

}
