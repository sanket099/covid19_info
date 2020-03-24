package com.example.covid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements recycler_adapter.OnNoteList{
    //TextView tv;
    RecyclerView recyclerView;
    recycler_adapter adapter;
    EditText et;
    ArrayList<cases> modelRecyclerArrayList;
    Button btgo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tv = findViewById(R.id.tv);
        recyclerView = findViewById(R.id.recycler);
        modelRecyclerArrayList = new ArrayList<>();
        et = findViewById(R.id.et);



        Json();

    }
    private void Json(){
        Call<String> call = retrofit_client.getInstance().getapi().summary();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                assert response.body() != null;
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.code()==200) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        writeRecycler(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                System.out.println("fail" + t.getMessage());

            }
        });
    }

    private void writeRecycler(String response){

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);


                modelRecyclerArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("Countries");

                for (int i = 0; i < dataArray.length(); i++) {

                    cases modelRecycler = new cases();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    //modelRecycler.setImgURL(dataobj.getString("imgURL"));
                    modelRecycler.setCountry_name(dataobj.getString("Country"));
                    modelRecycler.setCases(dataobj.getString("TotalConfirmed"));
                    modelRecycler.setDeaths(dataobj.getString("TotalDeaths"));
                    modelRecycler.setRecovered(dataobj.getString("TotalRecovered"));

                    modelRecyclerArrayList.add(modelRecycler);

                }

                adapter = new recycler_adapter(this,modelRecyclerArrayList,this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));



        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("error");
        }

    }

    @Override
    public void OnnoteClick(int position) {
        Intent intent = new Intent(MainActivity.this, com.example.covid.specific.class);
        intent.putExtra("selected", modelRecyclerArrayList.get(position).toString());

        intent.putExtra("select", position);
        intent.putExtra("array", modelRecyclerArrayList);
        //intent.putExtra("note",note);

        //intent.getParcelableArrayListExtra("array",arrayList);
        startActivity(intent);

    }

    public void go(View view) {
        if(et.getText().toString().isEmpty()){
            Toast.makeText(this,"this cannot be empty",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this,com.example.covid.specific.class);
            intent.putExtra("name",et.getText().toString());
            intent.putExtra("flag",1);
            startActivity(intent);
        }


    }
}

