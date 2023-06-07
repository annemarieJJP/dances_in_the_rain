package com.example.dances_in_the_rain.activities.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dances_in_the_rain.R;
import com.example.dances_in_the_rain.entities.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class createnoteactivity extends AppCompatActivity {


    private EditText inputnotetitle, inputnotesubtitle, inputnotetext;
    private TextView TextDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnoteactivity);
        ImageView imageback = findViewById(R.id.imageback);
        imageback.setOnClickListener((v)-> {
                onBackPressed();});

        inputnotetitle = findViewById(R.id.inputnotetitle);
        inputnotesubtitle = findViewById(R.id.inputnotesubtitle);
        inputnotetext = findViewById(R.id.inputnote);
        TextDateTime = findViewById(R.id.TextDateTime);

        TextDateTime.setText(

                new SimpleDateFormat("EEEE,dd MMMM yyyy HH:mm a", Locale.getDefault()).format(new Date())
        );
        ImageView imageSave = findViewById(R.id.imagesave);
        imageSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                saveNote();
            }
        });
    }

    private void saveNote() {
        if (inputnotetitle.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Diary title shouldn't be empty", Toast.LENGTH_SHORT).show();
            return;
        } else if (inputnotesubtitle.getText().toString().trim().isEmpty() && inputnotetext.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Diary shouldn't be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        final Note note = new Note();
        note.setTitle(inputnotetitle.getText().toString());
        note.setSubtitle(inputnotesubtitle.getText().toString());
        note.setNotetext(inputnotetext.getText().toString());
        note.setDatetime(TextDateTime.getText().toString());



        /*@SuppressLint("StaticFieldLeak")
        class SaveNoteTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                NotesDatabase.getDatabase(getApplicationContext()).noteDao.insertNote(note);
                return null;
            }

            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        }
        new SaveNoteTask().execute();
    }*/
}}

