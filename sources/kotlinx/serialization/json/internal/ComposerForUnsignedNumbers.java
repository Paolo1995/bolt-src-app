package kotlinx.serialization.json.internal;

import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import p7.c;
import p7.d;
import p7.e;
import p7.g;

/* compiled from: Composers.kt */
/* loaded from: classes5.dex */
public final class ComposerForUnsignedNumbers extends Composer {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f52380c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(JsonWriter writer, boolean z7) {
        super(writer);
        Intrinsics.f(writer, "writer");
        this.f52380c = z7;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void d(byte b8) {
        boolean z7 = this.f52380c;
        String h8 = UByte.h(UByte.c(b8));
        if (z7) {
            m(h8);
        } else {
            j(h8);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void h(int i8) {
        boolean z7 = this.f52380c;
        int c8 = UInt.c(i8);
        if (z7) {
            m(c.a(c8));
        } else {
            j(d.a(c8));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void i(long j8) {
        String a8;
        String a9;
        boolean z7 = this.f52380c;
        long c8 = ULong.c(j8);
        if (z7) {
            a9 = e.a(c8, 10);
            m(a9);
            return;
        }
        a8 = g.a(c8, 10);
        j(a8);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void k(short s7) {
        boolean z7 = this.f52380c;
        String h8 = UShort.h(UShort.c(s7));
        if (z7) {
            m(h8);
        } else {
            j(h8);
        }
    }
}
