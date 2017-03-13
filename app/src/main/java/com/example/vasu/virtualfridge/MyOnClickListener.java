package com.example.vasu.virtualfridge;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

class MyOnClickListener implements View.OnClickListener
{
    private final int position;

    public MyOnClickListener(int position)
    {
        this.position = position;
    }

    public void onClick(View v)
    {
        // Preform a function based on the position
        //someFunction(this.position);


    }
}