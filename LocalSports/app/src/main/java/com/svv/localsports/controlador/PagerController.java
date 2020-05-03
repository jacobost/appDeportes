package com.svv.localsports.controlador;

import android.content.res.Resources;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.svv.localsports.MainActivity;
import com.svv.localsports.R;

import java.util.Set;

public class PagerController extends FragmentPagerAdapter {
    int numoftabs;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new home();
            case 1:
                return new map();
            case 2:
                return new user();
            case 3:
                return new chat();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
