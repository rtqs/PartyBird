package com.digidemic.partybird;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView hornbutton;
	MediaPlayer mp;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeButton();
	}

	private void initializeButton(){
		hornbutton = (ImageView)findViewById(R.id.hornbutton);
		hornbutton.setSoundEffectsEnabled(false);
		mp = MediaPlayer.create(MainActivity.this, R.raw.horn1); 

		hornbutton.setOnClickListener(new OnClickListener() {
			@Override
	        public void onClick(View v) {
	        	if(mp.isPlaying()){
	        		try{
	        			SystemClock.sleep(3);//To fix multiclick glitch on some devices
	        		}
	        		catch(Exception implotion){ }
	        		mp.seekTo(0);
	        	}     	
	        	else{
		            (mp).start();
	        	}
		    }
	    });
	}
}
