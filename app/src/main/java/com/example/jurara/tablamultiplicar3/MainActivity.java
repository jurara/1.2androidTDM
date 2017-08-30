package com.example.jurara.tablamultiplicar3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, ListView.OnItemClickListener  {

    TextView txtTitulo;
    SeekBar bar;

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.-construir referencias a componentes xml
        txtTitulo=(TextView)findViewById(R.id.txt_titulo);
        bar=(SeekBar)findViewById(R.id.seekBar);
        list=(ListView)findViewById(R.id.list_view);
        //2.-asociar Listener a btnCalc

        bar.setMax(10);
        bar.setOnSeekBarChangeListener(this);
        list.setOnItemClickListener(this);
    }







    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //3.-Obtener el valor numerico de la tabla
        int numero;
        ArrayList lista=new ArrayList<String>();
        numero=bar.getProgress();
        for(int i=1;i<11;i++){

            lista.add(numero+" * "+i+" = "+(numero*i));
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);
        list.setAdapter(adapter);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"ha presionado "+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
    }
}
