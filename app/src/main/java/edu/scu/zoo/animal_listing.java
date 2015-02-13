package edu.scu.zoo;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class animal_listing extends CommonActionBarActivity {


    public static List<Animal> animals;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_listing);
        listView = (ListView) findViewById(R.id.animalListView);
        animals= new ArrayList<>();
        animals.add(new Animal("Polar Bear","polar_bear_thumb.jpg" ,"polar_bear.jpg","The polar bear (Ursus maritimus) is a " +
                "carnivorous bear whose native range lies largely within the Arctic Circle, encompassing the Arctic Ocean, its " +
                "surrounding seas and surrounding land masses. It is a large bear, approximately the same size as the omnivorous " +
                "Kodiak bear. A boar (adult male) weighs around 350–700 kg (770–1,540 lb), while " +
                "a sow (adult female) is about half that size"));
        animals.add(new Animal("Tiger","tiger_tbn.jpg" ,"tiger.jpg","Mesmerizing and gorgeous, but also endangered, our Malayan " +
                "tigers are always a pleasure to watch. Their exhibit was designed to closely resemble a natural jungle habitat and " +
                "was built on a steep slope that gives the big cats plenty of exercise. You can safely view these powerful hunters " +
                "from three vantage points along Tiger Trail"));
        animals.add(new Animal("Grizzly Bear","grizzly_bear_thumb.jpg","grizzly_bear.jpg","Brown bears in interior North America " +
                "are known as grizzly bears, because their brown fur is tipped with white or tan; the word grizzly means" +
                " sprinkled or streaked with gray)"));
        animals.add(new Animal("Macaw","macaw_thumb.jpg","macaw.jpg","Macaws are the giants of the parrot family. " +
                "They are famous for their bright colors. Their red, yellow, green, and/or blue feathers seem bold " +
                " eye-catching to us but actually blend in well with the green leaves, red and yellow fruits, and " +
                "bluish shadows of their rain forest home."));
        animals.add(new Animal("Dung Beetle","dung_beetle_thumb.jpg","dung_beetle.jpg","Dung beetles do just what their name suggests: " +
                "they use the manure, or dung, of other animals in some unique ways! These interesting insects fly around in search of" +
                " manure deposits, or pats, from herbivores like cows and elephants.\n" +
                "\n" +"Dung beetles come in a variety of colors, from dull and glossy black to metallic green and red. Ancient Egyptians" +
                " thought very highly of the dung beetle, also known as the scarab. They believed the dung beetle kept the Earth revolving" +
                " like a giant ball of dung."));
        animals.add(new Animal("Maned Wolf","maned_wolf_thumb.jpg","maned_wolf.jpg","Lanky and lean, the mysterious, misnamed, and " +
                "misunderstood maned wolf of South America is a sight to behold. Though it resembles a red fox on stilts and has “wolf” " +
                "in its name, this leggy canid is in a genus all its own: Chrysocyon "));
        animals.add(new Animal("Okapi","okapi_thumb.jpg","okapi.jpg","Just behind the river hippos’ beach you’ll find a most unusual animal:" +
                " the okapi. With its white-and-black striped hindquarters and front legs, it looks like it must be related to zebras. But " +
                "take a look at an okapi’s head, and you’ll notice a resemblance to giraffes"));
        animals.add(new Animal("Anaconda","anaconda_thumb.jpg","anaconda.jpg","A member of the boa family, South America’s green anaconda is the heaviest " +
                "snake in the world. Like all boas, it kills its prey by coiling its muscular body around the creature and squeezing " +
                "until the animal can no longer breathe"));

        listView.setAdapter(new AnimalListAdapter(this, R.layout.custom_row, animals));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==listView.getCount()-1) {
                    showDialog("This animal is very dangerous. Do you still want to continue?",animal_listing.this);
                }
                else {
                    showAnimalDetails(position);
                }
            }
        });
    }

    public void showAnimalDetails(int position){
        Intent activity = new Intent(animal_listing.this, DetailedAnimalActivity.class);
        Bundle data = new Bundle();
        data.putString("name", animals.get(position).getName());
        data.putString("image", animals.get(position).getImage());
        data.putString("description", animals.get(position).getDescription());
        activity.putExtras(data);
        startActivity(activity);
    }

    public Dialog showDialog(String msg, final Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(msg)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showAnimalDetails(listView.getCount()-1);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
        return alertDialog;

    }

}

