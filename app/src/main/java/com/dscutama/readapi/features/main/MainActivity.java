package com.dscutama.readapi.features.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dscutama.readapi.R;
import com.dscutama.readapi.data.model.response.Record;
import com.dscutama.readapi.data.remote.ApiService;
import com.dscutama.readapi.data.remote.UtilsApi;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainMvpView{

    private Toolbar toolbar;
    private RecyclerView recyclerUsers;
    private MainAdapter mainAdapter;
    private ApiService apiService;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        recyclerUsers = findViewById(R.id.recycler_name);
        setSupportActionBar(toolbar);

        setUpRecycler();
    }

    void setUpRecycler(){
        mainAdapter = new MainAdapter(this);
        recyclerUsers.setLayoutManager(new LinearLayoutManager(this));
        recyclerUsers.setHasFixedSize(true);
        recyclerUsers.setItemAnimator(new DefaultItemAnimator());

        apiService = UtilsApi.getApiService(this);
        mainPresenter = new MainPresenter(this, apiService, this);
        mainPresenter.getUsers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showData(List<Record> list) {
        mainAdapter.setData(list);
        recyclerUsers.setAdapter(mainAdapter);
    }
}
