package com.simon.refreshListview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.simon.R;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/12 14:31
 */

public class RefreshListView extends ListView implements AbsListView.OnScrollListener {

    private View header;//顶部布局
    private int headerHeight;//顶部布局的高度
    private int firstVisibleItem;//当前第一个可见item的下标
    private boolean isRemark;
    private int startY;//按下时Y的值

    private int state;//当前的状态
    private final int NONE = 0;//正常状态
    private final int PULL = 1;//提示下拉刷新的状态
    private final int RELEASE = 2;//提示释放的状态
    private final int REFRESHING = 3;//正在刷新

    private int scrollState;//滚动状态
    private IRefreshListener listener;


    public RefreshListView(Context context) {
        super(context, null);
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public RefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    /**
     * 初始化view
     *
     * @param cxt
     */
    private void initView(Context cxt) {

        LayoutInflater inflater = LayoutInflater.from(cxt);
        header = inflater.inflate(R.layout.header_layout, this);
        measureView(header);
        headerHeight = header.getMeasuredHeight();
        topPadding(-headerHeight);
        this.addHeaderView(header);
        this.setOnScrollListener(this);

    }


    /**
     * 测量布局宽高
     *
     * @param view
     */
    private void measureView(View view) {

        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null)
            params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

        int width = ViewGroup.getChildMeasureSpec(0, 0, params.width);
        int height;
        int tempHeight = params.height;
        if (tempHeight > 0) {
            height = MeasureSpec.makeMeasureSpec(tempHeight, MeasureSpec.EXACTLY);
        } else {
            height = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        view.measure(width, height);
    }


    /**
     * 设置header布局的上边距
     *
     * @param topPadding
     */
    private void topPadding(int topPadding) {

        header.setPadding(header.getPaddingLeft(), topPadding, header.getPaddingRight(), header.getPaddingBottom());
        header.invalidate();
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        this.scrollState = scrollState;

    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.firstVisibleItem = firstVisibleItem;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {


        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:

                if (firstVisibleItem == 0) {
                    isRemark = true;
                    startY = (int) ev.getY();
                }
                break;


            case MotionEvent.ACTION_MOVE:
                onMove(ev);
                break;

            case MotionEvent.ACTION_UP:
                refreshViewByState();
                if (state == RELEASE) {
                    state = REFRESHING;
                    //加载最近数据
                    if (listener != null) {
                        listener.onRefresh();
                    }
                } else if (state == PULL) {
                    state = NONE;
                    isRemark = false;
                }
                break;

            default:
                break;

        }

        return super.onTouchEvent(ev);
    }


    private void onMove(MotionEvent event) {

        if (!isRemark)
            return;

        int tempY = (int) event.getY();
        int space = tempY - startY;
        int topPadding = space - headerHeight;

        switch (state) {

            case NONE:
                refreshViewByState();
                if (space > 0) {
                    state = PULL;
                }

                break;

            case PULL:
                refreshViewByState();
                topPadding(topPadding);
                if (space > headerHeight + 30 && scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                    state = RELEASE;
                }
                break;

            case RELEASE:
                topPadding(topPadding);
                refreshViewByState();
                if (space < headerHeight + 30) {
                    state = PULL;
                } else if (space <= 0) {
                    state = NONE;
                    isRemark = false;
                }
                break;

            case REFRESHING:
                break;


        }

    }


    /**
     * 根据状态跟新界面内容
     */
    private void refreshViewByState() {

        TextView tip = (TextView) header.findViewById(R.id.tip);
        ImageView arrow = (ImageView) header.findViewById(R.id.arrow);
        ProgressBar progressBar = (ProgressBar) header.findViewById(R.id.progress);

        RotateAnimation rotateAnimation0 = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation0.setDuration(500);
        rotateAnimation0.setFillAfter(true);

        rotateAnimation1.setDuration(500);
        rotateAnimation1.setFillAfter(true);

        switch (state) {

            case NONE:
                topPadding(-headerHeight);
                arrow.clearAnimation();
                break;

            case PULL:
                arrow.setVisibility(VISIBLE);
                progressBar.setVisibility(GONE);
                tip.setText("下拉可以刷新");
                arrow.setAnimation(rotateAnimation0);
                break;

            case RELEASE:
                arrow.setVisibility(VISIBLE);
                progressBar.setVisibility(GONE);
                tip.setText("松开可以刷新");
                arrow.setAnimation(rotateAnimation1);
                break;

            case REFRESHING:
                topPadding(headerHeight);
                arrow.setVisibility(GONE);
                progressBar.setVisibility(VISIBLE);
                tip.setText("正在刷新...");
                arrow.clearAnimation();
                break;

            default:
                break;


        }
    }


    /**
     * 获取完数据
     */
    public void reflashConplete() {
        state = NONE;
        isRemark = false;
        refreshViewByState();
    }


    /**
     * 刷新数据接口
     */
    public interface IRefreshListener {
        void onRefresh();
    }


    public void setListener(IRefreshListener listener) {
        this.listener = listener;
    }
}



















