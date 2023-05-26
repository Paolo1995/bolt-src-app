package com.clevertap.android.sdk.login;

import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;

/* loaded from: classes.dex */
public class LegacyIdentityRepo implements IdentityRepo {

    /* renamed from: a  reason: collision with root package name */
    private IdentitySet f11601a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11602b;

    public LegacyIdentityRepo(CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f11602b = cleverTapInstanceConfig;
        c();
    }

    private void c() {
        this.f11601a = IdentitySet.d();
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11602b;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "LegacyIdentityRepo Setting the default IdentitySet[" + this.f11601a + "]");
    }

    @Override // com.clevertap.android.sdk.login.IdentityRepo
    public boolean a(@NonNull String str) {
        boolean a8 = this.f11601a.a(str);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11602b;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "isIdentity [Key: " + str + " , Value: " + a8 + "]");
        return a8;
    }

    @Override // com.clevertap.android.sdk.login.IdentityRepo
    public IdentitySet b() {
        return this.f11601a;
    }
}
