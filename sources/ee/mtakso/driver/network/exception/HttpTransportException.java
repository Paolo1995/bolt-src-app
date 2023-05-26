package ee.mtakso.driver.network.exception;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpTransportException.kt */
/* loaded from: classes3.dex */
public final class HttpTransportException extends IOException {

    /* renamed from: f  reason: collision with root package name */
    private final String f22933f;

    /* renamed from: g  reason: collision with root package name */
    private final String f22934g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTransportException(String host, String path, Throwable cause) {
        super("Network call failed due transport error: " + host + " :: " + path, cause);
        Intrinsics.f(host, "host");
        Intrinsics.f(path, "path");
        Intrinsics.f(cause, "cause");
        this.f22933f = host;
        this.f22934g = path;
    }
}
