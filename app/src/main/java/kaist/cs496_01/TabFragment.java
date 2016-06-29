package kaist.cs496_01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Instances of this class are fragments representing a single
// object in our collection.
public class TabFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        switch (getArguments().getInt(ARG_OBJECT)) {
            case 1:
                View rootView1 = inflater.inflate(R.layout.tab_phone, container, false);
                return rootView1;
            case 2:
                View rootView2 = inflater.inflate(R.layout.tab_gallery, container, false);
                return rootView2;
            case 3:
                View rootView3 = inflater.inflate(R.layout.layout3, container, false);
                return rootView3;
        }

        return null;
    }
}
