package com.example.btvn_fragment_navbar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.btvn_fragment_navbar.R;



public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }

    View view;
    TextView tv;
    public static String dataReceive="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);

        tv=view.findViewById(R.id.tv);
        Log.i("data","-->" + dataReceive);
        tv.setText(dataReceive);
        return view;
    }

    public void receiveDatafromHomeFragment(String data) {

        dataReceive=data;
        //tv=view.findViewById(R.id.tv);
        //Log.i("data","-->" + dataReceive);
        //tv.setText(data);

    }

    String getData() {
        return dataReceive;
    }
}