package com.io.sefu.rsolverfinalui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.layer_net.stepindicator.StepIndicator;

import java.util.HashMap;

//import static com.io.sefu.rsolverfinalui.Util.R;

public class MainActivity extends AppCompatActivity {

    // rubix cube side declared here
    LinearLayout cubeOneLinearLayout, cubeTwoLinearLayout, cubeThreeLinearLayout, cubeFourLinearLayout, cubeFiveLinearLayout, cubeSixLinearLayout;

    HashMap<Integer,String> map = new HashMap<>(54);

    Processing processing;

    //step indicator declared here
    StepIndicator stepIndicator;

    //buttons declared here
    Button currentButton, nextButton;
    //cube counter

    int counter = 0;
    String stringColor = "#d9d9d9";

    //Button colors
    Button rubicButtonBlue, rubicButtonWhite, rubicButtonYellow, rubicButtonGreen,
            rubicButtonOrange, rubicButtonRed;
    //cube one
    LinearLayout oneCubeOne, twoCubeOne, threeCubeOne, fourCubeOne, fiveCubeOne, sixCubeOne, sevenCubeOne, eightCubeOne, nineCubeOne;

    //cube two
    LinearLayout oneCubeTwo, twoCubeTwo, threeCubeTwo, fourCubeTwo, fiveCubeTwo, sixCubeTwo, sevenCubeTwo, eightCubeTwo, nineCubeTwo;

    //cube three
    LinearLayout oneCubeThree, twoCubeThree, threeCubeThree, fourCubeThree, fiveCubeThree, sixCubeThree, sevenCubeThree, eightCubeThree, nineCubeThree;

    //cube four
    LinearLayout oneCubeFour, twoCubeFour, threeCubeFour, fourCubeFour, fiveCubeFour, sixCubeFour, sevenCubeFour, eightCubeFour, nineCubeFour;

    //cube five
    LinearLayout oneCubeFive, twoCubeFive, threeCubeFive, fourCubeFive, fiveCubeFive, sixCubeFive, sevenCubeFive, eightCubeFive, nineCubeFive;
    //cube six
    LinearLayout oneCubeSix, twoCubeSix, threeCubeSix, fourCubeSix, fiveCubeSix, sixCubeSix, sevenCubeSix, eightCubeSix, nineCubeSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* #FFFFFF -> 3
        * #0000FF -> 2
        * #FFFF00 - > 6
        * #008000 - > 5
        * #FFA500 - > 1
        * #FF0000 - > 4
         */

        map.put(4,"#FFA500");
        map.put(13,"#0000FF");
        map.put(22,"#FFFFFF");
        map.put(31,"#FF0000");
        map.put(40,"#008000");
        map.put(49,"#FFFF00");

        //slide in transformation declared here
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        setContentView(R.layout.activity_main);

        //set the application orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //step indicator  init here
        stepIndicator = (StepIndicator) findViewById(R.id.step_indicator);
        stepIndicator.setStepsCount(6);
        //Enable | Disable click on step number
        stepIndicator.setClickable(false);

        //next and current button widget are declared here
        currentButton = (Button) findViewById(R.id.current);
        nextButton = (Button) findViewById(R.id.next);

        //rubix cube initialized here
        cubeOneLinearLayout = (LinearLayout) findViewById(R.id.cubeOne);
        cubeTwoLinearLayout = (LinearLayout) findViewById(R.id.cubeTwo);
        cubeThreeLinearLayout = (LinearLayout) findViewById(R.id.cubeThree);
        cubeFourLinearLayout = (LinearLayout) findViewById(R.id.cubeFour);
        cubeFiveLinearLayout = (LinearLayout) findViewById(R.id.cubeFive);
        cubeSixLinearLayout = (LinearLayout) findViewById(R.id.cubeSix);


        //---set button color here----//
        rubicButtonBlue = (Button) findViewById(R.id.blueButton);
        rubicButtonWhite = (Button) findViewById(R.id.whiteButton);
        rubicButtonYellow = (Button) findViewById(R.id.yellowButton);
        rubicButtonGreen = (Button) findViewById(R.id.greenButton);
        rubicButtonOrange = (Button) findViewById(R.id.orangeButton);
        rubicButtonRed = (Button) findViewById(R.id.redButton);

