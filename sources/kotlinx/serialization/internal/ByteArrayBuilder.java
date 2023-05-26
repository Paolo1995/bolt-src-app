package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class ByteArrayBuilder extends PrimitiveArrayBuilder<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f52134a;

    /* renamed from: b  reason: collision with root package name */
    private int f52135b;

    public ByteArrayBuilder(byte[] bufferWithData) {
        Intrinsics.f(bufferWithData, "bufferWithData");
        this.f52134a = bufferWithData;
        this.f52135b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        byte[] bArr = this.f52134a;
        if (bArr.length < i8) {
            d8 = RangesKt___RangesKt.d(i8, bArr.length * 2);
            byte[] copyOf = Arrays.copyOf(bArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52134a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52135b;
    }

    public final void e(byte b8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        byte[] bArr = this.f52134a;
        int d8 = d();
        this.f52135b = d8 + 1;
        bArr[d8] = b8;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: f */
    public byte[] a() {
        byte[] copyOf = Arrays.copyOf(this.f52134a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
