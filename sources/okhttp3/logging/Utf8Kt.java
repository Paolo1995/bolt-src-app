package okhttp3.logging;

import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import okio.Buffer;

/* compiled from: utf8.kt */
/* loaded from: classes5.dex */
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(Buffer buffer) {
        long h8;
        Intrinsics.f(buffer, "<this>");
        try {
            Buffer buffer2 = new Buffer();
            h8 = RangesKt___RangesKt.h(buffer.size(), 64L);
            buffer.j(buffer2, 0L, h8);
            int i8 = 0;
            while (i8 < 16) {
                i8++;
                if (!buffer2.y0()) {
                    int v02 = buffer2.v0();
                    if (Character.isISOControl(v02) && !Character.isWhitespace(v02)) {
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
