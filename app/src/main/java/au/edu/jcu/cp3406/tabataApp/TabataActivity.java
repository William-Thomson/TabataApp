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
    protected void onCreate(Bundle savedInstanceState) {
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
        if (savedInstanceState == null) {
            tabata = new Tabata(roundsToWork, workTime, restTime);
        }
    }

    public void backClicked(View view) {
        finish();
    }

    public void buttonClicked(View view) {
        if (!isRunning) {
            toggle.setText("stop");
            enableTimer();
        } else {
            toggle.setText("start");
            disableTimer();
        }
    }

    private void enableTimer() {
        isRunning = true;
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    if (tabata.round < tabata.roundToWork) {
                        tabata.tick();
                        timer.setText(tabata.toString());
                        checkStatus();
                        handler.postDelayed(this, 1000);
                    }

                }
            }
        });
    }

    private void disableTimer() {
        isRunning = false;
    }

    private void checkStatus() {
        if (tabata.tickR == 1) {
            display.setText("REST");
        } else if (tabata.tickW == 1) {
            display.setText("WORK");
        }
        round.setText(String.valueOf(tabata.round + 1));
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("roundsToWork", tabata.getRoundsToWork());
        outState.putInt("workTime", tabata.getWorkTime());
        outState.putInt("restTime", tabata.getRestTime());
        outState.putInt("time", tabata.getTime());
        outState.putInt("tickW", tabata.getTickW());
        outState.putInt("tickR", tabata.getTickR());

        outState.putBoolean("running", isRunning);


    }


}