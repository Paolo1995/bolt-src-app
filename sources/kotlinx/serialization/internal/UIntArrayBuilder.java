package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UIntArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class UIntArrayBuilder extends PrimitiveArrayBuilder<UIntArray> {

    /* renamed from: a  reason: collision with root package name */
    private int[] f52283a;

    /* renamed from: b  reason: collision with root package name */
    private int f52284b;

    private UIntArrayBuilder(int[] iArr) {
        this.f52283a = iArr;
        this.f52284b = UIntArray.r(iArr);
        b(10);
    }

    public /* synthetic */ UIntArrayBuilder(int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ UIntArray a() {
        return UIntArray.b(f());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        if (UIntArray.r(this.f52283a) < i8) {
            int[] iArr = this.f52283a;
            d8 = RangesKt___RangesKt.d(i8, UIntArray.r(iArr) * 2);
            int[] copyOf = Arrays.copyOf(iArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52283a = UIntArray.g(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52284b;
    }

    public final void e(int i8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        int[] iArr = this.f52283a;
        int d8 = d();
        this.f52284b = d8 + 1;
        UIntArray.w(iArr, d8, i8);
    }

    public int[] f() {
        int[] copyOf = Arrays.copyOf(this.f52283a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return UIntArray.g(copyOf);
    }
}
