package kaist.cs496_01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends Activity {

    private Bitmap mPlaceHolderBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        mPlaceHolderBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.waiting);

        ImageView image = (ImageView)findViewById(R.id.image);

        Point pSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(pSize);

        Intent intent = getIntent();
        BitmapHelper.loadBitmap(TabBFragment.mThumbIds[intent.getIntExtra("selected",0)],image,pSize.x,pSize.y,mPlaceHolderBitmap,getResources());
    }
}
