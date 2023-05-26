package com.google.firebase.perf.internal;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.ApplicationInfo;

/* loaded from: classes3.dex */
public class FirebasePerfApplicationInfoValidator extends PerfMetricValidator {

    /* renamed from: b  reason: collision with root package name */
    private static final AndroidLogger f16729b = AndroidLogger.e();

    /* renamed from: a  reason: collision with root package name */
    private final ApplicationInfo f16730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebasePerfApplicationInfoValidator(ApplicationInfo applicationInfo) {
        this.f16730a = applicationInfo;
    }

    private boolean g() {
        ApplicationInfo applicationInfo = this.f16730a;
        if (applicationInfo == null) {
            f16729b.i("ApplicationInfo is null");
            return false;
        } else if (!applicationInfo.hasGoogleAppId()) {
            f16729b.i("GoogleAppId is null");
            return false;
        } else if (!this.f16730a.hasAppInstanceId()) {
            f16729b.i("AppInstanceId is null");
            return false;
        } else if (!this.f16730a.hasApplicationProcessState()) {
            f16729b.i("ApplicationProcessState is null");
            return false;
        } else if (this.f16730a.hasAndroidAppInfo()) {
            if (!this.f16730a.getAndroidAppInfo().hasPackageName()) {
                f16729b.i("AndroidAppInfo.packageName is null");
                return false;
            } else if (!this.f16730a.getAndroidAppInfo().hasSdkVersion()) {
                f16729b.i("AndroidAppInfo.sdkVersion is null");
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override // com.google.firebase.perf.internal.PerfMetricValidator
    public boolean c() {
        if (!g()) {
            f16729b.i("ApplicationInfo is invalid");
            return false;
        }
        return true;
    }
}
