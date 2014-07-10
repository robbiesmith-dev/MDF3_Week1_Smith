package com.example.smithro1.mdf3_week1_smith;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;


//Robert Smith
//MDF3 Term 1407
//Web Browser
//This will be a Single Activity application that will serve as a Web Browser that can be launched
//via implicit intent through the OS app chooser


public class MyActivity extends Activity {

    private WebView mWebView;
    private EditText mEditText;
    private Button mGoButton;
    private String mURLString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Link member vars with layout counterparts
        mWebView = (WebView)findViewById(R.id.webView);
        mWebView.setWebViewClient(new client());
        mWebView.loadUrl("http://www.google.com");

        mEditText = (EditText)findViewById(R.id.editText);
        mEditText.setHint("www.google.com");

        mGoButton = (Button)findViewById(R.id.goButton);
        mGoButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //load url string - first check string format and format it correctly if user if lazy
                mURLString = mEditText.getText().toString();
                if(mURLString.startsWith("http://www.")){
                    mWebView.loadUrl(mURLString);
                }else if (mURLString.startsWith("www.")){
                    mWebView.loadUrl("http://" + mURLString);
                }else{
                    mWebView.loadUrl("http://www." + mURLString);
                }
               
            }
        });


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
