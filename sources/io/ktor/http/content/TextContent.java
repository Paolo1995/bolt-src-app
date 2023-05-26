package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: TextContent.kt */
/* loaded from: classes5.dex */
public final class TextContent extends OutgoingContent.ByteArrayContent {

    /* renamed from: a  reason: collision with root package name */
    private final String f46944a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentType f46945b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpStatusCode f46946c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f46947d;

    public /* synthetic */ TextContent(String str, ContentType contentType, HttpStatusCode httpStatusCode, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, contentType, (i8 & 4) != 0 ? null : httpStatusCode);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long a() {
        return Long.valueOf(this.f46947d.length);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType b() {
        return this.f46945b;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode d() {
        return this.f46946c;
    }

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public byte[] e() {
        return this.f46947d;
    }

    public String toString() {
        String f12;
        StringBuilder sb = new StringBuilder();
        sb.append("TextContent[");
        sb.append(b());
        sb.append("] \"");
        f12 = StringsKt___StringsKt.f1(this.f46944a, 30);
        sb.append(f12);
        sb.append('\"');
        return sb.toString();
    }

    public TextContent(String text, ContentType contentType, HttpStatusCode httpStatusCode) {
        byte[] g8;
        Intrinsics.f(text, "text");
        Intrinsics.f(contentType, "contentType");
        this.f46944a = text;
        this.f46945b = contentType;
        this.f46946c = httpStatusCode;
        Charset a8 = ContentTypesKt.a(b());
        a8 = a8 == null ? Charsets.f51135b : a8;
        if (Intrinsics.a(a8, Charsets.f51135b)) {
            g8 = StringsKt__StringsJVMKt.t(text);
        } else {
            CharsetEncoder newEncoder = a8.newEncoder();
            Intrinsics.e(newEncoder, "charset.newEncoder()");
            g8 = CharsetJVMKt.g(newEncoder, text, 0, text.length());
        }
        this.f46947d = g8;
    }
}
