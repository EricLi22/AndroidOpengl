package com.wangheart.androidopengl;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wangheart.androidopengl.common.BaseActivity;

/**
 * @author arvin
 * @description:
 * @date 2019/3/26
 */
public class MainActivity extends BaseActivity {
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        disableTopLeftView();
        LearnCenter.init();
        tvInfo=findViewById(R.id.tv_info);
        findViewById(R.id.btn_learn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LearnCenter.launchLearnList(getThis(),null);
            }
        });

        ActivityManager am= (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int supportES=am.getDeviceConfigurationInfo().reqGlEsVersion;
        tvInfo.setText("OpenGL ES support version:"+Integer.toHexString(supportES));

    }
}
