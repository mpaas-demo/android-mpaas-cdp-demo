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
import com.mpaas.cdp.ActionExecutor;
import com.mpaas.cdp.CdpAdvertisementService;
import com.mpaas.cdp.CdpAdvertisementView;
import com.mpaas.cdp.structure.SpaceInfo;
import com.mpaas.cdp.structure.SpaceObjectInfo;

import java.util.HashMap;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_demo_activity_splash);
        doSplashAction();
        CdpAdvertisementView pit_cdp_cav = (CdpAdvertisementView) findViewById(R.id.pit_cdp_cav);
        pit_cdp_cav.updateSpaceCode("STARTPAGE");
    }

    private void doSplashAction() {
        cdpService().setActionExecutor(new ActionExecutor() {
            @Override
            public boolean interceptAction(SpaceInfo spaceInfo, SpaceObjectInfo spaceObjectInfo, String s) {
                return spaceInfo != null && "STARTPAGE".equalsIgnoreCase(spaceInfo.spaceCode);
            }

            @Override
            public int executeAction(SpaceInfo spaceInfo, SpaceObjectInfo spaceObjectInfo, String s) {
                return executeSplashAction(spaceInfo, spaceObjectInfo, s);
            }
        });


    }

    private int executeSplashAction(SpaceInfo spaceInfo, SpaceObjectInfo spaceObjectInfo, String s) {
        Log.e("suj","onJump");
        return 1;
    }

    public static CdpAdvertisementService cdpService() {
        CdpAdvertisementService serviceByInterface = LauncherApplicationAgent.getInstance().getMicroApplicationContext().findServiceByInterface(CdpAdvertisementService.class.getName());
        return serviceByInterface;
    }

    public static boolean checkIfSplashPrepared() {
        return true;
    }
}
