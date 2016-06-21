package ilightning.readjsonwithretrofit.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import ilightning.readjsonwithretrofit.R;
import ilightning.readjsonwithretrofit.adpater.AdapterFlower;
import ilightning.readjsonwithretrofit.application.Initialize;
import ilightning.readjsonwithretrofit.model.Flower;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///**
// * Created by Hoàng on 6/21/2016.
// */

public class LoadFlower extends AsyncTask<Void, Void, Void> {

    RecyclerView rcFlower;

    private Activity context;
    private static ProgressDialog progress;
    private AdapterFlower adapterFlower;

    public LoadFlower(Activity activity) {
        this.context = activity;
        rcFlower = (RecyclerView) context.findViewById(R.id.rcvFlower);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        showProgressBar();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Call<List<Flower>> listCall = Initialize.API().List_call_flower();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                if (response.isSuccessful()) {
                    Log.d("HoangTV", "response - isSuccessful");
                    List<Flower> flowers = response.body();
                    for (Flower flower : flowers) {
                        Log.d("HoangTV", "ID: " + flower.getProductId() + "");
                        Log.d("HoangTV", "NAME: " + flower.getName());
                        Log.d("HoangTV", "PRICE: " + flower.getPrice() + "");
                        Log.d("HoangTV", "INTRODUCTION: " + flower.getInstructions());
                        Log.d("HoangTV", "PHOTO: " + flower.getPhoto());
                        Log.d("HoangTV", "*********************************");
                    }
                    adapterFlower = new AdapterFlower(flowers);

                    rcFlower.setHasFixedSize(true);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rcFlower.setLayoutManager(layoutManager);
                    rcFlower.setAdapter(adapterFlower);
                } else {
                    Log.d("HoangTV", "response - isError");
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        hideProgressBar();
    }

    public void showProgressBar() {
        progress = new ProgressDialog(context);
        progress.setMessage("Loading...");
        progress.setIndeterminate(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
    }

    public static void hideProgressBar() {
        progress.dismiss();
    }


}
