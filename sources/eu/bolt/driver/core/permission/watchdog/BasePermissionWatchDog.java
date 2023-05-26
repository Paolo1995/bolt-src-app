package eu.bolt.driver.core.permission.watchdog;

import eu.bolt.driver.core.permission.PermissionInitiatorTracker;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.utils.AssertUtils;
import eu.bolt.kalev.Kalev;
import i0.a;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasePermissionWatchDog.kt */
/* loaded from: classes5.dex */
public abstract class BasePermissionWatchDog<T> implements PermissionWatchDog {

    /* renamed from: e  reason: collision with root package name */
    private static final Companion f40928e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f40929a;

    /* renamed from: b  reason: collision with root package name */
    private final PermissionManager f40930b;

    /* renamed from: c  reason: collision with root package name */
    private final PermissionInitiatorTracker f40931c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<T> f40932d;

    /* compiled from: BasePermissionWatchDog.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BasePermissionWatchDog(long j8, T t7, PermissionManager permissionManager, PermissionInitiatorTracker permissionInitiatorTracker) {
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(permissionInitiatorTracker, "permissionInitiatorTracker");
        this.f40929a = j8;
        this.f40930b = permissionManager;
        this.f40931c = permissionInitiatorTracker;
        this.f40932d = new WeakReference<>(t7);
    }

    @Override // eu.bolt.driver.core.permission.watchdog.PermissionWatchDog
    public boolean a() {
        if (this.f40932d.get() == null) {
            return true;
        }
        return false;
    }

    @Override // eu.bolt.driver.core.permission.watchdog.PermissionWatchDog
    public PermissionManager.PermissionInfo b(String permission) {
        Intrinsics.f(permission, "permission");
        T t7 = this.f40932d.get();
        if (t7 == null) {
            return null;
        }
        if (f(t7, permission)) {
            return new PermissionManager.PermissionInfo(permission, PermissionManager.PermissionStatus.GRANTED, null, null);
        }
        this.f40931c.d(permission, h(t7, permission));
        PermissionInitiatorTracker.Result b8 = this.f40931c.b(permission);
        return new PermissionManager.PermissionInfo(permission, PermissionManager.PermissionStatus.DENIED, b8.a(), b8.b());
    }

    @Override // eu.bolt.driver.core.permission.watchdog.PermissionWatchDog
    public void c(int i8, String[] permissions, int[] grantResults) {
        boolean z7;
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        if (this.f40932d.get() == null || i8 != 99) {
            return;
        }
        if (permissions.length != grantResults.length) {
            int length = permissions.length;
            int length2 = grantResults.length;
            AssertUtils.a("Not usual situation. Permissions size (" + length + ") is differ from grantResults size (" + length2 + ")");
        }
        if (grantResults.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            Kalev.l("Looks like your permission request was cancelled. Does your fragment really have attached watch dog?");
        }
        int min = Math.min(permissions.length, grantResults.length);
        for (int i9 = 0; i9 < min; i9++) {
            String str = permissions[i9];
            if (grantResults[i9] == 0) {
                this.f40930b.b(str);
            } else {
                PermissionInitiatorTracker.Result b8 = this.f40931c.b(str);
                this.f40930b.a(str, b8.a(), b8.b());
            }
        }
    }

    @Override // eu.bolt.driver.core.permission.watchdog.PermissionWatchDog
    public boolean d(String permission) {
        Intrinsics.f(permission, "permission");
        T t7 = this.f40932d.get();
        if (t7 == null) {
            return false;
        }
        if (f(t7, permission)) {
            this.f40930b.b(permission);
            return true;
        }
        this.f40931c.d(permission, h(t7, permission));
        g(t7, new String[]{permission}, 99);
        return true;
    }

    public long e() {
        return this.f40929a;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<?> cls2 = getClass();
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.a(cls2, cls)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type eu.bolt.driver.core.permission.watchdog.BasePermissionWatchDog<*>");
        BasePermissionWatchDog basePermissionWatchDog = (BasePermissionWatchDog) obj;
        if (e() == basePermissionWatchDog.e() && Intrinsics.a(this.f40932d, basePermissionWatchDog.f40932d)) {
            return true;
        }
        return false;
    }

    protected abstract boolean f(T t7, String str);

    protected abstract void g(T t7, String[] strArr, int i8);

    protected abstract boolean h(T t7, String str);

    public int hashCode() {
        return (a.a(e()) * 31) + this.f40932d.hashCode();
    }
}
