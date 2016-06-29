package kaist.cs496_01;

import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by q on 2016-06-29.
 */
public class PhonePerson {
    private String name;
    private int number;

    public PhonePerson(JSONObject jobj) {
        try {
            this.name = jobj.getString("name");
            this.number = jobj.getInt("number");
        } catch (JSONException e) {
        }
    }

    public void write(View view) {
        TextView nametext = (TextView) view.findViewById(R.id.name);
        nametext.setText(this.name);
        TextView numbertext = (TextView) view.findViewById(R.id.number);
        numbertext.setText(Integer.toString(this.number));
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("name", name);
            obj.put("number", number);
        } catch (JSONException e) {}
        return obj;
    }
}
