package com.mpaas.demo.cdp;
import com.mpaas.demo.*;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alipay.mobile.antui.basic.AUTextView;
import com.alipay.mobile.framework.app.ui.BaseActivity;

/**
 * Created by gezihua on 2019/12/18.
 */

/**
 * 动态公告最佳实践
 * 1. 页面顶部，页面底部
 * 2. 列表头部，列表底部
 */
public class AnnouncementFullLocationActivity extends FulllocationBaseActivity {
    private TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_demo_actiivty_annoucement_fulllocation);
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setText("公告全位置示例");
        enableListModel();
    }

}
