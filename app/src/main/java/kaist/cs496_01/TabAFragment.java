package kaist.cs496_01;


import android.content.Context;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by q on 2016-06-29.
 */
public class TabAFragment extends Fragment {

    static JSONAdapter adapter;
    private final String filename = "phonebook";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getActivity().openFileInput(filename)));
            String text;
            String jsonfile="";
            while ((text=reader.readLine())!=null) {
                jsonfile+=text;
            }
            JSONArray jarray = new JSONArray(jsonfile);
            ArrayList<PhonePerson> values = new ArrayList<>();
            for (int i = 0 ; i < jarray.length(); i++) {
                values.add(new PhonePerson((JSONObject) jarray.get(i)));
            }
            adapter = new JSONAdapter(getActivity(), values);

            reader.close();
        } catch (FileNotFoundException e) {
            File fPhoneBook = new File(getContext().getFilesDir(), filename);
            ArrayList<PhonePerson> values = new ArrayList<>();
            adapter = new JSONAdapter(getActivity(), values);
        } catch (IOException e) {}
        catch (JSONException e) {}
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        JSONArray jarr = new JSONArray();

        for (int i = 0; i < adapter.getCount(); i++) {
            PhonePerson iPerson = (PhonePerson)adapter.getItem(i);
            JSONObject iObj = iPerson.toJSON();
            jarr.put(iObj);
        }
        try {
            FileOutputStream outputStream = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(jarr.toString().getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {}
        catch (IOException e) {}



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
            TabAFragment.adapter.add(new PhonePerson(jobj));
        }
        catch (JSONException e) {}
        catch (NumberFormatException e) {}

    }
}
