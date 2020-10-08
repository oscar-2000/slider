package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class cliente_act extends AppCompatActivity {

    private Spinner spn1;
    private Spinner spn2;
    private TextView textView;
    private EditText edText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_act);
        spn1 = (Spinner)findViewById(R.id.spnClientes);
        spn2 = (Spinner)findViewById(R.id.spnPlanes);
        textView = (TextView)findViewById(R.id.txtView);
        edText = (EditText)findViewById(R.id.edtView);

        //RECIBIMOS EL DATO EN FORMA DE ARRAY
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");
        ArrayAdapter<String> adp_clientes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adp_planes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPlanes);
        spn1.setAdapter(adp_clientes);
        spn2.setAdapter(adp_planes);
    }

    public void Calcular(View view)
    {
        int monto = Integer.parseInt(edText.getText().toString());
        //OBTENEMOS OBJETO SELECCIONADO Y LO CONVERTIMOS A STRING
        String cliente = spn1.getSelectedItem().toString();
        String planes = spn2.getSelectedItem().toString();
        Planes plan = new Planes();
        plan.setXtreme(80000);
        int resultXtreme = monto-plan.getXtreme();

        if(cliente.equals("Roberto") && planes.equals("xtreme") || cliente.equals("Ivan") && planes.equals("xtreme")){
            //MOSTRAR PRECIO DEL PLAN
            textView.setText("El precio es: "+resultXtreme);
        }
        if(cliente.equals("Roberto") && planes.equals("mindfullness") || cliente.equals("Ivan") && planes.equals("mindfullness")){
            //MOSTRAR PRECIO DEL PLAN
            textView.setText("El precio es: "+resultXtreme);
        }
    }
}