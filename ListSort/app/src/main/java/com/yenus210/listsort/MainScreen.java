package com.yenus210.listsort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    EditText dato, n;
    TextView lOrd;
    Button bubble, shell, add;
    ImageView gráficas;

    int len, n_dato, largo=0;
    int lista_A[];


    //ShellSort
    public void sort(int arr[]) {
        int n = arr.length;
        String lista_P="";
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j = 0;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;

            }

        }for (int i = 0; i < largo; i++) {
            if (i!=largo-1) {
                lista_P += (String.valueOf(lista_A[i]) + ",");
            }else{
                lista_P += (String.valueOf(lista_A[i]));
                lOrd.setText(lista_P);
            }

        }
        }


    //Bubble Sort
    void bubble_srt(int array[]) {
        int n = array.length;
        int k;
        String lista_P="";
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    int temp;
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }// aqui se imprime el proceso del sort

        }
        for (int i = 0; i < largo; i++) {
            if (i != largo - 1) {
                lista_P += (String.valueOf(lista_A[i]) + ",");
            } else {
                lista_P += (String.valueOf(lista_A[i]));
                lOrd.setText(lista_P);
            }
        }
    }
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
        n=(EditText) findViewById(R.id.n);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                len=Integer.parseInt(n.getText().toString());
                n_dato=Integer.parseInt(dato.getText().toString());
                if (largo==0){
                    lista_A = new int[len];
                    lista_A[largo] = n_dato;
                    lOrd.setText(String.valueOf(lista_A[largo] + ","));
                    largo+=1;

                }else if (largo>0 && largo<len) {
                    lista_A[largo]= n_dato;
                    lOrd.setText(String.valueOf(lista_A[largo] + ","));
                    largo+=1;

                }if (largo==len||largo>len) {
                    lOrd.setText(String.valueOf(lista_A[largo-1] + ","));
                    lOrd.setText("Escoja el ordenamieno");

                }

            }
        });
        bubble.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                bubble_srt(lista_A);
                gráficas.setImageResource(R.mipmap.sort_base);
                len=Integer.parseInt(n.getText().toString());
                    if (len <=5){
                        gráficas.setImageResource(R.mipmap.sort_5);
                    }else if(len>5&&len<=10){
                        gráficas.setImageResource(R.mipmap.sort_10);
                    }else if(len>10&&len<=25){
                        gráficas.setImageResource(R.mipmap.sort_25);
                    }else if(len>25){
                        gráficas.setImageResource(R.mipmap.sort_30);
                    }
            }
        });

        shell.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                sort(lista_A);
            }
        });

    }
}
