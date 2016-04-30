package com.oscarromero.tweettime;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Oscar on 1/5/16.
 */
public class PicassoImageNetworkLoader implements ImageNetworkLoader {
    private Context context;

    public PicassoImageNetworkLoader(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Picasso.with(context).load(url).into(imageView);
    }
}