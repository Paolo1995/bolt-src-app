package ee.mtakso.driver.service.push;

import android.content.Context;
import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.platform.push.PushManager;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthState;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushManagerImpl.kt */
@Singleton
/* loaded from: classes3.dex */
public final class PushManagerImpl implements PushManager {

    /* renamed from: a  reason: collision with root package name */
    private final PushTokenManager f25597a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f25598b;

    /* renamed from: c  reason: collision with root package name */
    private final TokenProvider f25599c;

    /* renamed from: d  reason: collision with root package name */
    private final AuthManager f25600d;

    /* renamed from: e  reason: collision with root package name */
    private final UiNotificationManager f25601e;

    /* renamed from: f  reason: collision with root package name */
    private final PushTokenAnalytics f25602f;

    /* renamed from: g  reason: collision with root package name */
    private List<PushHandler> f25603g;

    /* renamed from: h  reason: collision with root package name */
    private List<? extends PushTokenHandler> f25604h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f25605i;

    /* renamed from: j  reason: collision with root package name */
    private String f25606j;

    /* compiled from: PushManagerImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25607a;

        static {
            int[] iArr = new int[AuthState.values().length];
            try {
                iArr[AuthState.LOGGED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthState.PARTNER_LOGGED_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25607a = iArr;
        }
    }

    @Inject
    public PushManagerImpl(Set<PushHandler> handlers, PushTokenManager pushTokenManager, Context context, TokenProvider pushTokenProvider, AuthManager authManager, UiNotificationManager uiNotificationManager, PushTokenAnalytics pushTokenAnalytics) {
        List H0;
        List<PushHandler> v02;
        List<? extends PushTokenHandler> k8;
        Intrinsics.f(handlers, "handlers");
        Intrinsics.f(pushTokenManager, "pushTokenManager");
        Intrinsics.f(context, "context");
        Intrinsics.f(pushTokenProvider, "pushTokenProvider");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(uiNotificationManager, "uiNotificationManager");
        Intrinsics.f(pushTokenAnalytics, "pushTokenAnalytics");
        this.f25597a = pushTokenManager;
        this.f25598b = context;
        this.f25599c = pushTokenProvider;
        this.f25600d = authManager;
        this.f25601e = uiNotificationManager;
        this.f25602f = pushTokenAnalytics;
        H0 = CollectionsKt___CollectionsKt.H0(handlers);
        v02 = CollectionsKt___CollectionsKt.v0(H0, new Comparator() { // from class: ee.mtakso.driver.service.push.PushManagerImpl$special$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((PushHandler) t8).a()), Integer.valueOf(((PushHandler) t7).a()));
                return a8;
            }
        });
        this.f25603g = v02;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f25604h = k8;
        this.f25606j = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.platform.push.PushManager
    public void a(String token) {
        PushTokenAnalytics.TokenType tokenType;
        Intrinsics.f(token, "token");
        int i8 = WhenMappings.f25607a[this.f25600d.h().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                tokenType = PushTokenAnalytics.TokenType.UNKNOWN;
            } else {
                tokenType = PushTokenAnalytics.TokenType.PARTNER;
            }
        } else {
            tokenType = PushTokenAnalytics.TokenType.DRIVER;
        }
        this.f25602f.A3(token, tokenType);
        this.f25597a.m(token);
        if (Intrinsics.a(token, this.f25606j)) {
            Kalev.h("Got same push token. Handlers will not be notified");
            return;
        }
        for (PushTokenHandler pushTokenHandler : this.f25604h) {
            pushTokenHandler.a(token);
        }
        this.f25606j = token;
    }

    @Override // ee.mtakso.driver.platform.push.PushManager
    public void b(Push push) {
        Intrinsics.f(push, "push");
        Iterator<T> it = this.f25603g.iterator();
        while (it.hasNext() && !((PushHandler) it.next()).b(push)) {
        }
    }

    public final void e(Collection<? extends PushHandler> handlers) {
        List n02;
        List<PushHandler> v02;
        Intrinsics.f(handlers, "handlers");
        n02 = CollectionsKt___CollectionsKt.n0(this.f25603g, handlers);
        v02 = CollectionsKt___CollectionsKt.v0(n02, new Comparator() { // from class: ee.mtakso.driver.service.push.PushManagerImpl$addPushHandlers$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((PushHandler) t8).a()), Integer.valueOf(((PushHandler) t7).a()));
                return a8;
            }
        });
        this.f25603g = v02;
    }

    public final void f(Collection<? extends PushTokenHandler> handlers) {
        boolean z7;
        List<? extends PushTokenHandler> n02;
        Intrinsics.f(handlers, "handlers");
        if (this.f25606j.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            for (PushTokenHandler pushTokenHandler : handlers) {
                pushTokenHandler.a(this.f25606j);
            }
        }
        n02 = CollectionsKt___CollectionsKt.n0(this.f25604h, handlers);
        this.f25604h = n02;
    }

    public final void g(Collection<? extends PushHandler> handlers) {
        List l02;
        List<PushHandler> v02;
        Intrinsics.f(handlers, "handlers");
        l02 = CollectionsKt___CollectionsKt.l0(this.f25603g, handlers);
        v02 = CollectionsKt___CollectionsKt.v0(l02, new Comparator() { // from class: ee.mtakso.driver.service.push.PushManagerImpl$removePushHandlers$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((PushHandler) t8).a()), Integer.valueOf(((PushHandler) t7).a()));
                return a8;
            }
        });
        this.f25603g = v02;
    }

    public final void h(Collection<? extends PushTokenHandler> handlers) {
        List<? extends PushTokenHandler> l02;
        Intrinsics.f(handlers, "handlers");
        l02 = CollectionsKt___CollectionsKt.l0(this.f25604h, handlers);
        this.f25604h = l02;
    }

    public final void i() {
        if (!DisposableExtKt.b(this.f25605i)) {
            return;
        }
        Single<String> z7 = this.f25599c.b().K(Schedulers.c()).z(Schedulers.c());
        final PushManagerImpl$requestTokenUpdate$1 pushManagerImpl$requestTokenUpdate$1 = new PushManagerImpl$requestTokenUpdate$1(this);
        Consumer<? super String> consumer = new Consumer() { // from class: ee.mtakso.driver.service.push.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushManagerImpl.j(Function1.this, obj);
            }
        };
        final PushManagerImpl$requestTokenUpdate$2 pushManagerImpl$requestTokenUpdate$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.push.PushManagerImpl$requestTokenUpdate$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable throwable) {
                Intrinsics.e(throwable, "throwable");
                Kalev.e(throwable, "Failed to get new push token");
            }
        };
        this.f25605i = z7.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.push.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushManagerImpl.k(Function1.this, obj);
            }
        });
    }

    @Override // ee.mtakso.driver.platform.push.PushManager
    public void init() {
        this.f25601e.z(this.f25598b);
    }
}
