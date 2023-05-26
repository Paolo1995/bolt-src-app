package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes3.dex */
final class AutoValue_StaticSessionData extends StaticSessionData {

    /* renamed from: a  reason: collision with root package name */
    private final StaticSessionData.AppData f16089a;

    /* renamed from: b  reason: collision with root package name */
    private final StaticSessionData.OsData f16090b;

    /* renamed from: c  reason: collision with root package name */
    private final StaticSessionData.DeviceData f16091c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData(StaticSessionData.AppData appData, StaticSessionData.OsData osData, StaticSessionData.DeviceData deviceData) {
        if (appData != null) {
            this.f16089a = appData;
            if (osData != null) {
                this.f16090b = osData;
                if (deviceData != null) {
                    this.f16091c = deviceData;
                    return;
                }
                throw new NullPointerException("Null deviceData");
            }
            throw new NullPointerException("Null osData");
        }
        throw new NullPointerException("Null appData");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.AppData a() {
        return this.f16089a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.DeviceData c() {
        return this.f16091c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public StaticSessionData.OsData d() {
        return this.f16090b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData)) {
            return false;
        }
        StaticSessionData staticSessionData = (StaticSessionData) obj;
        if (this.f16089a.equals(staticSessionData.a()) && this.f16090b.equals(staticSessionData.d()) && this.f16091c.equals(staticSessionData.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f16089a.hashCode() ^ 1000003) * 1000003) ^ this.f16090b.hashCode()) * 1000003) ^ this.f16091c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f16089a + ", osData=" + this.f16090b + ", deviceData=" + this.f16091c + "}";
    }
}
