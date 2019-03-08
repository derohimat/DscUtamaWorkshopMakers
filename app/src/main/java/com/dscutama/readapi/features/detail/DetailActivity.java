package com.dscutama.readapi.features.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dscutama.readapi.R;
import com.dscutama.readapi.data.model.response.Record;

import java.io.Serializable;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private Record record;
    private Toolbar toolbar;
    private TextView txtAddress, txtPhone, txtNis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        txtNis = findViewById(R.id.txt_nis);
        txtAddress = findViewById(R.id.txt_address);
        txtPhone = findViewById(R.id.txt_phone);

        setSupportActionBar(toolbar);
        record = new Record();

        Intent intent = getIntent();
        record = intent.getParcelableExtra("user");

        toolbar.setTitle(record.getName());
        toolbar.setSubtitle(record.getNis()+"");
        txtNis.setText("NIS : " + record.getNis());
        txtAddress.setText("Alamat : " + record.getAddress());
        txtPhone.setText("No Telepon : " + record.getPhone());
    }
}
