package io.ktor.client.plugins;

import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;

/* compiled from: HttpRedirect.kt */
/* loaded from: classes5.dex */
public final class HttpRedirectKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<HttpMethod> f46362a;

    static {
        Set<HttpMethod> f8;
        HttpMethod.Companion companion = HttpMethod.f46834b;
        f8 = SetsKt__SetsKt.f(companion.a(), companion.b());
        f46362a = f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(HttpStatusCode httpStatusCode) {
        boolean z7;
        boolean z8;
        boolean z9;
        int b02 = httpStatusCode.b0();
        HttpStatusCode.Companion companion = HttpStatusCode.f46855c;
        if (b02 == companion.r().b0() || b02 == companion.j().b0()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 || b02 == companion.R().b0()) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8 || b02 == companion.E().b0()) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (!z9 && b02 != companion.N().b0()) {
            return false;
        }
        return true;
    }
}
