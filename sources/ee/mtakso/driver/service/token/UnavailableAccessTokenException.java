package ee.mtakso.driver.service.token;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnavailableAccessTokenException.kt */
/* loaded from: classes3.dex */
public final class UnavailableAccessTokenException extends Exception {

    /* renamed from: f  reason: collision with root package name */
    private final Throwable f26076f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnavailableAccessTokenException(Throwable cause) {
        super("Access token unavailable", cause);
        Intrinsics.f(cause, "cause");
        this.f26076f = cause;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f26076f;
    }
}
