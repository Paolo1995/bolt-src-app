package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class BooleanArrayBuilder extends PrimitiveArrayBuilder<boolean[]> {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f52129a;

    /* renamed from: b  reason: collision with root package name */
    private int f52130b;

    public BooleanArrayBuilder(boolean[] bufferWithData) {
        Intrinsics.f(bufferWithData, "bufferWithData");
        this.f52129a = bufferWithData;
        this.f52130b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        boolean[] zArr = this.f52129a;
        if (zArr.length < i8) {
            d8 = RangesKt___RangesKt.d(i8, zArr.length * 2);
            boolean[] copyOf = Arrays.copyOf(zArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52129a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52130b;
    }

    public final void e(boolean z7) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        boolean[] zArr = this.f52129a;
        int d8 = d();
        this.f52130b = d8 + 1;
        zArr[d8] = z7;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: f */
    public boolean[] a() {
        boolean[] copyOf = Arrays.copyOf(this.f52129a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
