package ilightning.readjsonwithretrofit.application;

import android.app.Application;
import android.util.Log;

import ilightning.readjsonwithretrofit.callback.api;
import ilightning.readjsonwithretrofit.config.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

///**
// * Created by Hoàng on 6/21/2016.
// */

public class Initialize extends Application {

    private static Initialize initialize;
    private static api mApi;

    @Override
    public void onCreate() {
        super.onCreate();
        if (initialize == null) {
            initialize = this;
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApi = retrofit.create(api.class);
        }

        Log.d("HoangTV", "onCreate() retrofit");
    }

    public static api API() {
        return mApi;
    }

}
