package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentTypes.kt */
/* loaded from: classes5.dex */
public final class BadContentTypeFormatException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadContentTypeFormatException(String value) {
        super("Bad Content-Type format: " + value);
        Intrinsics.f(value, "value");
    }
}
