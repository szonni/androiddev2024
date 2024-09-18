package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {
    private static final String tag = "WeatherActivity";
    AsyncTask<Void, Integer, String> task;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // AsyncTask
        initAsyncTask();

        // set view
        setContentView(R.layout.weather_activity);
        // toolbar
        Toolbar toolbar = findViewById(R.id.menu_bar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        // view pager
        viewPager2 = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        // tab layout
        tabLayout = findViewById(R.id.tab);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(viewPagerAdapter.getPageTitle(position));
            }
        });
        mediator.attach();

        // Music
        mediaPlayer = null;
        mediaPlayer = MediaPlayer.create(this, R.raw.virtualboo);
        mediaPlayer.start();
        if (!mediaPlayer.isPlaying()) mediaPlayer.release();
    }

    @SuppressLint("StaticFieldLeak")
    private void initAsyncTask() {
        task = new AsyncTask<Void, Integer, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Network response";
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String res) {
                Toast.makeText(WeatherActivity.this, res, Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.refresh) {
            task.execute();
        }
        return super.onOptionsItemSelected(item);
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
        if (mediaPlayer.isPlaying()) mediaPlayer.release();
        if (mediaPlayer != null) mediaPlayer = null;

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