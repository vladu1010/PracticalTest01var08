package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var08SecondaryActivity extends ActionBarActivity {

    private Button butcanel = null;
    private Button butverify = null;
    private TextView text2 = null;
    int nr1,nr2;

    butonclick2 but = new butonclick2();
    private class butonclick2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonverify:
                    nr1++;
                    setResult(RESULT_OK);

                    break;
                case R.id.buttoncancel:
                    nr2++;
                    setResult(RESULT_CANCELED);

                    break;
            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secondary);
        Intent int1 = getIntent();
        text2 = (TextView)findViewById(R.id.introduce_yourself_edit_text2);
        butcanel = (Button)findViewById(R.id.buttoncancel);
        butverify = (Button)findViewById(R.id.buttonverify);
        if(int1 != null && int1.getExtras().containsKey("text")) {
            String text3 = int1.getStringExtra("text");
            text2.setText(text3);
           // nr1 += int1.getIntExtra("cor",0);
           // nr2 += int1.getIntExtra("gre", 0);
            //Intent intentToParent = new Intent();
            int1.putExtra("nrverify", nr1);
            int1.putExtra("nrcancel", nr2);
        }
        butverify.setOnClickListener(but);
        butcanel.setOnClickListener(but);
    }

}
