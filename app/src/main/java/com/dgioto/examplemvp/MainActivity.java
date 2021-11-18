package com.dgioto.examplemvp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

    /*
        - Activity, она же View, в методе onCreate() создаёт экзмпляр Presenter и передаёт ему
        в конструктор себя.
        - Presenter при создании явно получает View и создаёт экзмепляр Repository (его, кстати,
        можно сделать Singleton)
        - При нажатии на кнопку, View стучится презентеру и сообщает: «Кнопка была нажата».
        - Presenter обращается к Repository: «Загрузи мне вот эту шнягу».
        - Repository грузит и отдаёт «шнягу» Presenter’у.
        - Presenter обращается к View: «Вот тебе данные, отрисуй»
     */
public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = "MainActivity";
    private MainContract.Presenter mPresenter;
    private TextView myTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создаём Presenter и в аргументе передаём ему this - эта Activity расширяет
        // интерфейс MainContract.View
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
