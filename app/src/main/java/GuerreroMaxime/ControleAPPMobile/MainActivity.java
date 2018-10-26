package GuerreroMaxime.ControleAPPMobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import android.view.TextureView;

public class MainActivity extends AppCompatActivity {

    private TextView Nom;
    private TextView Prenom;
    private TextView Mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    while (!isInterrupted() ) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = (TextView) findViewById(R.id.textView2);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
                                String dateString = sdf.format(date);
                                tdate.setText(dateString);

                            }
                        });
                    }
                }catch (InterruptedException e) {

                }
            }

        };
        t.start();

        Nom=(TextView) findViewById(R.id.editText);
        Prenom=(TextView) findViewById(R.id.editText2);
        Mail=(TextView) findViewById(R.id.textView5);
        Mail.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (Nom.getText()!= "") {
                    if (Prenom.getText()!= "") {
                        Mail.setText(Prenom.getEditableText().toString().toLowerCase().charAt(0)+Nom.getEditableText().toString().toLowerCase()+"@gmail.com");
                    }
                 }
            }
        }
        );
    }

}
