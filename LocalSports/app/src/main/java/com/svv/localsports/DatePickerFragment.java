package com.svv.localsports;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {

    private long minMillisDesde1970, maxMillisDesde1970;
    private DatePickerDialog.OnDateSetListener listener;

    public void setFechasMinMax(long min, long max) {
        minMillisDesde1970 = min;
        maxMillisDesde1970 = max;
    }
    public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener listener) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setListener(listener);
        return fragment;
    }

    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    @Override
    @NonNull
    public DatePickerDialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), listener, year, month, day);

        //Opcionalmente llamando a setFechasMinMax se podría escribir sobre minMillis y maxMillis. Si no se escribe o se pone 0 se ignoran.
        if (minMillisDesde1970 > 0) {
            datePickerDialog.getDatePicker().setMinDate(minMillisDesde1970);
        }
        if (maxMillisDesde1970 > 0) {
            datePickerDialog.getDatePicker().setMaxDate(maxMillisDesde1970);
        }

        return datePickerDialog;
    }

}