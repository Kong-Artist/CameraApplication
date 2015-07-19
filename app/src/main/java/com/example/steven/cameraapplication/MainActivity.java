package com.example.steven.cameraapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity implements CameraFragment.OnFragmentInteractionListener {

    private Fragment mFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        mFragment = new CameraFragment();

        ft.add(R.id.fragment_container, mFragment).commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((CameraFragment) mFragment).releaseCamera();              // release the camera immediately on pause event
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
