package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: XorWowRandom.kt */
/* loaded from: classes5.dex */
public final class XorWowRandom extends Random implements Serializable {

    /* renamed from: n  reason: collision with root package name */
    private static final Companion f51032n = new Companion(null);

    /* renamed from: h  reason: collision with root package name */
    private int f51033h;

    /* renamed from: i  reason: collision with root package name */
    private int f51034i;

    /* renamed from: j  reason: collision with root package name */
    private int f51035j;

    /* renamed from: k  reason: collision with root package name */
    private int f51036k;

    /* renamed from: l  reason: collision with root package name */
    private int f51037l;

    /* renamed from: m  reason: collision with root package name */
    private int f51038m;

    /* compiled from: XorWowRandom.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public XorWowRandom(int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f51033h = i8;
        this.f51034i = i9;
        this.f51035j = i10;
        this.f51036k = i11;
        this.f51037l = i12;
        this.f51038m = i13;
        int i14 = i8 | i9 | i10 | i11 | i12;
        if (!(i14 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i15 = 0; i15 < 64; i15++) {
            d();
        }
    }

    @Override // kotlin.random.Random
    public int b(int i8) {
        return RandomKt.f(d(), i8);
    }

    @Override // kotlin.random.Random
    public int d() {
        int i8 = this.f51033h;
        int i9 = i8 ^ (i8 >>> 2);
        this.f51033h = this.f51034i;
        this.f51034i = this.f51035j;
        this.f51035j = this.f51036k;
        int i10 = this.f51037l;
        this.f51036k = i10;
        int i11 = ((i9 ^ (i9 << 1)) ^ i10) ^ (i10 << 4);
        this.f51037l = i11;
        int i12 = this.f51038m + 362437;
        this.f51038m = i12;
        return i11 + i12;
    }

    public XorWowRandom(int i8, int i9) {
        this(i8, i9, 0, 0, ~i8, (i8 << 10) ^ (i9 >>> 4));
    }
}
