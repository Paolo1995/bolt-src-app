package eu.bolt.verification.sdk.internal;

import android.net.Uri;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w3 {

    /* renamed from: a  reason: collision with root package name */
    public static final w3 f45487a;

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f45488b;

    static {
        w3 w3Var = new w3();
        f45487a = w3Var;
        f45488b = w3Var.a();
    }

    private w3() {
    }

    private final Set<String> a() {
        Set<String> d8;
        d8 = SetsKt__SetsKt.d("bolt", "taxify");
        if (g2.f43075c) {
            d8.add("boltprelive");
        }
        return d8;
    }

    private final boolean c(Uri uri) {
        boolean P;
        P = CollectionsKt___CollectionsKt.P(f45488b, uri.getScheme());
        return P;
    }

    public final boolean b(Uri uri) {
        Intrinsics.f(uri, "uri");
        if (c(uri)) {
            String host = uri.getHost();
            return host != null && host.equals("action");
        }
        return false;
    }
}
