package com.next.sheharyar.recylerviewudacityexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.next.sheharyar.recylerviewudacityexample.Adapters.GreenAdapter;
import com.next.sheharyar.recylerviewudacityexample.Interfaces.ListItemClickListener;

public class RecyclerViewActivity extends AppCompatActivity implements ListItemClickListener {

    RecyclerView mRecylerView;
    private final String TAG = RecyclerViewActivity.class.getName();
    private GreenAdapter mAdapter;
    private static final int mNumberOfItems = 50;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecylerView = (RecyclerView) findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecylerView.setLayoutManager(layoutManager);
        mRecylerView.setHasFixedSize(true);
        mAdapter = new GreenAdapter(mNumberOfItems, this);
        mRecylerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.numbers_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_search) {

            Toast.makeText(this, "You clicked on Referesh button", Toast.LENGTH_SHORT).show();
            return true;
        }

        return onOptionsItemSelected(item);
    }

    @Override
    public void onItemClicked(int clickedItemIndex) {

        String message = "Item #" + clickedItemIndex + "clicked.";
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
