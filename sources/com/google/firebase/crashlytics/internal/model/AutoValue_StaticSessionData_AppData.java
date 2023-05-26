package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AutoValue_StaticSessionData_AppData extends StaticSessionData.AppData {

    /* renamed from: a  reason: collision with root package name */
    private final String f16092a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16093b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16094c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16095d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16096e;

    /* renamed from: f  reason: collision with root package name */
    private final DevelopmentPlatformProvider f16097f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int i8, DevelopmentPlatformProvider developmentPlatformProvider) {
        if (str != null) {
            this.f16092a = str;
            if (str2 != null) {
                this.f16093b = str2;
                if (str3 != null) {
                    this.f16094c = str3;
                    if (str4 != null) {
                        this.f16095d = str4;
                        this.f16096e = i8;
                        if (developmentPlatformProvider != null) {
                            this.f16097f = developmentPlatformProvider;
                            return;
                        }
                        throw new NullPointerException("Null developmentPlatformProvider");
                    }
                    throw new NullPointerException("Null installUuid");
                }
                throw new NullPointerException("Null versionName");
            }
            throw new NullPointerException("Null versionCode");
        }
        throw new NullPointerException("Null appIdentifier");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String a() {
        return this.f16092a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public int c() {
        return this.f16096e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public DevelopmentPlatformProvider d() {
        return this.f16097f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String e() {
        return this.f16095d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.AppData)) {
            return false;
        }
        StaticSessionData.AppData appData = (StaticSessionData.AppData) obj;
        if (this.f16092a.equals(appData.a()) && this.f16093b.equals(appData.f()) && this.f16094c.equals(appData.g()) && this.f16095d.equals(appData.e()) && this.f16096e == appData.c() && this.f16097f.equals(appData.d())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String f() {
        return this.f16093b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public String g() {
        return this.f16094c;
    }

    public int hashCode() {
        return ((((((((((this.f16092a.hashCode() ^ 1000003) * 1000003) ^ this.f16093b.hashCode()) * 1000003) ^ this.f16094c.hashCode()) * 1000003) ^ this.f16095d.hashCode()) * 1000003) ^ this.f16096e) * 1000003) ^ this.f16097f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f16092a + ", versionCode=" + this.f16093b + ", versionName=" + this.f16094c + ", installUuid=" + this.f16095d + ", deliveryMechanism=" + this.f16096e + ", developmentPlatformProvider=" + this.f16097f + "}";
    }
}
