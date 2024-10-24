package fr.univpau.convertisseur;

//La classe ButtonListener est une classe qui écoute les événements sur un bouton

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class ButtonListener implements View.OnClickListener {

    Spinner srcUnit;
    Spinner destUnit;
    EditText srcValue;
    EditText destValue;

    public ButtonListener(Spinner srcUnit, Spinner destUnit, EditText srcValue, EditText destValue) {
        this.srcUnit = srcUnit;
        this.destUnit = destUnit;
        this.srcValue = srcValue;
        this.destValue = destValue;
    }

    @Override
    public void onClick(View v) {
        Temperature temperature = new Temperature(srcUnit.getSelectedItemPosition(), destUnit.getSelectedItemPosition(), Double.parseDouble(srcValue.getText().toString()));
        destValue.setText(String.valueOf(temperature.convert()));
    }



}
