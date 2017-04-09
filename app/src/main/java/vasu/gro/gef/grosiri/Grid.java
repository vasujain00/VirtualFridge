package vasu.gro.gef.grosiri;


    import android.content.Intent;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.GridView;
    import android.widget.Toast;

    import com.example.vasu.grosiri.R;

public class Grid extends AppCompatActivity {
           FloatingActionButton b12;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tryflo);

            GridView gridView = (GridView) findViewById(R.id.grid_view);
            b12  =  (FloatingActionButton) findViewById(R.id.fab);
            // Instance of ImageAdapter Class
            gridView.setAdapter(new ImageAdapter(this));
            b12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a = new Intent(getApplicationContext(),Add_Item.class);
                    startActivity(a);
                    Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
                }
            });

        }
    }

