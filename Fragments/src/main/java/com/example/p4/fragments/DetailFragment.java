package com.example.p4.fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.p4.R;
import com.example.p4.data.about;

/**
 * Created by Shyam Rokde on 8/5/16.
 */
public class DetailFragment extends Fragment {
    int position = 0;
    TextView tvTitle;
    TextView tvDetails;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            // Get back arguments
            if(getArguments() != null) {
                position = getArguments().getInt("position", 0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.activity_aboutfounder, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Set values for view here
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvDetails = (TextView) view.findViewById(R.id.tvDetails);

        // update view
        tvTitle.setText(about.infoMenu[position]);
        tvDetails.setText(about.infoDetails[position]);
    }

    // Activity is calling this to update view on Fragment
    public void updateView(int position){
        tvTitle.setText(about.infoMenu[position]);
        tvDetails.setText(about.infoDetails[position]);
    }
}
