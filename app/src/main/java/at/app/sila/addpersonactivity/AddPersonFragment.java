package at.app.sila.addpersonactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.app.sila.R;


/**
 * Created by AAbdalla on 15.01.2016.
 */
public class AddPersonFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View currentView = inflater.inflate(R.layout.add_person_fragment, container, false);
        return currentView;
    }


}
