package com.num.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.num.Constants;
import com.num.R;
import com.num.controller.managers.MeasurementManager;
import com.num.controller.managers.TracerouteManager;
import com.num.controller.utils.ServerUtil;
import com.num.model.Traceroute;

/**
 * Activity describing the application and asking users to rate the app
 */
public class AboutUsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        /**
         * Set up rate our app button to send the user to the store
         */
        LinearLayout rateButton = (LinearLayout) findViewById(R.id.about_us_button);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "market://details?id=com.num";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });
        if(Constants.DEBUG) {
            MeasurementManager manager = new MeasurementManager(this.getApplicationContext());
            manager.execute();
//            new TracerouteManager(this, new Handler()).execute(ServerUtil.getTargets(), Traceroute.ICMP);
        }
    }
}
