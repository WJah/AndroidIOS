package entry;

import generated.R;
import com.intel.inde.common.Context;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    private Button btnInc, btnSwitch;
    private TextView textView;
    private Context self;
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
        self = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("counter: " + Counter.val);
        
        btnInc = (Button) findViewById(R.id.button);
        btnInc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("btnInc");
                Counter.val++;
                textView.setText("counter: " + Counter.val);
            }
        });
        
        btnSwitch = (Button) findViewById(R.id.button2);

        btnSwitch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("btnSwitch");
                Intent intent = new Intent();
                intent.setClassName(self, "entry.BackActivity");
                startActivity(intent);
            }
        });        
    }

    public void onInc(View v) {
        Counter.val++;
        System.out.println(Counter.val);
    }

}
