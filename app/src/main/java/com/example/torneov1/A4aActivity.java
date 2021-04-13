package com.example.torneov1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class A4aActivity extends AppCompatActivity {
    TextView ntr, Lg,Ct,Vl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_a4a);
            ntr = (TextView) findViewById(R.id.idNtorneo);
            Ct = (TextView) findViewById(R.id.idTcategoria);
            Lg = (TextView) findViewById(R.id.idTliga);
            Vl = (TextView) findViewById(R.id.idTvalor);


        }


    public void BtSave(View view) {
        //Intent Btnext=new Intent (this,A5Activity.class);
        //startActivity(Btnext);
        String Ntorneo, Liga, Categoria, Vls;
        Ntorneo = ntr.getText().toString();
        Liga = Lg.getText().toString();
        Categoria = Ct.getText().toString();
        Vls = Vl.getText().toString();

        if (Ntorneo.isEmpty() ||  Ntorneo.isEmpty() || Ntorneo.isEmpty() ||Ntorneo.isEmpty())
        {
            Toast.makeText(this,"Existen Campos Vacios..",Toast.LENGTH_LONG);
        } else {

           if ( checkInt(Vls)){
               int ValorI;

               CRUDSql cdDB = new CRUDSql(this);
               torneoCs tn = new torneoCs();


               ValorI = Integer.parseInt(Vls);
               tn.setNtorneo(Ntorneo);
               tn.setCategoria(Liga);
               tn.setLiga(Categoria);
               tn.setValor(ValorI);


               boolean bl = cdDB.registrar(tn);
               if (bl) {
                   Toast.makeText(this, "Torneo Registrado", Toast.LENGTH_LONG).show();
               } else {
                   Toast.makeText(this, "NO ES POSIBLE  Registrar", Toast.LENGTH_LONG).show();
               }
           }else{
               Toast.makeText(this, "Compruebe que el valor del toreno sea númerico", Toast.LENGTH_SHORT).show();
           }


        }
    }


    public boolean checkInt(String vl){
        try {
            Integer.parseInt(vl);
        }catch (NumberFormatException e){
            return  false;
        }catch (NullPointerException e){

            return false;
        }
        return  true;
    }

    }
