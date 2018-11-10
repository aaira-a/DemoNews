package com.example.azama.demonews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView title;
    WebView content;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final String id = getIntent().getExtras().getString("id");
        title = (TextView) findViewById(R.id.title);
        content = (WebView)findViewById(R.id.content);
        content.setWebViewClient(new WebViewClient());
        content.getSettings().setJavaScriptEnabled(true);
        content.getSettings().setDomStorageEnabled(true);
        content.getSettings().setBuiltInZoomControls(true);
        content.getSettings().setDisplayZoomControls(false);
        content.setOverScrollMode(WebView.OVER_SCROLL_NEVER);

        progressDialog = new ProgressDialog(DetailsActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        content.loadUrl("http://mnurdin.com/?p="+id);
        progressDialog.dismiss();
    }
}
