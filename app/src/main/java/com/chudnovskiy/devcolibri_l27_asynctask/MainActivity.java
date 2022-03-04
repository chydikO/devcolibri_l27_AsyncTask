package com.chudnovskiy.devcolibri_l27_asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            new ProgressBarAsyncTask().execute();
        });
    }

    class ProgressBarAsyncTask extends AsyncTask<Void, Integer, Void> {

        private int progressBarValue = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
            textView.setText(values[0].intValue() + "%");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (progressBarValue < 100) {
                progressBarValue++;
                publishProgress(progressBarValue);
                SystemClock.sleep(200);
            }
            return null;
        }
    }
}