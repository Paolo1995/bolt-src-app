package com.clevertap.android.sdk.login;

import android.content.Context;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.validation.ValidationResultFactory;
import com.clevertap.android.sdk.validation.ValidationResultStack;

/* loaded from: classes.dex */
public class ConfigurableIdentityRepo implements IdentityRepo {

    /* renamed from: a  reason: collision with root package name */
    private IdentitySet f11596a;

    /* renamed from: b  reason: collision with root package name */
    private final LoginInfoProvider f11597b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f11598c;

    /* renamed from: d  reason: collision with root package name */
    private final ValidationResultStack f11599d;

    public ConfigurableIdentityRepo(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, ValidationResultStack validationResultStack) {
        this.f11598c = cleverTapInstanceConfig;
        this.f11597b = new LoginInfoProvider(context, cleverTapInstanceConfig, deviceInfo);
        this.f11599d = validationResultStack;
        d();
    }

    private void c(IdentitySet identitySet, IdentitySet identitySet2) {
        if (identitySet.f() && identitySet2.f() && !identitySet.equals(identitySet2)) {
            this.f11599d.b(ValidationResultFactory.a(531));
            CleverTapInstanceConfig cleverTapInstanceConfig = this.f11598c;
            cleverTapInstanceConfig.A("ON_USER_LOGIN", "ConfigurableIdentityRepopushing error due to mismatch [Pref:" + identitySet + "], [Config:" + identitySet2 + "]");
            return;
        }
        CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f11598c;
        cleverTapInstanceConfig2.A("ON_USER_LOGIN", "ConfigurableIdentityRepoNo error found while comparing [Pref:" + identitySet + "], [Config:" + identitySet2 + "]");
    }

    @Override // com.clevertap.android.sdk.login.IdentityRepo
    public boolean a(@NonNull String str) {
        boolean a8 = this.f11596a.a(str);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11598c;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "ConfigurableIdentityRepoisIdentity [Key: " + str + " , Value: " + a8 + "]");
        return a8;
    }

    @Override // com.clevertap.android.sdk.login.IdentityRepo
    public IdentitySet b() {
        return this.f11596a;
    }

    void d() {
        IdentitySet b8 = IdentitySet.b(this.f11597b.d());
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11598c;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "ConfigurableIdentityRepoPrefIdentitySet [" + b8 + "]");
        IdentitySet c8 = IdentitySet.c(this.f11598c.l());
        CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f11598c;
        cleverTapInstanceConfig2.A("ON_USER_LOGIN", "ConfigurableIdentityRepoConfigIdentitySet [" + c8 + "]");
        c(b8, c8);
        if (b8.f()) {
            this.f11596a = b8;
            CleverTapInstanceConfig cleverTapInstanceConfig3 = this.f11598c;
            cleverTapInstanceConfig3.A("ON_USER_LOGIN", "ConfigurableIdentityRepoIdentity Set activated from Pref[" + this.f11596a + "]");
        } else if (c8.f()) {
            this.f11596a = c8;
            CleverTapInstanceConfig cleverTapInstanceConfig4 = this.f11598c;
            cleverTapInstanceConfig4.A("ON_USER_LOGIN", "ConfigurableIdentityRepoIdentity Set activated from Config[" + this.f11596a + "]");
        } else {
            this.f11596a = IdentitySet.d();
            CleverTapInstanceConfig cleverTapInstanceConfig5 = this.f11598c;
            cleverTapInstanceConfig5.A("ON_USER_LOGIN", "ConfigurableIdentityRepoIdentity Set activated from Default[" + this.f11596a + "]");
        }
        if (!b8.f()) {
            String identitySet = this.f11596a.toString();
            this.f11597b.i(identitySet);
            CleverTapInstanceConfig cleverTapInstanceConfig6 = this.f11598c;
            cleverTapInstanceConfig6.A("ON_USER_LOGIN", "ConfigurableIdentityRepoSaving Identity Keys in Pref[" + identitySet + "]");
        }
    }
}
