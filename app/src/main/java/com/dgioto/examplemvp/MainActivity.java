package com.dgioto.examplemvp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = "MainActivity";
    private MainContract.Presenter mPresenter;
    private TextView myTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Создаём Presenter и в аргументе передаём ему this - эта Activity расширяет интерфейс MainContract.View
        mPresenter = new MainPresenter(this);

        myTv = findViewById(R.id.text_View);
        Button mButton = findViewById(R.id.button);

        mButton.setOnClickListener(v -> mPresenter.onButtonWasClicked());
        Log.d(TAG, "onCreate()");
    }

    @Override
    public void showText(String message) {
        myTv.setText(message);
        Log.d(TAG, "showMessage()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
