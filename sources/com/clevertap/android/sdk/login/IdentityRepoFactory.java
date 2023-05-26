package com.clevertap.android.sdk.login;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.validation.ValidationResultStack;

/* loaded from: classes.dex */
public class IdentityRepoFactory {
    private IdentityRepoFactory() {
    }

    public static IdentityRepo a(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, ValidationResultStack validationResultStack) {
        IdentityRepo configurableIdentityRepo;
        if (new LoginInfoProvider(context, cleverTapInstanceConfig, deviceInfo).h()) {
            configurableIdentityRepo = new LegacyIdentityRepo(cleverTapInstanceConfig);
        } else {
            configurableIdentityRepo = new ConfigurableIdentityRepo(context, cleverTapInstanceConfig, deviceInfo, validationResultStack);
        }
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "Repo provider: " + configurableIdentityRepo.getClass().getSimpleName());
        return configurableIdentityRepo;
    }
}
