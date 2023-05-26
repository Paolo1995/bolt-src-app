package io.ktor.serialization;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentConvertException.kt */
/* loaded from: classes5.dex */
public final class JsonConvertException extends ContentConvertException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonConvertException(String message, Throwable th) {
        super(message, th);
        Intrinsics.f(message, "message");
    }
}
