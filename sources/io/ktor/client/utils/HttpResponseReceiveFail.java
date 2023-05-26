package io.ktor.client.utils;

import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientEvents.kt */
/* loaded from: classes5.dex */
public final class HttpResponseReceiveFail {

    /* renamed from: a  reason: collision with root package name */
    private final HttpResponse f46710a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f46711b;

    public HttpResponseReceiveFail(HttpResponse response, Throwable cause) {
        Intrinsics.f(response, "response");
        Intrinsics.f(cause, "cause");
        this.f46710a = response;
        this.f46711b = cause;
    }
}
