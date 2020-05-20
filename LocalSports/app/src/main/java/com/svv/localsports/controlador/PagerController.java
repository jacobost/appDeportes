package com.svv.localsports.controlador;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.svv.localsports.controlador.home.home;

public class PagerController extends FragmentPagerAdapter {
    int numoftabs;
    public Fragment fragmentHome;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                fragmentHome = new home();
                return fragmentHome;
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
