package com.example.ucrinstagram;



import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class PostPicture extends Activity {

    private AmazonS3Client s3Client = new AmazonS3Client( new BasicAWSCredentials( "AKIAJVITZZSHZ4EDHDMA", "" ) );                    
    String filePath;
    String caption;
    EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_picture);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);
	
	    filePath = getIntent().getExtras().getString("picture");
		System.out.println("TEST: "+filePath);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 8;
    	Bitmap bmp = BitmapFactory.decodeFile(filePath,options);
        ImageView myImage2 = (ImageView) findViewById(R.id.imageView1);
        myImage2.setScaleType(ScaleType.FIT_XY);
        myImage2.setImageBitmap(bmp);
        et = (EditText)findViewById(R.id.editText1);
	}

	public void clickShare(View view){
        System.out.println(et.getText().toString());
        caption = et.getText().toString();
        new S3PutObjectTask().execute();
    	Intent intent = new Intent(this, HomeScreen.class);
    	intent.putExtra("caption", caption);
    	startActivity(intent);    	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_post_picture, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class S3PutObjectTask extends AsyncTask<Void,Void,Void>{
		
		@Override
		protected Void doInBackground(Void... arg0) {
			s3Client.createBucket("ucrinstagram");
			PutObjectRequest por = new PutObjectRequest("ucrinstagram",caption,new java.io.File(filePath));
			por.setCannedAcl(CannedAccessControlList.PublicRead);
			s3Client.putObject(por);
			return null;
		}
	}
	
}
