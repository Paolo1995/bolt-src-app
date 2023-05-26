package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class FloatArrayBuilder extends PrimitiveArrayBuilder<float[]> {

    /* renamed from: a  reason: collision with root package name */
    private float[] f52179a;

    /* renamed from: b  reason: collision with root package name */
    private int f52180b;

    public FloatArrayBuilder(float[] bufferWithData) {
        Intrinsics.f(bufferWithData, "bufferWithData");
        this.f52179a = bufferWithData;
        this.f52180b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        float[] fArr = this.f52179a;
        if (fArr.length < i8) {
            d8 = RangesKt___RangesKt.d(i8, fArr.length * 2);
            float[] copyOf = Arrays.copyOf(fArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52179a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52180b;
    }

    public final void e(float f8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        float[] fArr = this.f52179a;
        int d8 = d();
        this.f52180b = d8 + 1;
        fArr[d8] = f8;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: f */
    public float[] a() {
        float[] copyOf = Arrays.copyOf(this.f52179a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
