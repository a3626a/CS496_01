package kaist.cs496_01;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by q on 2016-06-29.
 */
public class TabAFragment extends Fragment {

    static JSONAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<PhonePerson> values = new ArrayList<>();

        JSONObject jobj;

        jobj = new JSONObject();
        try {
            jobj.put("name", "KIM");
            jobj.put("number", 123);
        } catch (JSONException e) {}
        values.add(new PhonePerson(jobj));

        jobj = new JSONObject();
        try {
            jobj.put("name", "LEE");
            jobj.put("number", 234);
        } catch (JSONException e) {}
        values.add(new PhonePerson(jobj));

        jobj = new JSONObject();
        try {
            jobj.put("name", "PARK");
            jobj.put("number", 345);
        } catch (JSONException e) {}
        values.add(new PhonePerson(jobj));

        adapter = new JSONAdapter(getActivity(), values);

        View view = inflater.inflate(R.layout.tab_phone, null);
        ListView lv = (ListView) view.findViewById(R.id.list);
        lv.setAdapter(adapter);

        Button btn = (Button) view.findViewById(R.id.phone_button);
        EditText name_text = (EditText) view.findViewById(R.id.edit_name);
        EditText number_text = (EditText) view.findViewById(R.id.edit_number);

        btn.setOnClickListener(new onClickListener(name_text,number_text));

        return view;
    }

}

class onClickListener implements  View.OnClickListener {

    EditText mNameText;
    EditText mNumberText;

    public onClickListener(EditText nameText, EditText numberText) {
        this.mNameText=nameText;
        this.mNumberText=numberText;
    }

    @Override
    public void onClick(View v) {
        JSONObject jobj = new JSONObject();

        try {
         jobj.put("name", mNameText.getText().toString());
         jobj.put("number", Integer.parseInt(mNumberText.getText().toString()));
        } catch (JSONException e) {}

        TabAFragment.adapter.add(new PhonePerson(jobj));
    }
}
