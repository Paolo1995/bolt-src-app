package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.nh;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class de {
    public final fl a(fl paragraphTextAlignment, fl stepTextAlignment, nh.b.a stepAlignment) {
        Intrinsics.f(paragraphTextAlignment, "paragraphTextAlignment");
        Intrinsics.f(stepTextAlignment, "stepTextAlignment");
        Intrinsics.f(stepAlignment, "stepAlignment");
        fl flVar = fl.UNDEFINED;
        return paragraphTextAlignment != flVar ? paragraphTextAlignment : stepTextAlignment != flVar ? stepTextAlignment : stepAlignment == nh.b.a.TOP ? fl.START : fl.CENTER;
    }
}
