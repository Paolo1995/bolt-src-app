package eu.bolt.verification.sdk.internal;

import eu.bolt.logger.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class zb implements Logger {

    /* renamed from: a  reason: collision with root package name */
    private final String f45845a;

    public zb(String str) {
        this.f45845a = str;
    }

    public /* synthetic */ zb(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : str);
    }

    private final void j() {
        String str = this.f45845a;
        if (str != null) {
            Timber.f53064a.o(str);
        }
    }

    @Override // eu.bolt.logger.Logger
    public void a(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        j();
        Timber.f53064a.c(e8, str, new Object[0]);
    }

    @Override // eu.bolt.logger.Logger
    public void b(String message) {
        Intrinsics.f(message, "message");
        j();
        Timber.f53064a.h(message, new Object[0]);
    }

    @Override // eu.bolt.logger.Logger
    public void c(Throwable e8) {
        Intrinsics.f(e8, "e");
        j();
        Timber.f53064a.b(e8);
    }

    @Override // eu.bolt.logger.Logger
    public void d(String message) {
        Intrinsics.f(message, "message");
        j();
        Timber.f53064a.m(message, new Object[0]);
    }

    @Override // eu.bolt.logger.Logger
    public void e(String message) {
        Intrinsics.f(message, "message");
        j();
        Timber.f53064a.a(message, new Object[0]);
    }

    @Override // eu.bolt.logger.Logger
    public void f(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        j();
        Timber.f53064a.n(e8, str, new Object[0]);
    }

    @Override // eu.bolt.logger.Logger
    public void g(Throwable e8, String str) {
        Intrinsics.f(e8, "e");
        c(e8);
    }

    @Override // eu.bolt.logger.Logger
    public void h(Throwable e8) {
        Intrinsics.f(e8, "e");
        c(e8);
    }

    @Override // eu.bolt.logger.Logger
    public void i(String message) {
        Intrinsics.f(message, "message");
        c(new RuntimeException(message));
    }
}
