package com.example.btvn_fragment_navbar.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.btvn_fragment_navbar.MainActivity;
import com.example.btvn_fragment_navbar.R;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters

    View view;

    Button btn1,btn2,btn3,btn4;
    TextView tvName1,tvName2,tvName3,tvName4;
    String textClick="";

    ISendDataListener mISendDataListener;

    public interface ISendDataListener {
        void sendData(String data);
    }

    MainActivity mainActivity = (MainActivity) getActivity();


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mISendDataListener = (ISendDataListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);

        btn1=view.findViewById(R.id.btnAdd1);
        btn2=view.findViewById(R.id.btnAdd2);
        btn3=view.findViewById(R.id.btnAdd3);
        btn4=view.findViewById(R.id.btnAdd4);

        tvName1=view.findViewById(R.id.tvName1);
        tvName2=view.findViewById(R.id.tvName2);
        tvName3=view.findViewById(R.id.tvName3);
        tvName4=view.findViewById(R.id.tvName4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textClick+=tvName1.getText().toString().trim();
                sendDatatoCartFragment();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textClick+=tvName2.getText().toString().trim();
                sendDatatoCartFragment();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textClick+=tvName3.getText().toString().trim();
                sendDatatoCartFragment();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textClick+=tvName4.getText().toString().trim();
                sendDatatoCartFragment();
            }
        });


        return view;
    }

    void sendDatatoCartFragment() {
        Log.i("data",":    "+textClick);
        mISendDataListener.sendData(textClick);
    }
}