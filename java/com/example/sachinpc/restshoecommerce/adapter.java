package com.example.sachinpc.restshoecommerce;


        import android.app.Dialog;
        import android.content.ClipData;
        import android.content.Context;
        import android.content.res.Resources;
        import android.graphics.Rect;
        import android.support.v7.widget.DefaultItemAnimator;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.PopupMenu;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.util.TypedValue;
        import android.view.LayoutInflater;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.bumptech.glide.Glide;
        import com.facebook.share.widget.ShareButton;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

        import static com.example.sachinpc.restshoecommerce.R.id.add;
        import static com.example.sachinpc.restshoecommerce.R.id.img_seeProd;
        import static com.facebook.login.widget.ProfilePictureView.TAG;


/**
 * Created by SachinPC on 8/11/2017.
 */
public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {

    private Context mContext;
    static adapter adapterInstance;
    private List<Product> ItemList;

    public class viewHolder extends RecyclerView.ViewHolder {

        public TextView title, count;
        public ImageView thumbnail, overflow, mesg;
        ShareButton shareButton;

        public viewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title_mens);
            count = (TextView) view.findViewById(R.id.count_mens);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail_mens);
            overflow = (ImageView) view.findViewById(R.id.overflow_mens);
            mesg = (ImageView) view.findViewById(R.id.mesg_mens);
            // shareButton= (ShareButton)view.findViewById(R.id.shareButton);

        }
    }
    public adapter(Context mContext, List<Product> ItemList) {
        this.mContext = mContext;
        this.ItemList = ItemList;
    }
    public static adapter getInstance(Context context, List<Product> ItemList){
        if((adapterInstance==null)) {
            adapterInstance = new adapter(context, ItemList);
        }
        else if (adapterInstance.ItemList!=ItemList){
            adapterInstance = new adapter(context, ItemList);
        }
        //  }
        return adapterInstance;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.display_card, parent, false);

        return new viewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        final Product Item = ItemList.get(position);
        holder.title.setText(Item.getName());
        holder.count.setText(Item.getType());
        //final Sharing_data sharing_data = new Sharing_data();
        //final cartLogic c = new cartLogic();
        //final dbClass db=dbClass.getInstance(mContext);
        //final SharedPrefClass sp = new SharedPrefClass(mContext);

        Glide.with(mContext).load(Item.getImg()).placeholder(R.drawable.dots_vertical).into(holder.thumbnail);

        View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View v) {
                if (v.equals(holder.thumbnail)) {
                    //          final SharedPrefClass sp = new SharedPrefClass(v.getContext());
                    //Toast.makeText(v.getContext(),,Toast.LENGTH_LONG).show();
                     //       final cartLogic c = new cartLogic();
                    //  c.addToCart(v,album.getName(),String.valueOf(album.getNumOfSongs()));
                    final Dialog dialog = new Dialog(v.getContext());
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                       dialog.setContentView(R.layout.add_cart_dialog);
                    EditText add_q= (EditText) dialog.findViewById(R.id.add_q);
                    Button btn = (Button) dialog.findViewById(R.id.btn_add);
                      final String update_Q= add_q.getText().toString();
                    dialog.show();


                    //btn.setOnClickListener(new View.OnClickListener() {
                    // @Override
                    // public void onClick(View v) {
                    //      dbClass db = dbClass.getInstance(v.getContext());
                    //    EditText quantity = (EditText) dialog.findViewById(R.id.add_q);

                    //  String add_Q = quantity.getText().toString();
                    // if (c.addToCart(v,Item.getItem_ID(),add_Q)) {
                    //   c.viewCart(v, sp.getUserName());

                    // if(c.UpdateQuantities(v,0,Integer.parseInt(add_Q),Integer.parseInt(Item.getItem_quantity()),Item.getItem_ID())){
                    //   Log.d("success","reduced inventory");

                    //}
                    // dialog.dismiss();
                    // }
                    // if( db.updateCartInfo(.getID(),update_Q)) {
                    //  Toast.makeText(view.getContext(), "Successfully updated!", Toast.LENGTH_SHORT).show();
                    //  Intent in = new Intent(view.getContext(),Main7Activity.class);
                    //  view.getContext().startActivity(in);
                    //}


                    //     }
                    //  });
//                    c.viewCart(v,sp.getUserName());
                    //}
                }
            }
        };

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_see_product);
                TextView tv = (TextView) dialog.findViewById(R.id.product_name);
                TextView product_desc = (TextView) dialog.findViewById(R.id.textView12);
                TextView product_price = (TextView) dialog.findViewById(R.id.textView6);
                TextView pro_size= (TextView) dialog.findViewById(R.id.pro_size);
                tv.setText(Item.getName());
                pro_size.setText("Available in: "+Item.getSize());
                product_desc.setText(Item.getDescription());
                product_price.setText("Price : Rs. "+Item.getPrice());
                ImageView prod_image = (ImageView) dialog.findViewById(img_seeProd);
                Glide.with(mContext).load(Item.getImg()).placeholder(R.drawable.dots_vertical).into(prod_image);
                final EditText quantity = (EditText) dialog.findViewById(R.id.prod_qnt);
                Button btn = (Button) dialog.findViewById(R.id.pro_add_btn);
                dialog.show();


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "hello", Toast.LENGTH_SHORT).show();
                        String add_Q = quantity.getText().toString();
                cart_logic cart_logic = new cart_logic();
                        //cart_logic.sendPost(2,Integer.parseInt(add_Q),Item.getId(),39);

                        apiInterface apiService =
                                ApiClient.getClient().create(apiInterface.class);

                        apiService.addToCart(new Cart(2,Item.getId(),Integer.parseInt(add_Q),2)).enqueue(new Callback<Cart>() {
                            @Override
                            public void onResponse(Call<Cart> call, Response<Cart> response) {

                                if(response.isSuccessful()) {
                                    Log.i("!!!!!",response.body().toString());
                                    Log.i(TAG, "post submitted to API." + response.body().toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<Cart> call, Throwable t) {
                                Log.i("!!!!!",t.toString());
                                Log.e(TAG, "Unable to submit post to API.");
                            }
                        });

                        /// / if (c.addToCart(view,Item.getId(), add_Q)) {
                         //   if(c.UpdateQuantities(view,0,Integer.parseInt(add_Q),Integer.parseInt(Item.getQuantity()),Item.getItem_ID())){
                           //     Log.d("success","reduced inventory to "+ db.getQuantityForId(Item.Item_ID));
                            //}
                            //dialog.dismiss();
                       // }
                    }
                });
                // EditText upd_q= (EditText) view.findViewById(R.id.update_q1);
                // Button btn= (Button) dialog.findViewById(R.id.btn_add);
