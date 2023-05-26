package eu.bolt.driver.core.permission;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.driver.core.utils.AssertUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionManager.kt */
@Singleton
/* loaded from: classes5.dex */
public final class PermissionManager implements PermissionCallback {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f40899f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final PermissionInitiatorTracker f40900a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f40901b;

    /* renamed from: c  reason: collision with root package name */
    private final Stack<PermissionWatchDog> f40902c;

    /* renamed from: d  reason: collision with root package name */
    private final PermissionWatchDogFactory f40903d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Set<PermissionCallback>> f40904e;

    /* compiled from: PermissionManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(PermissionInfo permissionInfo) {
            Intrinsics.f(permissionInfo, "<this>");
            if (permissionInfo.a() == DenyInitiator.AUTOMATIC_DENY) {
                return true;
            }
            return false;
        }

        public final boolean b(PermissionInfo permissionInfo) {
            Intrinsics.f(permissionInfo, "<this>");
            if (permissionInfo.c() == RationalStatus.RATIONAL_IS_A_MANDATORY) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: PermissionManager.kt */
    /* loaded from: classes5.dex */
    public enum DenyInitiator {
        DENIED_BY_USER,
        AUTOMATIC_DENY
    }

    /* compiled from: PermissionManager.kt */
    /* loaded from: classes5.dex */
    public static final class PermissionInfo {

        /* renamed from: a  reason: collision with root package name */
        private final String f40908a;

        /* renamed from: b  reason: collision with root package name */
        private final PermissionStatus f40909b;

        /* renamed from: c  reason: collision with root package name */
        private final DenyInitiator f40910c;

        /* renamed from: d  reason: collision with root package name */
        private final RationalStatus f40911d;

        public PermissionInfo(String permission, PermissionStatus status, DenyInitiator denyInitiator, RationalStatus rationalStatus) {
            Intrinsics.f(permission, "permission");
            Intrinsics.f(status, "status");
            this.f40908a = permission;
            this.f40909b = status;
            this.f40910c = denyInitiator;
            this.f40911d = rationalStatus;
        }

        public final DenyInitiator a() {
            return this.f40910c;
        }

        public final String b() {
            return this.f40908a;
        }

        public final RationalStatus c() {
            return this.f40911d;
        }

