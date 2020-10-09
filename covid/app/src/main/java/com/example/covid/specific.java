package com.example.covid;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class specific extends AppCompatActivity {
    TextView date, country, case_number, status;
    Button show_map;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific);

        date = findViewById(R.id.date);
        country = findViewById(R.id.country);
        case_number = findViewById(R.id.case_number);
        status = findViewById(R.id.status);
        show_map = findViewById(R.id.show_map);

        final int flag = Objects.requireNonNull(getIntent().getExtras()).getInt("flag");
        if(flag == 1){
            spec2();
        }
        else{
            spec();
        }



    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void spec2() {

        final int select = Objects.requireNonNull(getIntent().getExtras()).getInt("select");
        final ArrayList<cases> list = getIntent().getParcelableArrayListExtra("array");
        assert list != null;
        Call<List<specific_case>> call = retrofit_client.getInstance().getapi().spec(getIntent().getExtras().getString("name"));
        call.enqueue(new Callback<List<specific_case>>() {
            @Override
            public void onResponse(@NonNull Call<List<specific_case>> call, @NonNull Response<List<specific_case>> response) {
                if (response.code() != 200) {
                    //System.out.println("error "+response.body());
                    System.out.println("error");
                    return;

                }
                System.out.println("succ");
                final List<specific_case> list1 = response.body();
                assert list1 != null;
                System.out.println("succ " + list1);
                Collections.reverse(list1);

                country.setText(list1.get(0).getCountry());
                date.setText(list1.get(0).getDate());
                case_number.setText(list1.get(0).getCases());
                status.setText(list1.get(0).getStatus());
                System.out.println("ok "+list1.get(0).getCountry());
                final Double lat = list1.get(0).getLat();
                final Double longi = list1.get(0).getLongi();
                show_map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(specific.this,com.example.covid.MapsActivity.class);
                        intent.putExtra("lat",lat);
                        intent.putExtra("longi",longi);
                        intent.putExtra("country",country.getText().toString());
                        intent.putExtra("cases",case_number.getText().toString());
                        startActivity(intent);
                    }
                });
                //JSONObject dataobj = list1.get(0);
            }

            @Override
            public void onFailure(@NonNull Call<List<specific_case>> call, @NonNull Throwable t) {
                System.out.println("fail2 " + t.getMessage());

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void spec() {
        final int select = Objects.requireNonNull(getIntent().getExtras()).getInt("select");
        final ArrayList<cases> list = getIntent().getParcelableArrayListExtra("array");
        assert list != null;
        Call<List<specific_case>> call = retrofit_client.getInstance().getapi().spec(list.get(select).getCountry_name());
        call.enqueue(new Callback<List<specific_case>>() {
            @Override
            public void onResponse(@NonNull Call<List<specific_case>> call, @NonNull Response<List<specific_case>> response) {
                if (response.code() != 200) {
                    //System.out.println("error "+response.body());
                    System.out.println("error");
                    return;

                }
                System.out.println("succ");
                List<specific_case> list1 = response.body();
                assert list1 != null;
                System.out.println("succ " + list1);
                Collections.reverse(list1);

                country.setText(list1.get(0).getCountry());
                date.setText(list1.get(0).getDate());
                case_number.setText(list1.get(0).getCases());
                status.setText(list1.get(0).getStatus());
                System.out.println("ok "+list1.get(0).getCountry());
                final Double lat = list1.get(0).getLat();
                final Double longi = list1.get(0).getLongi();
                show_map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(specific.this,com.example.covid.MapsActivity.class);
                        intent.putExtra("lat",lat);
                        intent.putExtra("longi",longi);
                        intent.putExtra("country",country.getText().toString());
                        intent.putExtra("cases",case_number.getText().toString());
                        startActivity(intent);
                    }
                });

                //JSONObject dataobj = list1.get(0);
            }

            @Override
            public void onFailure(@NonNull Call<List<specific_case>> call, @NonNull Throwable t) {
                System.out.println("fail2 " + t.getMessage());

            }
        });
    }

    /*public void setup(List<String> response) {


        JSONObject obj = null;
        try {
            //obj = new JSONObject(response);
            obj = new JSONObject(Arrays.toString(response.toArray()));
            JSONArray dataArray  =  obj.getJSONArray("");
            JSONObject dataobj = dataArray.getJSONObject(dataArray.length());

            country.setText(dataobj.getString("Country"));
            status.setText(dataobj.getString("Status"));
            date.setText(dataobj.getString("Date"));
            case_number.setText(dataobj.getString("Cases"));

            System.out.println("success ");
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("fail" + e.getMessage());
        }


    }
    }*/
}

