package okio;

import androidx.fragment.app.FragmentTransaction;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Segment.kt */
/* loaded from: classes5.dex */
public final class Segment {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f52630h = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f52631a;

    /* renamed from: b  reason: collision with root package name */
    public int f52632b;

    /* renamed from: c  reason: collision with root package name */
    public int f52633c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52634d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52635e;

    /* renamed from: f  reason: collision with root package name */
    public Segment f52636f;

    /* renamed from: g  reason: collision with root package name */
    public Segment f52637g;

    /* compiled from: Segment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Segment() {
        this.f52631a = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
        this.f52635e = true;
        this.f52634d = false;
    }

    public final void a() {
        boolean z7;
        Segment segment = this.f52637g;
        int i8 = 0;
        if (segment != this) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            Intrinsics.c(segment);
            if (!segment.f52635e) {
                return;
            }
            int i9 = this.f52633c - this.f52632b;
            Segment segment2 = this.f52637g;
            Intrinsics.c(segment2);
            int i10 = 8192 - segment2.f52633c;
            Segment segment3 = this.f52637g;
            Intrinsics.c(segment3);
            if (!segment3.f52634d) {
                Segment segment4 = this.f52637g;
                Intrinsics.c(segment4);
                i8 = segment4.f52632b;
            }
            if (i9 > i10 + i8) {
                return;
            }
            Segment segment5 = this.f52637g;
            Intrinsics.c(segment5);
            g(segment5, i9);
            b();
            SegmentPool.b(this);
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final Segment b() {
        Segment segment = this.f52636f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f52637g;
        Intrinsics.c(segment2);
        segment2.f52636f = this.f52636f;
        Segment segment3 = this.f52636f;
        Intrinsics.c(segment3);
        segment3.f52637g = this.f52637g;
        this.f52636f = null;
        this.f52637g = null;
        return segment;
    }

    public final Segment c(Segment segment) {
        Intrinsics.f(segment, "segment");
        segment.f52637g = this;
        segment.f52636f = this.f52636f;
        Segment segment2 = this.f52636f;
        Intrinsics.c(segment2);
        segment2.f52637g = segment;
        this.f52636f = segment;
        return segment;
    }

    public final Segment d() {
        this.f52634d = true;
        return new Segment(this.f52631a, this.f52632b, this.f52633c, true, false);
    }

    public final Segment e(int i8) {
        boolean z7;
        Segment c8;
        if (i8 > 0 && i8 <= this.f52633c - this.f52632b) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 >= 1024) {
                c8 = d();
            } else {
                c8 = SegmentPool.c();
                byte[] bArr = this.f52631a;
                byte[] bArr2 = c8.f52631a;
                int i9 = this.f52632b;
                ArraysKt___ArraysJvmKt.h(bArr, bArr2, 0, i9, i9 + i8, 2, null);
            }
            c8.f52633c = c8.f52632b + i8;
            this.f52632b += i8;
            Segment segment = this.f52637g;
            Intrinsics.c(segment);
            segment.c(c8);
            return c8;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final Segment f() {
        byte[] bArr = this.f52631a;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(copyOf, this.f52632b, this.f52633c, false, true);
    }

    public final void g(Segment sink, int i8) {
        Intrinsics.f(sink, "sink");
        if (sink.f52635e) {
            int i9 = sink.f52633c;
            if (i9 + i8 > 8192) {
                if (!sink.f52634d) {
                    int i10 = sink.f52632b;
                    if ((i9 + i8) - i10 <= 8192) {
                        byte[] bArr = sink.f52631a;
                        ArraysKt___ArraysJvmKt.h(bArr, bArr, 0, i10, i9, 2, null);
                        sink.f52633c -= sink.f52632b;
                        sink.f52632b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f52631a;
            byte[] bArr3 = sink.f52631a;
            int i11 = sink.f52633c;
            int i12 = this.f52632b;
            ArraysKt___ArraysJvmKt.f(bArr2, bArr3, i11, i12, i12 + i8);
            sink.f52633c += i8;
            this.f52632b += i8;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(byte[] data, int i8, int i9, boolean z7, boolean z8) {
        Intrinsics.f(data, "data");
        this.f52631a = data;
        this.f52632b = i8;
        this.f52633c = i9;
        this.f52634d = z7;
        this.f52635e = z8;
    }
}
