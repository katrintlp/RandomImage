package com.example.randimagesound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class RandImagePicker extends Activity {

	List<ImageSound> ImageSoundObjs = new ArrayList<ImageSound>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rand_image_picker);
		
		createImageAndSoundObjects();
		showObjects();
	}
	
	private void createImageAndSoundObjects() {
		ImageSound obj;
		
		TypedArray imgs = getResources().obtainTypedArray(R.array.random_imgs);
		for(int i = 0 ; i < 3 ; i++) {
			
			obj = new ImageSound(imgs.getResourceId(i, -1));
			ImageSoundObjs.add(obj);
		}
	}
	
	private void showObjects() {
		Random rand = new Random();
		ImageView img1 = (ImageView) findViewById(R.id.image1);
		ImageView img2 = (ImageView) findViewById(R.id.image2);
		
		for(int i = 0 ; i < 2 ; i++) {
			int  n1 = rand.nextInt(2) + 1;
			int  n2 = rand.nextInt(2) + 1;
			
			int resId1 = ImageSoundObjs.get(n1).getResourceId();
			img1.setImageResource(resId1);
			
			int resId2 = ImageSoundObjs.get(n2).getResourceId();
			img2.setImageResource(resId2);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rand_image_picker, menu);
		return true;
	}

}
