package com.example.vasu.virtualfridge;


    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.AdapterView.OnItemClickListener;
    import android.widget.GridView;

    public class Grid extends Activity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.select_item);

            GridView gridView = (GridView) findViewById(R.id.grid_view);

            // Instance of ImageAdapter Class
            gridView.setAdapter(new ImageAdapter(this));
        }
    }

