package com.example.ucrinstagram;

import android.os.Bundle;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
<<<<<<< HEAD
import android.preference.PreferenceManager;
=======
>>>>>>> origin/master
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> origin/master

public class Profile extends Activity {
    //final int TAKE_PICTURE = 1;
	private static final int ACTIVITY_SELECT_IMAGE = 1234;
//    private String selectedImagePath;
//    private ImageView img;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
<<<<<<< HEAD
        
        TextView usernametv = (TextView) findViewById(R.id.username);
        TextView nicknametv = (TextView) findViewById(R.id.nickname);
        TextView gendertv = (TextView) findViewById(R.id.gender);
        TextView biotv = (TextView) findViewById(R.id.aboutme);
        SharedPreferences sharedPrefs = getSharedPreferences("tempUsername", 0);
        SharedPreferences defSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPrefs.getString("username", "username");
        String nickname = defSharedPrefs.getString("nickname", "nickname");
        String gender = defSharedPrefs.getString("listpref", "gender");
        String bio = defSharedPrefs.getString("aboutme", "About Me");
        
        usernametv.setText(username);
        nicknametv.setText(nickname);
        gendertv.setText(gender);
        biotv.setText(bio);
        
=======
>>>>>>> origin/master
		
		
        // Loader image - will be shown before loading image
        int loader = R.drawable.loader;
 
        // Imageview to show
        ImageView image = (ImageView) findViewById(R.id.image);
 
        // Image url
        String image_url = "http://api.androidhive.info/images/sample.jpg";
 
        // ImageLoader class instance
        ImageLoader imgLoader = new ImageLoader(getApplicationContext());
 
        // whenever you want to load an image from url
        // call DisplayImage function
        // url - image url to load
        // loader - loader image, will be displayed before getting image
        // image - ImageView
        imgLoader.DisplayImage(image_url, loader, image);
		
//		WebView myWebView = (WebView) findViewById(R.id.webview);                   
//		myWebView.loadUrl("http://img191.imageshack.us/img191/7379/tronlegacys7i7wsjf.jpg");
        
        new DownloadImageTask((ImageView) findViewById(R.id.imageView1)).execute("http://api.androidhive.info/images/sample.jpg");
        
<<<<<<< HEAD
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		TextView usernametv = (TextView) findViewById(R.id.username);
        TextView nicknametv = (TextView) findViewById(R.id.nickname);
        TextView gendertv = (TextView) findViewById(R.id.gender);
        TextView biotv = (TextView) findViewById(R.id.aboutme);
        SharedPreferences sharedPrefs = getSharedPreferences("tempUsername", 0);
        SharedPreferences defSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPrefs.getString("username", "username");
        String nickname = defSharedPrefs.getString("nickname", "nickname");
        String gender = defSharedPrefs.getString("listpref", "gender");
        String bio = defSharedPrefs.getString("aboutme", "About Me");
        
        usernametv.setText(username);
        nicknametv.setText(nickname);
        gendertv.setText(gender);
        biotv.setText(bio);
=======
>>>>>>> origin/master
	}
	
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;
		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;
		}
		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon11 = null;
		try {
			InputStream in = new java.net.URL(urldisplay).openStream();
			mIcon11 = BitmapFactory.decodeStream(in);
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
			e.printStackTrace();
			}
		return mIcon11;
		}
		protected void onPostExecute(Bitmap result) {
			bmImage.setImageBitmap(result);
		}
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_profile, menu);
		return true;
	}
	
<<<<<<< HEAD

	
    public void home(View view){
    	Intent intent = new Intent(this, HomeScreen.class);
    	startActivity(intent);    	
    }
	
    public void explore(View view){
    	Intent intent = new Intent(this, Explore.class);
    	startActivity(intent);    	
    }
    
    public void camera(View view){
    	Intent intent = new Intent(this, Camera.class);
    	startActivity(intent);    	
    }
    
    public void settings(View view){
    	Intent intent = new Intent(this, PrefsActivity.class);
    	startActivity(intent);    	
    }
    
    public void logout(){
        // Clearing all data from Shared Preferences
        SharedPreferences settings = getSharedPreferences("DB_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove("user");
        editor.remove("pass");
        editor.clear();
        editor.commit();
        
    	Intent intent = new Intent(this, Login.class);
    	startActivity(intent);    	
    }
    
    public void startGallery(View view){
    	Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent, "Select Picture for UCRinstagram"),ACTIVITY_SELECT_IMAGE);
		//done();
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
     //Bitmap bmp = null;
        if(resultCode == RESULT_OK && requestCode == ACTIVITY_SELECT_IMAGE){
        	//Upload the picture and associate it with the proper account

        	//reload the profile page
        	Intent intent = new Intent(this, Profile.class);
        	startActivity(intent);  
        	
        	
//            Uri selectedImageUri = data.getData();
//            selectedImagePath = getPath(selectedImageUri);
//            System.out.println("Image Path : " + selectedImagePath);
//            img.setImageURI(selectedImageUri);
////        }
//        new DownloadImageTask((ImageView) findViewById(R.id.imageView1)).execute(selectedImagePath);

=======

	
    public void home(View view){
    	Intent intent = new Intent(this, HomeScreen.class);
    	startActivity(intent);    	
    }
	
    public void explore(View view){
    	Intent intent = new Intent(this, Explore.class);
    	startActivity(intent);    	
    }
    
    public void camera(View view){
    	Intent intent = new Intent(this, Camera.class);
    	startActivity(intent);    	
    }
    
    public void settings(View view){
    	Intent intent = new Intent(this, PrefsActivity.class);
    	startActivity(intent);    	
    }
    
    public void logout(){
        // Clearing all data from Shared Preferences
        SharedPreferences settings = getSharedPreferences("DB_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove("user");
        editor.remove("pass");
        editor.clear();
        editor.commit();
        
    	Intent intent = new Intent(this, Login.class);
    	startActivity(intent);    	
    }
    
    public void startGallery(View view){
    	Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent, "Select Picture for UCRinstagram"),ACTIVITY_SELECT_IMAGE);
		//done();
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
     //Bitmap bmp = null;
        if(resultCode == RESULT_OK && requestCode == ACTIVITY_SELECT_IMAGE){
        	//Upload the picture and associate it with the proper account

        	//reload the profile page
        	Intent intent = new Intent(this, Profile.class);
        	startActivity(intent);  
        	
        	
//            Uri selectedImageUri = data.getData();
//            selectedImagePath = getPath(selectedImageUri);
//            System.out.println("Image Path : " + selectedImagePath);
//            img.setImageURI(selectedImageUri);
////        }
//        new DownloadImageTask((ImageView) findViewById(R.id.imageView1)).execute(selectedImagePath);

>>>>>>> origin/master
   }

}
    
//    public String getPath(Uri uri) {
//        String[] projection = { MediaStore.Images.Media.DATA };
//        Cursor cursor = managedQuery(uri, projection, null, null, null);
//        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        cursor.moveToFirst();
//        return cursor.getString(column_index);
//    }
}
