package au.edu.jcu.cp3406.tabataApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TabataSettings extends AppCompatActivity {
    public EditText rounds, work, rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabata_settings);
        rounds = findViewById(R.id.rounds);
        work = findViewById(R.id.work);
        rest = findViewById(R.id.rest);
    }

    public void backClicked(View view) {
        finish();
    }

    public void doneClicked(View view) {
        String text = rounds.getText().toString();
        String text2 = work.getText().toString();
        String text3 = rest.getText().toString();

        int roundsToWork = Integer.parseInt(text);
        int workTime = Integer.parseInt(text2);
        int restTime = Integer.parseInt(text3);

        Intent data = new Intent(this, TabataActivity.class);
        data.putExtra("roundsToWork", roundsToWork);
        data.putExtra("workTime", workTime);
        data.putExtra("restTime", restTime);
        startActivity(data);
        finish();
    }
}