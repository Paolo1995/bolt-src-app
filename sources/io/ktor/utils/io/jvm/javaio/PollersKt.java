package io.ktor.utils.io.jvm.javaio;

/* compiled from: Pollers.kt */
/* loaded from: classes5.dex */
public final class PollersKt {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Parking<Thread>> f47501a = new ThreadLocal<>();

    public static final Parking<Thread> a() {
        Parking<Thread> parking = f47501a.get();
        if (parking == null) {
            return DefaultParking.f47490a;
        }
        return parking;
    }

    public static final boolean b() {
        if (a() != ProhibitParking.f47502a) {
            return true;
        }
        return false;
    }
}
