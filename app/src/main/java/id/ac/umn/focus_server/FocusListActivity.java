package id.ac.umn.focus_server;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import id.ac.umn.focus_server.Interface.ItemClickListener;
import id.ac.umn.focus_server.Model.Focus;
import id.ac.umn.focus_server.ViewHolder.FocusClientHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FocusListActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference focusList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    String categoryId = "";
    FirebaseRecyclerAdapter<Focus, FocusClientHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_list_client);
        //Firebase
        database = FirebaseDatabase.getInstance();
        focusList = database.getReference("Stationery");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_focus);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get Intent here
        if(getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if(!categoryId.isEmpty() && categoryId != null){
            loadListFocus(categoryId);
        }


    }

    private void loadListFocus(String categoryID){
        adapter = new FirebaseRecyclerAdapter<Focus, FocusClientHolder>(Focus.class,
                R.layout.focus_item,
                FocusClientHolder.class,
                focusList.orderByChild("menuId").equalTo(categoryId)) { //like Select * from Stationery where MenuID =
            @Override
            protected void populateViewHolder(FocusClientHolder viewHolder, Focus model, int position) {
                viewHolder.focus_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.focus_image);

                final Focus local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isClick) {
                        //start new activity
                        Intent focusDetail =  new Intent(FocusListActivity.this, FocusDetailActivity.class);
                        focusDetail.putExtra("FocusId", adapter.getRef(position).getKey());
                        startActivity(focusDetail);
                    }
                });
            }
        };
        //Set Adapter
        Log.d("TAG", ""+adapter.getItemCount());
        recyclerView.setAdapter(adapter);
    }
}
