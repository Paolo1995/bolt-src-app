package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: JsonContentTypeMatcher.kt */
/* loaded from: classes5.dex */
public final class JsonContentTypeMatcher implements ContentTypeMatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonContentTypeMatcher f46495a = new JsonContentTypeMatcher();

    private JsonContentTypeMatcher() {
    }

    @Override // io.ktor.http.ContentTypeMatcher
    public boolean a(ContentType contentType) {
        boolean L;
        boolean v7;
        Intrinsics.f(contentType, "contentType");
        if (contentType.h(ContentType.Application.f46731a.a())) {
            return true;
        }
        String headerValueWithParameters = contentType.j().toString();
        L = StringsKt__StringsJVMKt.L(headerValueWithParameters, "application/", false, 2, null);
        if (L) {
            v7 = StringsKt__StringsJVMKt.v(headerValueWithParameters, "+json", false, 2, null);
            if (v7) {
                return true;
            }
        }
        return false;
    }
}
