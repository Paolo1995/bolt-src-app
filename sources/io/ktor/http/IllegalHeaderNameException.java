package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpHeaders.kt */
/* loaded from: classes5.dex */
public final class IllegalHeaderNameException extends IllegalArgumentException {

    /* renamed from: f  reason: collision with root package name */
    private final String f46884f;

    /* renamed from: g  reason: collision with root package name */
    private final int f46885g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalHeaderNameException(String headerName, int i8) {
        super("Header name '" + headerName + "' contains illegal character '" + headerName.charAt(i8) + "' (code " + (headerName.charAt(i8) & 255) + ')');
        Intrinsics.f(headerName, "headerName");
        this.f46884f = headerName;
        this.f46885g = i8;
    }
}
