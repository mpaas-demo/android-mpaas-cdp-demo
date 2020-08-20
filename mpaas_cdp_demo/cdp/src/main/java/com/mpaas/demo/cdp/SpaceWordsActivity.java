package com.mpaas.demo.cdp;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.mpaas.cdp.CdpAdvertisementService;
import com.mpaas.cdp.structure.SpaceInfo;

/**
 * Created by gezihua on 2020/1/16.
 * 底纹词示例
 */

public class SpaceWordsActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        querySpaceCode();
    }

    private void querySpaceCode() {
        CdpAdvertisementService service = LauncherApplicationAgent.getInstance().getMicroApplicationContext().findServiceByInterface(CdpAdvertisementService.class.getName());
        service.getSpaceInfoByCode("space-words", new CdpAdvertisementService.IAdGetSingleSpaceInfoCallBack() {
            @Override
            public void onSuccess(SpaceInfo spaceInfo) {
                showSuccessSpaceWords(spaceInfo);
            }

            @Override
            public void onFail() {

            }
        });

    }

    private void showSuccessSpaceWords(SpaceInfo spaceInfo) {
        showSuccessSpaceWordsInUIThread(spaceInfo);

    }

    private void showSuccessSpaceWordsInUIThread(final SpaceInfo spaceInfo) {
        if (spaceInfo == null) {
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), JSON.toJSONString(spaceInfo), Toast.LENGTH_LONG).show();
            }
        });

    }
}
