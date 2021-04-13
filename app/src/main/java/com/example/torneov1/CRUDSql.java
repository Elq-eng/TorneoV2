package com.example.torneov1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CRUDSql {
    SqlAdmin adm;

    public CRUDSql(Context context) {
        this.adm=new SqlAdmin(context,"DBTorneoa",null,1);
    }

    //torneoCs aa=new torneoCs();
    public boolean registrar(torneoCs tn){
        SQLiteDatabase dbs=adm.getWritableDatabase();
        boolean flag;
        flag=false;
        String Ntorneo, Liga, Categoria;
        int Valor;

        Ntorneo=tn.getNtorneo();
        Liga=tn.getLiga();
        Categoria=tn.getCategoria();
        Valor=tn.getValor();
        boolean empc=!Ntorneo.isEmpty()&& !Liga.isEmpty()&& !Categoria.isEmpty();

        if(empc){
            ContentValues registro=new ContentValues();
            registro.put("ntorneo", Ntorneo);
            registro.put("categoria",Categoria);
            registro.put("liga",Liga);
            registro.put("valor",Valor);
            dbs.insert("torneosv1a", null,registro);
            //dbs.rawQuery("insert into ")
            dbs.close();
            flag=true;
        }
        return  flag;
    }

    public boolean registrar(equipoCs eqp){
        SQLiteDatabase dbs=adm.getWritableDatabase();
        boolean flag;
        flag=false;
        String SNequi , SNcap, SCel;
        int Valor;

        SNequi=eqp.getNequipo();
        SNcap=eqp.getNcap();
        SCel=eqp.getCel();

        boolean empc=!SNequi.isEmpty()&& !SNcap.isEmpty()&& !SCel.isEmpty();

        if(empc){
            ContentValues registro=new ContentValues();
            registro.put("nequipo", SNequi);
            registro.put("capitan",SNcap);
            registro.put("ncelular",SCel);
            dbs.insert("equipov1a", null,registro);
            //dbs.rawQuery("insert into ")
            dbs.close();
            flag=true;
        }
        return  flag;
    }

    public torneoCs consultarUno(String ntorneo){
        torneoCs pd=new torneoCs();
        SQLiteDatabase dbs=adm.getWritableDatabase();

        if(!ntorneo.isEmpty()){
            Cursor fila=dbs.rawQuery("select * from torneosv1a where usuarion = '"+ntorneo+"'",null);
            if(fila.moveToFirst()){
                String Ntorneo, Liga, Categoria;
                int Valor;
                pd.setNtorneo(fila.getString(fila.getColumnIndex("ntorneo")));
                pd.setLiga(fila.getString(fila.getColumnIndex("liga")));
                pd.setCategoria(fila.getString(fila.getColumnIndex("categoria")));
                pd.setValor(fila.getInt(fila.getColumnIndex("valor")));
                dbs.close();
            }
            dbs.close();
        }
        return pd;
    }

    public ArrayList<torneoCs> consultarTodos(){
        ArrayList<torneoCs> pd=new ArrayList<>();

        SQLiteDatabase dbs=adm.getWritableDatabase();
        Cursor cursore=dbs.rawQuery("select * from torneosv1a",null);

        if(cursore.moveToFirst()){
            while(!cursore.isAfterLast()){
                torneoCs ob=new torneoCs();
                ob.setNtorneo(cursore.getString(cursore.getColumnIndex("ntorneo")));
                ob.setLiga(cursore.getString(cursore.getColumnIndex("liga")));
                ob.setCategoria(cursore.getString(cursore.getColumnIndex("categoria")));
                ob.setValor(cursore.getInt(cursore.getColumnIndex("valor")));

                pd.add(ob);
                cursore.moveToNext();

            }
            cursore.close();
            dbs.close();
        }
        dbs.close();

        return pd;
    }
    public ArrayList<equipoCs> consultarTodos(boolean f){
        ArrayList<equipoCs> pd=new ArrayList<>();

        SQLiteDatabase dbs=adm.getWritableDatabase();
        Cursor cursore=dbs.rawQuery("select * from equipov1a",null);

        if(cursore.moveToFirst()){
            while(!cursore.isAfterLast()){
                equipoCs ob=new equipoCs();
                ob.setNequipo(cursore.getString(cursore.getColumnIndex("nequipo")));
                ob.setNcap(cursore.getString(cursore.getColumnIndex("capitan")));
                ob.setCel(cursore.getString(cursore.getColumnIndex("ncelular")));

                pd.add(ob);
                cursore.moveToNext();

            }
            cursore.close();
            dbs.close();
        }
        dbs.close();

        return pd;
    }

    //crud crear leer actualizar eliminar
}
