package com.example.sachinpc.restshoecommerce;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import java.util.ArrayList;



import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

/**
 * Created by SachinPC on 8/12/2017.
 */

public class FragmentSetter {
    ItemFragment fragment;
   // dbClass db;
    int categoryCount;
    public Fragment getFragment(String type, Context context){
     //   db= dbClass.getInstance(context);
        if(type=="WMN"){
            ItemFragment fragment= new ItemFragment();

            //fragment.setItemList(db.getProductsFor(type));
            return fragment;
        }
        if(type=="MEN"){
            ItemFragment fragment= new ItemFragment();
           // ArrayList<Display_Items> display_itemses=new ArrayList<>();
            //display_itemses.add(new Display_Items("0","adsa","dadas","dsadsa","dasda","asdad","asdasd","M"));
            //display_itemses.add(new Display_Items("1","adsa","dadas","dsadsa","dasda","asdad","asdasd","M"));
            //fragment.setItemList(display_itemses);
            //fragment.setItemList(db.getProductsFor(type));
            return fragment;
        }
        if(type=="KID") {
            ItemFragment fragment= new ItemFragment();

            //fragment.setItemList(db.getProductsFor(type));
            return fragment;
        }
        if(type=="ACC") {
            ItemFragment fragment= new ItemFragment();

            //fragment.setItemList(db.getProductsFor(type));
            return fragment;
        }



        else return null;
        //  return fragment;
    }






    public Fragment giveFrag(String type,Context context){
        //db= dbClass.getInstance(context);
        ItemFragment items = new ItemFragment();

        items.setItemList(null);
        return items;

    }
    /*
    public ArrayList<Fragment> fragmentFactory(Context context){
       // db= dbClass.getInstance(context);
        ArrayList<String> array= db.getCategories();
        ArrayList<Fragment>fragments=new ArrayList<>();
        Fragment[] fragArray= new Fragment[array.size()];
        for(String category : array){
            ItemFragment fragment= new ItemFragment();
            fragment.setItemList(db.getProductsFor(category));
            // fragArray[category]= fragment;
            fragments.add(fragment);
        }
        //categoryCount= array.size();
        // for (int i=0; i<array.size();i++){
        //   ItemFragment fragment= new ItemFragment();
        //  fragment.setItemList(db.getProductsFor(array.get(i)));
        // fragArray[i]= fragment;

        return fragments;
    }
*/
    public int getFragcount(){

        return 4;
    }

}
