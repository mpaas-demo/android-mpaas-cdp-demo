package com.mpaas.demo.cdp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.alipay.mobile.antui.basic.AUTitleBar;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.mpaas.cdp.structure.SpaceInfo;
import com.mpaas.cdp.structure.SpaceObjectInfo;
import com.mpaas.cdp.ui.layer.StandardLayer;
import  com.mpaas.demo.*;
public class LottieActivity extends BaseActivity {

    public static void startLottieActivity(Activity cdpMultiStyleActivity) {
        Intent intent = new Intent();
        intent.setClass(cdpMultiStyleActivity, LottieActivity.class);
        cdpMultiStyleActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_demo_activity_lottie);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText(getString(R.string.lottie_ad));
        LinearLayout viewById = (LinearLayout) findViewById(R.id.container);
        StandardLayer standardLayer = new StandardLayer(this, fromTestSpaceInfo(), formTestSpaceObjectInfo());
        standardLayer.setTag("space-rotation-pic");
        viewById.addView(standardLayer);
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
                "            \"widgetId\": \"\",\n" +
                "            \"content\": \"\",\n" +
                "            \"hrefUrl\": \"https://mulei.oss-cn-hangzhou.aliyuncs.com/f20_cuf1Vq.zip\",\n" +
                "        }", SpaceObjectInfo.class);
    }

    public static SpaceInfo fromTestSpaceInfo() {
        return JSON.parseObject("{\n" +
                "    \"spaceCode\": \"space-rotation-pic\",\n" +
                "    \"iOSViewId\": \"null\",\n" +
                "    \"androidViewId\": \"com.mpaas.demo.cdp.RotationActivity\",\n" +
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
                "            \"widgetId\": \"\",\n" +
                "            \"content\": \"\",\n" +
                "            \"hrefUrl\": \"https://mulei.oss-cn-hangzhou.aliyuncs.com/f20_cuf1Vq.zip\",\n" +
                "        }\n" +
                "    ]\n" +
                "}\n", SpaceInfo.class);
    }
}
