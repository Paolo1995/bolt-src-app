package io.ktor.client.request;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpRequest.kt */
/* loaded from: classes5.dex */
public interface HttpRequest extends HttpMessage, CoroutineScope {

    /* compiled from: HttpRequest.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static CoroutineContext a(HttpRequest httpRequest) {
            return httpRequest.Y().j();
        }
    }

    HttpClientCall Y();

    Attributes getAttributes();

    OutgoingContent getContent();

    HttpMethod getMethod();

    Url getUrl();

    CoroutineContext j();
}
