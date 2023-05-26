package kotlinx.serialization.internal;

import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: ElementMarker.kt */
/* loaded from: classes5.dex */
public final class ElementMarker {

    /* renamed from: e  reason: collision with root package name */
    private static final Companion f52163e = new Companion(null);
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    private static final long[] f52164f = new long[0];

    /* renamed from: a  reason: collision with root package name */
    private final SerialDescriptor f52165a;

    /* renamed from: b  reason: collision with root package name */
    private final Function2<SerialDescriptor, Integer, Boolean> f52166b;

    /* renamed from: c  reason: collision with root package name */
    private long f52167c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f52168d;

    /* compiled from: ElementMarker.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ElementMarker(SerialDescriptor descriptor, Function2<? super SerialDescriptor, ? super Integer, Boolean> readIfAbsent) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(readIfAbsent, "readIfAbsent");
        this.f52165a = descriptor;
        this.f52166b = readIfAbsent;
        int e8 = descriptor.e();
        if (e8 <= 64) {
            this.f52167c = e8 != 64 ? (-1) << e8 : 0L;
            this.f52168d = f52164f;
            return;
        }
        this.f52167c = 0L;
        this.f52168d = e(e8);
    }

    private final void b(int i8) {
        int i9 = (i8 >>> 6) - 1;
        long[] jArr = this.f52168d;
        jArr[i9] = jArr[i9] | (1 << (i8 & 63));
    }

    private final int c() {
        int length = this.f52168d.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 + 1;
            int i10 = i9 * 64;
            long j8 = this.f52168d[i8];
            while (j8 != -1) {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(~j8);
                j8 |= 1 << numberOfTrailingZeros;
                int i11 = numberOfTrailingZeros + i10;
                if (this.f52166b.s(this.f52165a, Integer.valueOf(i11)).booleanValue()) {
                    this.f52168d[i8] = j8;
                    return i11;
                }
            }
            this.f52168d[i8] = j8;
            i8 = i9;
        }
        return -1;
    }

    private final long[] e(int i8) {
        int I;
        long[] jArr = new long[(i8 - 1) >>> 6];
        if ((i8 & 63) != 0) {
            I = ArraysKt___ArraysKt.I(jArr);
            jArr[I] = (-1) << i8;
        }
        return jArr;
    }

    public final void a(int i8) {
        if (i8 < 64) {
            this.f52167c |= 1 << i8;
        } else {
            b(i8);
        }
    }

    public final int d() {
        int numberOfTrailingZeros;
        int e8 = this.f52165a.e();
        do {
            long j8 = this.f52167c;
            if (j8 != -1) {
                numberOfTrailingZeros = Long.numberOfTrailingZeros(~j8);
                this.f52167c |= 1 << numberOfTrailingZeros;
            } else if (e8 > 64) {
                return c();
            } else {
                return -1;
            }
        } while (!this.f52166b.s(this.f52165a, Integer.valueOf(numberOfTrailingZeros)).booleanValue());
        return numberOfTrailingZeros;
    }
}
