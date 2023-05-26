package eu.bolt.verification.sdk.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ki {

    /* renamed from: a  reason: collision with root package name */
    private final String f43873a;

    /* renamed from: b  reason: collision with root package name */
    private final List<sj> f43874b;

    /* JADX WARN: Multi-variable type inference failed */
    public ki(String id, List<? extends sj> slides) {
        Intrinsics.f(id, "id");
        Intrinsics.f(slides, "slides");
        this.f43873a = id;
        this.f43874b = slides;
    }

    public final String a() {
        return this.f43873a;
    }

    public final List<sj> b() {
        return this.f43874b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ki) {
            ki kiVar = (ki) obj;
            return Intrinsics.a(this.f43873a, kiVar.f43873a) && Intrinsics.a(this.f43874b, kiVar.f43874b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f43873a.hashCode() * 31) + this.f43874b.hashCode();
    }

    public String toString() {
        String str = this.f43873a;
        List<sj> list = this.f43874b;
        return "Story(id=" + str + ", slides=" + list + ")";
    }
}
