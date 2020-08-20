package com.mpaas.demo.cdp;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.mpaas.demo.*;

import com.alipay.mobile.antui.basic.AUTitleBar;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.mpaas.nebula.adapter.api.MPNebula;
import com.mpaas.nebula.adapter.api.MpaasNebulaDownloadCallback;


/**
 * 这个类主要是为了拉起h5 页面而已
 * https://90000001.h5app.com/index.html
 */
public class H5AppZoneActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_activity_h5app);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText("H5 App验证");
        findViewById(R.id.mcdp_btn_h5app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickmcdp_btn_h5app();
            }
        });
        findViewById(R.id.mcdp_btn_h5app_download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickMcdpH5AppDownload();
            }
        });
    }

    private void onClickMcdpH5AppDownload() {
        MPNebula.downloadApp("90000001",new MpaasNebulaDownloadCallback(){
            @Override
            public void onAppHasDownloaded(String appId, String version) {
                super.onAppHasDownloaded(appId, version);
                Log.d("H5AppZoneActivity",appId+version);
            }
        });

    }

    private void onClickmcdp_btn_h5app() {
        openApp("90000001");
    }

    private void openApp(String appId) {
        MPNebula.startApp(appId);
    }

    public static void start(Application application) {
        Intent intent = new Intent();
        intent.setClass(application, H5AppZoneActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        application.startActivity(intent);
    }
}
