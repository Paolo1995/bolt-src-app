package com.clevertap.android.sdk.login;

import android.content.Context;
import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LoginInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapInstanceConfig f11624a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11625b;

    /* renamed from: c  reason: collision with root package name */
    private final DeviceInfo f11626c;

    public LoginInfoProvider(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo) {
        this.f11625b = context;
        this.f11624a = cleverTapInstanceConfig;
        this.f11626c = deviceInfo;
    }

    private boolean g() {
        boolean R = this.f11626c.R();
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "isErrorDeviceId:[" + R + "]");
        return R;
    }

    public void a(String str, String str2, String str3) {
        if (!g() && str != null && str2 != null && str3 != null) {
            String str4 = str2 + "_" + str3;
            JSONObject c8 = c();
            try {
                c8.put(str4, str);
                j(c8);
            } catch (Throwable th) {
                this.f11624a.n().s(this.f11624a.c(), "Error caching guid: " + th.toString());
            }
        }
    }

    public boolean b() {
        boolean z7 = true;
        if (c().length() <= 1) {
            z7 = false;
        }
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "deviceIsMultiUser:[" + z7 + "]");
        return z7;
    }

    public JSONObject c() {
        String k8 = StorageHelper.k(this.f11625b, this.f11624a, "cachedGUIDsKey", null);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "getCachedGUIDs:[" + k8 + "]");
        return CTJsonConverter.j(k8, this.f11624a.n(), this.f11624a.c());
    }

    public String d() {
        String k8 = StorageHelper.k(this.f11625b, this.f11624a, "SP_KEY_PROFILE_IDENTITIES", "");
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "getCachedIdentityKeysForAccount:" + k8);
        return k8;
    }

    public String e(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                String string = c().getString(str + "_" + str2);
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
                cleverTapInstanceConfig.A("ON_USER_LOGIN", "getGUIDForIdentifier:[Key:" + str + ", value:" + string + "]");
                return string;
            } catch (Throwable th) {
                Logger n8 = this.f11624a.n();
                String c8 = this.f11624a.c();
                n8.s(c8, "Error reading guid cache: " + th.toString());
            }
        }
        return null;
    }

    public boolean f() {
        boolean z7;
        if (c().length() <= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "isAnonymousDevice:[" + z7 + "]");
        return z7;
    }

    public boolean h() {
        boolean z7;
        JSONObject c8 = c();
        if (c8 != null && c8.length() > 0 && TextUtils.isEmpty(d())) {
            z7 = true;
        } else {
            z7 = false;
        }
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "isLegacyProfileLoggedIn:" + z7);
        return z7;
    }

    public void i(String str) {
        StorageHelper.o(this.f11625b, this.f11624a, "SP_KEY_PROFILE_IDENTITIES", str);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "saveIdentityKeysForAccount:" + str);
    }

    public void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String jSONObject2 = jSONObject.toString();
            StorageHelper.p(this.f11625b, StorageHelper.s(this.f11624a, "cachedGUIDsKey"), jSONObject2);
            CleverTapInstanceConfig cleverTapInstanceConfig = this.f11624a;
            cleverTapInstanceConfig.A("ON_USER_LOGIN", "setCachedGUIDs:[" + jSONObject2 + "]");
        } catch (Throwable th) {
            Logger n8 = this.f11624a.n();
            String c8 = this.f11624a.c();
            n8.s(c8, "Error persisting guid cache: " + th.toString());
        }
    }
}
