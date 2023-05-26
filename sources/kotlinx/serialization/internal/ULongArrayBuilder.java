package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ULongArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class ULongArrayBuilder extends PrimitiveArrayBuilder<ULongArray> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f52288a;

    /* renamed from: b  reason: collision with root package name */
    private int f52289b;

    private ULongArrayBuilder(long[] jArr) {
        this.f52288a = jArr;
        this.f52289b = ULongArray.r(jArr);
        b(10);
    }

    public /* synthetic */ ULongArrayBuilder(long[] jArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ ULongArray a() {
        return ULongArray.b(f());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        if (ULongArray.r(this.f52288a) < i8) {
            long[] jArr = this.f52288a;
            d8 = RangesKt___RangesKt.d(i8, ULongArray.r(jArr) * 2);
            long[] copyOf = Arrays.copyOf(jArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52288a = ULongArray.g(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52289b;
    }

    public final void e(long j8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        long[] jArr = this.f52288a;
        int d8 = d();
        this.f52289b = d8 + 1;
        ULongArray.w(jArr, d8, j8);
    }

    public long[] f() {
        long[] copyOf = Arrays.copyOf(this.f52288a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return ULongArray.g(copyOf);
    }
}