        //init cube one cubes
        oneCubeOne = (LinearLayout) findViewById(R.id.oneCubeOne);
        twoCubeOne = (LinearLayout) findViewById(R.id.twoCubeOne);
        threeCubeOne = (LinearLayout) findViewById(R.id.threeCubeOne);
        fourCubeOne = (LinearLayout) findViewById(R.id.fourCubeOne);
        fiveCubeOne = (LinearLayout) findViewById(R.id.fiveCubeOne);
        sixCubeOne = (LinearLayout) findViewById(R.id.sixCubeOne);
        sevenCubeOne = (LinearLayout) findViewById(R.id.sevenCubeOne);
        eightCubeOne = (LinearLayout) findViewById(R.id.eightCubeOne);
        nineCubeOne = (LinearLayout) findViewById(R.id.nineCubeOne);

        oneCubeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneCubeOne.setBackgroundColor(Color.parseColor(stringColor));
                map.put(18,stringColor);
            }
        });
        twoCubeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoCubeOne.setBackgroundColor(Color.parseColor(stringColor));
                map.put(19,stringColor);
            }
        });
        threeCubeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeCubeOne.setBackgroundColor(Color.parseColor(stringColor));
                map.put(20,stringColor);
            }
        });
        fourCubeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourCubeOne.setBackgroundColor(Color.parseColor(stringColor));
                map.put(21,stringColor);
            }
        });

        sixCubeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixCubeOne.setBackgroundColor(Color.parseColor(stringColor));
                map.put(23,stringColor);
            }
        });
        sevenCubeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sevenCubeOne.setBackgroundColor(Color.parseColor(stringColor));
                map.put(24,stringColor);
            }
        });
        eightCubeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eightCubeOne.setBackgroundColor(Color.parseColor(stringColor));
                map.put(25,stringColor);
            }
        });

        nineCubeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nineCubeOne.setBackgroundColor(Color.parseColor(stringColor));
                map.put(26,stringColor);
            }
        });


        //init cube two cubes
        oneCubeTwo = (LinearLayout) findViewById(R.id.oneCubeTwo);
        twoCubeTwo = (LinearLayout) findViewById(R.id.twoCubeTwo);
        threeCubeTwo = (LinearLayout) findViewById(R.id.threeCubeTwo);
        fourCubeTwo = (LinearLayout) findViewById(R.id.fourCubeTwo);
        fiveCubeTwo = (LinearLayout) findViewById(R.id.fiveCubeTwo);
        sixCubeTwo = (LinearLayout) findViewById(R.id.sixCubeTwo);
        sevenCubeTwo = (LinearLayout) findViewById(R.id.sevenCubeTwo);
        eightCubeTwo = (LinearLayout) findViewById(R.id.eightCubeTwo);
        nineCubeTwo = (LinearLayout) findViewById(R.id.nineCubeTwo);

        oneCubeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneCubeTwo.setBackgroundColor(Color.parseColor(stringColor));
                map.put(9,stringColor);

            }
        });
        twoCubeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoCubeTwo.setBackgroundColor(Color.parseColor(stringColor));
                map.put(10,stringColor);
            }
        });
        threeCubeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeCubeTwo.setBackgroundColor(Color.parseColor(stringColor));
                map.put(11,stringColor);
            }
        });
        fourCubeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourCubeTwo.setBackgroundColor(Color.parseColor(stringColor));
                map.put(12,stringColor);
            }
        });

        sixCubeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixCubeTwo.setBackgroundColor(Color.parseColor(stringColor));
                map.put(14,stringColor);
            }
        });
        sevenCubeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sevenCubeTwo.setBackgroundColor(Color.parseColor(stringColor));
                map.put(15,stringColor);
            }
        });
        eightCubeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eightCubeTwo.setBackgroundColor(Color.parseColor(stringColor));
                map.put(16,stringColor);
            }
        });

        nineCubeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nineCubeTwo.setBackgroundColor(Color.parseColor(stringColor));
                map.put(17,stringColor);
            }
        });


        //init cube three cubes
        oneCubeThree = (LinearLayout) findViewById(R.id.oneCubeThree);
        twoCubeThree = (LinearLayout) findViewById(R.id.twoCubeThree);
        threeCubeThree = (LinearLayout) findViewById(R.id.threeCubeThree);
        fourCubeThree = (LinearLayout) findViewById(R.id.fourCubeThree);
        fiveCubeThree = (LinearLayout) findViewById(R.id.fiveCubeThree);
        sixCubeThree = (LinearLayout) findViewById(R.id.sixCubeThree);
        sevenCubeThree = (LinearLayout) findViewById(R.id.sevenCubeThree);
        eightCubeThree = (LinearLayout) findViewById(R.id.eightCubeThree);
        nineCubeThree = (LinearLayout) findViewById(R.id.nineCubeThree);

        oneCubeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneCubeThree.setBackgroundColor(Color.parseColor(stringColor));
                map.put(45,stringColor);
            }
        });
        twoCubeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoCubeThree.setBackgroundColor(Color.parseColor(stringColor));
                map.put(46,stringColor);
            }
        });
        threeCubeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeCubeThree.setBackgroundColor(Color.parseColor(stringColor));
                map.put(47,stringColor);
            }
        });
        fourCubeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourCubeThree.setBackgroundColor(Color.parseColor(stringColor));
                map.put(48,stringColor);
            }
        });

        sixCubeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixCubeThree.setBackgroundColor(Color.parseColor(stringColor));
                map.put(50,stringColor);
            }
        });
        sevenCubeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sevenCubeThree.setBackgroundColor(Color.parseColor(stringColor));
                map.put(51,stringColor);
            }
        });
        eightCubeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eightCubeThree.setBackgroundColor(Color.parseColor(stringColor));
                map.put(52,stringColor);
            }
        });

        nineCubeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nineCubeThree.setBackgroundColor(Color.parseColor(stringColor));
                map.put(53,stringColor);
            }
        });


        //init cube four cubes
        oneCubeFour = (LinearLayout) findViewById(R.id.oneCubeFour);
        twoCubeFour = (LinearLayout) findViewById(R.id.twoCubeFour);
        threeCubeFour = (LinearLayout) findViewById(R.id.threeCubeFour);
        fourCubeFour = (LinearLayout) findViewById(R.id.fourCubeFour);
        fiveCubeFour = (LinearLayout) findViewById(R.id.fiveCubeFour);
        sixCubeFour = (LinearLayout) findViewById(R.id.sixCubeFour);
        sevenCubeFour = (LinearLayout) findViewById(R.id.sevenCubeFour);
        eightCubeFour = (LinearLayout) findViewById(R.id.eightCubeFour);
        nineCubeFour = (LinearLayout) findViewById(R.id.nineCubeFour);

        oneCubeFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneCubeFour.setBackgroundColor(Color.parseColor(stringColor));
                map.put(36,stringColor);
            }
        });
        twoCubeFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoCubeFour.setBackgroundColor(Color.parseColor(stringColor));
                map.put(37,stringColor);
            }
        });
        threeCubeFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeCubeFour.setBackgroundColor(Color.parseColor(stringColor));
                map.put(38,stringColor);
            }
        });
        fourCubeFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourCubeFour.setBackgroundColor(Color.parseColor(stringColor));
                map.put(39,stringColor);
            }
        });

        sixCubeFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixCubeFour.setBackgroundColor(Color.parseColor(stringColor));
                map.put(41,stringColor);
            }
        });
        sevenCubeFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sevenCubeFour.setBackgroundColor(Color.parseColor(stringColor));
                map.put(42,stringColor);
            }
        });
        eightCubeFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eightCubeFour.setBackgroundColor(Color.parseColor(stringColor));
                map.put(43,stringColor);
            }
        });

        nineCubeFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nineCubeFour.setBackgroundColor(Color.parseColor(stringColor));
                map.put(44,stringColor);
            }
        });


        //init cube five cubes
        oneCubeFive = (LinearLayout) findViewById(R.id.oneCubeFive);
        twoCubeFive = (LinearLayout) findViewById(R.id.twoCubeFive);
        threeCubeFive = (LinearLayout) findViewById(R.id.threeCubeFive);
        fourCubeFive = (LinearLayout) findViewById(R.id.fourCubeFive);
        fiveCubeFive = (LinearLayout) findViewById(R.id.fiveCubeFive);
        sixCubeFive = (LinearLayout) findViewById(R.id.sixCubeFive);
        sevenCubeFive = (LinearLayout) findViewById(R.id.sevenCubeFive);
        eightCubeFive = (LinearLayout) findViewById(R.id.eightCubeFive);
        nineCubeFive = (LinearLayout) findViewById(R.id.nineCubeFive);


        oneCubeFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneCubeFive.setBackgroundColor(Color.parseColor(stringColor));
                map.put(2,stringColor);
            }
        });
        twoCubeFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoCubeFive.setBackgroundColor(Color.parseColor(stringColor));
                map.put(5,stringColor);
            }
        });
        threeCubeFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeCubeFive.setBackgroundColor(Color.parseColor(stringColor));
                map.put(8,stringColor);
            }
        });
        fourCubeFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourCubeFive.setBackgroundColor(Color.parseColor(stringColor));
                map.put(1,stringColor);
            }
        });

        sixCubeFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixCubeFive.setBackgroundColor(Color.parseColor(stringColor));
                map.put(7,stringColor);
            }
        });
        sevenCubeFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sevenCubeFive.setBackgroundColor(Color.parseColor(stringColor));
                map.put(0,stringColor);
            }
        });
        eightCubeFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eightCubeFive.setBackgroundColor(Color.parseColor(stringColor));
                map.put(3,stringColor);
            }
        });

        nineCubeFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nineCubeFive.setBackgroundColor(Color.parseColor(stringColor));
                map.put(6,stringColor);
            }
        });


        //init cube six cubes
        oneCubeSix = (LinearLayout) findViewById(R.id.oneCubeSix);
        twoCubeSix = (LinearLayout) findViewById(R.id.twoCubeSix);
        threeCubeSix = (LinearLayout) findViewById(R.id.threeCubeSix);
        fourCubeSix = (LinearLayout) findViewById(R.id.fourCubeSix);
        fiveCubeSix = (LinearLayout) findViewById(R.id.fiveCubeSix);
        sixCubeSix = (LinearLayout) findViewById(R.id.sixCubeSix);
        sevenCubeSix = (LinearLayout) findViewById(R.id.sevenCubeSix);
        eightCubeSix = (LinearLayout) findViewById(R.id.eightCubeSix);
        nineCubeSix = (LinearLayout) findViewById(R.id.nineCubeSix);

        oneCubeSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneCubeSix.setBackgroundColor(Color.parseColor(stringColor));
                map.put(33,stringColor);
            }
        });
        twoCubeSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoCubeSix.setBackgroundColor(Color.parseColor(stringColor));
                map.put(30,stringColor);
            }
        });
        threeCubeSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeCubeSix.setBackgroundColor(Color.parseColor(stringColor));
                map.put(27,stringColor);
            }
        });
        fourCubeSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourCubeSix.setBackgroundColor(Color.parseColor(stringColor));
                map.put(34,stringColor);
            }
        });

        sixCubeSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixCubeSix.setBackgroundColor(Color.parseColor(stringColor));
                map.put(28,stringColor);
            }
        });
        sevenCubeSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sevenCubeSix.setBackgroundColor(Color.parseColor(stringColor));
                map.put(35,stringColor);
            }
        });
        eightCubeSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eightCubeSix.setBackgroundColor(Color.parseColor(stringColor));
                map.put(32,stringColor);
            }
        });

        nineCubeSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nineCubeSix.setBackgroundColor(Color.parseColor(stringColor));
                map.put(29,stringColor);
            }
        });


        rubicButtonBlue.setBackgroundResource(R.color.rubicBlue);
        rubicButtonWhite.setBackgroundResource(R.color.rubicWhite);
        rubicButtonYellow.setBackgroundResource(R.color.rubicYellow);
        rubicButtonGreen.setBackgroundResource(R.color.rubicGreen);
        rubicButtonOrange.setBackgroundResource(R.color.rubicOrange);
        rubicButtonRed.setBackgroundResource(R.color.rubicRed);

        rubicButtonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefStoreBlue = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefStoreBlue.edit();
                editor.remove(stringColor);
                editor.putString("color", rubicButtonBlue.getText().toString());
                editor.commit();

                SharedPreferences sharedPrefRetrieveBlue = getPreferences(Context.MODE_PRIVATE);
                stringColor = sharedPrefRetrieveBlue.getString("color", "default");
            }
        });

        rubicButtonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefStoreWhite = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefStoreWhite.edit();
                editor.remove(stringColor);
                editor.putString("color", rubicButtonWhite.getText().toString());
                editor.commit();

                SharedPreferences sharedPrefRetrieveWhite = getPreferences(Context.MODE_PRIVATE);
                stringColor = sharedPrefRetrieveWhite.getString("color", "default");
            }
        });

        rubicButtonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefStoreYellow = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefStoreYellow.edit();
                editor.remove(stringColor);
                editor.putString("color", rubicButtonYellow.getText().toString());
                editor.commit();

                SharedPreferences sharedPrefRetrieveYellow = getPreferences(Context.MODE_PRIVATE);
                stringColor = sharedPrefRetrieveYellow.getString("color", "default");
            }
        });

        rubicButtonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefStoreGreen = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefStoreGreen.edit();
                editor.remove(stringColor);
                editor.putString("color", rubicButtonGreen.getText().toString());
                editor.commit();

                SharedPreferences sharedPrefRetrieveGreen = getPreferences(Context.MODE_PRIVATE);
                stringColor = sharedPrefRetrieveGreen.getString("color", "default");
            }
        });

        rubicButtonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefStoreOrange = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefStoreOrange.edit();
                editor.remove(stringColor);
                editor.putString("color", rubicButtonOrange.getText().toString());
                editor.commit();

                SharedPreferences sharedPrefRetrieveOrange = getPreferences(Context.MODE_PRIVATE);
                stringColor = sharedPrefRetrieveOrange.getString("color", "default");
            }
        });

        rubicButtonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefStoreRed = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefStoreRed.edit();
                editor.remove(stringColor);
                editor.putString("color", rubicButtonRed.getText().toString());
                editor.commit();

                SharedPreferences sharedPrefRetrieveRed = getPreferences(Context.MODE_PRIVATE);
                stringColor = sharedPrefRetrieveRed.getString("color", "default");
            }
        });

        //---set button color here----//
        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == 0) {
                    currentButton.setVisibility(View.INVISIBLE);
                }

                counter--;

                if (counter == 0) {
                    cubeOneLinearLayout.setVisibility(View.VISIBLE);
                    cubeTwoLinearLayout.setVisibility(View.GONE);
                } else if (counter == 1) {
                    cubeTwoLinearLayout.setVisibility(View.VISIBLE);
                    cubeThreeLinearLayout.setVisibility(View.GONE);
                } else if (counter == 2) {
                    cubeThreeLinearLayout.setVisibility(View.VISIBLE);
                    cubeFourLinearLayout.setVisibility(View.GONE);
                } else if (counter == 3) {
                    cubeFourLinearLayout.setVisibility(View.VISIBLE);
                    cubeFiveLinearLayout.setVisibility(View.GONE);
                } else if (counter == 4) {
                    cubeFiveLinearLayout.setVisibility(View.VISIBLE);
                    cubeSixLinearLayout.setVisibility(View.GONE);
                } else if (counter == 5) {
                    nextButton.setText("NEXT");
                }
                stepIndicator.setCurrentStepPosition(counter);
            }
        });


        //next button transition of cubes are with onclick is here

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == 0) {
                    currentButton.setVisibility(View.VISIBLE);
                } else if (counter == 6) {
                    processing = new Processing(view.getContext(),map);
                    if(processing.ValidString()){
                        String str = processing.getString();
                        new BackgroundTask(view.getContext()).execute(str);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Filled in Colors are not valid...", Toast.LENGTH_SHORT).show();
                    }

                }

                //  If All colors are filled, then go next, else print message
                //  Basically Does the validation of colors...
                if(((map.size()-6)%8)==0){
                    counter++;
                }
                else{
                    Toast.makeText(MainActivity.this, "missed to fill color...", Toast.LENGTH_SHORT).show();
                }
                if (counter == 1) {
                    cubeOneLinearLayout.setVisibility(View.GONE);
                    cubeTwoLinearLayout.setVisibility(View.VISIBLE);
                } else if (counter == 2) {
                    cubeTwoLinearLayout.setVisibility(View.GONE);
                    cubeThreeLinearLayout.setVisibility(View.VISIBLE);
                } else if (counter == 3) {
                    cubeThreeLinearLayout.setVisibility(View.GONE);
                    cubeFourLinearLayout.setVisibility(View.VISIBLE);
                } else if (counter == 4) {
                    cubeFourLinearLayout.setVisibility(View.GONE);
                    cubeFiveLinearLayout.setVisibility(View.VISIBLE);
                } else if (counter == 5) {
                    cubeFiveLinearLayout.setVisibility(View.GONE);
                    cubeSixLinearLayout.setVisibility(View.VISIBLE);
                } else if (counter == 6) {
                    nextButton.setText("SOLUTION");
                }
                stepIndicator.setCurrentStepPosition(counter);

            }
        });
    }
}

class BackgroundTask extends AsyncTask<String, Void, String> {

    Context context;

    BackgroundTask(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String result = new Search().solution(strings[0], 21, 100000000, 0, 0);
        System.out.println(result);// R2 U2 B2 L2 F2 U' L2 R2 B2 R2 D  B2 F  L' F  U2 F' R' D' L2 R'
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Intent intent = new Intent(context,Answer.class);
        intent.putExtra("AnswerStr",s);
        context.startActivity(intent);
    }
}