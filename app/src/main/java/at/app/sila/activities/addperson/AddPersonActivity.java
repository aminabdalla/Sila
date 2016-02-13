package at.app.sila.activities.addperson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;

import at.app.sila.R;
import at.app.sila.mainactivity.MainActivity;
import at.app.sila.people.Relation;
import at.app.sila.people.Sex;
import at.app.sila.places.Places;


/**
 * Created by AAbdalla on 16.01.2016.
 */
public class AddPersonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person_fragment);
    }

    public void addPerson(View view){
        Intent back2MainIntent = new Intent(view.getContext(), MainActivity.class);
        back2MainIntent.putExtra("name","Geddo");
        back2MainIntent.putExtra("relation", Relation.FATHER);
        back2MainIntent.putExtra("sex", Sex.MALE);
        back2MainIntent.putExtra("place", (Serializable) Places.HOME.place());
        setResult(Activity.RESULT_OK, back2MainIntent);
        finish();
    }
}
