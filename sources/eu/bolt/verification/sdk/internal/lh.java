package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
public final class lh {

    /* renamed from: a  reason: collision with root package name */
    private final int f44054a;

    /* renamed from: b  reason: collision with root package name */
    private final int f44055b;

    public lh(int i8, int i9) {
        this.f44054a = i8;
        this.f44055b = i9;
    }

    public final int a() {
        return this.f44054a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof lh) {
            lh lhVar = (lh) obj;
            return this.f44054a == lhVar.f44054a && this.f44055b == lhVar.f44055b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f44054a * 31) + this.f44055b;
    }

    public String toString() {
        int i8 = this.f44054a;
        int i9 = this.f44055b;
        return "SlidePosition(top=" + i8 + ", left=" + i9 + ")";
    }
}
