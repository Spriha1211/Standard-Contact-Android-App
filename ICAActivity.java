package project.my;

import java.net.URI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ICAActivity extends Activity {
    /** Called when the activity is first created. */

    TextView t1,t2;
    EditText e1,e2;
    RadioButton cl, sms;
    Button b1,b2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        cl=(RadioButton)findViewById(R.id.radio1);
        sms=(RadioButton)findViewById(R.id.radio0);
        cl.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				t2.setEnabled(false);
				e2.setEnabled(false);
				b1.setText("CALL");
				
			}
		});
        sms.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				t2.setEnabled(true);
				e2.setEnabled(true);
				b1.setText("SEND");
				
			}
		});
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(b1.getText().toString()=="CALL")
				{ String n=e1.getText().toString();
				  Intent callIntent=new Intent(Intent.ACTION_CALL);
				  callIntent.setData(Uri.parse("tel:"+n)); 
				  startActivity(callIntent);
				  }
				if(b1.getText().toString()=="SEND"){
					String n=e1.getText().toString();
					SmsManager sms=SmsManager.getDefault();
					sms.sendTextMessage(n,null,e2.getText().toString(),null,null);
					e2.setText(" ");
					e1.setText(" ");
				}
			}
		});
     
        
        }
}