package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeatherActivity extends AppCompatActivity {

    private static final String tag = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // set view
        setContentView(R.layout.weather_activity);
        // toolbar
        Toolbar toolbar = findViewById(R.id.menu_bar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i(tag, "start");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(tag, "resume");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i(tag, "pause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i(tag, "stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(tag, "destroy");
    }

}