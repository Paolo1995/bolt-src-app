package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultResponseValidation.kt */
/* loaded from: classes5.dex */
public final class ServerResponseException extends ResponseException {

    /* renamed from: g  reason: collision with root package name */
    private final String f46412g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerResponseException(HttpResponse response, String cachedResponseText) {
        super(response, cachedResponseText);
        Intrinsics.f(response, "response");
        Intrinsics.f(cachedResponseText, "cachedResponseText");
        this.f46412g = "Server error(" + response.Y().e().getMethod().c() + ' ' + response.Y().e().getUrl() + ": " + response.e() + ". Text: \"" + cachedResponseText + '\"';
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f46412g;
    }
}
