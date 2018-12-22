package com.whatsapp.magazine.paulooliveira.meucarroflex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editprecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        //Recupera valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if ( camposValidados ){
             this.calcularMelhorPreco(precoAlcool, precoGasolina);
        }else {
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){

        //Converter valores string para números
        Double precaoAlcool = Double.parseDouble(pAlcool);
        Double precaoGasolina = Double.parseDouble(pGasolina);

        /*Faz cálculo ( precoAlcool / precoGasolina )
            * Se resultado >= 0.7 melhor utilizar gasolina
            * senão melhor utilizar Álcool
        * */
        Double resultado = precaoAlcool / precaoGasolina;
            if (resultado >= 0.7){
                textResultado.setText("Melhor abastecer com Gasolina!");
            }else {
                textResultado.setText("Melhor abastecer com Álcool!");
            }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

       Boolean camposValidados = true;

       //Validar campos
        if (  pAlcool==null || pAlcool.equals("") ){
            camposValidados = false;
        }else if( pGasolina==null || pGasolina.equals("") ){
            camposValidados = false;
        }

       return camposValidados;

    }
}
