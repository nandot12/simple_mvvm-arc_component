package com.udacoding.testmvvm.ui.main;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.udacoding.testmvvm.ui.main.model.Data;

public class MainViewModel extends ViewModel {

    Application application ;
    public MainViewModel(Application application) {
        this.application = application;
    }
    // TODO: Implement the ViewModel


    public LiveData<Data> logic(String name){

        MutableLiveData<Data> data = new MutableLiveData<>();

        if(name.isEmpty()){
            data.setValue(null);

            report();
        }
        else{

            Data datas = new Data();
            datas.setInput(name);

            data.setValue(datas);
        }

        return data ;



    }

    public String report(){

        return "tidak boleh kosong";

    }
}
