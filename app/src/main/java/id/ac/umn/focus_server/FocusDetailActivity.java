package id.ac.umn.focus_server;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.umn.focus_server.Model.Focus;
import id.ac.umn.focus_server.ViewHolder.FocusClientHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FocusDetailActivity extends AppCompatActivity {

    TextView focus_name, focus_price, focus_description;
    ImageView focus_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FirebaseDatabase database;
    DatabaseReference stationery;
    Focus currentFocus;

    String focusId = "";
    FirebaseRecyclerAdapter<Focus, FocusClientHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_detail_client);

        //Firebase
        database = FirebaseDatabase.getInstance();
        stationery = database.getReference("Stationery");



        focus_description = (TextView) findViewById(R.id.focus_description);
        focus_name = (TextView) findViewById(R.id.focus_name);
        focus_price = (TextView) findViewById(R.id.focus_price);
        focus_image = (ImageView) findViewById(R.id.img_focus);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //Get focus ID from Intent
        if(getIntent() != null)
            focusId = getIntent().getStringExtra("FocusId");
        if(!focusId.isEmpty()){
            getDetailFocus(focusId);
        }

    }

    private void getDetailFocus(String focusId) {
        stationery.child(focusId).addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                currentFocus = dataSnapshot.getValue(Focus.class);

                //Set Image
                Picasso.with(getBaseContext()).load(currentFocus.getImage()).into(focus_image);

                collapsingToolbarLayout.setTitle(currentFocus.getName());

                focus_price.setText(currentFocus.getPrice());

                focus_name.setText(currentFocus.getName());

                focus_description.setText(currentFocus.getDescription());

            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });

    }
}
