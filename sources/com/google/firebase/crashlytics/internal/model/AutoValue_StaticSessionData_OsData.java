package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AutoValue_StaticSessionData_OsData extends StaticSessionData.OsData {

    /* renamed from: a  reason: collision with root package name */
    private final String f16107a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16108b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16109c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_StaticSessionData_OsData(String str, String str2, boolean z7) {
        if (str != null) {
            this.f16107a = str;
            if (str2 != null) {
                this.f16108b = str2;
                this.f16109c = z7;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public boolean b() {
        return this.f16109c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public String c() {
        return this.f16108b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public String d() {
        return this.f16107a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.OsData)) {
            return false;
        }
        StaticSessionData.OsData osData = (StaticSessionData.OsData) obj;
        if (this.f16107a.equals(osData.d()) && this.f16108b.equals(osData.c()) && this.f16109c == osData.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i8;
        int hashCode = (((this.f16107a.hashCode() ^ 1000003) * 1000003) ^ this.f16108b.hashCode()) * 1000003;
        if (this.f16109c) {
            i8 = 1231;
        } else {
            i8 = 1237;
        }
        return hashCode ^ i8;
    }

    public String toString() {
        return "OsData{osRelease=" + this.f16107a + ", osCodeName=" + this.f16108b + ", isRooted=" + this.f16109c + "}";
    }
}
