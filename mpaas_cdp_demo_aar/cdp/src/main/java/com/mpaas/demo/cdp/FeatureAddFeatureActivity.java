package com.mpaas.demo.cdp;
import com.mpaas.demo.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.alipay.mobile.antui.basic.AUTextView;
import com.alipay.mobile.antui.basic.AUTitleBar;

public class FeatureAddFeatureActivity extends FeatureNewActivityActivity {
    public static void startActivity(Context applicationContext) {
        Intent intent = new Intent();
        intent.setClass(applicationContext, FeatureAddFeatureActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        applicationContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mSpaceCode = "feature_space_add_adcode";
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText("活动上下线测试");
        ((AUTextView) findViewById(R.id.feature_show_adcode)).setText(getText(R.string.feature_add_feature_adcode));
    }
}
