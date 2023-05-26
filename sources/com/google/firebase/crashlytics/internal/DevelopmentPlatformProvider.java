package com.google.firebase.crashlytics.internal;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class DevelopmentPlatformProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15543a;

    /* renamed from: b  reason: collision with root package name */
    private DevelopmentPlatform f15544b = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class DevelopmentPlatform {

        /* renamed from: a  reason: collision with root package name */
        private final String f15545a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15546b;

        private DevelopmentPlatform() {
            int q8 = CommonUtils.q(DevelopmentPlatformProvider.this.f15543a, "com.google.firebase.crashlytics.unity_version", "string");
            if (q8 == 0) {
                if (DevelopmentPlatformProvider.this.c("flutter_assets/NOTICES.Z")) {
                    this.f15545a = "Flutter";
                    this.f15546b = null;
                    Logger.f().i("Development platform is: Flutter");
                    return;
                }
                this.f15545a = null;
                this.f15546b = null;
                return;
            }
            this.f15545a = "Unity";
            String string = DevelopmentPlatformProvider.this.f15543a.getResources().getString(q8);
            this.f15546b = string;
            Logger f8 = Logger.f();
            f8.i("Unity Editor version is: " + string);
        }
    }

    public DevelopmentPlatformProvider(Context context) {
        this.f15543a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        if (this.f15543a.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.f15543a.getAssets().open(str);
            if (open != null) {
                open.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private DevelopmentPlatform f() {
        if (this.f15544b == null) {
            this.f15544b = new DevelopmentPlatform();
        }
        return this.f15544b;
    }

    public String d() {
        return f().f15545a;
    }

    public String e() {
        return f().f15546b;
    }
}
