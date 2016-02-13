package at.app.sila.fragments;

import android.support.v4.app.Fragment;

import at.app.sila.fragments.addplace.PlaceFragment;

/**
 * Created by AAbdalla on 07.01.2016.
 */
public class SectionFragmentFactory {


    public static Fragment createSectionFragment(int sectionnumber){

        switch (sectionnumber) {
            case 0:
                return new PeopleSectionFragment();
            case 1:
                return new PlaceFragment();
            case 2:
                return SectionFragment.newInstance(2);
        }
        return null;

    }

}
