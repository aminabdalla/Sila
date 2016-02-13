package at.app.sila.adapter;

import android.content.Context;

import java.util.List;
import java.util.Map;

import at.app.sila.mainactivity.MainActivity;
import at.app.sila.people.Person;

/**
 * Created by AAbdalla on 13.02.2016.
 */
public class PeopleAdapter extends ExpandableListAdapter<Person>{


    public PeopleAdapter(Context context, List<String> listDataHeader, Map<String, List<Person>> listChildData) {
        super(context, listDataHeader, listChildData);
    }

    public void update(){
        _listDataChild.put(_listDataHeader.get(0), MainActivity.getServiceFactory().createService().getCloseFamily());
        _listDataChild.put(_listDataHeader.get(1),MainActivity.getServiceFactory().createService().getGreatFamily());
        _listDataChild.put(_listDataHeader.get(2),MainActivity.getServiceFactory().createService().getFriends());
    }

}
