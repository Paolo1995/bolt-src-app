package ee.mtakso.driver.service.modules.surge;

import ee.mtakso.driver.network.client.driver.surge.SurgeMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeSettings.kt */
/* loaded from: classes3.dex */
public final class SurgeSettings {

    /* renamed from: a  reason: collision with root package name */
    private final SurgeMap f25315a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25316b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25317c;

    public SurgeSettings(SurgeMap surgeMap, String str, boolean z7) {
        this.f25315a = surgeMap;
        this.f25316b = str;
        this.f25317c = z7;
    }

    public final String a() {
        return this.f25316b;
    }

    public final boolean b() {
        return this.f25317c;
    }

    public final SurgeMap c() {
        return this.f25315a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SurgeSettings) {
            SurgeSettings surgeSettings = (SurgeSettings) obj;
            return Intrinsics.a(this.f25315a, surgeSettings.f25315a) && Intrinsics.a(this.f25316b, surgeSettings.f25316b) && this.f25317c == surgeSettings.f25317c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        SurgeMap surgeMap = this.f25315a;
        int hashCode = (surgeMap == null ? 0 : surgeMap.hashCode()) * 31;
        String str = this.f25316b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z7 = this.f25317c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode2 + i8;
    }

    public String toString() {
        SurgeMap surgeMap = this.f25315a;
        String str = this.f25316b;
        boolean z7 = this.f25317c;
        return "SurgeSettings(surgeMap=" + surgeMap + ", surgeCategoryId=" + str + ", surgeCategoryIdSet=" + z7 + ")";
    }
}
