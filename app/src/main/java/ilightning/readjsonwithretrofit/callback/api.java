package ilightning.readjsonwithretrofit.callback;

import java.util.List;

import ilightning.readjsonwithretrofit.model.Flower;
import retrofit2.Call;
import retrofit2.http.GET;

///**
// * Created by Hoàng on 6/21/2016.
// */

public interface api {

    @GET("/feeds/flowers.json")
    Call<List<Flower>> List_call_flower();

}
