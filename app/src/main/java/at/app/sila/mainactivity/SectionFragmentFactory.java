package at.app.sila.mainactivity;

import android.support.v4.app.Fragment;

/**
 * Created by AAbdalla on 07.01.2016.
 */
public class SectionFragmentFactory {


    static Fragment createSectionFragment(int sectionnumber){

        switch (sectionnumber) {
            case 0:
                return new PeopleSectionFragment();
            case 1:
                return SectionFragment.newInstance(1);
            case 2:
                return SectionFragment.newInstance(2);
        }
        return null;

    }

}
