package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pollers.kt */
/* loaded from: classes5.dex */
final class DefaultParking implements Parking<Thread> {

    /* renamed from: a  reason: collision with root package name */
    public static final DefaultParking f47490a = new DefaultParking();

    private DefaultParking() {
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public void a(long j8) {
        boolean z7;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            LockSupport.parkNanos(j8);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    /* renamed from: c */
    public void b(Thread token) {
        Intrinsics.f(token, "token");
        LockSupport.unpark(token);
    }
}
