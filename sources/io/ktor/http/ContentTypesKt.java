package io.ktor.http;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentTypes.kt */
/* loaded from: classes5.dex */
public final class ContentTypesKt {
    public static final Charset a(HeaderValueWithParameters headerValueWithParameters) {
        Intrinsics.f(headerValueWithParameters, "<this>");
        String c8 = headerValueWithParameters.c("charset");
        if (c8 == null) {
            return null;
        }
        try {
            return Charset.forName(c8);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final ContentType b(ContentType contentType, Charset charset) {
        Intrinsics.f(contentType, "<this>");
        Intrinsics.f(charset, "charset");
        return contentType.i("charset", CharsetJVMKt.i(charset));
    }

    public static final ContentType c(ContentType contentType, Charset charset) {
        Intrinsics.f(contentType, "<this>");
        Intrinsics.f(charset, "charset");
        String f8 = contentType.f();
        Locale locale = Locale.ROOT;
        String lowerCase = f8.toLowerCase(locale);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.a(lowerCase, "application")) {
            String lowerCase2 = contentType.e().toLowerCase(locale);
            Intrinsics.e(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.a(lowerCase2, "json")) {
                return contentType;
            }
        }
        return contentType.i("charset", CharsetJVMKt.i(charset));
    }
}
