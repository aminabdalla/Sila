package at.app.sila.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.app.sila.R;
import at.app.sila.adapter.PeopleAdapter;
import at.app.sila.mainactivity.MainActivity;
import at.app.sila.people.Person;
import at.app.sila.people.RelationshipType;
import at.app.sila.service.ServiceProvider;
import at.app.sila.service.people.PeopleService;

/**
 * Created by AAbdalla on 07.01.2016.
 */
public class PeopleSectionFragment extends Fragment {

    private ListView listView;
    private List<Person> allEntities;
    private ExpandableListView expListView;

    public PeopleSectionFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ServiceProvider<PeopleService> serviceFactory = MainActivity.getServiceFactory();
        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        List<String> familyGroupingList = getFamilyGroupingList();
        Map<String, List<Person>> childElementList = getFamilyChildElementList(serviceFactory, familyGroupingList);
        PeopleAdapter listAdapter = new PeopleAdapter(this.getActivity(), familyGroupingList, childElementList);
        // setting list adapter
        expListView.setAdapter(listAdapter);


        /**
        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);
                Person person = allEntities.get(position);

                // Show Alert
                Toast.makeText(view.getContext(),person.toString(), Toast.LENGTH_SHORT)
                        .show();

            }

        });
        */
        return rootView;

    }

    @NonNull
    private Map<String, List<Person>> getFamilyChildElementList(ServiceProvider<PeopleService> serviceFactory, List<String> familyGroupingList) {
        Map<String,List<Person>> listDataChild = new HashMap<String,List<Person>>();
        listDataChild.put(familyGroupingList.get(0),serviceFactory.createService().getCloseFamily());
        listDataChild.put(familyGroupingList.get(1),serviceFactory.createService().getGreatFamily());
        listDataChild.put(familyGroupingList.get(2),serviceFactory.createService().getFriends());
        return listDataChild;
    }

    @NonNull
    private List<String> getFamilyGroupingList() {
        // preparing list data
        List<String> listDataHeader = new ArrayList<String>();
        listDataHeader.add(RelationshipType.Family.name());
        listDataHeader.add(RelationshipType.Wider_Family.name());
        listDataHeader.add(RelationshipType.Friends.name());
        listDataHeader.add(RelationshipType.Colleagues.name());
        return listDataHeader;
    }

}
