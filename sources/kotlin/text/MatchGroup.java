package kotlin.text;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: Regex.kt */
/* loaded from: classes5.dex */
public final class MatchGroup {

    /* renamed from: a  reason: collision with root package name */
    private final String f51153a;

    /* renamed from: b  reason: collision with root package name */
    private final IntRange f51154b;

    public MatchGroup(String value, IntRange range) {
        Intrinsics.f(value, "value");
        Intrinsics.f(range, "range");
        this.f51153a = value;
        this.f51154b = range;
    }

    public final IntRange a() {
        return this.f51154b;
    }

    public final String b() {
        return this.f51153a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MatchGroup) {
            MatchGroup matchGroup = (MatchGroup) obj;
            return Intrinsics.a(this.f51153a, matchGroup.f51153a) && Intrinsics.a(this.f51154b, matchGroup.f51154b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f51153a.hashCode() * 31) + this.f51154b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f51153a + ", range=" + this.f51154b + ')';
    }
}
