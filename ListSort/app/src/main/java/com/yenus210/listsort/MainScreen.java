package com.yenus210.listsort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainScreen extends AppCompatActivity {

    EditText dato, n;
    TextView lOrd;
    Button bubble, shell, add;
    ImageView gráficas;
    int lista_A[];
    String lista_P;
    int len, n_dato, i=0;

    //ShellSort
    public void sort(int arr[]) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j = 0;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;

            }


        }
        for (int i = 0; i < n; i++) {
            lista_P.concat(String.valueOf(arr[i]) + ",");
            lOrd.setText(lista_P);
        }
    }
    //Bubble Sort


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        lOrd = (TextView)findViewById(R.id.lOrd);
        dato = (EditText)findViewById(R.id.dato);
        bubble = (Button)findViewById(R.id.bubble);
        shell = (Button)findViewById(R.id.shell);
        gráficas = (ImageView)findViewById(R.id.gráficas);
        add=(Button)findViewById(R.id.add);
        n=(EditText)findViewById(R.id.n);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                len=Integer.parseInt(String.valueOf(n.getText()));
                n_dato=Integer.parseInt(String.valueOf(dato.getText()));
                if (i==0){
                    lista_A = new int[len];
                    lista_A[i]=n_dato;
                    i++;
                }else if (i>0 && i<len) {
                    lista_A[i] = n_dato;
                    i++;
                }else if (i==len) {
                    lOrd.setText("Escoja el ordenamiento");
                }

            }
        });
        bubble.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {


            }
        });

        shell.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                sort(lista_A);
            }
        });
    }
}
