package kaist.cs496_01;

import android.app.ActionBar;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.astuetz.PagerSlidingTabStrip;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by q on 2016-06-30.
 */
public class TabCFragment extends Fragment {
    MediaPlayer mp;
    public static final Integer[] music_sample = {R.raw.konan,R.raw.allegro,R.raw.canon};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mp = MediaPlayer.create(getActivity(), R.raw.konan);
        mp.setLooping(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_music, null);
        ViewPager page = (ViewPager) view.findViewById(R.id.pager);
        Button btn1 = (Button) view.findViewById(R.id.button1);
        Button btn2 = (Button) view.findViewById(R.id.button2);
        Button btn3 = (Button) view.findViewById(R.id.button3);
        page.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new MusicFragment();
            }

            @Override
            public int getCount() {
                return music_sample.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "SONG " + (position + 1);
            }
        });
        page.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mp.stop();
                try {
                    mp.prepare();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
                mp.seekTo(0);
                mp = MediaPlayer.create(getActivity(),music_sample[position]);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.music_tabs);
        tabs.setViewPager(page);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                try {
                    mp.prepare();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
                mp.seekTo(0);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        return view;
    }
}


