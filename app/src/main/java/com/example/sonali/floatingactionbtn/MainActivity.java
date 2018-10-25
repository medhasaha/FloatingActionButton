package com.example.sonali.floatingactionbtn;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab1,fab2,fab3,fab4;
    TextView Tv2,Tv3,Tv4;
    private Boolean isFabOpen = false;
    private Animation fab_close,fab_open,forward_rotate,backward_rotate,tv_open,tv_close;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        fab1=(FloatingActionButton)findViewById(R.id.fab1);
        fab2=(FloatingActionButton)findViewById(R.id.fab2);
        fab3=(FloatingActionButton)findViewById(R.id.fab3);
        fab4=(FloatingActionButton)findViewById(R.id.fab4);
        Tv2=(TextView)findViewById(R.id.TextView2);
        Tv3=(TextView)findViewById(R.id.TextView3);
        Tv4=(TextView)findViewById(R.id.TextView4);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        forward_rotate=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.f_rotate);
        backward_rotate=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.b_rotate);
        tv_open=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tv_open);
        tv_close=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tv_close);


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(relativeLayout.getVisibility()==View.VISIBLE){
                    relativeLayout.setVisibility(View.GONE);
                }
                else {
                    relativeLayout.setVisibility(View.VISIBLE);
                }*/
                int id = v.getId();
                switch (id){
                    case R.id.fab1:
                        animateFAB();
                        break;
                    case R.id.fab2:
                        Toast.makeText(MainActivity.this, "like", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fab3:
                        Toast.makeText(MainActivity.this,"Navigate",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fab4:
                        Toast.makeText(MainActivity.this, "My Loaction", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }



    public void animateFAB(){

        if(isFabOpen){
            fab1.startAnimation(backward_rotate);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab4.startAnimation(fab_close);
            Tv2.startAnimation(tv_close);
            Tv3.startAnimation(tv_close);
            Tv4.startAnimation(tv_close);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            /*Tv2.setVisibility(View.INVISIBLE);
            Tv3.setVisibility(View.INVISIBLE);
            Tv4.setVisibility(View.INVISIBLE);*/
            isFabOpen = false;
            Toast.makeText(this, "animation close", Toast.LENGTH_SHORT).show();

        } else {
            fab1.startAnimation(forward_rotate);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab4.startAnimation(fab_open);
            Tv2.startAnimation(tv_open);
            Tv3.startAnimation(tv_open);
            Tv4.startAnimation(tv_open);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            /*Tv2.setVisibility(View.VISIBLE);
            Tv3.setVisibility(View.VISIBLE);
            Tv4.setVisibility(View.VISIBLE);*/
            isFabOpen = true;
            Toast.makeText(this, "animation open", Toast.LENGTH_SHORT).show();

        }
    }


}
