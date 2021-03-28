package au.edu.jcu.cp3406.tabataApp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class TabataActivity extends AppCompatActivity {
    private boolean isRunning;
    private Tabata tabata;
    private Handler handler;
    private TextView timer, display, round;
    private Button toggle;
    public int roundsToWork, workTime, restTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //The constructor
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabata_display);

        display = findViewById(R.id.display);
        round = findViewById(R.id.round);
        toggle = findViewById(R.id.toggle);
        timer = findViewById(R.id.timer);
        Intent intent = getIntent();
        roundsToWork = intent.getIntExtra("roundsToWork", 8);
        workTime = intent.getIntExtra("workTime", 20);
        restTime = intent.getIntExtra("restTime", 10);


        isRunning = false;
        if (savedInstanceState == null) { // creates a new Tabata if it is a new state.
            tabata = new Tabata(roundsToWork, workTime, restTime);
        } else { // gets values from the previous saved Instance and creates a Tabata using the values.
            int roundsToWork = savedInstanceState.getInt("roundsToWork");
            int workTime = savedInstanceState.getInt("workTime");
            int restTime = savedInstanceState.getInt("restTime");
            int time = savedInstanceState.getInt("time");
            int tickW = savedInstanceState.getInt("tickW");
            int tickR = savedInstanceState.getInt("tickR");
            int round = savedInstanceState.getInt("round");
            String display = savedInstanceState.getString("display");

            tabata = new Tabata(roundsToWork, workTime, restTime, time, tickW, tickR, round);
            timer.setText(tabata.toString());
            this.round.setText(String.valueOf(tabata.round + 1));
            this.display.setText(display);

            boolean running = savedInstanceState.getBoolean("running");
            if (running) {
                enableTimer();
                toggle.setText("stop");
            }
        }
    }

    public void backClicked(View view) { // Returns to the home page
        finish();
    }

    public void buttonClicked(View view) { // toggles the timer to start and stop.
        if (!isRunning) {
            toggle.setText("stop");
            enableTimer();
        } else {
            toggle.setText("start");
            disableTimer();
        }
    }

    private void enableTimer() { //starts the timer and sets the display.
        isRunning = true;
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    if (tabata.round < tabata.roundsToWork) {
                        tabata.tick();
                        timer.setText(tabata.toString());
                        checkStatus();
                        handler.postDelayed(this, 1000);
                    }

                }
            }
        });
    }

    private void disableTimer() { //stops the timer.
        isRunning = false;
    }

    private void checkStatus() { //checks and changes the status between rest and work.
        if (tabata.tickR == 1) {
            display.setText("REST");
        } else if (tabata.tickW == 1) {
            display.setText("WORK");
            round.setText(String.valueOf(tabata.round + 1));
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { //saves the values when state is changed.
        super.onSaveInstanceState(outState);
        outState.putInt("roundsToWork", tabata.getRoundsToWork());
        outState.putInt("workTime", tabata.getWorkTime());
        outState.putInt("restTime", tabata.getRestTime());
        outState.putInt("time", tabata.getTime());
        outState.putInt("tickW", tabata.getTickW());
        outState.putInt("tickR", tabata.getTickR());
        outState.putInt("round", tabata.getRound());
        outState.putBoolean("running", isRunning);
        outState.putString("display", display.getText().toString());


    }


}