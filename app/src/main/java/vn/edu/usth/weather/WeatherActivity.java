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
import androidx.viewpager2.widget.ViewPager2;

public class WeatherActivity extends AppCompatActivity {
    private static final String tag = "WeatherActivity";

    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;

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

        viewPager2 = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

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