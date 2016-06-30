package kaist.cs496_01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by q on 2016-06-28.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment;

        if (i==0)
            return new TabAFragment();
        else if (i==1)
            return new TabBFragment();
        else if (i==2)
            return new TabCFragment();

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "PHONE BOOK";
            case 1:
                return "GAGLLERY";
            case 2:
                return "MUSIC";
        }
        return "NULL";
    }
}
