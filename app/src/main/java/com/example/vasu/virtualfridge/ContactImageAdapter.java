package com.example.vasu.virtualfridge;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactImageAdapter extends ArrayAdapter<Item>{
    Context context;
    int layoutResourceId;
    // BcardImage data[] = null;
    ArrayList<Item> data=new ArrayList<Item>();
    public ContactImageAdapter(Context context, int layoutResourceId, ArrayList<Item> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View row = convertView;
        ImageHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ImageHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.b = (Button)row.findViewById(R.id.button2);
            row.setTag(holder);
        }
        else
        {
            holder = (ImageHolder)row.getTag();
        }

        Item picture = data.get(position);
        holder.txtTitle.setText(picture._name);
        //convert byte to bitmap take from contact class

        byte[] outImage=picture._Image;
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        holder.imgIcon.setImageBitmap(theImage);
        holder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = position;
                DatabaseHandler db = new DatabaseHandler(context);
                db.deleteContact(id);
                Toast.makeText(context,"1",Toast.LENGTH_LONG).show();
            }
        });
        return row;

    }

    static class ImageHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
        Button b;
    }
}
