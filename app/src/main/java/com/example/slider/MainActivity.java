package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper vf;
    //GUARDAMOS IMAGENES EN EL ARREGLO
    private int[] image = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vf = (ViewFlipper)findViewById(R.id.vf);
        for(int i = 0; i<image.length;i++)
        {
            flip_image(image[i]);
        }
    }

    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        //INSERTAMOS IMAGENES
        view.setBackgroundResource(i);
        vf.addView(view);
        //CADA CUANTO SE MOSTRARA LA NUEVA IMAGEN
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        //EMPIEZA DESDE LA IZQUIERDA
        vf.setInAnimation(this,android.R.anim.slide_in_left);
        //AVANZA HACIA LA DERECHA
        vf.setOutAnimation(this,android.R.anim.slide_out_right);

    }

    public void Cliente(View view)
    {
        //ENVIAR EL DATO
        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> planes = new ArrayList<String>();
        clientes.add("Roberto");
        clientes.add("Ivan");
        planes.add("xtreme");
        planes.add("mindfullness");
        Intent vistaCliente = new Intent(this, cliente_act.class);
        vistaCliente.putExtra("listaClientes",clientes); //PREPARAMOS DATO
        vistaCliente.putExtra("listaPlanes",planes);
        startActivity(vistaCliente);
    }

    public void Mapa(View view)
    {
        Intent vistaMapa = new Intent(this, mapa_act.class);
        startActivity(vistaMapa);
    }

    public void Insumos (View view)
    {
        Intent vistaInsumo = new Intent(this, insumos_act.class);
        startActivity(vistaInsumo);
    }

    public void Informacion(View view)
    {
        Intent vistaInfo = new Intent(this, info_act.class);
        startActivity(vistaInfo);
    }

}