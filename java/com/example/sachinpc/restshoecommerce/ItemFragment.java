package com.example.sachinpc.restshoecommerce;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Movie;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
        import android.os.Parcelable;
        import android.support.v4.app.Fragment;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.DefaultItemAnimator;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.login.widget.ProfilePictureView.TAG;

public class ItemFragment extends Fragment {

    private RecyclerView recyclerView;
    //private Item_Adapter adapter;
    View rootView;
    private ArrayList<ShoeModel> ItemList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // type= savedInstanceState.getString("Type");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_items, container, false);
        //    initCollapsingToolbar();
        //      ItemList= new ArrayList<>();

        //HttpRequestTask.execute(runnable);
//ArrayList<Display_Items> items= savedInstanceState.getParcelableArrayList("ItemsArray");
        // setItemList(items);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.item_recycler);
        recyclerView.setHasFixedSize(true);

        //adapter = new Item_Adapter(rootView.getContext(), albumList);
        // ProductLogic pl = new ProductLogic();
        // pl.loadProducts(rootView);

        //cartLogic cL= new cartLogic();
        //  cL.cf(this.getActivity(),5);

        //  final dbClass db = new dbClass(this.getContext());
        //getAlbumList().addAll(db.getProducts());
        // setItemList(db.getProductsFor(type));
        //  new Thread(new Runnable() {
        //    @Override
        //   public void run() {

      //  setAdapter(recyclerView, rootView, this.getContext(), ItemList);

        //    }
        //   }).start();
        //

        apiInterface apiService =
                ApiClient.getClient().create(apiInterface.class);

        Call<List<Product>> call = apiService.getAll();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>>  response) {
                int statusCode = response.code();
                List<Product> shoes = new ArrayList<Product>();
                shoes.addAll(response.body());
                Log.i("objects",String.valueOf(statusCode));
                Log.i("objects",response.body().toString());
                setAdapter(recyclerView, rootView, getContext(), shoes);

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Log error here since request failed
                Log.e("!!!!!!!!!!!!!!",t.toString());
                Log.e(TAG, t.toString());
            }
        });

        // prepareAlbums();

        try {
            // Glide.with(this).load(R.drawable.cover).into((ImageView) rootView.findViewById(R.id.backdrop_mens));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
    }

    public void setAdapter(RecyclerView recyclerView, View rootView, Context context, List<Product> itemsList) {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(rootView.getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter adapterobj = new adapter(context, itemsList);
        recyclerView.setAdapter(adapterobj);

    }

    public ArrayList<ShoeModel> getItemList() {
        return ItemList;
    }


    public void setItemList(ArrayList<ShoeModel> ItemList) {
        this.ItemList = ItemList;
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /* private class HttpRequestTask extends AsyncTask<Void, Void, ArrayList<ShoeModel>> {
         @Override
         protected ArrayList<ShoeModel> doInBackground(Void... params) {
             try {
                 final String url = "http://localhost:8080/api/notes";
                 RestTemplate restTemplate = new RestTemplate();
                 restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                 ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(url, Object[].class);
                 Object[] objects = responseEntity.getBody();
                 MediaType contentType = responseEntity.getHeaders().getContentType();
                 HttpStatus statusCode = responseEntity.getStatusCode();
                 ArrayList<ShoeModel> shoeModel = new ArrayList<>();
                 shoeModel.addAll(Arrays.asList(Arrays.copyOf(objects,objects.length,ShoeModel[].class)));
                 Log.i("@@@@@@@@@@",statusCode.toString());
                 return shoeModel;
             } catch (Exception e) {
                 Log.e("MainActivity", e.getMessage(), e);
             }

             return null;
         }

         @Override
         protected void onPostExecute(ArrayList<ShoeModel> shoeModels) {
             setAdapter(recyclerView,rootView,getContext(),shoeModels);
         }

     }
 */







}