package ilightning.readjsonwithretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ilightning.readjsonwithretrofit.services.LoadFlower;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadFlower loadFlower = new LoadFlower(this);
        loadFlower.execute();
        Log.d("HoangTV", "onCreate()");
        Log.d("HoangTV", "onCreate()");
        Log.d("HoangTV", "onCreate()");
        Log.d("HoangTV", "onCreate()");
        Log.d("HoangTV", "Test Commit change MainActivity");
    }
}

