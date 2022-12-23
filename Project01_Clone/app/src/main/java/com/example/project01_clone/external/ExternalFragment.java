package com.example.project01_clone.external;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project01_clone.R;


public class ExternalFragment extends Fragment {

     ImageView imgv1, imgv2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_external, container, false);

        imgv1 =v.findViewById(R.id.imgv1);
        imgv2 =v.findViewById(R.id.imgv2);
        Glide.with(this).load("https://w.namu.la/s/6d37d2792f61b69511edc288e16598d0722ff0407af67089c0004ddeda7ad7b9bdc0b2e4880db9548efe21f2082a4c34545902a67aaa00eafce75c7f89fcdcb84a0e490db41866fd956891342168fef35435adc1de1f1dbfb849dd15375fd8ed"
            ).into(imgv1);
        Glide.with(this).load("https://item.kakaocdn.net/do/7f552a5d038cc7b0b6f99339bbc330baf43ad912ad8dd55b04db6a64cddaf76d").into(imgv2);

        return  v;
    }
}