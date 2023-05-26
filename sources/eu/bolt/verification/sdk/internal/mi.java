package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.jk;
import eu.bolt.verification.sdk.internal.oi;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class mi {
    public final oi a(jk.h from) {
        Intrinsics.f(from, "from");
        String b8 = from.b();
        if (!Intrinsics.a(b8, "match_width")) {
            if (Intrinsics.a(b8, "fixed")) {
                jk.d a8 = from.a();
                if (a8 != null) {
                    int b9 = a8.b();
                    jk.d a9 = from.a();
                    if (a9 != null) {
                        return new oi.a(b9, a9.a());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            String b10 = from.b();
            t3.c("Unsupported dimension type [" + b10 + "]", null, 2, null);
        }
        return oi.b.f44475a;
    }
}
