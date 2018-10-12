package no1s.sanchaeg.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import no1s.sanchaeg.fragment.FavoriteFragment;
import no1s.sanchaeg.fragment.LocationFragment;
import no1s.sanchaeg.fragment.MainFragment;
import no1s.sanchaeg.fragment.PlanFragment;
import no1s.sanchaeg.fragment.RouteFragment;

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {
    public CustomFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // メイン
                return new MainFragment();
            case 1:
                // ルート
                return new RouteFragment();
            case 2:
                // 場所検索
                return new LocationFragment();
            case 3:
                // お気に入り
                return new FavoriteFragment();
            case 4:
                // プラン
                return new PlanFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