//                                final String update_Q= upd_q.getText().toString();


                //  showPopupMenu(holder.overflow);
            }
        });
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //    sharing_data.share(mContext, Item);

            }

        });

      //  holder.mesg.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View view) {
            //    final Dialog dialog = new Dialog(view.getContext());
              //  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                // dialog.setContentView(R.layout.message_dialog);
                //final List<Message> messages= new ArrayList<Message>();
                //messages.addAll(db.getMessages(Item.getItem_ID()));
                //RecyclerView rV= (RecyclerView) dialog.findViewById(R.id.msg_recycler);
                //final msg_adapter msg_adapter= new msg_adapter(dialog.getContext(),messages);
                //rV.setAdapter(msg_adapter);


                //LinearLayoutManager llm = new LinearLayoutManager(dialog.getContext());
                //rV.setLayoutManager(llm);

                //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(dialog.getContext(),
                //      llm.getOrientation());
                // rV.addItemDecoration(dividerItemDecoration);
               // dialog.show();
                //final EditText msgBox= (EditText) dialog.findViewById(R.id.msg_Box);
                //Button sendBtn = (Button) dialog.findViewById(R.id.send_btn);
                // Button clearBtn = (Button) dialog.findViewById(R.id.clear_btn);
                // ImageView refresh= (ImageView) dialog.findViewById(R.id.refresh_mesg);
                //LinearLayoutManager llm = new LinearLayoutManager(dialog.getContext());
                // rV.setLayoutManager(llm);
                //  clearBtn.setOnClickListener(new View.OnClickListener() {
                //  @Override
                //public void onClick (View view){
                //        msgBox.setText("");
                //    }
                //});

                //refresh.setOnClickListener(new View.OnClickListener() {
                // @Override
                // public void onClick (View view){
                //      swap((ArrayList<Message>) messages,db.getMessages(Item.getItem_ID()),msg_adapter);
                //    msg_adapter.notifyDataSetChanged();
                //    }
                //});


                //dialog.show();

                // sendBtn.setOnClickListener(new View.OnClickListener() {
              //  @Override
                //public void onClick (View v){
                    //       String msg = msgBox.getText().toString();
                    //     if (db.addMessage(Item.getItem_ID(),sp.getUserName(),msg,null)) {
                    //       swap((ArrayList<Message>) messages,db.getMessages(Item.getItem_ID()),msg_adapter);
                    //     msgBox.setText("");
                    //}
                    //else{
                    //  Toast.makeText(mContext, R.string.mesg_wasnt_sent, Toast.LENGTH_SHORT).show();
                    //}
                    //           }
                    // });
                    //*/
                }


                //  });

                // SharePhoto photo = new SharePhoto.Builder()
                ////     .setImageUrl(new Uri.Builder().path(Item.getItem_img()).build())
                //   .setCaption("Buy your favourite" + Item.getItem_Type() + ", " + Item.getItem_Name())
                //   .build();
                //SharePhotoContent content = new SharePhotoContent.Builder()

                //      .setContentUrl(new Uri.Builder().path(Item.getItem_img()).build())
                //    .addPhoto(photo)
                //    .build();

                //   holder.shareButton.setShareContent(content);
                // ShareDialog.show(vie,content);

                // });

                //}


    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    ;
/*
    public void swap(ArrayList<Message> message,ArrayList<Message> newmessage, RecyclerView.Adapter ad){
        message.clear();
        message.addAll(newmessage);
        ad.notifyDataSetChanged();
    }
    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
       // inflater.inflate(R.menu.menu_album, popup.getMenu());
      //  popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
       // popup.show();
    }

    /**
     * Click listener for popup menu items
     */
   /* class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
*/





    }




