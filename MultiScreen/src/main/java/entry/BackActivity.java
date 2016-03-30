package entry;
import generated.R;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BackActivity extends ActionBarActivity {

    private TextView textView;
    private Button btnDec, btnBack;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_layout);
        
        textView = (TextView)findViewById(R.id.textView2);
        textView.setText("counter: " + Counter.val);
        
        btnDec = (Button)findViewById(R.id.button3);
        btnDec.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                System.out.println("btnDec");
                Counter.val--;
                textView.setText("counter: " + Counter.val);
            }
        });
        
        btnBack = (Button)findViewById(R.id.button4);
        btnBack.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                System.out.println("btnBack");
                finish();
            }
        });
    }

    public void onDec(View v) {
        Counter.val--;
        textView.setText("counter: " + Counter.val);
    }

}
