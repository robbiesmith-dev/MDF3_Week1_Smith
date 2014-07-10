package com.example.smithro1.mdf3_week1_smith;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


//Robert Smith
//MDF3 Term 1407
//Web Browser
//This will be a Single Activity application that will serve as a Web Browser


public class MyActivity extends Activity {

    private WebView mWebView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Link member vars with layout counterparts
        mWebView = (WebView)findViewById(R.id.webView);
        mEditText = (EditText)findViewById(R.id.editText);

        mWebView.setWebViewClient(new client());
        mWebView.loadUrl("http://www.google.com");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    //Subclass WebViewClient to prevent app from launching default browser
    class client extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);

            return true;
        }
    }
}
