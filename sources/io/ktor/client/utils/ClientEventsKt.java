package io.ktor.client.utils;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;

/* compiled from: ClientEvents.kt */
/* loaded from: classes5.dex */
public final class ClientEventsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final EventDefinition<HttpRequestBuilder> f46703a = new EventDefinition<>();

    /* renamed from: b  reason: collision with root package name */
    private static final EventDefinition<HttpRequestBuilder> f46704b = new EventDefinition<>();

    /* renamed from: c  reason: collision with root package name */
    private static final EventDefinition<HttpResponse> f46705c = new EventDefinition<>();

    /* renamed from: d  reason: collision with root package name */
    private static final EventDefinition<HttpResponseReceiveFail> f46706d = new EventDefinition<>();

    /* renamed from: e  reason: collision with root package name */
    private static final EventDefinition<HttpResponse> f46707e = new EventDefinition<>();

    public static final EventDefinition<HttpRequestBuilder> a() {
        return f46703a;
    }

    public static final EventDefinition<HttpRequestBuilder> b() {
        return f46704b;
    }

    public static final EventDefinition<HttpResponse> c() {
        return f46707e;
    }

    public static final EventDefinition<HttpResponseReceiveFail> d() {
        return f46706d;
    }

    public static final EventDefinition<HttpResponse> e() {
        return f46705c;
    }
}
