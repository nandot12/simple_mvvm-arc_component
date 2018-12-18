package com.udacoding.testmvvm.ui.main;

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.udacoding.testmvvm.R;
import com.udacoding.testmvvm.ui.main.model.Data;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    Button btnSubmit ;
    EditText textView ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      //  FactoryMain factoryMain = new FactoryMain(getActivity().getApplication());

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        textView = view.findViewById(R.id.edtName);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mViewModel.logic(textView.getText().toString()).observe(getActivity(), new Observer<Data>() {
                    @Override
                    public void onChanged(@Nullable Data data) {

                        Toast.makeText(getContext(), data.getInput(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }
}
