package com.dycode.edu.actors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
//import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_actors )
    RecyclerView listActors;

    MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );
        ButterKnife.bind (this);

        adapter = new MainAdapter();
        listActors.setLayoutManager(new LinearLayoutManager(this));
        listActors.setAdapter(adapter);
        listActors.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        RestClient.getActorsService().getActors().enqueue(new Callback<ActorsResponse>() {
            @Override
            public void onResponse(Call<ActorsResponse> call, Response<ActorsResponse> response) {
                adapter.listActors.addAll(response.body().getActors());
                adapter.notifyDataSetChanged();
            }
            
            @Override
            public void onFailure(Call<ActorsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(),
                Toast. LENGTH_SHORT ).show();
            }
        });
    }

}

