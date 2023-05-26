package ee.mtakso.driver.network.exception;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpException.kt */
/* loaded from: classes3.dex */
public final class HttpException extends IOException {

    /* renamed from: f  reason: collision with root package name */
    private final String f22930f;

    /* renamed from: g  reason: collision with root package name */
    private final String f22931g;

    /* renamed from: h  reason: collision with root package name */
    private final int f22932h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(String host, String path, int i8) {
        super("Network call failed: " + host + " :: " + path + " code: " + i8);
        Intrinsics.f(host, "host");
        Intrinsics.f(path, "path");
        this.f22930f = host;
        this.f22931g = path;
        this.f22932h = i8;
    }
}
