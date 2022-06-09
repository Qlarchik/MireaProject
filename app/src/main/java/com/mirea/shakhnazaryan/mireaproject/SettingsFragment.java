package com.mirea.shakhnazaryan.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText nameText;
    private EditText ageText;
    private EditText universityText;
    private Button saveButton;
    private SharedPreferences preferences;
    final String SAVED_NAME = "saved_name";
    final String SAVED_AGE = "saved_age";
    final String SAVED_UNIVERSITY = "saved_university";

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        nameText = view.findViewById(R.id.editName);
        ageText = view.findViewById(R.id.editAge);
        universityText = view.findViewById(R.id.editUniversity);
        saveButton = view.findViewById(R.id.saveButton2);
        saveButton.setOnClickListener(this::onCLickSaveSettings);
        preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        loadSettings();
        return view;
    }

    private void onCLickSaveSettings(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_NAME, nameText.getText().toString());
        editor.putString(SAVED_AGE, ageText.getText().toString());
        editor.putString(SAVED_UNIVERSITY, universityText.getText().toString());
        editor.apply();
    }

    private void loadSettings () {
        try {
            nameText.setText(preferences.getString(SAVED_NAME, null));
            ageText.setText(preferences.getString(SAVED_AGE, null));
            universityText.setText(preferences.getString(SAVED_UNIVERSITY, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}