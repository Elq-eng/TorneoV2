package com.example.torneov1;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class popWindowELA6 extends AppCompatActivity {

    private TextView TxtNequi, TxtNcap, TxtCel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow_ela6);
        TxtNequi=(TextView) findViewById(R.id.idNequi);
        TxtNcap=(TextView) findViewById(R.id.idNcap);
        TxtCel=(TextView) findViewById(R.id.idCel);


        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int heigth=dm.heightPixels;
        width= (int) (width*0.8);
        heigth=(int)(heigth*0.8);

        getWindow().setLayout(width,heigth);
    }

    public  void GuardarEq(View v){
        String SNequi , SNcap, SCel;
        SNequi = TxtNequi.getText().toString();
        SNcap = TxtNcap.getText().toString();
        SCel = TxtCel.getText().toString();
        if (SNequi.isEmpty() ||  SNcap.isEmpty() || SCel.isEmpty())
        {
            Toast.makeText(this,"Existen Campos Vacios..",Toast.LENGTH_LONG);
        }else {
            CRUDSql cdDB = new CRUDSql(this);
            equipoCs eqp = new equipoCs();


            //ValorI = Integer.parseInt(Vls);
            eqp.setNequipo(SNequi);
            eqp.setNcap(SNcap);
            eqp.setCel(SCel);

            boolean bl = cdDB.registrar(eqp);
            if (bl) {
                Toast.makeText(this, "Equipo Registrado", Toast.LENGTH_LONG).show();




            } else {
                Toast.makeText(this, "NO ES POSIBLE Registrar", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
