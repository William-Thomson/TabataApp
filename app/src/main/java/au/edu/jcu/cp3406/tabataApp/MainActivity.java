package au.edu.jcu.cp3406.tabataApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void TabataClicked(View view) {
        Intent intent = new Intent(this, TabataSettings.class);
        startActivity(intent);


    }
}