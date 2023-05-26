package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UShortArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class UShortArrayBuilder extends PrimitiveArrayBuilder<UShortArray> {

    /* renamed from: a  reason: collision with root package name */
    private short[] f52293a;

    /* renamed from: b  reason: collision with root package name */
    private int f52294b;

    private UShortArrayBuilder(short[] sArr) {
        this.f52293a = sArr;
        this.f52294b = UShortArray.r(sArr);
        b(10);
    }

    public /* synthetic */ UShortArrayBuilder(short[] sArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(sArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ UShortArray a() {
        return UShortArray.b(f());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        if (UShortArray.r(this.f52293a) < i8) {
            short[] sArr = this.f52293a;
            d8 = RangesKt___RangesKt.d(i8, UShortArray.r(sArr) * 2);
            short[] copyOf = Arrays.copyOf(sArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52293a = UShortArray.g(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52294b;
    }

    public final void e(short s7) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        short[] sArr = this.f52293a;
        int d8 = d();
        this.f52294b = d8 + 1;
        UShortArray.w(sArr, d8, s7);
    }

    public short[] f() {
        short[] copyOf = Arrays.copyOf(this.f52293a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return UShortArray.g(copyOf);
    }
}
