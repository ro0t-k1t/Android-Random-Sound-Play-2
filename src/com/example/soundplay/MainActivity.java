package com.example.soundplay;

import java.util.Random;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {
	
	
	int[] sounds={R.raw.hello, R.raw.step, R.raw.low, R.raw.high};
	RelativeLayout backclick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		RelativeLayout backclick = (RelativeLayout) findViewById(R.id.backclick);
		backclick.setOnClickListener(new OnClickListener() {

		        @Override
		        public void onClick(View v) {
		    		Random r = new Random();
		    		int Low = 0;
		    		int High = 4;
		    		int rndm = r.nextInt(High-Low) + Low; 
		    		final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), sounds[rndm]);
		    		mp1.setOnCompletionListener(new OnCompletionListener() {
		    			public void onCompletion(MediaPlayer mp) {
		                    mp1.stop();
		                    mp1.release();
		                    mp1 = null;
		                }
		    		});
		        	mp1.start();
		        	
		        	
		            

		        }
		    });
		
		
		
        

        //final MediaPlayer mp = MediaPlayer.create(this, R.raw.hello);

        //Button play_button = (Button)this.findViewById(R.id.play_button);
        //play_button.setOnClickListener(new View.OnClickListener() {
           // public void onClick(View v) {
                
               // mp.start();
            //}
       // });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
