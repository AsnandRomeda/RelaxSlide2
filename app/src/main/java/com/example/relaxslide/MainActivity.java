package com.example.relaxslide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.net.URI;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText editTextStr, editTextNum;
    Button btnSave, btnLoad;
    SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStr = (EditText) findViewById(R.id.editTextStr);
        editTextNum = (EditText) findViewById(R.id.editTextNum);

        btnSave = (Button) findViewById(R.id.save);
        btnSave.setOnClickListener((View.OnClickListener) this);

        btnLoad = (Button) findViewById(R.id.load);
        btnLoad.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                saveData();
                break;
            case R.id.load:
                loadData();
                break;
            default:
                break;
        }
    }

    void saveData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(editTextNum.getText().toString(), editTextStr.getText().toString());
//        editor.putInt(editTextStr.getText().toString(), Integer.parseInt(editTextNum.getText().toString()));
        editor.commit();
        //Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        editTextNum.setText("");editTextStr.setText("");
    }
    String savedText;
    void loadData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String n_record=editTextNum.getText().toString();
        savedText = sharedPreferences.getString(n_record, "");
//        Integer savedNum = sharedPreferences.getInt(editTextStr.getText().toString(), 0);
        //editTextStr.setText(savedText);
        editTextStr.setText(savedText);
//        Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show();
    }

    public void play(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("myNote", savedText);
        startActivity(intent);


    }


/*    public void pause(View view) {
    }

    public void stop(View view) {
    }*/
/*

    Intent intent = new Intent(this, MainActivity2.class);
    public <EditPhoto> void onClick2 (View view) {
        EditText userEditText = (EditText) findViewById(R.id.счастье);
        EditPhoto giftEditText = (EditPhoto) findViewById (R.drawable.dolphin, R.drawable.sun, R.drawable.sea);

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        intent.putExtra("счастье", userEditText.getText().toString());

        intent.putExtra("dolphin","sun","sea");((EditText) giftEditText).getText().toString();
        startActivity(intent);


    }

    private void findViewById(int dolphin, int sun, int sea) {
    }
*/

}
