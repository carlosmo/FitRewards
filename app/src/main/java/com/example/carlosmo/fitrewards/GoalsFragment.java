package com.example.carlosmo.fitrewards;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.carlosmo.fitrewards.Logger.Log;
import com.example.carlosmo.fitrewards.Logger.LogView;
import com.example.carlosmo.fitrewards.Logger.LogWrapper;
import com.example.carlosmo.fitrewards.Logger.MessageOnlyLogFilter;

import java.util.ArrayList;
import java.util.List;

public class GoalsFragment extends Fragment {
    public static final String TAG = "GoalsBasicSensorsApi";

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.goals_fragment, container, false);

        // This method sets up our custom logger, which will print all log messages to the device
        // screen, as well as to adb logcat.
        //initializeLogging();

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                EditText input = new EditText(getContext());

                builder.setTitle("Goal");
                builder.setMessage("Please enter your goal");

                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();
            }
        });

        CircularSeekBar seekbar = (CircularSeekBar) rootView.findViewById(R.id.circularSeekBar1);
        seekbar.getProgress();
        seekbar.setProgress(50);


        return rootView;
    }

    /**
     *  Initialize a custom log class that outputs both to in-app targets and logcat.
     */
    /*
    private void initializeLogging() {
        // Wraps Android's native log framework.
        LogWrapper logWrapper = new LogWrapper();
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        Log.setLogNode(logWrapper);
        // Filter strips out everything except the message text.
        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
        logWrapper.setNext(msgFilter);
        // On screen logging via a customized TextView.
        LogView logView = (LogView) rootView.findViewById(R.id.sample_logview);

        // Fixing this lint errors adds logic without benefit.
        //noinspection AndroidLintDeprecation
        if (Build.VERSION.SDK_INT < 23) {
            logView.setTextAppearance(getContext(),R.style.Log);
        } else {
            logView.setTextAppearance(R.style.Log);
        }

        logView.setBackgroundColor(Color.WHITE);
        msgFilter.setNext(logView);
        Log.i(TAG, "Ready");
    }
    */
}
