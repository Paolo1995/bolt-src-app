package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxSerializationConverter.kt */
/* loaded from: classes5.dex */
public final class KotlinxSerializationConverterKt {
    public static final void a(Configuration configuration, ContentType contentType, StringFormat format) {
        Intrinsics.f(configuration, "<this>");
        Intrinsics.f(contentType, "contentType");
        Intrinsics.f(format, "format");
        Configuration.DefaultImpls.a(configuration, contentType, new KotlinxSerializationConverter(format), null, 4, null);
    }
}
