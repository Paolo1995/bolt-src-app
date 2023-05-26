package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class IntArrayBuilder extends PrimitiveArrayBuilder<int[]> {

    /* renamed from: a  reason: collision with root package name */
    private int[] f52188a;

    /* renamed from: b  reason: collision with root package name */
    private int f52189b;

    public IntArrayBuilder(int[] bufferWithData) {
        Intrinsics.f(bufferWithData, "bufferWithData");
        this.f52188a = bufferWithData;
        this.f52189b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        int[] iArr = this.f52188a;
        if (iArr.length < i8) {
            d8 = RangesKt___RangesKt.d(i8, iArr.length * 2);
            int[] copyOf = Arrays.copyOf(iArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52188a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52189b;
    }

    public final void e(int i8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        int[] iArr = this.f52188a;
        int d8 = d();
        this.f52189b = d8 + 1;
        iArr[d8] = i8;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: f */
    public int[] a() {
        int[] copyOf = Arrays.copyOf(this.f52188a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
