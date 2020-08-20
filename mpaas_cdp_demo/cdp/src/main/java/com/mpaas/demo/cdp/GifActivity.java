package com.mpaas.demo.cdp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ViewGroup;

import com.alipay.android.phone.mobilecommon.multimedia.file.data.APFileDownloadRsp;
import com.alipay.mobile.antui.basic.AUTitleBar;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.alipay.multimedia.widget.APMGifView;
import com.mpaas.mobile.beehive.lottie.util.DownloadFileUtils;
import com.mpaas.demo.*;
public class GifActivity extends BaseActivity {
    public static void startGifActivity(Activity cdpMultiStyleActivity) {
        Intent intent = new Intent();
        intent.setClass(cdpMultiStyleActivity, GifActivity.class);
        cdpMultiStyleActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_demo_activity_gif);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText(getString(R.string.mcdp_demo_style_gif));
        initView();
    }

    private void initView() {
        ViewGroup viewById = (ViewGroup) findViewById(R.id.mcdp_demo_gif_container);
        final APMGifView apmGifView = new APMGifView(this);
        viewById.addView(apmGifView);
        new AsyncTask<Void, String, String>() {

            @Override
            protected String doInBackground(Void[] objects) {
                String download = download();
                return download;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                apmGifView.init(s);
                apmGifView.startAnimation();
            }
        }.execute();


    }

    private String download() {
        APFileDownloadRsp apFileDownloadRsp = DownloadFileUtils.loadMeidaSync("https://mulei.oss-cn-hangzhou.aliyuncs.com/57f4da01e6001937acf215dd1c92a65e.gif", null);
        return apFileDownloadRsp.getFileReq().getSavePath();
    }
}
