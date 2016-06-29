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


        fragment = new TabFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(TabFragment.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}
