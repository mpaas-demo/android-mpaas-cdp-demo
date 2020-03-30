package com.mpaas.demo.cdp;
import com.mpaas.demo.*;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alipay.mobile.antui.basic.AUTitleBar;

public class ListActivity extends PitActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText(getString(R.string.list));
        mSpaceCode = "space-list-pic";
    }
}
