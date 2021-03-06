package com.example.autonoma.ejercicio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfesoresActivity extends AppCompatActivity {

    EditText etNombre;
    Button btnGrebar;
    ArrayList Profesores;
    ListView lvProfesores;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);
        //
        etNombre = findViewById(R.id.etNombre);
        btnGrebar = findViewById(R.id.btnAgregar);
        lvProfesores = findViewById(R.id.lvProfesores);
        // inicializamos el array
        Profesores = new ArrayList<String>();
        //adaptadoir
        adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        Profesores);
        //asignamos adaptador al list view
        lvProfesores.setAdapter(adapter);
        //
        btnGrebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profesores.add(etNombre.getText().toString());
                lvProfesores.deferNotifyDataSetChanged();
            }
        });


    }// Fin onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    //detectar click


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(ProfesoresActivity.this, "Agregar Item", Toast.LENGTH_LONG).show();

                //agregar listado
                Profesores.add("Profesores X");
                adapter.notifyDataSetChanged();
                lvProfesores.deferNotifyDataSetChanged();
                return true;

            //inicio case refrescar
            case R.id.refrescar:
                Toast.makeText(ProfesoresActivity.this, "Refrescar", Toast.LENGTH_LONG).show();
                //refrescar el adaptador
                adapter.notifyDataSetChanged();
                return true;
            //inicio case ver mapa
            case R.id.vermapa:
                //Crear un activity Plantilla Mapa
                //Lleva al Activity
                Intent i = new Intent(this, Mapa.class);
                startActivity(i);

                Toast.makeText(ProfesoresActivity.this, "Ver Mapa", Toast.LENGTH_LONG).show();
                return true;
            //incio case Cerrar
            case R.id.cerrar:
                //llevarte al mainActivity
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(ProfesoresActivity.this, "Cerrar", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}// Fin Profesores Activity
