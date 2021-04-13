package com.example.torneov1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class A3Activity extends AppCompatActivity {

    private  ListView listview;
    private ArrayList <String> names,inmu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);




        listview=(ListView) findViewById(R.id.idListVwTorn);
        boolean tr=mostrarC();
        if(tr){
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent nxt=new Intent(A3Activity.this,ElA6Activity.class);
                    //listaAux=Segunda.Lista.get(idx);
                    //nxt.putExtra("infoT",usuar.get(i));
                    startActivity(nxt);

                }
            });
        }


    }
    public void  NuevoTorneo(View view){
        Intent sig=new Intent(this, A4aActivity.class);
        startActivity(sig);
        //onDestroy();

    }
    public boolean mostrarC(){
        CRUDSql cdDB=new CRUDSql(this);
        ArrayList<torneoCs> tn=new ArrayList<>();
        ArrayList<String> ntorneoDB=new ArrayList<>();
        torneoCs tnDb=new torneoCs();
        tn=cdDB.consultarTodos();
        String nton;
        if(!tn.isEmpty()){
           for(int i=0; i<tn.size();i++){
               tnDb=tn.get(i);
               nton=tnDb.getNtorneo();
               ntorneoDB.add(nton);
           }

            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ntorneoDB);
            listview.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();
            return true;
        }else {
            Toast.makeText(this, "NO hay torneos registrados",Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    //TODO: update data
    @Override
    public void onResume() {
        super.onResume();
        mostrarC();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}