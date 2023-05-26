package eu.bolt.verification.sdk.internal;

import android.net.Uri;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes5.dex */
public final class v3 {

    /* renamed from: a  reason: collision with root package name */
    private final Function0<Unit> f45426a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<String, Boolean> f45427b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<String, Unit> f45428c;

    /* JADX WARN: Multi-variable type inference failed */
    public v3(Function0<Unit> closeRequest, Function1<? super String, Boolean> actionRequest, Function1<? super String, Unit> unsupportedDeeplinkFound) {
        Intrinsics.f(closeRequest, "closeRequest");
        Intrinsics.f(actionRequest, "actionRequest");
        Intrinsics.f(unsupportedDeeplinkFound, "unsupportedDeeplinkFound");
        this.f45426a = closeRequest;
        this.f45427b = actionRequest;
        this.f45428c = unsupportedDeeplinkFound;
    }

    private final void a(String str) {
        boolean Q;
        Q = StringsKt__StringsKt.Q(str, u3.CLOSE_BROWSER.c(), false, 2, null);
        if (Q) {
            this.f45426a.invoke();
        } else if (this.f45427b.invoke(str).booleanValue()) {
        } else {
            this.f45428c.invoke(str);
        }
    }

    public final boolean b(String url) {
        Intrinsics.f(url, "url");
        w3 w3Var = w3.f45487a;
        Uri parse = Uri.parse(url);
        Intrinsics.e(parse, "parse(url)");
        if (w3Var.b(parse)) {
            a(url);
            return true;
        }
        return false;
    }
}
