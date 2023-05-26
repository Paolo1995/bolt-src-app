package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class jh extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh(String assetType, String url, Throwable cause) {
        super("Slide asset could not be loaded: " + assetType + " , " + url, cause);
        Intrinsics.f(assetType, "assetType");
        Intrinsics.f(url, "url");
        Intrinsics.f(cause, "cause");
    }
}
