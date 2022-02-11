package com.nm.nmitchellc196.Control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nm.nmitchellc196.Database.Repository;
import com.nm.nmitchellc196.Entity.Term;
import com.nm.nmitchellc196.R;

import java.util.List;

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        Repository repo = new Repository(getApplication());
        List<Term> terms = repo.getAllTerms();

        RecyclerView recyclerView = findViewById(R.id.termCecycleView);
        final TermAdapter adapter = new TermAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setTerms(terms);

        FloatingActionButton mAddButton = findViewById(R.id.addButton);
        mAddButton.setOnClickListener(mAddButtonClick);
    }

    private View.OnClickListener mAddButtonClick = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(TermList.this, TermDetail.class);
            intent.putExtra("case", "add");
            startActivity(intent);
        }
    };

}