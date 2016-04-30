package com.oscarromero.tweettime.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oscarromero.tweettime.R;
import com.oscarromero.tweettime.mvp.model.TweetPM;

import butterknife.BindView;

/**
 * Created by Oscar on 30/4/16.
 */
public class TweetView extends LinearLayout {
    @BindView(R.id.user_iv)
    ImageView user_iv;
    @BindView(R.id.name_tv)
    TextView name_tv;
    @BindView(R.id.username_tv)
    TextView username_tv;
    @BindView(R.id.date_tv)
    TextView date_tv;
    @BindView(R.id.message_tv)
    TextView message_tv;

    public TweetView(Context context) {
        super(context);
        init();
    }

    public TweetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TweetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TweetView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_tweet, this, true);
        setOrientation(VERTICAL);
        int padding = getResources().getDimensionPixelSize(R.dimen.margin_padding_M);
        setPadding(padding, padding, padding, padding);

    }

    public void render(TweetPM tweetPM){

    }
}