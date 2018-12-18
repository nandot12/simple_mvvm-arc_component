package com.udacoding.testmvvm.ui.main;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class FactoryMain implements ViewModelProvider.Factory {

    Application application ;

    public FactoryMain(Application application) {
        this.application = application ;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(application);
    }
}
