package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.NetworkManager;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaseResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapResponse f11729a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11730b;

    /* renamed from: c  reason: collision with root package name */
    private final LocalDataStore f11731c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f11732d;

    /* renamed from: e  reason: collision with root package name */
    private final NetworkManager f11733e;

    public BaseResponse(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, NetworkManager networkManager, LocalDataStore localDataStore, CleverTapResponse cleverTapResponse) {
        this.f11729a = cleverTapResponse;
        this.f11730b = cleverTapInstanceConfig;
        this.f11732d = cleverTapInstanceConfig.n();
        this.f11733e = networkManager;
        this.f11731c = localDataStore;
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        if (str == null) {
            this.f11732d.s(this.f11730b.c(), "Problem processing queue response, response is null");
            return;
        }
        try {
            Logger logger = this.f11732d;
            String c8 = this.f11730b.c();
            logger.s(c8, "Trying to process response: " + str);
            JSONObject jSONObject2 = new JSONObject(str);
            this.f11729a.a(jSONObject2, str, context);
            this.f11731c.V(context, jSONObject2);
        } catch (Throwable th) {
            this.f11733e.v();
            this.f11732d.t(this.f11730b.c(), "Problem process send queue response", th);
        }
    }
}
