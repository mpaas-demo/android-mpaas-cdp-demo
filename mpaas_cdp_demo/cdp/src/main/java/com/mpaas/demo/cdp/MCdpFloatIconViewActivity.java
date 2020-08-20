package com.mpaas.demo.cdp;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.mpaas.demo.*;

import com.alibaba.fastjson.JSON;
import com.alipay.mobile.antui.basic.AUTitleBar;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.mpaas.cdp.structure.SpaceInfo;
import com.mpaas.cdp.structure.SpaceObjectInfo;
import com.mpaas.cdp.ui.floatview.AdFloatView;

public class MCdpFloatIconViewActivity extends BaseActivity {
    public static void startFloatIconActivity(CdpMultiStyleActivity cdpMultiStyleActivity) {
        Intent intent = new Intent();
        intent.setClass(cdpMultiStyleActivity, MCdpFloatIconViewActivity.class);
        cdpMultiStyleActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.mcdp_demo_activity_float_icon);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText(getString(R.string.mcdp_demo_style_float_icon));
        AdFloatView floatView = new AdFloatView(this);
        floatView.init("", fromTestSpaceInfo(), formTestSpaceObjectInfo());
        ViewGroup view = (ViewGroup) findViewById(R.id.mcdp_demo_floaticon_container);
    }

    public static SpaceObjectInfo formTestSpaceObjectInfo() {
        return JSON.parseObject("{\n" +
                "            \"objectId\": \"1010\",\n" +
                "            \"contentType\": \"LOTTIE\",\n" +
                "            \"contentHeight\": 0,\n" +
                "            \"crontabList\": null,\n" +
                "            \"behaviors\": [\n" +
                "                {\n" +
                "                    \"behavior\": \"CLOSE_AFTER_MOMENT\",\n" +
                "                    \"showTimes\": \"3\",\n" +
                "                    \"closedByUser\": false,\n" +
                "                    \"jumpedByUser\": false\n" +
                "                }\n" +
                "            ],\n" +
                "            \"bizExtInfo\": {\n" +
                "                \"picWidth\": 200,\n" +
                "                \"picHeight\": 200\n" +
                "            },\n" +
                "            \"widgetId\": \"\",\n" +
                "            \"content\": \"\",\n" +
                "            \"hrefUrl\": \"https://mulei.oss-cn-hangzhou.aliyuncs.com/f20_cuf1Vq.zip\",\n" +
                "        }", SpaceObjectInfo.class);
    }

    public static SpaceInfo fromTestSpaceInfo() {
        return JSON.parseObject("{\n" +
                "    \"spaceCode\": \"space-content-lottie\",\n" +
                "    \"iOSViewId\": \"null\",\n" +
                "    \"androidViewId\": \"com.mpaas.demo.cdp.LottieActivity\",\n" +
                "    \"h5ViewId\": \"null\",\n" +
                "    \"appId\": \"\",\n" +
                "    \"spaceObjectList\": [\n" +
                "        {\n" +
                "            \"objectId\": \"1010\",\n" +
                "            \"contentType\": \"LOTTIE\",\n" +
                "            \"contentHeight\": 0,\n" +
                "            \"crontabList\": null,\n" +
                "            \"behaviors\": [\n" +
                "                {\n" +
                "                    \"behavior\": \"CLOSE_AFTER_MOMENT\",\n" +
                "                    \"showTimes\": \"3\",\n" +
                "                    \"closedByUser\": false,\n" +
                "                    \"jumpedByUser\": false\n" +
                "                }\n" +
                "            ],\n" +
                "            \"bizExtInfo\": {\n" +
                "                \"picWidth\": 200,\n" +
                "                \"picHeight\": 200\n" +
                "            },\n" +
                "            \"widgetId\": \"\",\n" +
                "            \"content\": \"\",\n" +
                "            \"hrefUrl\": \"https://mulei.oss-cn-hangzhou.aliyuncs.com/f20_cuf1Vq.zip\"\n" +
                "        }\n" +
                "    ]\n" +
                "}", SpaceInfo.class);
    }
}
