package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AutoValue_StaticSessionData_DeviceData extends StaticSessionData.DeviceData {

    /* renamed from: a  reason: collision with root package name */
    private final int f16098a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16099b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16100c;

    /* renamed from: d  reason: collision with root package name */
    private final long f16101d;

    /* renamed from: e  reason: collision with root package name */
    private final long f16102e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f16103f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16104g;

    /* renamed from: h  reason: collision with root package name */
    private final String f16105h;

    /* renamed from: i  reason: collision with root package name */
    private final String f16106i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_DeviceData(int i8, String str, int i9, long j8, long j9, boolean z7, int i10, String str2, String str3) {
        this.f16098a = i8;
        if (str != null) {
            this.f16099b = str;
            this.f16100c = i9;
            this.f16101d = j8;
            this.f16102e = j9;
            this.f16103f = z7;
            this.f16104g = i10;
            if (str2 != null) {
                this.f16105h = str2;
                if (str3 != null) {
                    this.f16106i = str3;
                    return;
                }
                throw new NullPointerException("Null modelClass");
            }
            throw new NullPointerException("Null manufacturer");
        }
        throw new NullPointerException("Null model");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int a() {
        return this.f16098a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int b() {
        return this.f16100c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public long d() {
        return this.f16102e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public boolean e() {
        return this.f16103f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.DeviceData)) {
            return false;
        }
        StaticSessionData.DeviceData deviceData = (StaticSessionData.DeviceData) obj;
        if (this.f16098a == deviceData.a() && this.f16099b.equals(deviceData.g()) && this.f16100c == deviceData.b() && this.f16101d == deviceData.j() && this.f16102e == deviceData.d() && this.f16103f == deviceData.e() && this.f16104g == deviceData.i() && this.f16105h.equals(deviceData.f()) && this.f16106i.equals(deviceData.h())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String f() {
        return this.f16105h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String g() {
        return this.f16099b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public String h() {
        return this.f16106i;
    }

    public int hashCode() {
        int i8;
        long j8 = this.f16101d;
        long j9 = this.f16102e;
        int hashCode = (((((((((this.f16098a ^ 1000003) * 1000003) ^ this.f16099b.hashCode()) * 1000003) ^ this.f16100c) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003;
        if (this.f16103f) {
            i8 = 1231;
        } else {
            i8 = 1237;
        }
        return ((((((hashCode ^ i8) * 1000003) ^ this.f16104g) * 1000003) ^ this.f16105h.hashCode()) * 1000003) ^ this.f16106i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public int i() {
        return this.f16104g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public long j() {
        return this.f16101d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f16098a + ", model=" + this.f16099b + ", availableProcessors=" + this.f16100c + ", totalRam=" + this.f16101d + ", diskSpace=" + this.f16102e + ", isEmulator=" + this.f16103f + ", state=" + this.f16104g + ", manufacturer=" + this.f16105h + ", modelClass=" + this.f16106i + "}";
    }
}
