package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class DoubleArrayBuilder extends PrimitiveArrayBuilder<double[]> {

    /* renamed from: a  reason: collision with root package name */
    private double[] f52156a;

    /* renamed from: b  reason: collision with root package name */
    private int f52157b;

    public DoubleArrayBuilder(double[] bufferWithData) {
        Intrinsics.f(bufferWithData, "bufferWithData");
        this.f52156a = bufferWithData;
        this.f52157b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        double[] dArr = this.f52156a;
        if (dArr.length < i8) {
            d8 = RangesKt___RangesKt.d(i8, dArr.length * 2);
            double[] copyOf = Arrays.copyOf(dArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52156a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52157b;
    }

    public final void e(double d8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        double[] dArr = this.f52156a;
        int d9 = d();
        this.f52157b = d9 + 1;
        dArr[d9] = d8;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: f */
    public double[] a() {
        double[] copyOf = Arrays.copyOf(this.f52156a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
