package com.simon.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.simon.R;

import java.util.List;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/28 15:37
 */

public class ConvenientBannerUtil {

    private ConvenientBanner banner;
    private List<String> imgs;
    private Context cxt;
    private IImageClick listener;
    private int[] dots = {R.drawable.dota, R.drawable.dotb};
    private long loopTime = 4000;
    private ConvenientBanner.PageIndicatorAlign pageIndicatorAlign = ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT;


    public ConvenientBannerUtil(Context cxt, ConvenientBanner banner, List<String> imgs) {
        this.banner = banner;
        this.imgs = imgs;
        this.cxt = cxt;
        if (banner == null)
            new IllegalArgumentException("banner view can not be null");
        if (imgs == null || imgs.isEmpty())
            new IllegalArgumentException("must has image url");
    }


    public void show() {
        banner.setCanLoop(imgs.size() != 1);
        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        }, imgs).setPointViewVisible(imgs.size() != 1)
                .setPageIndicator(dots)
                .setPageIndicatorAlign(pageIndicatorAlign)
                .startTurning(loopTime)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        if (listener != null) {
                            listener.itemClick(position);
                        }
                    }
                })
                .setManualPageable(true);
    }


    class LocalImageHolderView implements Holder<String> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            //glide加载出图片，data是传过来的图片地址，
            Glide.with(context).load(data).into(imageView);
        }

    }

    public ConvenientBannerUtil setDots(int[] dots) {
        this.dots = dots;
        return this;
    }

    public ConvenientBannerUtil setLoopTime(long loopTime) {
        this.loopTime = loopTime;
        return this;
    }

    public ConvenientBannerUtil setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign pageIndicatorAlign) {
        this.pageIndicatorAlign = pageIndicatorAlign;
        return this;
    }

    public void setListener(IImageClick listener) {
        this.listener = listener;
    }

    public interface IImageClick {
        void itemClick(int position);
    }
}
