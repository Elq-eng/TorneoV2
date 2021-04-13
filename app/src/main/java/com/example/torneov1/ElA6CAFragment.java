package com.example.torneov1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ElA6CAFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElA6CAFragment extends Fragment implements LifecycleObserver {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listview;
    private ArrayList<String> names;
    private Handler handler;
    private Runnable runnable;



    public ElA6CAFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ElA6CAFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ElA6CAFragment newInstance(String param1, String param2) {
        ElA6CAFragment fragment = new ElA6CAFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_el_a6_c_a, container, false);
        FloatingActionButton fb =view.findViewById(R.id.idFbnEq);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent pp=new Intent(getActivity().getApplicationContext(),popWindowELA6.class);
                startActivity(new Intent(getActivity().getApplicationContext(),popWindowELA6.class));
            }
        });
        names = new ArrayList<String>();
      /* names.add("Equipo N");
        names.add("Equipo N+1");
        names.add("Equipo N+2");*/
        listview=(ListView) view.findViewById(R.id.idListVwEquip);

        /*ArrayAdapter<String> madapter =new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, names);
        listview.setAdapter(madapter);*/
        mostrarC();
        // Inflate the layout for this fragment
        return  view;//inflater.inflate(R.layout.fragment_el_a6_c_a, container, false);

    }




    public boolean mostrarC(){
        CRUDSql cdDB=new CRUDSql(getActivity().getApplicationContext());
        ArrayList<equipoCs> tn=new ArrayList<>();
        ArrayList<String> nequipoDB=new ArrayList<>();
        equipoCs tnDb=new equipoCs();
        tn=cdDB.consultarTodos(true);
        String nequi;
        if(!tn.isEmpty()){
            for(int i=0; i<tn.size();i++){
                tnDb=tn.get(i);
                nequi=tnDb.getNequipo();
                nequipoDB.add(nequi);
            }

             ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, nequipoDB);
            listview.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();

            return true;
        }else {
            Toast.makeText(getActivity().getApplicationContext(), "NO hay equipos registrados",Toast.LENGTH_SHORT).show();
            return false;
        }

    }

/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mostrarC();
    }
*/
    //TODO: UPDATE DATA
    @Override
    public void onResume() {
        super.onResume();
         mostrarC();
    }


}