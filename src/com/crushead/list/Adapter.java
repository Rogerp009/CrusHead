package com.crushead.list;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crushead.R;

public class Adapter extends BaseAdapter{

	ArrayList<DataItem> list;
    private Context context;
    
    public Adapter(Context ctx, ArrayList<DataItem> list) {
        super();
        this.context = ctx;
        this.list = list;
    }
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
        return list.size();
	}

    @Override
    public DataItem getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        DataItem item = getItem(position);

        final Drawable drawable = item.getDrawable();
        holder.imageView.setImageDrawable(drawable);
        holder.textView.setText(item.getLabel());

        if (item.getNavigationInfo() != -1) {
            holder.textView.setCompoundDrawablesWithIntrinsicBounds(null,
                    null,
                    context.getResources().getDrawable(R.drawable.ic_chevron_right_grey600_48dp),
                    null);
        }
        else {
            holder.textView.setCompoundDrawablesWithIntrinsicBounds(null,
                    null,
                    null,
                    null);
        }

        // fix for animation not playing for some below 4.4 devices
        if (drawable instanceof AnimationDrawable) {
            holder.imageView.post(new Runnable() {
                @Override
                public void run() {
                    ((AnimationDrawable) drawable).stop();
                    ((AnimationDrawable) drawable).start();
                }
            });
        }

        return convertView;        
	}
	
    private static class ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.imageView);
            textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
