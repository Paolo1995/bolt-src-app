package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpHeaders.kt */
/* loaded from: classes5.dex */
public final class IllegalHeaderValueException extends IllegalArgumentException {

    /* renamed from: f  reason: collision with root package name */
    private final String f46886f;

    /* renamed from: g  reason: collision with root package name */
    private final int f46887g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalHeaderValueException(String headerValue, int i8) {
        super("Header value '" + headerValue + "' contains illegal character '" + headerValue.charAt(i8) + "' (code " + (headerValue.charAt(i8) & 255) + ')');
        Intrinsics.f(headerValue, "headerValue");
        this.f46886f = headerValue;
        this.f46887g = i8;
    }
}
