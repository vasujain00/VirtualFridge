package com.example.vasu.virtualfridge;

/**
 * Created by Shivangi Jain on 3/16/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.implments.SwipeItemMangerImpl;
import com.daimajia.swipe.interfaces.SwipeAdapterInterface;
import com.daimajia.swipe.interfaces.SwipeItemMangerInterface;
import com.daimajia.swipe.util.Attributes;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class ArraySwipeAdapter<T> extends ArrayAdapter implements SwipeItemMangerInterface, SwipeAdapterInterface {

    Context context;
    int layoutResourceId;
    // BcardImage data[] = null;
    ArrayList<Item> data=new ArrayList<Item>();
    private SwipeItemMangerImpl mItemManger = new SwipeItemMangerImpl(this) {
        @Override
        public void initialize(View target, int position) {

        }

        @Override
        public void updateConvertView(View target, int position) {

        }

        @Override
        public void bindView(View target, int position) {

        }
    };

    public ArraySwipeAdapter(Context context, int layoutResourceId, ArrayList<Item> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    public ArraySwipeAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ArraySwipeAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ArraySwipeAdapter(Context context, int resource, T[] objects) {
        super(context, resource, objects);
    }

    public ArraySwipeAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ArraySwipeAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
    }

    public ArraySwipeAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        super(context, resource, textViewResourceId, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ContactImageAdapter.ImageHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ContactImageAdapter.ImageHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            row.setTag(holder);
        }
        else
        {
            holder = (ContactImageAdapter.ImageHolder)row.getTag();
        }

        Item picture = data.get(position);
        holder.txtTitle.setText(picture._name);
        //convert byte to bitmap take from contact class

        byte[] outImage=picture._Image;
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        holder.imgIcon.setImageBitmap(theImage);
        return row;

    }

    static class ImageHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }

    @Override
    public void openItem(int position) {
        mItemManger.openItem(position);
    }

    @Override
    public void closeItem(int position) {
        mItemManger.closeItem(position);
    }

    @Override
    public void closeAllExcept(SwipeLayout layout) {
        mItemManger.closeAllExcept(layout);
    }

    @Override
    public void closeAllItems() {
        mItemManger.closeAllItems();
    }

    @Override
    public List<Integer> getOpenItems() {
        return mItemManger.getOpenItems();
    }

    @Override
    public List<SwipeLayout> getOpenLayouts() {
        return mItemManger.getOpenLayouts();
    }

    @Override
    public void removeShownLayouts(SwipeLayout layout) {
        mItemManger.removeShownLayouts(layout);
    }

    @Override
    public boolean isOpen(int position) {
        return mItemManger.isOpen(position);
    }

    @Override
    public Attributes.Mode getMode() {
        return mItemManger.getMode();
    }

    @Override
    public void setMode(Attributes.Mode mode) {
        mItemManger.setMode(mode);
    }
}