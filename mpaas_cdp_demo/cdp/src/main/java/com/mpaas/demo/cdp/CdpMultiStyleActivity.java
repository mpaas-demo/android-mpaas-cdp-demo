package com.mpaas.demo.cdp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alipay.mobile.antui.basic.AUTitleBar;
import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5Service;
import com.mpaas.demo.R;

public class CdpMultiStyleActivity extends BaseActivity {
    public static void startActivity(Context baseContext) {
        Intent intent = new Intent();
        intent.setClass(baseContext,CdpMultiStyleActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        baseContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcdp_demo_activity_multi_style);
        ((AUTitleBar) findViewById(R.id.title_atb)).setTitleText(getString(R.string.multi_style));
        findViewById(R.id.multi_style_rotation_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CdpMultiStyleActivity.this, RotationActivity.class));
            }
        });
        findViewById(R.id.multi_style_banner_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CdpMultiStyleActivity.this, BannerActivity.class));
            }
        });
        findViewById(R.id.multi_style_list_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CdpMultiStyleActivity.this, ListActivity.class));
            }
        });
        findViewById(R.id.multi_style_announcement_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CdpMultiStyleActivity.this, AnnouncementActivity.class));
            }
        });

        findViewById(R.id.multi_style_splash_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSplashPrepared()) {
                    Log.e("suj", "isSplashPrepared");
                    startActivity(new Intent(CdpMultiStyleActivity.this, SplashActivity.class));
                } else {
                    Toast.makeText(getBaseContext(), "splash is not ready", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.multi_style_h5_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CdpMultiStyleActivity.this, H5PopUpActivity.class));
            }
        });

        findViewById(R.id.multi_style_h5_native_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startH5();
            }
        });
        findViewById(R.id.multi_style_lottie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLottie();
            }
        });
        findViewById(R.id.multi_style_gif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGif();
            }
        });
        findViewById(R.id.multi_style_float_con).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickFloatIcon();
            }
        });
        findViewById(R.id.multi_style_space_words).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSpaceWords();
            }
        });
    }

    private void onClickSpaceWords() {


    }

    private void onClickFloatIcon() {
//        MCdpFloatIconViewActivity.startFloatIconActivity(this);
    }

    private void onClickGif() {
        GifActivity.startGifActivity(this);

    }

    private void onClickLottie() {
        LottieActivity.startLottieActivity(this);

    }

    private void startH5() {
        String url = "https://mcube-prod.oss-cn-hangzhou.aliyuncs.com/226BA46061731-default/66666666/1.0.0.0_all/nebula/fallback/index.html";
        H5Service h5Service = LauncherApplicationAgent.getInstance().getMicroApplicationContext()
                .findServiceByInterface(H5Service.class.getName());
        Bundle h5Bundle = new Bundle();
        h5Bundle.putString(H5Param.LONG_URL, url);
        h5Service.startPage(LauncherApplicationAgent.getInstance().getMicroApplicationContext().getTopApplication(),
                new H5Bundle(h5Bundle));
        return;


    }

    private boolean isSplashPrepared() {
        return SplashActivity.checkIfSplashPrepared();
    }
}
