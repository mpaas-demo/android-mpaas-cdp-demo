package com.mpaas.demo.cdp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.mpaas.demo.*;

/**
 *  com.mpaas.demo.cdp.BannerFullLocationActivity
 * Created by gezihua on 2019/12/18.
 */

public class BannerFullLocationActivity extends FulllocationBaseActivity {
    private TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_demo_actiivty_annoucement_fulllocation);
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setText("轮播广告最佳实践");
        findViewById(R.id.dynamic_content_lv).setVisibility(View.VISIBLE);
        enableListModel();
    }
}
