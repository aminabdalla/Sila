package at.app.sila.mainactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.HashSet;

import at.app.sila.R;
import at.app.sila.activities.addperson.AddPersonActivity;
import at.app.sila.adapter.PeopleAdapter;
import at.app.sila.fragments.SectionFragmentFactory;
import at.app.sila.fragments.addplace.PlaceFragment;
import at.app.sila.fragments.addplace.dummy.DummyContent;
import at.app.sila.people.Person;
import at.app.sila.people.Relation;
import at.app.sila.people.Sex;
import at.app.sila.places.Place;
import at.app.sila.service.ServiceProvider;
import at.app.sila.service.ServiceProviderImpl;
import at.app.sila.service.people.PeopleService;
import at.app.sila.things.Thing;

public class MainActivity extends AppCompatActivity implements PlaceFragment.OnListFragmentInteractionListener{

    private static ServiceProvider<PeopleService> peopleServiceFactory;
    public static ServiceProvider<PeopleService> getServiceFactory() {return peopleServiceFactory;};

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        peopleServiceFactory = new ServiceProviderImpl();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent addPersonIntend = new Intent(view.getContext(), AddPersonActivity.class);
              startActivityForResult(addPersonIntend, 1);
          }
      });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            String name = data.getStringExtra("name");
            Relation relation = (Relation) data.getSerializableExtra("relation");
            Place place = (Place) data.getSerializableExtra("place");
            Sex sex = (Sex) data.getSerializableExtra("sex");
            Person addedPerson = new Person(name, relation, sex, place, new HashSet<Thing>());
            PeopleService pService = MainActivity.getServiceFactory().createService();
            pService.addEntity(addedPerson);
            ExpandableListView expListView = (ExpandableListView) this.findViewById(R.id.lvExp);
            PeopleAdapter adapter = (PeopleAdapter) expListView.getExpandableListAdapter();
            adapter.update();


            System.out.println("################### adapter was notified children count: "+adapter.getChildrenCount(1));
        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return SectionFragmentFactory.createSectionFragment(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "People";
                case 1:
                    return "Places";
                case 2:
                    return "Things";
            }
            return null;
        }
    }


}
