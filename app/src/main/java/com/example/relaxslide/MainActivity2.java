package com.example.relaxslide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import android.media.MediaPlayer;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer mPlayer;

    String [] good_words={"радость","счастье","хорошо","прекрасно"};
    String [] bad_words={"печаль","больно","плохо"};

//    private final int[] mDrawablesArray = {R.drawable.neutral, R.drawable.happiness, R.drawable.anger,};
    private final int[] mDrawablesArray_good = {R.drawable.sun, R.drawable.happiness, R.drawable.sea};
    private final int[] mDrawablesArray_bad = {R.drawable.light_d, R.drawable.fall_d, R.drawable.water_d};
    private final int[] mDrawablesArray_neutral = {R.drawable.stars_a, R.drawable.galaxy_a, R.drawable.planet_a};

    ViewFlipper mViewFlipper;

    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle arguments = getIntent().getExtras();
        String myNote = arguments.get("myNote").toString();
        tv2=(TextView)findViewById(R.id.textView3);
        tv2.setText(myNote);

        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        boolean is_good=false,is_bad=false;
        for(String s1 : good_words) { if(myNote.indexOf(s1)<0){} else{ is_good=true;}}
        for(String s2 : bad_words ) { if(myNote.indexOf(s2)<0){} else{ is_bad =true;}}
        //если хорошо
        if(is_good && (!is_bad) ) {
            for (int j1 : mDrawablesArray_good) setFlipperImage(j1);
            mPlayer = MediaPlayer.create(this, R.raw.happiness);
        }
        else
        //если плохо
        if(!is_good && (is_bad) ) {
            for (int j2 : mDrawablesArray_bad) setFlipperImage(j2);
            mPlayer = MediaPlayer.create(this, R.raw.bad);
        }
        else
        //если нейтральное
        {
            for (int j3 : mDrawablesArray_neutral) setFlipperImage(j3);
            mPlayer = MediaPlayer.create(this, R.raw.neutral);
        }

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //     stopPlay();
            }
        });
        mPlayer.start();

        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(1500);
    }

    private void setFlipperImage(int resId) {
        ImageView image = new ImageView(getApplicationContext());
        image.setBackgroundResource(resId);
        mViewFlipper.addView(image);
    }

    public void stop(View view) {
        mPlayer.stop();
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }


/*    public class Array {
        public class Arrays {
            final int[] images = {
                    R.drawable.dolphin,
                    R.drawable.sea,
                    R.drawable.sun,

                    R.drawable.galaxy_a,
                    R.drawable.planet_a,
                    R.drawable.stars_a,

                    R.drawable.fall_d,
                    R.drawable.light_d,
                    R.drawable.water_d,
            };
        }

        final int[] texts = {
                R.string.счастье,
                R.string.злость,
                R.string.депрессия,
        };
    }*/

/*
    private final int[] mDrawablesArray2 = {R.drawable.dolphin, R.drawable.sea, R.drawable.sun,
    };
    ViewFlipper mViewFlipper2;
*/


/*    public class MainActivity3 extends AppCompatActivity implements MainActivity_2 {
        MediaPlayer mPlayer;

        protected void onCreate1(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);


            mPlayer = MediaPlayer.create(this, R.raw.happiness);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    //     stopPlay();
                }
            });
            mPlayer.start();


            mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

            for (int i = 0; i < mDrawablesArray.length; i++) {
                setFlipperImage(mDrawablesArray[i]);
            }

            mViewFlipper.setAutoStart(true);
            mViewFlipper.setFlipInterval(1500);
        }

        private void setFlipperImage2(int resId) {
            ImageView image = new ImageView(getApplicationContext());
            image.setBackgroundResource(resId);
            mViewFlipper.addView(image);
        }

        public void stop2(View view) {
            mPlayer.stop();
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public class MainActivity_second extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            TextView textView = new TextView(this);
            textView.setTextSize(26);
            textView.setPadding(16, 16, 16, 16);

            Bundle arguments = getIntent().getExtras();

            if(arguments!=null){
                String name = arguments.get("name").toString();
                String company = arguments.getString("company");
                int age = arguments.getInt("age");
                textView.setText("Name: " + name + "\nCompany: " + company +
                        "\nAge: " + age);
            }

            setContentView(textView);
        }
    }*/
}
