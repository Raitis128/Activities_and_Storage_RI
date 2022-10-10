package com.example.androidstorage_app_ri;

import static com.example.androidstorage_app_ri.Constants.NOTE_ID;
import static com.example.androidstorage_app_ri.Constants.NOTE_KEY;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {

    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        Button submitButton = findViewById(R.id.btnSubmit);
        EditText editText = findViewById(R.id.editText);

        Intent intent = getIntent();

        noteId = intent.getIntExtra(NOTE_ID, -1);
        if (noteId != -1) {
            editText.setText(MainActivity.notes.get(noteId));
        } else {

            MainActivity.notes.add("");
            noteId = MainActivity.notes.size() - 1;
            MainActivity.arrayAdapter.notifyDataSetChanged();

        }
    }
}