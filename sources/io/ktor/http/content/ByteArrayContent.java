package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayContent.kt */
/* loaded from: classes5.dex */
public final class ByteArrayContent extends OutgoingContent.ByteArrayContent {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f46940a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentType f46941b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpStatusCode f46942c;

    public /* synthetic */ ByteArrayContent(byte[] bArr, ContentType contentType, HttpStatusCode httpStatusCode, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i8 & 2) != 0 ? null : contentType, (i8 & 4) != 0 ? null : httpStatusCode);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long a() {
        return Long.valueOf(this.f46940a.length);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType b() {
        return this.f46941b;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode d() {
        return this.f46942c;
    }

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public byte[] e() {
        return this.f46940a;
    }

    public ByteArrayContent(byte[] bytes, ContentType contentType, HttpStatusCode httpStatusCode) {
        Intrinsics.f(bytes, "bytes");
        this.f46940a = bytes;
        this.f46941b = contentType;
        this.f46942c = httpStatusCode;
    }
}
