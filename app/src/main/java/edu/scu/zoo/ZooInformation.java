package edu.scu.zoo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


public class ZooInformation extends CommonActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_information);

        final TextView callView=(TextView) findViewById(R.id.callView);
        callView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ph="tel:"+ callView.getText().toString().trim();
                Intent call=new Intent(Intent.ACTION_CALL, Uri.parse(ph));
                startActivity(call);
            }
        });

    }

}
