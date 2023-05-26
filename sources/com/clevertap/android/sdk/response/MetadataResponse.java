package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.NetworkManager;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MetadataResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapResponse f11764a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11765b;

    /* renamed from: c  reason: collision with root package name */
    private final DeviceInfo f11766c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f11767d;

    /* renamed from: e  reason: collision with root package name */
    private final NetworkManager f11768e;

    public MetadataResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, NetworkManager networkManager) {
        this.f11764a = cleverTapResponse;
        this.f11765b = cleverTapInstanceConfig;
        this.f11767d = cleverTapInstanceConfig.n();
        this.f11766c = deviceInfo;
        this.f11768e = networkManager;
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        try {
            if (jSONObject.has("g")) {
                String string = jSONObject.getString("g");
                this.f11766c.j(string);
                Logger logger = this.f11767d;
                String c8 = this.f11765b.c();
                logger.s(c8, "Got a new device ID: " + string);
            }
        } catch (Throwable th) {
            this.f11767d.t(this.f11765b.c(), "Failed to update device ID!", th);
        }
        try {
            if (jSONObject.has("_i")) {
                this.f11768e.F(context, jSONObject.getLong("_i"));
            }
        } catch (Throwable unused) {
        }
        try {
            if (jSONObject.has("_j")) {
                this.f11768e.G(context, jSONObject.getLong("_j"));
            }
        } catch (Throwable unused2) {
        }
        this.f11764a.a(jSONObject, str, context);
    }
}
