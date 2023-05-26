package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class LongArrayBuilder extends PrimitiveArrayBuilder<long[]> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f52199a;

    /* renamed from: b  reason: collision with root package name */
    private int f52200b;

    public LongArrayBuilder(long[] bufferWithData) {
        Intrinsics.f(bufferWithData, "bufferWithData");
        this.f52199a = bufferWithData;
        this.f52200b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        long[] jArr = this.f52199a;
        if (jArr.length < i8) {
            d8 = RangesKt___RangesKt.d(i8, jArr.length * 2);
            long[] copyOf = Arrays.copyOf(jArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52199a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52200b;
    }

    public final void e(long j8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        long[] jArr = this.f52199a;
        int d8 = d();
        this.f52200b = d8 + 1;
        jArr[d8] = j8;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: f */
    public long[] a() {
        long[] copyOf = Arrays.copyOf(this.f52199a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
