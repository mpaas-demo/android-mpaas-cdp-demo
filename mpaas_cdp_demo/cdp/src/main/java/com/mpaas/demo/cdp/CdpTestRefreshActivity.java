package com.mpaas.demo.cdp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.mpaas.demo.*;

import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.mpaas.cdp.CdpAdvertisementService;
import com.mpaas.cdp.CdpAdvertisementView;
import com.mpaas.cdp.api.IMCdpExportApi;
import com.mpaas.cdp.api.MCdpApi;

import java.util.HashMap;
import java.util.Map;

/**
 * 本页面用来展示通过拓展参数拉取不同的活动的功能
 * 刷新接口
 *
 * @since 3.0 cdp sdk
 */
public class CdpTestRefreshActivity extends BaseActivity implements IMCdpExportApi {
    private final static String TAG = CdpTestRefreshActivity.class.getName();

    private View mcdp_btn_refresh;
    private CdpAdvertisementView pit_cdp_cav;

    public static void start(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CdpTestRefreshActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_demo_activity_refresh_layout);
        initView();
        initClick();
    }

    private void initClick() {
        mcdp_btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpExtendPrams();
                findCdpApiService().refresh(new CdpRefreshCallback());

            }
        });
    }

    private void setUpExtendPrams() {
        MCdpApi.API.api().setExportApi(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        pit_cdp_cav.updateSpaceCode("cdp_space_code_extend_code");
    }

    private CdpAdvertisementService findCdpApiService() {
        return LauncherApplicationAgent.getInstance()
                .getMicroApplicationContext()
                .findServiceByInterface(CdpAdvertisementService.class.getName());
    }

    private void initView() {
        mcdp_btn_refresh = findViewById(R.id.mcdp_btn_refresh);
        pit_cdp_cav = (CdpAdvertisementView) findViewById(R.id.pit_cdp_cav);
    }

    /**
     * 设置拓展点
     * <p>
     * 拓展的key 需要在控制台->活动配置
     *
     * @return
     */
    @Override
    public Map<String, String> getExtras() {
        HashMap<String, String> extras = new HashMap<>();
        extras.put("cdp_extend_params", String.valueOf(1));
        return extras;
    }


    // 这里是为给用户一个拓展点，用来展示loading 效果
    public static class CdpRefreshCallback implements CdpAdvertisementService.IRefreshZoneCallBack {

        public void onStart() {
            Log.e(TAG, "CDP refresh  on start");
        }

        public void onEnd() {
            Log.e(TAG, "CDP refresh  on end");
        }
    }
}
