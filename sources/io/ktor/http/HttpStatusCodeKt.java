package io.ktor.http;

import io.ktor.http.HttpStatusCode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpStatusCode.kt */
/* loaded from: classes5.dex */
public final class HttpStatusCodeKt {
    public static final List<HttpStatusCode> a() {
        List<HttpStatusCode> n8;
        HttpStatusCode.Companion companion = HttpStatusCode.f46855c;
        n8 = CollectionsKt__CollectionsKt.n(companion.e(), companion.Q(), companion.G(), companion.A(), companion.f(), companion.a(), companion.v(), companion.u(), companion.M(), companion.B(), companion.s(), companion.t(), companion.r(), companion.j(), companion.N(), companion.z(), companion.X(), companion.P(), companion.R(), companion.E(), companion.c(), companion.T(), companion.D(), companion.i(), companion.x(), companion.q(), companion.w(), companion.H(), companion.J(), companion.d(), companion.l(), companion.o(), companion.F(), companion.C(), companion.K(), companion.V(), companion.L(), companion.g(), companion.U(), companion.p(), companion.h(), companion.W(), companion.S(), companion.I(), companion.n(), companion.y(), companion.b(), companion.O(), companion.k(), companion.Z(), companion.Y(), companion.m());
        return n8;
    }

    public static final boolean b(HttpStatusCode httpStatusCode) {
        Intrinsics.f(httpStatusCode, "<this>");
        int b02 = httpStatusCode.b0();
        if (200 > b02 || b02 >= 300) {
            return false;
        }
        return true;
    }
}
