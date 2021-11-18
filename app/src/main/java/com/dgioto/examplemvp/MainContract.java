package com.dgioto.examplemvp;

    /*
        Пока что мы просто выделяем 3 компонента нашего
        будущего приложения и что они будут делать.
     */

public interface MainContract {
    interface View {
        void showText(String message);
    }

    interface Presenter {
        void onButtonWasClicked();
        void onDestroy();
    }

    interface Repository {
        String loadMessage();
    }
}
