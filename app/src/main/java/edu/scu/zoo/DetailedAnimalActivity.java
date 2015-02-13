package edu.scu.zoo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;


public class DetailedAnimalActivity extends CommonActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_animal);
        TextView animalName=(TextView) findViewById(R.id.animalName);
        ImageView animalImage=(ImageView) findViewById(R.id.animalImage);
        TextView animalDescription=(TextView) findViewById(R.id.description);

        Intent intent = getIntent();
        if (null != intent) {
            String name=intent.getStringExtra("name");
            animalName.setText(name);
            String description=intent.getStringExtra("description");
            animalDescription.setText(description);
            InputStream inputStream = null;
            try {
                inputStream = getAssets().open(intent.getStringExtra("image"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            animalImage.setImageDrawable(drawable);

        }

    }

}
