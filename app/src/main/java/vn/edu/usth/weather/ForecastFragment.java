package vn.edu.usth.weather;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {


    public ForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // inflater.inflate(R.layout.fragment_forecast, container, false);
        LinearLayout lin = new LinearLayout(getContext());
        lin.setOrientation(LinearLayout.VERTICAL);

        // Layout size
        float density = getResources().getDisplayMetrics().density;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,  // Width
                LinearLayout.LayoutParams.MATCH_PARENT               // Height
        );

        // Layout's text
        TextView text = new TextView(getContext());
        text.setText(R.string.thursday);


        // Layout's image
        ImageView img = new ImageView(getContext());
        img.setImageResource(R.drawable.sunny);

        // add views
        lin.addView(text);
        lin.addView(img);

        lin.setBackgroundColor(Color.parseColor("#6817AB"));
        lin.setLayoutParams(params);
        return lin;
    }
}