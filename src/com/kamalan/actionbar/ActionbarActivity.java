package com.kamalan.actionbar;

import com.kamalan.widget.ActionBar;
import com.kamalan.widget.ActionBar.ActionbarClickedListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActionbarActivity extends Activity {
	
    private String TAG = "*** ActionbarActivity ***";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ActionBar actionbar = (ActionBar) findViewById(R.id.actionBar);
        actionbar.setTitle("Kamalan.com");
        actionbar.setOnItemClickedListener(new ActionbarClickedListener() {
			@Override
			public void eventOccured(int id) {
				switch(id) {
					case R.id.actionbar_menu:  Log.i(TAG, "Menu Clicked");  break;
					case R.id.actionbar_stage: Log.i(TAG, "Stage Clicked"); break;
				}
			}
		});
    }
}