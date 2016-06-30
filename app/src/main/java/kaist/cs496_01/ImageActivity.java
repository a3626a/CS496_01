package kaist.cs496_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView image = (ImageView)findViewById(R.id.image);

        Intent intent = getIntent();
        image.setImageResource(TabBFragment.mThumbIds[intent.getIntExtra("selected",0)]);
    }
}
