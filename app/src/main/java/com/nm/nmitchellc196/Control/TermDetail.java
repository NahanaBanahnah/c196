package com.nm.nmitchellc196.Control;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import com.nm.nmitchellc196.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TermDetail extends AppCompatActivity {

    //Intent Extras
    private int termId;
    private String viewCase;
    private String termName;
    private String startDate;
    private String endDate;

    //Views
    private Button startButton;
    private Button endDateButton;
    private TextView startDateView;
    private TextView endDateView;
    private TextView termNameView;
    private EditText termNameInput;

    //Date Pickers
    final String dateFormat = "MM/dd/yy";

    DatePickerDialog.OnDateSetListener startDateDialog;
    DatePickerDialog.OnDateSetListener endDateDialog;

    Calendar calendarStart = Calendar.getInstance();
    Calendar calendarEnd = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //get the intents to pass around
        termId = getIntent().getIntExtra("termID", -1);
        viewCase = getIntent().getStringExtra("case");
        termName = getIntent().getStringExtra("termName");
        startDate = getIntent().getStringExtra("startDate");
        endDate = getIntent().getStringExtra("endDate");

        switch(viewCase.toString()) {
            case "add":
                setContentView(R.layout.activity_term_edit);
                this.initAdd();
                break;
            case "edit":
                setContentView(R.layout.activity_term_edit);
                this.initEdit();
                break;
            case "view":
                setContentView(R.layout.activity_term_view);
                this.initView();
                break;
        }

        startDateView = findViewById(R.id.startDateText);
        endDateView = findViewById(R.id.endDateText);

        if(startDate == null) {
            startDate = "MM/DD/YY";
        }

        if(endDate == null) {
            endDate = "MM/DD/YY";
        }

        startDateView.setText(startDate);
        endDateView.setText(endDate);

        startDateDialog = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendarStart.set(Calendar.YEAR, year);
                calendarStart.set(Calendar.MONTH, month);
                calendarStart.set(Calendar.DAY_OF_MONTH, day);

                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
                updateStartLabel();
            }
        };

        endDateDialog = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendarEnd.set(Calendar.YEAR, year);
                calendarEnd.set(Calendar.MONTH, month);
                calendarEnd.set(Calendar.DAY_OF_MONTH, day);

                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
                updateEndLabel();
            }
        };

    }

    private void initAdd() {
        setTitle("Add Term");
        initDatePickers();
    }

    private void initView() {
        setTitle("Term Details");
        termNameView = findViewById(R.id.termNameText);
        termNameView.setText(termName);
    }

    private void initEdit() {
        setTitle("Edit Term");
        termNameInput = findViewById(R.id.termNameText);
        termNameInput.setText(termName);
        initDatePickers();
    }

    private void initDatePickers() {
        startButton = findViewById(R.id.startDateButton);
        endDateButton = findViewById(R.id.endDateButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(TermDetail.this, startDateDialog, calendarStart.get(Calendar.YEAR), calendarStart.get(Calendar.MONTH), calendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        endDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(TermDetail.this, endDateDialog, calendarEnd.get(Calendar.YEAR), calendarEnd.get(Calendar.MONTH), calendarEnd.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void updateStartLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        startDateView.setText(sdf.format(calendarStart.getTime()));
    }

    public void updateEndLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        endDateView.setText(sdf.format(calendarEnd.getTime()));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if(viewCase.contains("view")) {
            getMenuInflater().inflate(R.menu.term_detail, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_term_list, menu);
        }

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "text from notes field");
                sendIntent.putExtra(Intent.EXTRA_TITLE, "Message Title");
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                break;

            case R.id.edit:
                Intent intent = new Intent(this, TermDetail.class);
                intent.putExtra("case", "edit");
                intent.putExtra("termID", termId);
                intent.putExtra("termName", termName);
                intent.putExtra("startDate", startDate);
                intent.putExtra("endDate", endDate);
                this.startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}