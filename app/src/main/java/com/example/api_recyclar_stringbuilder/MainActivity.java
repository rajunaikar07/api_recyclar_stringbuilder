package com.example.api_recyclar_stringbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String baseUrl;
     RequestQueue queue;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    JsonModel jsonModel;
   JsonAdapter jsonAdapter;
   List<JsonModel>jsonModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.JsonRecyclerList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        queue= Volley.newRequestQueue(this);

        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);

        baseUrl=getResources().getString(R.string.placeholder_api);

        jsonAdapter=new JsonAdapter(this,jsonModelList);
        recyclerView.setAdapter(jsonAdapter);

        loadMethod(baseUrl);

    }catch (Exception e) {
            e.printStackTrace();
        }
        }

    private void loadMethod(String baseUrl) {

        progressDialog.show();
        progressDialog.setMessage("Fetching Api Data!....");

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, baseUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressDialog.dismiss();

                for(int i=0;i< response.length();i++)
                {

                    try {
                        JSONObject jsonObject= response.getJSONObject(i);
                        StringBuilder id= new StringBuilder(jsonObject.getString("id"));
                        StringBuilder name= new StringBuilder(jsonObject.getString("Name"));
                        StringBuilder mobile= new StringBuilder(jsonObject.getString("Mobile"));
                        StringBuilder datainfo= new StringBuilder(jsonObject.getString("DateInfo"));
                        StringBuilder password= new StringBuilder(jsonObject.getString("Password"));
                        StringBuilder email= new StringBuilder(jsonObject.getString("Email"));


//                        int userId=jsonObject.getInt("userId");
//                        int id=jsonObject.getInt("id");
//                        StringBuilder title= new StringBuilder(jsonObject.getString("title"));
//                        StringBuilder body= new StringBuilder(jsonObject.getString("body"));

                        jsonModel=new JsonModel(id,name,mobile,datainfo,password,email);
                        jsonModelList.add(jsonModel);
                        jsonAdapter.notifyDataSetChanged();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

                Toast.makeText(MainActivity.this, ""+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);

    }
}