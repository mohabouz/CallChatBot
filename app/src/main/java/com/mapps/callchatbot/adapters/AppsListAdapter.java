package com.mapps.callchatbot.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapps.callchatbot.R;
import com.mapps.callchatbot.model.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by MohammedBouzaid
 * 01-Dec-18.
 */

public class AppsListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Application> appsList;

    public AppsListAdapter(Context mContext, List<Application> appsList) {
        this.mContext = mContext;
        this.appsList = appsList;
    }

    @Override
    public int getCount() {
        return appsList.size();
    }

    @Override
    public Object getItem(int position) {
        return appsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        @SuppressLint("ViewHolder")
        View v = View.inflate(mContext, R.layout.app_item,null);

        //getting reference to layout views
        ImageView appIcon = v.findViewById(R.id.app_image);
        TextView appName = v.findViewById(R.id.app_name);

        String appIcongPath = appsList.get(position).getAppIcon();
        String appNameTxt = appsList.get(position).getAppName();

        //setting the list item icon
        try {
            InputStream ims = mContext.getAssets().open("images/"+appIcongPath);
            Drawable d = Drawable.createFromStream(ims, null);
            appIcon.setImageDrawable(d);
            ims .close();
        } catch(IOException ex){
            appIcon.setImageResource(R.drawable.ic_launcher_foreground);
            ex.printStackTrace();
        }

        //Setting the app name text
        appName.setText(appNameTxt);

        v.setTag(position);

        return v;
    }
}
