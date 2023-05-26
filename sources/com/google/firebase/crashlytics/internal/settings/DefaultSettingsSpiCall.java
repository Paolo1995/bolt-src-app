package com.google.firebase.crashlytics.internal.settings;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DefaultSettingsSpiCall implements SettingsSpiCall {

    /* renamed from: a  reason: collision with root package name */
    private final String f16154a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpRequestFactory f16155b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f16156c;

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory) {
        this(str, httpRequestFactory, Logger.f());
    }

    private HttpGetRequest b(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest) {
        c(httpGetRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", settingsRequest.f16184a);
        c(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.i());
        c(httpGetRequest, "Accept", "application/json");
        c(httpGetRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f16185b);
        c(httpGetRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.f16186c);
        c(httpGetRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.f16187d);
        c(httpGetRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.f16188e.a());
        return httpGetRequest;
    }

    private void c(HttpGetRequest httpGetRequest, String str, String str2) {
        if (str2 != null) {
            httpGetRequest.d(str, str2);
        }
    }

    private JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e8) {
            Logger logger = this.f16156c;
            logger.l("Failed to parse settings JSON from " + this.f16154a, e8);
            Logger logger2 = this.f16156c;
            logger2.k("Settings response " + str);
            return null;
        }
    }

    private Map<String, String> f(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.f16191h);
        hashMap.put("display_version", settingsRequest.f16190g);
        hashMap.put("source", Integer.toString(settingsRequest.f16192i));
        String str = settingsRequest.f16189f;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsSpiCall
    public JSONObject a(SettingsRequest settingsRequest, boolean z7) {
        if (z7) {
            try {
                Map<String, String> f8 = f(settingsRequest);
                HttpGetRequest b8 = b(d(f8), settingsRequest);
                Logger logger = this.f16156c;
                logger.b("Requesting settings from " + this.f16154a);
                Logger logger2 = this.f16156c;
                logger2.i("Settings query params were: " + f8);
                return g(b8.c());
            } catch (IOException e8) {
                this.f16156c.e("Settings request failed.", e8);
                return null;
            }
        }
        throw new RuntimeException("An invalid data collection token was used.");
    }

    protected HttpGetRequest d(Map<String, String> map) {
        HttpGetRequest a8 = this.f16155b.a(this.f16154a, map);
        return a8.d("User-Agent", "Crashlytics Android SDK/" + CrashlyticsCore.i()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    JSONObject g(HttpResponse httpResponse) {
        int b8 = httpResponse.b();
        Logger logger = this.f16156c;
        logger.i("Settings response code was: " + b8);
        if (h(b8)) {
            return e(httpResponse.a());
        }
        Logger logger2 = this.f16156c;
        logger2.d("Settings request failed; (status: " + b8 + ") from " + this.f16154a);
        return null;
    }

    boolean h(int i8) {
        return i8 == 200 || i8 == 201 || i8 == 202 || i8 == 203;
    }

    DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory, Logger logger) {
        if (str != null) {
            this.f16156c = logger;
            this.f16155b = httpRequestFactory;
            this.f16154a = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
