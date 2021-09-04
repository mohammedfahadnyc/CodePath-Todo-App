package com.john.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String stItemText = getIntent().getStringExtra("item_text");
        EditText eItemText = (EditText) findViewById(R.id.etItemText);
        eItemText.setText(stItemText);
        eItemText.setSelection(stItemText.length());

        itemPosition = getIntent().getIntExtra("item_position", -1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSave(View v) {
        Intent data = new Intent();

        EditText eItemText = (EditText) findViewById(R.id.etItemText);
        data.putExtra("item_text", eItemText.getText().toString());
        data.putExtra("item_position", itemPosition);

        setResult(RESULT_OK, data);
        this.finish();
    }
}
