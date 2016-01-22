package at.app.sila.mainactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import at.app.sila.people.PeopleService;
import at.app.sila.people.Person;
import at.app.sila.people.ServiceFactory;

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
        ServiceFactory<PeopleService> serviceFactory = MainActivity.getServiceFactory();
        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);

        // preparing list data
        List<String> listDataHeader = new ArrayList<String>();
        listDataHeader.add("Family");
        listDataHeader.add("Wider Family");
        listDataHeader.add("Friends");
        System.out.println("################### adding data");
        Map<String,List<Person>> listDataChild = new HashMap<String,List<Person>>();
        listDataChild.put(listDataHeader.get(0),serviceFactory.createService().getCloseFamily());
        listDataChild.put(listDataHeader.get(1),serviceFactory.createService().getGreatFamily());
        listDataChild.put(listDataHeader.get(2),serviceFactory.createService().getFriends());

        ExpandableListAdapter<Person> listAdapter = new ExpandableListAdapter<Person>(this.getActivity(), listDataHeader, listDataChild);
        Log.d("PeopleSectionFragment","adapter was set!");
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

}
