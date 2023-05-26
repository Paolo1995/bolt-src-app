package eu.bolt.verification.sdk.internal;

import android.content.Context;
import eu.bolt.android.engine.html.DesignHtmlEngine;
import eu.bolt.android.engine.html.font.HtmlFontMapper;
import eu.bolt.android.engine.html.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* loaded from: classes5.dex */
public final class w4 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f45489a;

    /* loaded from: classes5.dex */
    public static final class a implements Logger {
        a() {
        }

        @Override // eu.bolt.android.engine.html.logger.Logger
        public void a(String message, Throwable th) {
            Intrinsics.f(message, "message");
            Timber.f53064a.c(th, message, new Object[0]);
        }
    }

    public w4(Context context) {
        Intrinsics.f(context, "context");
        this.f45489a = context;
    }

    private final a b() {
        return new a();
    }

    private final HtmlFontMapper c() {
        return new x4();
    }

    public final DesignHtmlEngine a() {
        return new DesignHtmlEngine(this.f45489a, c(), b());
    }
}
