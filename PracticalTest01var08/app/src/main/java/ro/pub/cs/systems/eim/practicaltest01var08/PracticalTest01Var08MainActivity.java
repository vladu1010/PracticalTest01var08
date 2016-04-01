package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var08MainActivity extends ActionBarActivity {

    private Button but1 = null;
    private Button but2 = null;
    private Button but3 = null;
    private Button but4 = null;
    private Button but5 = null;
    private Button other = null;
    private TextView text = null;
    private String text1 = null;
   int ct=10;
    private int nrNav ;
    private int nrCor ;
    private int nrInc ;

    private IntentFilter intentFilter = new IntentFilter();
    private MessageBroadcastReceiver messageBroadcastReceiver = null;
    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("broadcast_message");
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            Log.d("RECEIVER", message);
        }
    }

    butonclick but = new butonclick();
    private class butonclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    text1 = text.getText().toString();
                    if (text.getText().toString().length() > 0) {
                        text.setText(text1 + "," + " Top Left");
                    }
                    else {
                        text.setText(text1 + "Top Left");
                    }
                    break;
                case R.id.button2:
                   text1 = text.getText().toString();
                    if (text.getText().toString().length() > 0) {
                        text.setText(text1 + "," + " Top Right");
                    }
                    else {
                        text.setText(text1 + "Top Right");
                    }
                    break;
                case R.id.button3:
                    text1 = text.getText().toString();
                    if (text.getText().toString().length() > 0) {
                        text.setText(text1 + "," + " Center");
                    }
                    else {
                        text.setText(text1 + "Center");
                    }
                    break;
                case R.id.button4:
                   text1 = text.getText().toString();
                    if (text.getText().toString().length() > 0) {
                        text.setText(text1 + "," + " Bottom Left");
                    }
                    else {
                        text.setText(text1 + "Bottom Left");
                    }
                    break;
                case R.id.button5:
                   text1 = text.getText().toString();
                    if (text.getText().toString().length() > 0) {
                        text.setText(text1 + "," + " Bottom Right");
                    }
                    else {
                        text.setText(text1 + "Bottom Right");
                    }
                    break;
                case R.id.buttonother:
                    nrNav++;
                   Intent int2 = new Intent(getApplicationContext(),PracticalTest01Var08SecondaryActivity.class);
                    int2.putExtra("text",text.getText().toString());
                    int2.putExtra("nrIncercari", nrNav);
                    int2.putExtra("nrCorecte",nrCor);
                    int2.putExtra("nrGresite", nrInc);
                    startActivityForResult(int2, 2016);
                    text.setText("");
                    break;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08Service.class);
        stopService(intent);
        super.onDestroy();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);
        but1 = (Button)findViewById(R.id.button1);
        but2 = (Button)findViewById(R.id.button2);
        but3 = (Button)findViewById(R.id.button3);
        but4 = (Button)findViewById(R.id.button4);
        but5 = (Button)findViewById(R.id.button5);
        other = (Button)findViewById(R.id.buttonother);
        text = (TextView)findViewById(R.id.introduce_yourself_edit_text1);
        nrNav=0;
        nrCor=0;
        nrInc=0;
        but1.setOnClickListener(but);
        but2.setOnClickListener(but);
        but3.setOnClickListener(but);
        but4.setOnClickListener(but);
        but5.setOnClickListener(but);
        other.setOnClickListener(but);
        intentFilter.addAction("broadcast_message_action");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var08_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("nrIncercari", String.valueOf(nrNav));
        savedInstanceState.putString("nrCorecte",String.valueOf(nrCor));
        savedInstanceState.putString("nrGresit", String.valueOf(nrInc));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getString("nrIncercari")!=null) {
            nrNav = Integer.parseInt(savedInstanceState.getString("nrIncercari"));
        }
        else {
            nrNav = 0;
        }
        if (savedInstanceState.getString("nrCorecte")!=null) {
            nrCor = Integer.parseInt(savedInstanceState.getString("nrCorecte"));
        }
        else {
            nrCor = 0;
        }
        if (savedInstanceState.getString("nrGresit")!=null) {
            nrInc = Integer.parseInt(savedInstanceState.getString("nrGresit"));
        }
        else {
            nrInc = 0;
        }
        Toast.makeText(getApplicationContext(), "Result is" + Integer.parseInt(savedInstanceState.getString("nrIncercari")) + " " +
                Integer.parseInt(savedInstanceState.getString("nrCorecte")) + " " +
                Integer.parseInt(savedInstanceState.getString("nrGresit")),Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 2016) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08SecondaryActivity.class);
            nrCor = intent.getIntExtra("nrverify",0);
            nrInc = intent.getIntExtra("nrcancel",0);
            Toast.makeText(getApplicationContext(), "Result is: " + nrNav+" "+nrCor+" "+nrInc, Toast.LENGTH_LONG).show();
            Intent intent2 = new Intent(getApplicationContext(), PracticalTest01Var08SecondaryActivity.class);
           // intent2.putExtra("cor", nrCor);
           // intent2.putExtra("gres", nrInc);
            startService(intent2);
        }
        String toComputes = text.getText().toString();
        int result = 0;
        for (String elem:toComputes.split("\\, ")) {
            result++;
        }
        if(result > ct) {
            Intent intent = new Intent(getApplicationContext(),PracticalTest01Var08Service.class);
            intent.putExtra("mediaa",result);
            getApplicationContext().startService(intent);
        }

    }
}
