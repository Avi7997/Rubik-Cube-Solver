package com.io.sefu.rsolverfinalui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Answer extends AppCompatActivity {

    private int ImageID[] = new int[50];
    private ViewFlipper viewFlipper;

    //   10 sec delay...
    private static final int FLIP_DURATION = 10000;

    //   TAG for Logs
    private String TAG = "Answer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        viewFlipper = findViewById(R.id.flipper);

        Intent getSteps = getIntent();
        String getStringAnswer = getSteps.getStringExtra("AnswerStr");

        String[] elements = getStringAnswer.split(" ");

        for (String str: elements) {
            Log.d(TAG, str + "\n");
        }

        //  U' F' U' L' U' F2 D  B' D2 F' D2 F  L2 F' D2 B' U2 B  R2 U
        for (int i=0;i<elements.length;i++){
            switch (elements[i]){
                case "B":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"b1", null,
                            getPackageName());
                    break;
                case "B2":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"b2", null,
                            getPackageName());
                    break;
                case "B'":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"b3", null,
                            getPackageName());
                    break;


                case "D":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"d1", null,
                            getPackageName());

                    break;
                case "D2":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"d2", null,
                            getPackageName());
                    break;
                case "D'":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"d3", null,
                            getPackageName());

                    break;


                case "F":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"f1", null,
                            getPackageName());

                    break;
                case "F2":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"f2", null,
                            getPackageName());
                    break;
                case "F'":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"f3", null,
                            getPackageName());
                    break;


                case "L":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"l1", null, getPackageName());
                    break;
                case "L2":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"l2", null,
                            getPackageName());
                    break;
                case "L'":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"l3", null, getPackageName());
                    break;


                case "R":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"r1", null, getPackageName());
                    break;
                case "R2":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"r2", null,
                            getPackageName());
                    break;
                case "R'":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"r3", null, getPackageName());
                    break;


                case "U":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"u1", null, getPackageName());
                    break;
                case "U2":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"u2", null,
                            getPackageName());
                    break;
                case "U'":
                    ImageID[i] = getResources().getIdentifier("drawable/"+"u3", null,
                            getPackageName());
                    break;
            }
        }

        for (int imageID : ImageID) {
            //  This will create dynamic image view and add them to ViewFlipper
            setFlipperImage(imageID);
        }
    }

    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res+"");
        ImageView image = new ImageView(getApplicationContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        startSlideshow();
    }

    private void startSlideshow(){
        if(!viewFlipper.isFlipping()){
            viewFlipper.setAutoStart(true);
            viewFlipper.setFlipInterval(FLIP_DURATION);
            viewFlipper.startFlipping();
        }
    }

}
