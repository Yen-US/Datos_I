package gerom.aron.daniel.yenson.calcusimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText número1, número2;
    TextView resultado;
    Button suma, resta, multi, div;

    float num_1,num_2,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView)findViewById(R.id.resultado);
        número1 = (EditText)findViewById(R.id.número1);
        número2 = (EditText)findViewById(R.id.número2);
        suma = (Button)findViewById(R.id.suma);
        resta = (Button)findViewById(R.id.resta);
        multi = (Button)findViewById(R.id.multi);
        div = (Button)findViewById(R.id.div);

        suma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num_1 = Integer.parseInt(número1.getText().toString());
                num_2 = Integer.parseInt(número2.getText().toString());
                res = num_1 + num_2;
                resultado.setText(String.valueOf(res));
            }
        });
        resta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num_1 = Integer.parseInt(número1.getText().toString());
                num_2 = Integer.parseInt(número2.getText().toString());
                res = num_1 - num_2;
                resultado.setText(String.valueOf(res));
            }
        });
        multi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num_1 = Integer.parseInt(número1.getText().toString());
                num_2 = Integer.parseInt(número2.getText().toString());
                res = num_1 * num_2;
                resultado.setText(String.valueOf(res));
            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num_1 = Integer.parseInt(número1.getText().toString());
                num_2 = Integer.parseInt(número2.getText().toString());

                res = num_1 / num_2;
                resultado.setText(String.valueOf(res));
            }
        });
    }
}
