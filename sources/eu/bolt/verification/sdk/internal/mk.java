package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class mk {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f44211a;

    /* renamed from: b  reason: collision with root package name */
    private final int f44212b;

    /* renamed from: c  reason: collision with root package name */
    private final int f44213c;

    /* renamed from: d  reason: collision with root package name */
    private final int f44214d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f44215e;

    public mk(CharSequence text, int i8, int i9, int i10, Integer num) {
        Intrinsics.f(text, "text");
        this.f44211a = text;
        this.f44212b = i8;
        this.f44213c = i9;
        this.f44214d = i10;
        this.f44215e = num;
    }

    public final int a() {
        return this.f44212b;
    }

    public final int b() {
        return this.f44214d;
    }

    public final Integer c() {
        return this.f44215e;
    }

    public final int d() {
        return this.f44213c;
    }

    public final CharSequence e() {
        return this.f44211a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof mk) {
            mk mkVar = (mk) obj;
            return Intrinsics.a(this.f44211a, mkVar.f44211a) && this.f44212b == mkVar.f44212b && this.f44213c == mkVar.f44213c && this.f44214d == mkVar.f44214d && Intrinsics.a(this.f44215e, mkVar.f44215e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.f44211a.hashCode() * 31) + this.f44212b) * 31) + this.f44213c) * 31) + this.f44214d) * 31;
        Integer num = this.f44215e;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        CharSequence charSequence = this.f44211a;
        int i8 = this.f44212b;
        int i9 = this.f44213c;
        int i10 = this.f44214d;
        Integer num = this.f44215e;
        return "StoryTextStyle(text=" + ((Object) charSequence) + ", backgroundColor=" + i8 + ", horizontalPadding=" + i9 + ", backgroundRadius=" + i10 + ", highlightColor=" + num + ")";
    }
}
