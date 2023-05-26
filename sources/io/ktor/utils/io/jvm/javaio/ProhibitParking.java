package io.ktor.utils.io.jvm.javaio;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pollers.kt */
/* loaded from: classes5.dex */
final class ProhibitParking implements Parking<Thread> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProhibitParking f47502a = new ProhibitParking();

    private ProhibitParking() {
    }

    private final Void c() {
        throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public void a(long j8) {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    /* renamed from: d */
    public void b(Thread token) {
        Intrinsics.f(token, "token");
        DefaultParking.f47490a.b(token);
    }
}
