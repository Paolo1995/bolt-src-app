package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class fa extends sb {

    /* renamed from: b  reason: collision with root package name */
    private final String f42976b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa(String indexLetter) {
        super(indexLetter, null);
        Intrinsics.f(indexLetter, "indexLetter");
        this.f42976b = indexLetter;
    }

    public final String b() {
        return this.f42976b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof fa) && Intrinsics.a(this.f42976b, ((fa) obj).f42976b);
    }

    public int hashCode() {
        return this.f42976b.hashCode();
    }

    public String toString() {
        String str = this.f42976b;
        return "IndexLetterItem(indexLetter=" + str + ")";
    }
}
