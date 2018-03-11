package com.example.sachinpc.restshoecommerce;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;

import static com.example.sachinpc.restshoecommerce.R.id.container;

public class Main2Activity extends AppCompatActivity {


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
    TabLayout tabLayout;
    //CounterFab cf;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
      //  SharedPrefClass sp= new SharedPrefClass(getApplicationContext());
       // sp.checkLogin();
        //FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("StyleOmega Inc.");
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();
/*
        cf= (CounterFab) findViewById(R.id.counter_fab);
        cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(cf.getContext(),Main7Activity.class);
                startActivity(in);
            }

        });
*/


    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.icon_women);
        tabLayout.getTabAt(1).setIcon(R.drawable.men_icon_w);
        tabLayout.getTabAt(2).setIcon(R.drawable.kids_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.accessories_icon);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);

        return true;
    }

    //@Override
    // public boolean onOptionsItemSelected(MenuItem item) {

    //     return super.onOptionsItemSelected(item);
    // }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();




        //noinspection SimplifiableIfStatement

        if (id == R.id.action_search) {
            //Intent in = new Intent(this,SearchActivity.class);
        //    startActivity(in);
        }
        if (id == R.id.action_update) {
          //  Intent in = new Intent(this,UpdateActivity.class);
           // startActivity(in);
        }
        if (id == R.id.action_logout) {
           // Intent in = new Intent(this,Main3Activity.class);
           // SharedPrefClass sharedPrefClass= new SharedPrefClass(this);
           // sharedPrefClass.DestroySession();
           // Toast.makeText(this, "You have now logged out!", Toast.LENGTH_SHORT).show();
            //startActivity(in);
        }
        if (id == R.id.action_ViewCart) {
           // Intent in = new Intent(this,Main7Activity.class);
           // startActivity(in);
        }
        if (id == R.id.action_contact) {
            //Intent in = new Intent(this,ContactStore.class);
            //startActivity(in);
        }

        return super.onOptionsItemSelected(item);
    }




    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }
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

            switch (position) {
                //for(int i=0;i<4;i++) {
                case 0:
                    return new FragmentSetter().getFragment("WMN",getBaseContext());
                case 1:
                    return new FragmentSetter().getFragment("MEN", getBaseContext());

                case 2:
                    return new FragmentSetter().getFragment("KID", getBaseContext());
                case 3:
                    return new FragmentSetter().getFragment("ACC", getBaseContext());

            }


            return null;

        }

        @Override
        public int getCount() {

            // Show 4 total pages.
            return new FragmentSetter().getFragcount();
        }



        @Override
        public CharSequence getPageTitle(int position) {
            //    switch (position) {
            //  case 0:
            //      return "SECTION 1";
            //  case 1:
            //     return "SECTION 2";
            // case 2:
            //     return "SECTION 3";
            // }
            return null;
        }

    }

}
