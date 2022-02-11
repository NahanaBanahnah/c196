package com.nm.nmitchellc196.Control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nm.nmitchellc196.Database.Repository;
import com.nm.nmitchellc196.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository repo = new Repository(getApplication());
//        Term term1 = new Term(1, "Term 1", "2022-02-01", "2022-03-01");
//        Term term2 = new Term(2, "Term 2", "2022-03-01", "2022-04-01");
//        Term term3 = new Term(3, "Term 3", "2022-04-01", "2022-05-01");
//        Term term4 = new Term(4, "Term 4", "2022-05-01", "2022-06-01");
//
//        repo.insert(term1);
//        repo.insert(term2);
//        repo.insert(term3);
//        repo.insert(term4);

        Button mEnter = findViewById(R.id.btnEnter);
        mEnter.setOnClickListener(mEnterClick);

    }

    private View.OnClickListener mEnterClick = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, TermList.class);
            startActivity(intent);
        }
    };
}