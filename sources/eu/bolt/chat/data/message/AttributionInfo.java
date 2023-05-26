package eu.bolt.chat.data.message;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributionInfo.kt */
/* loaded from: classes5.dex */
public final class AttributionInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f38976a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38977b;

    public AttributionInfo(String str, String str2) {
        this.f38976a = str;
        this.f38977b = str2;
    }

    public final String a() {
        return this.f38977b;
    }

    public final String b() {
        return this.f38976a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AttributionInfo) {
            AttributionInfo attributionInfo = (AttributionInfo) obj;
            return Intrinsics.a(this.f38976a, attributionInfo.f38976a) && Intrinsics.a(this.f38977b, attributionInfo.f38977b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f38976a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f38977b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AttributionInfo(providerName=" + this.f38976a + ", providerLogoUrl=" + this.f38977b + ')';
    }
}
