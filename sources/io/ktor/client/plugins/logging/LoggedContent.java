package io.ktor.client.plugins.logging;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggedContent.kt */
/* loaded from: classes5.dex */
public final class LoggedContent extends OutgoingContent.ReadChannelContent {

    /* renamed from: a  reason: collision with root package name */
    private final OutgoingContent f46526a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteReadChannel f46527b;

    /* renamed from: c  reason: collision with root package name */
    private final ContentType f46528c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f46529d;

    /* renamed from: e  reason: collision with root package name */
    private final HttpStatusCode f46530e;

    /* renamed from: f  reason: collision with root package name */
    private final Headers f46531f;

    public LoggedContent(OutgoingContent originalContent, ByteReadChannel channel) {
        Intrinsics.f(originalContent, "originalContent");
        Intrinsics.f(channel, "channel");
        this.f46526a = originalContent;
        this.f46527b = channel;
        this.f46528c = originalContent.b();
        this.f46529d = originalContent.a();
        this.f46530e = originalContent.d();
        this.f46531f = originalContent.c();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long a() {
        return this.f46529d;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType b() {
        return this.f46528c;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers c() {
        return this.f46531f;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode d() {
        return this.f46530e;
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel e() {
        return this.f46527b;
    }
}
