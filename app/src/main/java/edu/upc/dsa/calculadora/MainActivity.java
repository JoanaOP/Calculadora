package edu.upc.dsa.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView resultatText;
    public double numAnterior;
    public double numActual;
    public int operacioAcumulada = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultatText = findViewById(R.id.resultatText);
    }

    public void operacioClick (View v){

        Button bt = (Button)v;
        String operacio = (String)bt.getText();
        if(operacio.equals("=")==false) {
            resultatText.setText(operacio);
        }

        if (operacio.equals("+")== true){
            if(operacioAcumulada == 0) {
                numAnterior = numActual;
            }
            else{
                numAnterior = ferOperacio(operacioAcumulada);
            }
            operacioAcumulada = 1;
        }
        else if (operacio.equals("-")== true){
            if(operacioAcumulada == 0) {
                numAnterior = numActual;
            }
            else{
                numAnterior = ferOperacio(operacioAcumulada);
            }
            operacioAcumulada = 2;
        }
        else if (operacio.equals("*")== true){
            if(operacioAcumulada == 0) {
                numAnterior = numActual;
            }
            else{
                numAnterior = ferOperacio(operacioAcumulada);
            }
            operacioAcumulada = 3;
        }
        else if (operacio.equals("/")== true){
            if(operacioAcumulada == 0) {
                numAnterior = numActual;
            }
            else{
                numAnterior = ferOperacio(operacioAcumulada);
            }
            operacioAcumulada = 4;
        }
        else if (operacio.equals("sin")== true){
            borrar();
            operacioAcumulada = 5;
        }
        else if (operacio.equals("cos")== true){
            borrar();
            operacioAcumulada = 6;
        }
        else if (operacio.equals("tan")== true){
            borrar();
            operacioAcumulada = 7;
        }
        else if (operacio.equals("=")== true){
            double resultat = ferOperacio(operacioAcumulada);
            resultatText.setText(String.valueOf(resultat));
            numActual = resultat;
            operacioAcumulada = 0;
            Log.d("resultat",String.valueOf(resultat));
        }
        else if (operacio.equals("clr")== true){
            borrar();
        }

    }

    public double ferOperacio(int op){
        double res = 0;
        if (op == 1){
            res = numActual + numAnterior;
        }
        else if (op == 2){
            res = numAnterior - numActual;
        }
        else if (op == 3) {
            res = numActual*numAnterior;
        }
        else if (op == 4){
            res = numAnterior/numActual;
        }
        else if (op == 5){
            res = Math.sin(numActual); //radians
        }
        else if (op == 6){
            res = Math.cos(numActual); //radians
        }
        else if (op == 7){
            res = Math.tan(numActual); //radians
        }

        return res;

    }

    public void borrar(){
        operacioAcumulada = 0;
        numActual = 0;
        numAnterior = 0;
        resultatText.setText("");
    }

    public void numeroClick (View v){

        Button bt = (Button)v;
        numActual = Double.parseDouble((String)bt.getText());
        resultatText.setText((String)bt.getText());

    }

}