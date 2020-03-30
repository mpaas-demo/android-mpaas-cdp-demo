package com.mpaas.demo.cdp;
import com.mpaas.demo.*;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.mpaas.cdp.CdpAdvertisementService;
import com.mpaas.cdp.structure.SpaceInfo;

import java.util.HashMap;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.request_start_up_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request_start_up_page();
            }
        });

        doSplash();

    }

    /**
     *
     *  展示开屏页面
     */

    private void doSplash() {
        final CdpAdvertisementService cdpAdvertisementService = cpdService();
        cdpAdvertisementService.doSplash(this, new HashMap<String, String>(), new CdpAdvertisementService.IAdEventHandler() {
            @Override
             public void onClosed(SpaceInfo spaceInfo) {

            }

            @Override
            public void onJump(SpaceInfo spaceInfo) {
                Log.e("suj","onJump clicked");

            }
        });
    }

    /**
     * 
     *  加载启动页面
     */
    private void request_start_up_page() {
        final CdpAdvertisementService cdpAdvertisementService = cpdService();
        cdpAdvertisementService.getSpaceInfoByCode("STARTPAGE", new HashMap<String, String>(), true, new CdpAdvertisementService.IAdGetSingleSpaceInfoCallBack() {
            @Override
            public void onSuccess(SpaceInfo spaceInfo) {
                //
                toastShow(spaceInfo.toString());
            }

            @Override
            public void onFail() {

            }
        });


    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    private void toastShow(final String toString) {
        if (Looper.getMainLooper().getThread().equals(Thread.currentThread())) {
            Toast.makeText(this, toString, Toast.LENGTH_LONG).show();
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(SplashActivity.this, toString, Toast.LENGTH_LONG).show();
                }
            });
        }


    }

    public static CdpAdvertisementService cpdService() {
        CdpAdvertisementService serviceByInterface = LauncherApplicationAgent.getInstance().getMicroApplicationContext().findServiceByInterface(CdpAdvertisementService.class.getName());
        return serviceByInterface;
    }

    public static boolean checkIfSplashPrepared(){
        return cpdService().checkIfSplashPrepared();
    }
}
