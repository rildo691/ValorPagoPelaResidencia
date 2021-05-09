package com.example.valorpagopelaresidencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText salarioMinimo;
    EditText valorKw;
    TextView resultadoCadaKw;
    TextView resultadoValorASerPago;
    TextView resultadoValorASerPagoDesc;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salarioMinimo = (EditText) findViewById(R.id.editTextTextPersonName);
        valorKw = (EditText) findViewById(R.id.editTextTextPersonName3);
        resultadoCadaKw = (TextView) findViewById(R.id.textView4);
        resultadoValorASerPago = (TextView) findViewById(R.id.textView5);
        resultadoValorASerPagoDesc = (TextView) findViewById(R.id.textView6);
        calcular = (Button) findViewById(R.id.button);

        calcular.setOnClickListener(c->{
            if (salarioMinimo.getText().toString().contains(",") || valorKw.getText().toString().contains(",")){
                Toast.makeText(this, "Deve substituir o ponto pela vírgula caso queira inserir um valor decimal", Toast.LENGTH_SHORT).show();
            }
            else {
                double valorDeKw, valorGastoRes, valorPagoDesc, perc_desc;

                valorDeKw = ((Double.parseDouble(salarioMinimo.getText().toString()) * Double.parseDouble(valorKw.getText().toString()))/5)/Double.parseDouble(valorKw.getText().toString());
                valorGastoRes = (Double.parseDouble(salarioMinimo.getText().toString()) * Double.parseDouble(valorKw.getText().toString()));
                perc_desc = (valorGastoRes * 15)/100;
                valorPagoDesc = valorGastoRes - perc_desc;

                resultadoCadaKw.setText(Double.toString(valorDeKw));
                resultadoValorASerPago.setText(Double.toString(valorGastoRes));
                resultadoValorASerPagoDesc.setText(Double.toString(valorPagoDesc));
            }
        });
    }
}