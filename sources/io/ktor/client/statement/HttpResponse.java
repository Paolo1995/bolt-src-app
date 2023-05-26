package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpResponse.kt */
/* loaded from: classes5.dex */
public abstract class HttpResponse implements HttpMessage, CoroutineScope {
    public abstract HttpClientCall Y();

    public abstract ByteReadChannel a();

    public abstract GMTDate b();

    public abstract GMTDate c();

    public abstract HttpStatusCode e();

    public abstract HttpProtocolVersion f();

    public String toString() {
        return "HttpResponse[" + HttpResponseKt.d(this).getUrl() + ", " + e() + ']';
    }
}
