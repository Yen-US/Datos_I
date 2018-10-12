package com.yenus210.listsort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    EditText lista;
    TextView lOrd;
    Button bubble, shell;
    ImageView gráficas;
    String lista_S;
    String lista_P;
    int lista_A[];

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
        lista = (EditText)findViewById(R.id.lista);
        bubble = (Button)findViewById(R.id.bubble);
        shell = (Button)findViewById(R.id.shell);
        gráficas = (ImageView)findViewById(R.id.gráficas);

        bubble.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //cod;

            }
        });

        shell.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                lista_S = String.valueOf(lista.getText());
                lista_A=new int[(lista_S.length())/2];
                for (int i=0; i<lista_S.length();i++){
                    char l = lista_S.charAt(i);
                    if (l==','||l==' '||l=='.'){

                    }else{
                        lista_A[i/2]=Integer.valueOf(l);
                    }
                }sort(lista_A);
            }
        });
    }
}
