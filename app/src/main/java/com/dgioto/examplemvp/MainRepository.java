package com.dgioto.examplemvp;

import android.util.Log;


//просто загрузк - выгрузка данных.
public class MainRepository implements MainContract.Repository{

    private static final String TAG = "MainRepository";

    @Override
    public String loadMessage() {
        Log.d(TAG, "loadMessage()");
        /*
           Здесь обращаемся к БД или сети.
          Я специально ничего не пишу, чтобы не загромождать пример
          DBHelper'ами и прочими не относяшимеся к теме объектами.
          Поэтому я буду возвращать строку Сосисочная =)
        */
        return "Сосисочная у Лёхи";
    }
}
