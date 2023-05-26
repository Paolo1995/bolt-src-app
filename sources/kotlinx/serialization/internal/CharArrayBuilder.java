package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class CharArrayBuilder extends PrimitiveArrayBuilder<char[]> {

    /* renamed from: a  reason: collision with root package name */
    private char[] f52141a;

    /* renamed from: b  reason: collision with root package name */
    private int f52142b;

    public CharArrayBuilder(char[] bufferWithData) {
        Intrinsics.f(bufferWithData, "bufferWithData");
        this.f52141a = bufferWithData;
        this.f52142b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        char[] cArr = this.f52141a;
        if (cArr.length < i8) {
            d8 = RangesKt___RangesKt.d(i8, cArr.length * 2);
            char[] copyOf = Arrays.copyOf(cArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52141a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52142b;
    }

    public final void e(char c8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        char[] cArr = this.f52141a;
        int d8 = d();
        this.f52142b = d8 + 1;
        cArr[d8] = c8;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* renamed from: f */
    public char[] a() {
        char[] copyOf = Arrays.copyOf(this.f52141a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
