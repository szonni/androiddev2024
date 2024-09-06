package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private static final int PAGE_COUNT = 3;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new WeatherAndForecastFragment();
            case 1: return new WeatherFragment();
            case 2: return new ForecastFragment();
            default: return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return PAGE_COUNT;
    }
}
