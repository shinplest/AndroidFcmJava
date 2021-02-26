package com.shinplest.fcmjava;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private WebSettings mWebSettings; //웹뷰세팅


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.wb_main);
        mWebSettings = mWebView.getSettings(); //세부 세팅 등록

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부


        String click_action = getIntent().getStringExtra("click_action");

        if (click_action != null) {
            mWebView.loadUrl(click_action);
        } else
            mWebView.loadUrl("https://m.uzumarket.co.kr?cafe_mkt=ue_pfp0617cc35");

        mWebView.setWebChromeClient(new WebChromeClient());

        mWebView.setWebViewClient(new WebViewClientClass());
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL", url);
            view.loadUrl(url);
            return true;
        }
    }

}