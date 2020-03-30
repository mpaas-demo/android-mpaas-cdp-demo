package com.mpaas.demo.cdp;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.mpaas.demo.*;


import com.alipay.mobile.antui.basic.AUTitleBar;

public class RotationActivity extends PitActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText(getString(R.string.rotation));
        mSpaceCode = "space-rotation-pic";
    }
}
