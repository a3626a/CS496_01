package kaist.cs496_01;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by q on 2016-06-30.
 */
public class MusicFragment extends Fragment {
    public static final String[] music_name = {"konan","allegro","canon"};
    private int position;

    public static MusicFragment position_i(int position) {
        MusicFragment fragment = new MusicFragment();
        Bundle args = new Bundle();
        args.putInt("key", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position=getArguments().getInt("key");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_entry, null);
        LinearLayout background=(LinearLayout)view.findViewById(R.id.background);
        TextView page_num=(TextView)view.findViewById(R.id.page_num);

        page_num.setText(String.valueOf(music_name[position]));
        background.setBackgroundColor(0xff6dc6d2);
        return view;
    }

}

