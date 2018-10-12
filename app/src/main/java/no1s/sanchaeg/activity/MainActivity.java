package no1s.sanchaeg.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import no1s.sanchaeg.Adapter.CustomFragmentPagerAdapter;
import no1s.sanchaeg.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        FragmentManager manager = getSupportFragmentManager();
        ViewPager pager = findViewById(R.id.main_viewpager);
        CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(manager);
        pager.setAdapter(adapter);

        TabLayout tab = findViewById(R.id.main_tab);
        tab.setupWithViewPager(pager);
        tab.setSelectedTabIndicatorHeight(0);

        tab.getTabAt(0).setCustomView(R.layout.tab_main);
        tab.getTabAt(1).setCustomView(R.layout.tab_route);
        tab.getTabAt(2).setCustomView(R.layout.tab_location);
        tab.getTabAt(3).setCustomView(R.layout.tab_favorite);
        tab.getTabAt(4).setCustomView(R.layout.tab_plan);
    }

}
