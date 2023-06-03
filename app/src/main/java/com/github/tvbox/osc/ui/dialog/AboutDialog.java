package com.github.tvbox.osc.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.github.tvbox.osc.BuildConfig;
import com.github.tvbox.osc.R;
import com.github.tvbox.osc.ui.xupdate.Constants;
import com.xuexiang.xupdate.easy.EasyUpdate;

import org.jetbrains.annotations.NotNull;

public class AboutDialog extends BaseDialog {

    public AboutDialog(@NonNull @NotNull Context context) {
        super(context);
        setContentView(R.layout.dialog_about);
        findViewById(R.id.xupdate).setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.xupdate:
                    EasyUpdate.checkUpdate(getContext(), Constants.UPDATE_DEFAULT_URL);
                    break;
            }
        });
    }
    private TextView appVersion;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        appVersion = (TextView)findViewById(R.id.app_version);
        appVersion.setText(BuildConfig.VERSION_NAME);

    }
}