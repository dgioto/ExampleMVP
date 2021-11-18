package com.dgioto.examplemvp;

import android.util.Log;

    /*
        Presenter живёт до тех пор пока живёт его View, при разработки
        сложных пользовательских сценариев, советую дублировать все колбеки View
        в Presenter’e и вызывать их в соответствующие моменты,
        дублируя ЖЦ Activity/Fragment, чтобы вовремя понять что нужно сделать
        с теми данными, которые висят в данный момент в «прослойке».
 */
public class MainPresenter implements MainContract.Presenter{

    private static final String TAG = "MainPresenter";

    //Компоненты MVP приложения
    private final MainContract.View mView;
    private final MainContract.Repository mRepository;

    /* Обрати внимание на аргументы конструктора - мы передаем экземпляр View,
    а Repository просто создаём конструктором.
    */
    public MainPresenter(MainContract.View mView){
        this.mView = mView;
        this.mRepository = new MainRepository();
        Log.d(TAG, "Constructor");
    }

    //View сообщает, что кнопка была нажата
    @Override
    public void onButtonWasClicked() {
        //Сообщение
        String message = mRepository.loadMessage();
        mView.showText(message);
        Log.d(TAG, "onButtonWasClicked()");
    }

    @Override
    public void onDestroy() {
        /*
             Если бы мы работали например с RxJava, в этом классе стоило бы отписываться от подписок
             Кроме того, при работе с другими методами асинхронного андроида,здесь мы боремся с утечкой контекста
        */
        Log.d(TAG, "onDestroy()");
    }
}
