package com.mjxx.speechdemo_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mjxx.speechlibsnative.mjxx.sdk.Config;
import com.mjxx.speechlibsnative.mjxx.sdk.SpeechSDK;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config config = new Config();
                config.setShowLog(true);  //是否打印日志
                //以下参数由服务方提供：
                config.setAsrServerUrl("http://182.61.15.84:8090/v2"); // 语音识别服务器地址
                config.setTtsServerUrl("http://182.61.15.84:8802/");  // 语音合成服务器地址
                config.setWebServerUrl("http://47.106.235.8:8889/#/"); //web host
                SpeechSDK.startSpeech(v.getContext(),config);
            }
        });
    }
}