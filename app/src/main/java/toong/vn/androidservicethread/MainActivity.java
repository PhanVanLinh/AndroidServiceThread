package toong.vn.androidservicethread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnStartService;
    private Button btnStopService;
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "currentThread " + Thread.currentThread().getId() + " name: " + Thread.currentThread().getName());
        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "" + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                stopService();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void startService() {
        startService(new Intent(this, AService.class));
    }

    private void stopService() {
        stopService(new Intent(this, AService.class));
    }
}
