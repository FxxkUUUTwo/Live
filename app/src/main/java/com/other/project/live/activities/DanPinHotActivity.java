package com.other.project.live.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.other.project.live.R;

public class DanPinHotActivity extends AppCompatActivity {
    private static final String TAG = DanPinHotActivity.class.getSimpleName();
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dan_pin_hot);

        String path = getIntent().getStringExtra("path");
        iniView(path);
    }

    private void iniView(String path) {


        mWebView = (WebView) findViewById(R.id.mywebview);
        WebSettings settings = mWebView.getSettings();

        settings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());


        Log.e(TAG, "sendWeb: " + path);
        mWebView.loadUrl(path);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == event.KEYCODE_BACK) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
