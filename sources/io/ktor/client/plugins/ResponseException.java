package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultResponseValidation.kt */
/* loaded from: classes5.dex */
public class ResponseException extends IllegalStateException {

    /* renamed from: f  reason: collision with root package name */
    private final transient HttpResponse f46411f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseException(HttpResponse response, String cachedResponseText) {
        super("Bad response: " + response + ". Text: \"" + cachedResponseText + '\"');
        Intrinsics.f(response, "response");
        Intrinsics.f(cachedResponseText, "cachedResponseText");
        this.f46411f = response;
    }
}
