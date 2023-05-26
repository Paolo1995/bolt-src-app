package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class tq extends zb {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tq(String parentTag, String tag) {
        super(parentTag + " - " + tag);
        Intrinsics.f(parentTag, "parentTag");
        Intrinsics.f(tag, "tag");
    }
}
