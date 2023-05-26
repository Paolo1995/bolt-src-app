package eu.bolt.client.chatdb.room.message.translation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationAttributionDBModel.kt */
/* loaded from: classes5.dex */
public final class TranslationAttributionDBModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f39897a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39898b;

    public TranslationAttributionDBModel(String str, String str2) {
        this.f39897a = str;
        this.f39898b = str2;
    }

    public final String a() {
        return this.f39898b;
    }

    public final String b() {
        return this.f39897a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TranslationAttributionDBModel) {
            TranslationAttributionDBModel translationAttributionDBModel = (TranslationAttributionDBModel) obj;
            return Intrinsics.a(this.f39897a, translationAttributionDBModel.f39897a) && Intrinsics.a(this.f39898b, translationAttributionDBModel.f39898b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f39897a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f39898b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TranslationAttributionDBModel(providerName=" + this.f39897a + ", providerLogoUrl=" + this.f39898b + ')';
    }
}
