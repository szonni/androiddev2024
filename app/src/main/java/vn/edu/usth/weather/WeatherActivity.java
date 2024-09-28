package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherActivity extends AppCompatActivity {
    private static final String tag = "WeatherActivity";
    AsyncTask<Void, Integer, Bitmap> task;
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
        task.execute();

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
        task = new AsyncTask<Void, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... voids) throws RuntimeException {

                try {
                    URL url = new URL("https://i.pinimg.com/originals/28/db/ff/28dbffd19ce1ec872dc51f62725b8d51.jpg");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.connect();

                    int response = connection.getResponseCode();
                    Log.i(tag, "The response is: " + response);
                    InputStream is = connection.getInputStream();

                    Bitmap bitmap = BitmapFactory.decodeStream(is);

                    connection.disconnect();

                    return bitmap;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(Bitmap bit) {
                ImageView bg = (ImageView) findViewById(R.id.background);
                bg.setImageBitmap(bit);
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
            return true;
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