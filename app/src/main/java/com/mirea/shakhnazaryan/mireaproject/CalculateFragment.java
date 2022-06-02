package com.mirea.shakhnazaryan.mireaproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText editText1;
    private EditText editText2;
    private TextView textView;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivision;

    public CalculateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculateFragment newInstance(String param1, String param2) {
        CalculateFragment fragment = new CalculateFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        editText1 = view.findViewById(R.id.editText1);
        editText2 = view.findViewById(R.id.editText2);
        buttonPlus = view.findViewById(R.id.buttonPlus);
        buttonMinus = view.findViewById(R.id.buttonMinus);
        buttonMultiply = view.findViewById(R.id.buttonMultiply);
        buttonDivision = view.findViewById(R.id.buttonDivision);
        textView = view.findViewById(R.id.textView4);
        calculate(view, textView, buttonPlus);
        calculate(view, textView, buttonMinus);
        calculate(view, textView, buttonMultiply);
        calculate(view, textView, buttonDivision);
        return view;
    }

    public void calculate(View view, TextView textView, Button button) {
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                float number1 = 0;
                float number2 = 0;
                float result = 0;
                try {
                    number1 = Float.parseFloat(editText1.getText().toString());
                    number2 = Float.parseFloat(editText2.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast toast = Toast.makeText(getActivity(), "It's not a number, try again!", Toast.LENGTH_LONG);
                    toast.show();
                }
                switch (view.getId()) {
                    case R.id.buttonPlus:
                        result = number1 + number2;
                        break;
                    case R.id.buttonMinus:
                        result = number1 - number2;
                        break;
                    case R.id.buttonMultiply:
                        result = number1 * number2;
                        break;
                    case R.id.buttonDivision:
                        result = number1 / number2;
                        break;
                    default:
                        break;
                }
                textView.setText("result: " + result);
            }
        });
    }
}