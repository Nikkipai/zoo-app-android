package edu.scu.zoo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by niki on 1/25/15.
 */
public class CommonActionBarActivity extends ActionBarActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_info) {
            Intent infoActivity=new Intent(this,ZooInformation.class);
            startActivity(infoActivity);
        }else if(id==R.id.action_remove){
            Uri packageURI = Uri.parse("package:edu.scu.zoo");
            Intent remove=new Intent(Intent.ACTION_DELETE,packageURI);
            startActivity(remove);
        }
        return super.onOptionsItemSelected(item);
    }
}
