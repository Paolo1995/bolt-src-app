package ee.mtakso.driver.utils.power;

import android.annotation.SuppressLint;
import android.os.PowerManager;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WakeLockManager.kt */
/* loaded from: classes5.dex */
public final class WakeLockManager {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f36459c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private static final int f36460d = 32;

    /* renamed from: a  reason: collision with root package name */
    private final PowerManager f36461a;

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f36462b;

    /* compiled from: WakeLockManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return WakeLockManager.f36460d;
        }
    }

    @Inject
    public WakeLockManager(PowerManager powerManager) {
        Intrinsics.f(powerManager, "powerManager");
        this.f36461a = powerManager;
    }

    private final PowerManager.WakeLock d(int i8, String str) {
        PowerManager.WakeLock lock = this.f36461a.newWakeLock(i8, str);
        this.f36462b = lock;
        Intrinsics.e(lock, "lock");
        return lock;
    }

    @SuppressLint({"WakelockTimeout"})
    public final void b(int i8, String tag) {
        Intrinsics.f(tag, "tag");
        PowerManager.WakeLock wakeLock = this.f36462b;
        if (wakeLock == null) {
            wakeLock = d(i8, tag);
        }
        if (wakeLock.isHeld()) {
            return;
        }
        wakeLock.acquire();
    }

    public final void c(int i8, String tag, long j8) {
        Intrinsics.f(tag, "tag");
        PowerManager.WakeLock wakeLock = this.f36462b;
        if (wakeLock == null) {
            wakeLock = d(i8, tag);
        }
        if (wakeLock.isHeld()) {
            return;
        }
        wakeLock.acquire(j8);
    }

    public final void e() {
        PowerManager.WakeLock wakeLock = this.f36462b;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        wakeLock.release();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WakeLockManager(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "power"
            java.lang.Object r2 = r2.getSystemService(r0)
            java.lang.String r0 = "null cannot be cast to non-null type android.os.PowerManager"
            kotlin.jvm.internal.Intrinsics.d(r2, r0)
            android.os.PowerManager r2 = (android.os.PowerManager) r2
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.utils.power.WakeLockManager.<init>(android.content.Context):void");
    }
}
