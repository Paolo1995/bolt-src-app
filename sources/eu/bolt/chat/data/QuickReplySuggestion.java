package eu.bolt.chat.data;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickReplySuggestion.kt */
/* loaded from: classes5.dex */
public final class QuickReplySuggestion {

    /* renamed from: a  reason: collision with root package name */
    private final String f38957a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38958b;

    public QuickReplySuggestion(String id, String text) {
        Intrinsics.f(id, "id");
        Intrinsics.f(text, "text");
        this.f38957a = id;
        this.f38958b = text;
    }

    public final String a() {
        return this.f38957a;
    }

    public final String b() {
        return this.f38958b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickReplySuggestion) {
            QuickReplySuggestion quickReplySuggestion = (QuickReplySuggestion) obj;
            return Intrinsics.a(this.f38957a, quickReplySuggestion.f38957a) && Intrinsics.a(this.f38958b, quickReplySuggestion.f38958b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f38957a.hashCode() * 31) + this.f38958b.hashCode();
    }

    public String toString() {
        return "QuickReplySuggestion(id=" + this.f38957a + ", text=" + this.f38958b + ')';
    }
}
