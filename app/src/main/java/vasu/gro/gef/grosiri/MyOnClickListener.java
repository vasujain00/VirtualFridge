package vasu.gro.gef.grosiri;

import android.view.View;

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