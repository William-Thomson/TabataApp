package au.edu.jcu.cp3406.tabataApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class TabataSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabata_settings);
    }

    public void backClicked(View view) {
        finish();
    }

    public void doneClicked(View view) {
    }
}