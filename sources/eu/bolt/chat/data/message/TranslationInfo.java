package eu.bolt.chat.data.message;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationInfo.kt */
/* loaded from: classes5.dex */
public final class TranslationInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f39018a;

    /* renamed from: b  reason: collision with root package name */
    private final AttributionInfo f39019b;

    public TranslationInfo(String text, AttributionInfo attribution) {
        Intrinsics.f(text, "text");
        Intrinsics.f(attribution, "attribution");
        this.f39018a = text;
        this.f39019b = attribution;
    }

    public final AttributionInfo a() {
        return this.f39019b;
    }

    public final String b() {
        return this.f39018a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TranslationInfo) {
            TranslationInfo translationInfo = (TranslationInfo) obj;
            return Intrinsics.a(this.f39018a, translationInfo.f39018a) && Intrinsics.a(this.f39019b, translationInfo.f39019b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39018a.hashCode() * 31) + this.f39019b.hashCode();
    }

    public String toString() {
        return "TranslationInfo(text=" + this.f39018a + ", attribution=" + this.f39019b + ')';
    }
}
