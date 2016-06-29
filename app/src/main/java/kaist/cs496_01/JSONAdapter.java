package kaist.cs496_01;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.Phaser;
import java.util.zip.Inflater;

/**
 * Created by q on 2016-06-29.
 */
public class JSONAdapter extends ArrayAdapter{

    public JSONAdapter(Context context, @NonNull List<PhonePerson> objects) {
        super(context, R.layout.phone_person_entry, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        PhonePerson person = (PhonePerson) getItem(position);

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate( R.layout.phone_person_entry, parent, false);
        } else {
            view = convertView;
        }

        person.write(view);

        return view;
    }
}
