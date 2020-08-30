package id.ac.umn.focus_server;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnHomeClient;
    TextView txtSlogan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnHomeClient = (Button)findViewById(R.id.btnHomeClient);
        txtSlogan = (TextView)findViewById(R.id.txtSlogan);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Pintgram.ttf");
        txtSlogan.setTypeface(face);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(signIn);
            }
        });

        btnHomeClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeClient = new Intent(MainActivity.this,HomeClientActivity.class);
                startActivity(homeClient);
            }
        });


    }
}
