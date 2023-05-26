package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultResponseValidation.kt */
/* loaded from: classes5.dex */
public final class ClientRequestException extends ResponseException {

    /* renamed from: g  reason: collision with root package name */
    private final String f46240g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientRequestException(HttpResponse response, String cachedResponseText) {
        super(response, cachedResponseText);
        Intrinsics.f(response, "response");
        Intrinsics.f(cachedResponseText, "cachedResponseText");
        this.f46240g = "Client request(" + response.Y().e().getMethod().c() + ' ' + response.Y().e().getUrl() + ") invalid: " + response.e() + ". Text: \"" + cachedResponseText + '\"';
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f46240g;
    }
}
