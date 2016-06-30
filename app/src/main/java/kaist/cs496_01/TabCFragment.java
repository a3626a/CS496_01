package kaist.cs496_01;

import android.app.ActionBar;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by q on 2016-06-30.
 */
public class TabCFragment extends Fragment {
    Button button;
    MediaPlayer mp;
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

        Button btn1 = (Button) view.findViewById(R.id.button1);
        Button btn2 = (Button) view.findViewById(R.id.button2);
        Button btn3 = (Button) view.findViewById(R.id.button3);


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


