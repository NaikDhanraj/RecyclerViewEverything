package com.dssp.recyclervieweverything.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dssp.recyclervieweverything.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String LOG_TAG = MainActivity.class.getSimpleName();
    private Context context = MainActivity.this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSimplerecyclerview).setOnClickListener(this);
        findViewById(R.id.btnSwipableRv).setOnClickListener(this);
        findViewById(R.id.btnMultipleRV).setOnClickListener(this);
        findViewById(R.id.btnInfiniteRV).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnSimplerecyclerview:
                Intent intent = new Intent(context,SimpleRecyclerViewActivity.class);
                startActivity(intent);
                break;

            case R.id.btnSwipableRv:

                Intent intent1 = new Intent(context,SwipeableRecyclerViewActivity.class);
                startActivity(intent1);
                break;

            case R.id.btnMultipleRV:
                Intent intent2 = new Intent(context,MultipleLayoutRecyclerView.class);
                startActivity(intent2);
                break;

            case R.id.btnInfiniteRV:
                Intent intent3= new Intent(context,InfiniteRvActivity.class);
                startActivity(intent3);
                break;
        }

    }
}
