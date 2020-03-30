package com.mpaas.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mpaas.demo.cdp.CdpLocationActivity;
import com.mpaas.demo.cdp.CdpMicroApp;
import com.mpaas.demo.cdp.CdpMultiStyleActivity;
import com.mpaas.demo.cdp.CdpTestActivity;
import com.mpaas.demo.cdp.FeatureActivity;

public class CdpPortalActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portal_actvitity);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_feature).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeatureActivity.startActivity(getBaseContext());
            }
        });
        findViewById(R.id.btn_locaiton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CdpLocationActivity.startActivity(getBaseContext());
            }
        });
        findViewById(R.id.btn_style).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CdpMultiStyleActivity.startActivity(getBaseContext());
            }
        });
        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CdpTestActivity.startActivity(getBaseContext());
            }
        });
        findViewById(R.id.btn_h5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CdpMicroApp.startH5();
            }
        });
        findViewById(R.id.btn_case).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CdpTestActivity.onClickCase(getApplicationContext());
            }
        });


    }
}
