package br.inatel.lojaonline.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import br.inatel.lojaonline.R;

/**
 * Created by bccre on 22/06/2016.
 */
public class SettingsFragment extends PreferenceFragment {

    private String title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.fragment_preferences);

        getActivity().setTitle("Configurações");
    }
}
