package eu.bolt.verification.sdk.internal;

import android.app.Application;
import eu.bolt.android.engine.html.DesignHtmlEngine;
import eu.bolt.android.engine.html.view.DesignHtmlTextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class y4 {

    /* renamed from: a  reason: collision with root package name */
    public static final y4 f45720a = new y4();

    /* renamed from: b  reason: collision with root package name */
    public static v4 f45721b;

    private y4() {
    }

    public final v4 a() {
        v4 v4Var = f45721b;
        if (v4Var != null) {
            return v4Var;
        }
        Intrinsics.w("designHtml");
        return null;
    }

    public final synchronized void b(Application application) {
        Intrinsics.f(application, "application");
        DesignHtmlEngine a8 = new w4(application).a();
        c(new v4(a8));
        DesignHtmlTextView.f36931k.a(a8);
    }

    public final void c(v4 v4Var) {
        Intrinsics.f(v4Var, "<set-?>");
        f45721b = v4Var;
    }
}