        public final PermissionStatus d() {
            return this.f40909b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PermissionInfo) {
                PermissionInfo permissionInfo = (PermissionInfo) obj;
                return Intrinsics.a(this.f40908a, permissionInfo.f40908a) && this.f40909b == permissionInfo.f40909b && this.f40910c == permissionInfo.f40910c && this.f40911d == permissionInfo.f40911d;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f40908a.hashCode() * 31) + this.f40909b.hashCode()) * 31;
            DenyInitiator denyInitiator = this.f40910c;
            int hashCode2 = (hashCode + (denyInitiator == null ? 0 : denyInitiator.hashCode())) * 31;
            RationalStatus rationalStatus = this.f40911d;
            return hashCode2 + (rationalStatus != null ? rationalStatus.hashCode() : 0);
        }

        public String toString() {
            String str = this.f40908a;
            PermissionStatus permissionStatus = this.f40909b;
            DenyInitiator denyInitiator = this.f40910c;
            RationalStatus rationalStatus = this.f40911d;
            return "PermissionInfo(permission=" + str + ", status=" + permissionStatus + ", denyInitiator=" + denyInitiator + ", rationalStatus=" + rationalStatus + ")";
        }
    }

    /* compiled from: PermissionManager.kt */
    /* loaded from: classes5.dex */
    public enum PermissionStatus {
        GRANTED,
        DENIED
    }

    /* compiled from: PermissionManager.kt */
    /* loaded from: classes5.dex */
    public enum RationalStatus {
        RATIONAL_IS_OPTIONAL,
        RATIONAL_IS_A_MANDATORY,
        UNKNOWN
    }

    @Inject
    public PermissionManager(PermissionInitiatorTracker permissionInitiatorTracker) {
        Intrinsics.f(permissionInitiatorTracker, "permissionInitiatorTracker");
        this.f40900a = permissionInitiatorTracker;
        this.f40901b = new Handler(Looper.getMainLooper());
        this.f40902c = new Stack<>();
        this.f40903d = new PermissionWatchDogFactory(this, permissionInitiatorTracker);
        this.f40904e = new LinkedHashMap();
    }

    private final synchronized void e(String str, PermissionCallback permissionCallback) {
        if (!this.f40904e.containsKey(str)) {
            this.f40904e.put(str, new LinkedHashSet());
        }
        Set<PermissionCallback> set = this.f40904e.get(str);
        if (set != null) {
            set.add(permissionCallback);
        }
    }

    private final synchronized void i(String str) {
        if (!this.f40904e.containsKey(str)) {
            return;
        }
        this.f40904e.remove(str);
    }

    public static /* synthetic */ Single l(PermissionManager permissionManager, String str, Context context, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            context = null;
        }
        return permissionManager.j(str, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(PermissionManager this$0, String permission, Context context, final SingleEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(permission, "$permission");
        Intrinsics.f(emitter, "emitter");
        this$0.p(permission, new PermissionCallback() { // from class: eu.bolt.driver.core.permission.PermissionManager$requestPermission$single$1$1
            @Override // eu.bolt.driver.core.permission.PermissionCallback
            public void a(String permission2, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
                Intrinsics.f(permission2, "permission");
                Intrinsics.f(initiator, "initiator");
                Intrinsics.f(rationalStatus, "rationalStatus");
                Kalev.h("onPermissionDenied");
                emitter.onSuccess(new PermissionManager.PermissionInfo(permission2, PermissionManager.PermissionStatus.DENIED, initiator, rationalStatus));
            }

            @Override // eu.bolt.driver.core.permission.PermissionCallback
            public void b(String permission2) {
                Intrinsics.f(permission2, "permission");
                Kalev.h("onPermissionGranted");
                emitter.onSuccess(new PermissionManager.PermissionInfo(permission2, PermissionManager.PermissionStatus.GRANTED, null, null));
            }
        }, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(PermissionManager this$0, String permission, PermissionCallback permissionCallback) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(permission, "$permission");
        Intrinsics.f(permissionCallback, "$permissionCallback");
        q(this$0, permission, permissionCallback, null, 4, null);
    }

    private final void p(String str, PermissionCallback permissionCallback, Context context) {
        List<PermissionWatchDog> r02;
        AssertUtils.d("requestPermission should be called only from main thread");
        if (context != null && ContextCompat.checkSelfPermission(context, str) == 0) {
            permissionCallback.b(str);
            return;
        }
        e(str, permissionCallback);
        r02 = CollectionsKt___CollectionsKt.r0(this.f40902c);
        for (PermissionWatchDog permissionWatchDog : r02) {
            if (!permissionWatchDog.a() && permissionWatchDog.d(str)) {
                return;
            }
        }
        throw new IllegalStateException("Could not find proper watch dog to resolve request");
    }

    static /* synthetic */ void q(PermissionManager permissionManager, String str, PermissionCallback permissionCallback, Context context, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            context = null;
        }
        permissionManager.p(str, permissionCallback, context);
    }

    @Override // eu.bolt.driver.core.permission.PermissionCallback
    public void a(String permission, DenyInitiator initiator, RationalStatus rationalStatus) {
        Intrinsics.f(permission, "permission");
        Intrinsics.f(initiator, "initiator");
        Intrinsics.f(rationalStatus, "rationalStatus");
        AssertUtils.d("onPermissionDenied should be called only from main thread");
        synchronized (this) {
            Set<PermissionCallback> set = this.f40904e.get(permission);
            if (set == null) {
                set = Collections.emptySet();
            }
            for (PermissionCallback permissionCallback : set) {
                permissionCallback.a(permission, initiator, rationalStatus);
            }
            i(permission);
            Unit unit = Unit.f50853a;
        }
    }

    @Override // eu.bolt.driver.core.permission.PermissionCallback
    public void b(String permission) {
        Intrinsics.f(permission, "permission");
        AssertUtils.d("onPermissionGranted should be called only from main thread");
        synchronized (this) {
            Set<PermissionCallback> set = this.f40904e.get(permission);
            if (set == null) {
                set = Collections.emptySet();
            }
            for (PermissionCallback permissionCallback : set) {
                permissionCallback.b(permission);
            }
            i(permission);
            Unit unit = Unit.f50853a;
        }
    }

    public final PermissionWatchDog f(AppCompatActivity activity) {
        Intrinsics.f(activity, "activity");
        AssertUtils.d("attachWatchDog should be called only from main thread");
        PermissionWatchDog a8 = this.f40903d.a(activity);
        this.f40902c.push(a8);
        return a8;
    }

    public final PermissionWatchDog g(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        AssertUtils.d("attachWatchDog should be called only from main thread");
        PermissionWatchDog b8 = this.f40903d.b(fragment);
        this.f40902c.push(b8);
        return b8;
    }

    public final void h(PermissionWatchDog victim) {
        Intrinsics.f(victim, "victim");
        AssertUtils.d("killWatchDog should be called only from main thread");
        this.f40902c.remove(victim);
    }

    public final Single<PermissionInfo> j(final String permission, final Context context) {
        Intrinsics.f(permission, "permission");
        Single f8 = Single.f(new SingleOnSubscribe() { // from class: z6.b
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                PermissionManager.m(PermissionManager.this, permission, context, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter ->\n    …    }, context)\n        }");
        Single<PermissionInfo> z7 = f8.z(AndroidSchedulers.a());
        Intrinsics.e(z7, "single.observeOn(AndroidSchedulers.mainThread())");
        return z7;
    }

    public final void k(final String permission, final PermissionCallback permissionCallback) {
        Intrinsics.f(permission, "permission");
        Intrinsics.f(permissionCallback, "permissionCallback");
        this.f40901b.post(new Runnable() { // from class: z6.a
            @Override // java.lang.Runnable
            public final void run() {
                PermissionManager.n(PermissionManager.this, permission, permissionCallback);
            }
        });
    }

    public final PermissionInfo o(String permission) {
        List<PermissionWatchDog> r02;
        PermissionInfo b8;
        Intrinsics.f(permission, "permission");
        AssertUtils.d("requestDenyStatus should be called only from main thread");
        r02 = CollectionsKt___CollectionsKt.r0(this.f40902c);
        for (PermissionWatchDog permissionWatchDog : r02) {
            if (!permissionWatchDog.a() && (b8 = permissionWatchDog.b(permission)) != null) {
                return b8;
            }
        }
        throw new IllegalStateException("No activity to resolve state");
    }
}
