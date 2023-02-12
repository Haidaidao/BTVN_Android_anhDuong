package com.example.btvn_fragment_navbar.Fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.btvn_fragment_navbar.R;
import com.example.btvn_fragment_navbar.databinding.FragmentCartBinding;


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


    static String dataReceive="";

    TextView tv;

    FragmentCartBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);


        binding.tv.setText(dataReceive);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        //Log.i("data","-->" + dataReceive);
        binding.tv.setText(dataReceive);
    }

    public void receiveDatafromHomeFragment(String data) {

        dataReceive=data;
        Log.i("data","-->" + dataReceive);
    }

    String getData() {
        return dataReceive;
    }
}