package nz.net.win;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;

public class MainActivity extends Activity {
	EditText usernameTxt;
	EditText targetTxt;
	EditText msgTxt;
	Button startBtn;
	Button sendBtn;
	static String formattedMessage;
	SharedPreferences sprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Set variables for layout elements
        usernameTxt = (EditText)findViewById(R.id.usernameTxt);
        targetTxt = (EditText)findViewById(R.id.targetTxt);
        msgTxt = (EditText)findViewById(R.id.msgTxt);
        startBtn = (Button)findViewById(R.id.startBtn);
        sendBtn = (Button)findViewById(R.id.sendBtn);
        
        //Fill out username
        sprefs = this.getSharedPreferences("nz.net.win", Context.MODE_PRIVATE);
        String username = sprefs.getString("username", null);
        
        if (username != null) {
        	usernameTxt.setText(username);
        }
        
        //TODO: Client
        
        //Grab a mcast lock... mmm, delicious
        WifiManager wifi = (WifiManager)getSystemService( Context.WIFI_SERVICE );
        if(wifi != null)
        {
            WifiManager.MulticastLock lock = wifi.createMulticastLock("WifiDevices");
            lock.acquire();
        }
        
        sendBtn.setOnClickListener(
        	new View.OnClickListener() {
        		public void onClick(View view) {
        			if (targetTxt.getText().toString() != null && msgTxt.getText().toString() != null && usernameTxt.getText().toString() != null) {
        	        	//Save username for later use
        	        	sprefs.edit().putString("username", usernameTxt.getText().toString()).commit();
        	        	
        	        	//Messages are encoded like so "senderProgramVx.x##target##sender##message"
        	        	//Example: "linuxV1.8##person87##NickGeek##Hey mate! What do you think of this WiN thing?"
        	        	formattedMessage = "androidVpre.release##"+targetTxt.getText().toString()+"##"+usernameTxt.getText().toString()+"##"+msgTxt.getText().toString();
        	        	
        	        	//Clear mesage textbox
        	        	msgTxt.setText("");
        	        	
        	        	//Start Multicast
        	            Thread sendMulticast = new Thread(new WiNServer());
        	            sendMulticast.start();
        	            Toast.makeText(getApplicationContext(), "Your message has been sent.", Toast.LENGTH_SHORT).show();
        	        }
        		}
        	});
    }

	public static String formattedMessage() {
		return formattedMessage;
	}
}
