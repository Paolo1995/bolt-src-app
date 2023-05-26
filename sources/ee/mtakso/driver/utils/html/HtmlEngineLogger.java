package ee.mtakso.driver.utils.html;

import eu.bolt.android.engine.html.logger.Logger;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlEngineLogger.kt */
/* loaded from: classes5.dex */
public final class HtmlEngineLogger implements Logger {
    @Override // eu.bolt.android.engine.html.logger.Logger
    public void a(String message, Throwable th) {
        Intrinsics.f(message, "message");
        if (th == null) {
            Kalev.d(message);
        } else {
            Kalev.e(th, message);
        }
    }
}
