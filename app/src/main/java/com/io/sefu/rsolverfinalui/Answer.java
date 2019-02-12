package com.io.sefu.rsolverfinalui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class Answer extends AppCompatActivity {

    private int ImageID[] = new int[50];
    private ViewFlipper viewFlipper;
    private  Button button;
    ImageView image;
    private int index = 0;
    private List<Integer> list_images= new ArrayList<>();

    //   10 sec delay...
    private static final int FLIP_DURATION = 10000;

    //   TAG for Logs
    private String TAG = "Answer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        //viewFlipper = findViewById(R.id.flipper);

        Intent getSteps = getIntent();
        String getStringAnswer = getSteps.getStringExtra("AnswerStr");

        String[] elements = getStringAnswer.split(" ");

        for (String str: elements) {
            Log.d(TAG, str + "\n");
        }

        //  U' F' U' L' U' F2 D  B' D2 F' D2 F  L2 F' D2 B' U2 B  R2 U
        for (int i=0;i<elements.length;i++) {
            switch (elements[i]) {
                case "B":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "b1", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
                case "B2":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "b2", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
                case "B'":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "b3", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;


                case "D":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "d1", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);

                    break;
                case "D2":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "d2", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
                case "D'":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "d3", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;


                case "F":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "f1", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
                case "F2":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "f2", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
                case "F'":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "f3", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;


                case "L":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "l1", null, getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
                case "L2":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "l2", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
                case "L'":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "l3", null, getPackageName());
                    //list_images.add(ImageID[i]);
                    break;


                case "R":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "r1", null, getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
                case "R2":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "r2", null,
                            getPackageName());
//                    list_images.add(ImageID[i]);
                    break;
                case "R'":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "r3", null, getPackageName());
//                    list_images.add(ImageID[i]);
                    break;


                case "U":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "u1", null, getPackageName());
//                    list_images.add(ImageID[i]);
                    break;
                case "U2":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "u2", null,
                            getPackageName());
//                    list_images.add(ImageID[i]);
                    break;
                case "U'":
                    ImageID[i] = getResources().getIdentifier("drawable/" + "u3", null,
                            getPackageName());
                    //list_images.add(ImageID[i]);
                    break;
            }
            list_images.add(ImageID[i]);
        }
        setInitialImage();
        setImageRotateListener();
    }

    private void setImageRotateListener() {
        final Button nextButton = (Button) findViewById(R.id.btnNextImage);
        final Button prevButton = (Button) findViewById(R.id.btnPrevImage);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index >= list_images.size()-1)
                    index = -1;
                index++;
                setCurrentImage();
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= 0)
                    index = 1;
                index--;
                setCurrentImage();
            }
        });
    }

    private void setInitialImage() {
        setCurrentImage();
    }

    private void setCurrentImage() {
        final TextView textView = (TextView) findViewById(R.id.steps_number);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setImageResource(list_images.get(index));
        textView.setText("Step = " + (index+1));
    }


    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res+"");

//        ImageView image = new ImageView(getApplicationContext());
//        image.setBackgroundResource(res);
//        viewFlipper.addView(image);
//        startSlideshow();
    }

    private void addListenerOnButton(int res) {
        image = (ImageView) findViewById(R.id.imageView1);
        button = (Button) findViewById(R.id.btnNextImage);
        final int res_f = res;
        Log.d("addListenerOnButton","Here comes");
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                image = new ImageView(getApplicationContext());
                image.setBackgroundResource(res_f);
            }

        });

    }

    private void startSlideshow(){
        if(!viewFlipper.isFlipping()){
            viewFlipper.setAutoStart(true);
            viewFlipper.setFlipInterval(FLIP_DURATION);
            viewFlipper.startFlipping();
        }
    }

}
