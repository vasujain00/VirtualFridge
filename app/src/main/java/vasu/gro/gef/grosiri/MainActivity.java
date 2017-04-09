package vasu.gro.gef.grosiri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.vasu.grosiri.R;

public class MainActivity extends AppCompatActivity {
     RelativeLayout r1,r2,r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        r1 = (RelativeLayout) findViewById(R.id.create);
        r2 = (RelativeLayout) findViewById(R.id.rem);
        r3 = (RelativeLayout) findViewById(R.id.view);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Hi soon I will create your fridge!",Toast.LENGTH_LONG).show();
                Intent ab = new Intent(getApplicationContext(),Grid.class);
                startActivity(ab);
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Hi soon i will show you your fridge!",Toast.LENGTH_LONG).show();
                Intent ac = new Intent(getApplicationContext(),View_item.class);
                startActivity(ac);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hi I can set Reminders for you!",Toast.LENGTH_LONG).show();
                Intent aw = new Intent(getApplicationContext(),LocationDemo.class);
                startActivity(aw);

            }
        });
    }
}
