package io.ktor.utils.io.charsets;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharsetJVM.kt */
/* loaded from: classes5.dex */
public class MalformedInputException extends java.nio.charset.MalformedInputException {

    /* renamed from: f  reason: collision with root package name */
    private final String f47368f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MalformedInputException(String message) {
        super(0);
        Intrinsics.f(message, "message");
        this.f47368f = message;
    }

    @Override // java.nio.charset.MalformedInputException, java.lang.Throwable
    public String getMessage() {
        return this.f47368f;
    }
}
