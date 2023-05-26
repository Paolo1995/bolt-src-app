package ee.mtakso.driver.service.integration.clevertap;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.integration.clevertap.internal.CleverTapInboxEvent;
import ee.mtakso.driver.service.integration.clevertap.internal.CleverTapInboxListener;
import ee.mtakso.driver.service.integration.clevertap.internal.CleverTapInboxStyle;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CleverTapManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class CleverTapManager {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f24534c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private CleverTapAPI f24535a;

    /* renamed from: b  reason: collision with root package name */
    private final BehaviorSubject<CleverTapInboxEvent> f24536b;

    /* compiled from: CleverTapManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public CleverTapManager() {
        BehaviorSubject<CleverTapInboxEvent> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<CleverTapInboxEvent>()");
        this.f24536b = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CleverTapAPI i() {
        CleverTapAPI cleverTapAPI = this.f24535a;
        if (cleverTapAPI != null) {
            return cleverTapAPI;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Integer) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public final void h() {
        i().J();
    }

    public final boolean j(Context context, Bundle bundle) {
        Intrinsics.f(context, "context");
        Intrinsics.f(bundle, "bundle");
        if (!CleverTapAPI.E(bundle).f11678a) {
            return false;
        }
        if (!TextUtils.isEmpty(bundle.getString("nm"))) {
            CleverTapAPI.m(context, bundle);
            return true;
        }
        return true;
    }

    public final Completable k(String identifier) {
        Object F;
        Intrinsics.f(identifier, "identifier");
        final String str = "lead-driver-" + identifier;
        final CleverTapAPI cleverTapAPI = this.f24535a;
        if (cleverTapAPI == null) {
            Completable t7 = Completable.t(new IllegalStateException("clevertap is not initialised"));
            Intrinsics.e(t7, "error(IllegalStateExcept…tap is not initialised\"))");
            return t7;
        }
        Kalev.b("Clevertap existing identity: " + cleverTapAPI.F("Identity"));
        if (!(!Intrinsics.a(F, str))) {
            Kalev.b("Clevertap login skipped");
            Completable g8 = Completable.g();
            Intrinsics.e(g8, "complete()");
            return g8;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Identity", str);
        cleverTapAPI.V(hashMap);
        Observable<Long> interval = Observable.interval(10L, 100L, TimeUnit.MILLISECONDS);
        final Function1<Long, Boolean> function1 = new Function1<Long, Boolean>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapManager$identifyLead$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Long it) {
                Intrinsics.f(it, "it");
                Object F2 = CleverTapAPI.this.F("Identity");
                Kalev.b("Checking clevertap identity. " + it + ". " + F2);
                return Boolean.valueOf(Intrinsics.a(str, CleverTapAPI.this.F("Identity")));
            }
        };
        Single<Long> firstOrError = interval.filter(new Predicate() { // from class: ee.mtakso.driver.service.integration.clevertap.a
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean l8;
                l8 = CleverTapManager.l(Function1.this, obj);
                return l8;
            }
        }).firstOrError();
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapManager$identifyLead$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Long l8) {
                String str2 = str;
                Kalev.b("New CleverTap user with ID " + str2 + " is set. Setting Analytics...[" + l8 + "]");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Completable v7 = firstOrError.o(new Consumer() { // from class: ee.mtakso.driver.service.integration.clevertap.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CleverTapManager.m(Function1.this, obj);
            }
        }).v();
        Intrinsics.e(v7, "leadId = \"lead-driver-$i…         .ignoreElement()");
        return v7;
    }

    public final Completable n(long j8) {
        Object F;
        final String str = "driver-" + j8;
        final CleverTapAPI cleverTapAPI = this.f24535a;
        if (cleverTapAPI == null) {
            Completable t7 = Completable.t(new IllegalStateException("clevertap is not initialised"));
            Intrinsics.e(t7, "error(IllegalStateExcept…tap is not initialised\"))");
            return t7;
        }
        Kalev.b("Clevertap existing identity: " + cleverTapAPI.F("Identity"));
        if (!(!Intrinsics.a(F, str))) {
            Kalev.b("Clevertap login skipped");
            Completable g8 = Completable.g();
            Intrinsics.e(g8, "complete()");
            return g8;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Identity", str);
        cleverTapAPI.V(hashMap);
        Observable<Long> interval = Observable.interval(10L, 100L, TimeUnit.MILLISECONDS);
        final Function1<Long, Boolean> function1 = new Function1<Long, Boolean>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapManager$identifyUser$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Long it) {
                Intrinsics.f(it, "it");
                Object F2 = CleverTapAPI.this.F("Identity");
                Kalev.b("Checking clevertap identity. " + it + ". " + F2);
                return Boolean.valueOf(Intrinsics.a(str, CleverTapAPI.this.F("Identity")));
            }
        };
        Single<Long> firstOrError = interval.filter(new Predicate() { // from class: ee.mtakso.driver.service.integration.clevertap.d
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean o8;
                o8 = CleverTapManager.o(Function1.this, obj);
                return o8;
            }
        }).firstOrError();
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapManager$identifyUser$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Long l8) {
                String str2 = str;
                Kalev.b("New CleverTap user with ID " + str2 + " is set. Setting Analytics...[" + l8 + "]");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Completable v7 = firstOrError.o(new Consumer() { // from class: ee.mtakso.driver.service.integration.clevertap.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CleverTapManager.p(Function1.this, obj);
            }
        }).v();
        Intrinsics.e(v7, "driverId = \"driver-$iden…         .ignoreElement()");
        return v7;
    }

    public final void q(Application app) {
        Intrinsics.f(app, "app");
        CleverTapAPI.l0(CleverTapAPI.LogLevel.OFF);
        CleverTapAPI.i("R97-779-6R5Z", "caa-ac2");
        ActivityLifecycleCallback.a(app);
        CleverTapAPI y7 = CleverTapAPI.y(app);
        this.f24535a = y7;
        if (y7 == null) {
            Kalev.e(new IllegalStateException("Failed to obtain clevertap instance"), "Clevertap failure");
            return;
        }
        String s7 = i().s();
        Kalev.b("CleverTap initialised " + s7);
        if (Build.VERSION.SDK_INT >= 24) {
            CleverTapAPI.o(app, "default", app.getString(R.string.notification_channel_default_name), app.getString(R.string.notification_channel_default_description), 3, true);
        }
        i().i0(new CleverTapInboxListener(this.f24536b));
    }

    public final void r(Context context) {
        Intrinsics.f(context, "context");
        i().n0(CleverTapInboxStyle.a(context));
    }

    public final Observable<Integer> s() {
        BehaviorSubject<CleverTapInboxEvent> behaviorSubject = this.f24536b;
        final Function1<CleverTapInboxEvent, Integer> function1 = new Function1<CleverTapInboxEvent, Integer>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapManager$unreadCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Integer invoke(CleverTapInboxEvent it) {
                CleverTapAPI i8;
                Intrinsics.f(it, "it");
                i8 = CleverTapManager.this.i();
                return Integer.valueOf(i8.D());
            }
        };
        Observable map = behaviorSubject.map(new Function() { // from class: ee.mtakso.driver.service.integration.clevertap.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer t7;
                t7 = CleverTapManager.t(Function1.this, obj);
                return t7;
            }
        });
        Intrinsics.e(map, "fun unreadCount(): Obser…essageUnreadCount }\n    }");
        return map;
    }

    public final Observable<List<CleverTapMessage>> u() {
        BehaviorSubject<CleverTapInboxEvent> behaviorSubject = this.f24536b;
        final Function1<CleverTapInboxEvent, List<? extends CleverTapMessage>> function1 = new Function1<CleverTapInboxEvent, List<? extends CleverTapMessage>>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapManager$unreadMessages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<CleverTapMessage> invoke(CleverTapInboxEvent it) {
                CleverTapAPI i8;
                int v7;
                Intrinsics.f(it, "it");
                i8 = CleverTapManager.this.i();
                ArrayList<CTInboxMessage> H = i8.H();
                Intrinsics.e(H, "getCleverTap().unreadInboxMessages");
                v7 = CollectionsKt__IterablesKt.v(H, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (CTInboxMessage it2 : H) {
                    Intrinsics.e(it2, "it");
                    arrayList.add(new CleverTapMessage(it2));
                }
                return arrayList;
            }
        };
        Observable map = behaviorSubject.map(new Function() { // from class: ee.mtakso.driver.service.integration.clevertap.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List v7;
                v7 = CleverTapManager.v(Function1.this, obj);
                return v7;
            }
        });
        Intrinsics.e(map, "fun unreadMessages(): Ob…it) }\n            }\n    }");
        return map;
    }

    public final void w(String token) {
        Intrinsics.f(token, "token");
        i().a0(token, true);
    }
}
