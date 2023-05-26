package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: SavedCall.kt */
/* loaded from: classes5.dex */
public final class SavedHttpResponse extends HttpResponse {

    /* renamed from: f  reason: collision with root package name */
    private final SavedHttpCall f46092f;

    /* renamed from: g  reason: collision with root package name */
    private final CompletableJob f46093g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpStatusCode f46094h;

    /* renamed from: i  reason: collision with root package name */
    private final HttpProtocolVersion f46095i;

    /* renamed from: j  reason: collision with root package name */
    private final GMTDate f46096j;

    /* renamed from: k  reason: collision with root package name */
    private final GMTDate f46097k;

    /* renamed from: l  reason: collision with root package name */
    private final Headers f46098l;

    /* renamed from: m  reason: collision with root package name */
    private final CoroutineContext f46099m;

    /* renamed from: n  reason: collision with root package name */
    private final ByteReadChannel f46100n;

    public SavedHttpResponse(SavedHttpCall call, byte[] body, HttpResponse origin) {
        CompletableJob b8;
        Intrinsics.f(call, "call");
        Intrinsics.f(body, "body");
        Intrinsics.f(origin, "origin");
        this.f46092f = call;
        b8 = JobKt__JobKt.b(null, 1, null);
        this.f46093g = b8;
        this.f46094h = origin.e();
        this.f46095i = origin.f();
        this.f46096j = origin.b();
        this.f46097k = origin.c();
        this.f46098l = origin.getHeaders();
        this.f46099m = origin.j().s0(b8);
        this.f46100n = ByteChannelCtorKt.a(body);
    }

    @Override // io.ktor.client.statement.HttpResponse
    public ByteReadChannel a() {
        return this.f46100n;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate b() {
        return this.f46096j;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate c() {
        return this.f46097k;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpStatusCode e() {
        return this.f46094h;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpProtocolVersion f() {
        return this.f46095i;
    }

    @Override // io.ktor.client.statement.HttpResponse
    /* renamed from: g */
    public SavedHttpCall Y() {
        return this.f46092f;
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.f46098l;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f46099m;
    }
}
