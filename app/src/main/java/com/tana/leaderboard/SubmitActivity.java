package com.tana.leaderboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SubmitActivity extends AppCompatActivity {
    EditText mFirstName;
    EditText mLastName;
    EditText mEmailAddress;
    EditText mGithubLink;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        mFirstName = (EditText) findViewById(R.id.first_name);
        mLastName = (EditText) findViewById(R.id.last_name);
        mEmailAddress = (EditText) findViewById(R.id.email);
        mGithubLink = (EditText) findViewById(R.id.github_link);
        mButton = (Button) findViewById(R.id.submit_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmitVerifiedDialog dialog = new SubmitVerifiedDialog(mFirstName.getText().toString(),
                        mLastName.getText().toString(), mEmailAddress.getText().toString(),
                        mGithubLink.getText().toString());
                dialog.show(getSupportFragmentManager(), "Example");
            }
        });
    }
}