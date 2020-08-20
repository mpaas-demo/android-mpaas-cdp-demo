package com.mpaas.demo.cdp;
import com.mpaas.demo.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

import com.alipay.mobile.antui.basic.AUTextView;
import com.alipay.mobile.common.logging.api.LoggerFactory;
import com.alipay.mobile.framework.app.ui.BaseActivity;

public class FeatureActivity extends BaseActivity implements View.OnClickListener {

    public static void startActivity(Context baseContext) {
        Intent intent = new Intent();
        intent.setClass(baseContext,FeatureActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        baseContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_demo_activity_feature);
        initView(this);
    }

    private void initView(FeatureActivity featureActivity) {
        findViewById(R.id.feature_add_feature).setOnClickListener(this);
        findViewById(R.id.feature_new_activity).setOnClickListener(this);
        findViewById(R.id.mock_bank_feature_show).setOnClickListener(this);
        findViewById(R.id.mock_bank_feature_show2).setOnClickListener(this);
        ((AUTextView)findViewById(R.id.v_show_id)).setText(LoggerFactory.getLogContext().getUserId());
        findViewById(R.id.feature_refresh_code).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        int id = v.getId();
        if (R.id.feature_add_feature == id) {
            onClickFeature_add_feature();
            return;
        }
        if (R.id.feature_new_activity == id) {
            onClickFeature_new_activity();
            return;
        }
        if (R.id.mock_bank_feature_show==id){
            onClickmock_bank_feature_show();
            return;
        }
        if (R.id.mock_bank_feature_show2==id){
            onClickmock_bank_feature_show2();
            return;
        }
        if (R.id.feature_refresh_code==id){
            onClickFeature_refresh_code();
            return;
        }

    }

    private void onClickFeature_refresh_code() {
        CdpTestRefreshActivity.start(this);

    }

    private void onClickmock_bank_feature_show2() {
        FeatureShow2Activity.startActivity(getApplicationContext());

    }

    private void onClickmock_bank_feature_show() {
        FeatureShowActivity.startActivity(getApplicationContext());

    }

    private void onClickFeature_new_activity() {
        FeatureNewActivityActivity.startActivity(getApplicationContext());

    }

    private void onClickFeature_add_feature() {
        FeatureAddFeatureActivity.startActivity(getApplicationContext());
    }
}
