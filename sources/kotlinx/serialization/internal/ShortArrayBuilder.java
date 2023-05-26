package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class ShortArrayBuilder extends PrimitiveArrayBuilder<short[]> {

    /* renamed from: a  reason: collision with root package name */
    private short[] f52257a;

    /* renamed from: b  reason: collision with root package name */
    private int f52258b;

    public ShortArrayBuilder(short[] bufferWithData) {
        Intrinsics.f(bufferWithData, "bufferWithData");
        this.f52257a = bufferWithData;
        this.f52258b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        short[] sArr = this.f52257a;
        if (sArr.length < i8) {
            d8 = RangesKt___RangesKt.d(i8, sArr.length * 2);
            short[] copyOf = Arrays.copyOf(sArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52257a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52258b;
    }

    public final void e(short s7) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        short[] sArr = this.f52257a;
        int d8 = d();
        this.f52258b = d8 + 1;
        sArr[d8] = s7;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: f */
    public short[] a() {
        short[] copyOf = Arrays.copyOf(this.f52257a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
