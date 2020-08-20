package com.mpaas.demo.cdp;

import android.os.Bundle;

import com.alipay.mobile.antui.basic.AUTitleBar;
import com.mpaas.demo.*;

/**
 * Created by gezihua on 2019/11/19.
 */

public class DynamicFloatIconActivity extends DynamicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText(getString(R.string.mcdp_float_icon));
    }
}
