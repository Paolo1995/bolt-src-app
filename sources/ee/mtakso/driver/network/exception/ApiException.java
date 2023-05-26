package ee.mtakso.driver.network.exception;

import ee.mtakso.driver.network.response.ErrorData;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ApiException.kt */
/* loaded from: classes3.dex */
public class ApiException extends IOException {

    /* renamed from: f  reason: collision with root package name */
    private final int f22925f;

    /* renamed from: g  reason: collision with root package name */
    private final ErrorData f22926g;

    /* renamed from: h  reason: collision with root package name */
    private final String f22927h;

    /* renamed from: i  reason: collision with root package name */
    private final String f22928i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiException(int i8, ErrorData errorData, String apiMessage, String endpoint) {
        super(endpoint + "_" + apiMessage + "(" + i8 + ")");
        Intrinsics.f(apiMessage, "apiMessage");
        Intrinsics.f(endpoint, "endpoint");
        this.f22925f = i8;
        this.f22926g = errorData;
        this.f22927h = apiMessage;
        this.f22928i = endpoint;
        setStackTrace(b());
    }

    private final String a() {
        String s02;
        String t02;
        String F;
        s02 = StringsKt__StringsKt.s0(this.f22928i, "/");
        t02 = StringsKt__StringsKt.t0(s02, "/");
        F = StringsKt__StringsJVMKt.F(t02, "/", "_", false, 4, null);
        String str = this.f22927h;
        return "Network_" + F + "-" + str;
    }

    private final StackTraceElement[] b() {
        String a8 = a();
        return new StackTraceElement[]{new StackTraceElement(a8, "backend", a8, 0)};
    }

    public final int c() {
        return this.f22925f;
    }

    public final ErrorData d() {
        return this.f22926g;
    }

    public String e() {
        ErrorData errorData = this.f22926g;
        if (errorData != null) {
            return errorData.c();
        }
        return null;
    }

    public final boolean f() {
        int i8 = this.f22925f;
        if (i8 >= 400 && i8 < 500) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
