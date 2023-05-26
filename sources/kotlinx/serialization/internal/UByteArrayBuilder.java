package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UByteArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PrimitiveArraysSerializers.kt */
/* loaded from: classes5.dex */
public final class UByteArrayBuilder extends PrimitiveArrayBuilder<UByteArray> {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f52278a;

    /* renamed from: b  reason: collision with root package name */
    private int f52279b;

    private UByteArrayBuilder(byte[] bArr) {
        this.f52278a = bArr;
        this.f52279b = UByteArray.r(bArr);
        b(10);
    }

    public /* synthetic */ UByteArrayBuilder(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ UByteArray a() {
        return UByteArray.b(f());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i8) {
        int d8;
        if (UByteArray.r(this.f52278a) < i8) {
            byte[] bArr = this.f52278a;
            d8 = RangesKt___RangesKt.d(i8, UByteArray.r(bArr) * 2);
            byte[] copyOf = Arrays.copyOf(bArr, d8);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f52278a = UByteArray.g(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f52279b;
    }

    public final void e(byte b8) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        byte[] bArr = this.f52278a;
        int d8 = d();
        this.f52279b = d8 + 1;
        UByteArray.w(bArr, d8, b8);
    }

    public byte[] f() {
        byte[] copyOf = Arrays.copyOf(this.f52278a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return UByteArray.g(copyOf);
    }
}
