package com.cosmicjourney;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    
    private TextView distanceTextView;
    private Button shareButton;
    private Handler handler = new Handler();
    private long secondsAlive = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        distanceTextView = findViewById(R.id.distanceTextView);
        shareButton = findViewById(R.id.shareButton);
        
        // Set birthday to January 1, 1990 (example)
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.JANUARY, 1);
        Date birthDate = cal.getTime();
        
        // Calculate initial distance
        updateDistance(birthDate);
        
        // Update every second
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateDistance(birthDate);
                handler.postDelayed(this, 1000);
            }
        }, 1000);
        
        shareButton.setOnClickListener(v -> {
            // Share functionality
            String shareText = "I've traveled " + distanceTextView.getText() + " through space!";
            // TODO: Implement sharing
        });
    }
    
    private void updateDistance(Date birthDate) {
        long currentTime = System.currentTimeMillis();
        long birthTime = birthDate.getTime();
        secondsAlive = (currentTime - birthTime) / 1000;
        
        double totalMiles = CosmicCalculator.calculateTotalDistance(secondsAlive);
        
        // Format with commas
        NumberFormat formatter = NumberFormat.getInstance();
        String formatted = formatter.format((long) totalMiles);
        
        distanceTextView.setText(formatted + " miles");
    }
    
    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
