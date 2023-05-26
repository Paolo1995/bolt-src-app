package eu.bolt.chat.chatcore.entity;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationAttribution.kt */
/* loaded from: classes5.dex */
public final class TranslationAttribution {

    /* renamed from: a  reason: collision with root package name */
    private final String f38192a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38193b;

    public TranslationAttribution(String str, String str2) {
        this.f38192a = str;
        this.f38193b = str2;
    }

    public final String a() {
        return this.f38193b;
    }

    public final String b() {
        return this.f38192a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TranslationAttribution) {
            TranslationAttribution translationAttribution = (TranslationAttribution) obj;
            return Intrinsics.a(this.f38192a, translationAttribution.f38192a) && Intrinsics.a(this.f38193b, translationAttribution.f38193b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f38192a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f38193b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TranslationAttribution(providerName=" + this.f38192a + ", logoUrl=" + this.f38193b + ')';
    }
}
