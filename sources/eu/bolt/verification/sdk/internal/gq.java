package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class gq {
    public final fl a(String str) {
        if (str != null) {
            if (Intrinsics.a(str, "center")) {
                return fl.CENTER;
            }
            if (Intrinsics.a(str, "start")) {
                return fl.START;
            }
        }
        return fl.UNDEFINED;
    }
}
