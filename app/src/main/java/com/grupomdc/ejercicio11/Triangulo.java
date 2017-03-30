package com.grupomdc.ejercicio11;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Triangulo extends AppCompatActivity {
/* Definición de objetos de las vistas*/
    RadioGroup rgOperaciones;
    TextView tvLado1;
    TextView tvLado2;
    TextView tvLado3;
    TextView tvBase;
    TextView tvAltura;
    TextView tvResultado;
    EditText edLado1;
    EditText edLado2;
    EditText edLado3;
    EditText edBase;
    EditText edAltura;
    Button btCalcular;
/*Fin de Definición*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);
/*Inicialización de objetos de vistas*/
        tvLado1 = (TextView) findViewById(R.id.tvLado1);
        tvLado2 = (TextView) findViewById(R.id.tvLado2);
        tvLado3 = (TextView) findViewById(R.id.tvLado3);
        tvBase = (TextView) findViewById(R.id.tvBase);
        tvAltura = (TextView) findViewById(R.id.tvAltura);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        edLado1 = (EditText) findViewById(R.id.edLado1);
        edLado2 = (EditText) findViewById(R.id.edLado2);
        edLado3 = (EditText) findViewById(R.id.edLado3);
        edBase = (EditText) findViewById(R.id.edBase);
        edAltura = (EditText) findViewById(R.id.edAltura);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        rgOperaciones = (RadioGroup) findViewById(R.id.rgOperaciones);
/*Fin de inicialización*/

/*muestra/oculta las vistas */
        rgOperaciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                //oculta todas las vistas
                tvLado1.setVisibility(View.GONE);
                tvLado2.setVisibility(View.GONE);
                tvLado3.setVisibility(View.GONE);
                tvBase.setVisibility(View.GONE);
                tvAltura.setVisibility(View.GONE);
                edLado1.setVisibility(View.GONE);
                edLado2.setVisibility(View.GONE);
                edLado3.setVisibility(View.GONE);
                edBase.setVisibility(View.GONE);
                edAltura.setVisibility(View.GONE);
                // muestra las vistas en función del radio seleccionado
                switch (i)
                {
                    case R.id.rbPerimetro:
                        tvLado1.setVisibility(View.VISIBLE);
                        tvLado2.setVisibility(View.VISIBLE);
                        tvLado3.setVisibility(View.VISIBLE);
                        edLado1.setVisibility(View.VISIBLE);
                        edLado2.setVisibility(View.VISIBLE);
                        edLado3.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbArea:
                        tvBase.setVisibility(View.VISIBLE);
                        tvAltura.setVisibility(View.VISIBLE);
                        edBase.setVisibility(View.VISIBLE);
                        edAltura.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
/*Fin de muestra/oculta las vistas*/

/* Realizar las operaciones: perímetro y área*/
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int operacion = rgOperaciones.getCheckedRadioButtonId();
                switch (operacion)
                {
                    case R.id.rbPerimetro:
                        double l1, l2, l3, perimetro;
                        try {
                            l1 = Double.parseDouble(edLado1.getText().toString());
                            l2 = Double.parseDouble(edLado2.getText().toString());
                            l3 = Double.parseDouble(edLado3.getText().toString());
                            perimetro = l1 + l2 + l3;
                            tvResultado.setText(getString(R.string.texto_perimetro_operacion) + perimetro);
                        }
                        catch (Exception e) {
                            tvResultado.setText(getString(R.string.texto_error));
                        }
                        break;
                    case R.id.rbArea:
                        double base, altura, area;
                        try {
                            base = Double.parseDouble(edBase.getText().toString());
                            altura = Double.parseDouble(edAltura.getText().toString());
                            area = base * altura / 2;
                            tvResultado.setText(getString(R.string.texto_area_operacion) + area);
                        }
                        catch (Exception e) {
                            tvResultado.setText(getString(R.string.texto_error));
                        }
                        break;
                    default:
                        tvResultado.setText(R.string.texto_sin_operacion);
                }
            }
        });
/*Fin de Realizar operaciones*/

    }
}