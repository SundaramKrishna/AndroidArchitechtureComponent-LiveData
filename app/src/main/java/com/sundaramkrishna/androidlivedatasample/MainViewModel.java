package com.sundaramkrishna.androidlivedatasample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Object> objectMutableLiveData;
    private int count = 0;
    public MutableLiveData<Object> getCount(){
        if (objectMutableLiveData == null){
            objectMutableLiveData = new MutableLiveData<>();
            incrementValue();
        }

        return objectMutableLiveData;

    }

    public void incrementValue() {
        if (objectMutableLiveData == null){
            throw new NullPointerException("Call getCount before increment");
        }
        count++;
        objectMutableLiveData.setValue(count);
    }

}
