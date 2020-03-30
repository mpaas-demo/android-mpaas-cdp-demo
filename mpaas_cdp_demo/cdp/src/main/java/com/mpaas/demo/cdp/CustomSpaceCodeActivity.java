package com.mpaas.demo.cdp;

import com.mpaas.demo.*;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alipay.mobile.antui.basic.AUTitleBar;


public class CustomSpaceCodeActivity extends PitActivity {
    public static final String CUSTOM_SPACE_CODE = "custom_space_code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText(getString(R.string.custom_space_code));
        mSpaceCode = getIntent().getStringExtra(CUSTOM_SPACE_CODE);
    }
}
