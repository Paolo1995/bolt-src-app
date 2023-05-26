package ee.mtakso.driver.service.integration.clevertap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import ee.mtakso.driver.R;
import ee.mtakso.driver.deeplink.DeepLinkAction;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CleverTapService.kt */
/* loaded from: classes3.dex */
public final class CleverTapService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final DriverConfig f24548a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverSettings f24549b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapManager f24550c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f24551d;

    /* renamed from: e  reason: collision with root package name */
    private final UiNotificationManager f24552e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f24553f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f24554g;

    @Inject
    public CleverTapService(DriverConfig driver, DriverSettings driverSettings, CleverTapManager cleverTapManager, Context context, UiNotificationManager uiNotificationManager) {
        Intrinsics.f(driver, "driver");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(cleverTapManager, "cleverTapManager");
        Intrinsics.f(context, "context");
        Intrinsics.f(uiNotificationManager, "uiNotificationManager");
        this.f24548a = driver;
        this.f24549b = driverSettings;
        this.f24550c = cleverTapManager;
        this.f24551d = context;
        this.f24552e = uiNotificationManager;
    }

    private final void k(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("boltdriverapp");
        builder.authority(DeepLinkAction.NEWS.c());
        builder.appendPath("inbox");
        this.f24552e.B(new Intent("android.intent.action.VIEW", builder.build()), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(List<CleverTapMessage> list) {
        if (list.size() == 1) {
            CleverTapInboxMessagePreview b8 = list.get(0).b();
            k(b8.b(), b8.a());
        } else if (list.size() > 1) {
            k(this.f24551d.getString(R.string.unread_news_format, Integer.valueOf(list.size())), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        Kalev.b("[CleverTap] Driver identified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
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
    public final boolean q(List<CleverTapMessage> list) {
        int v7;
        Set<String> h8;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (CleverTapMessage cleverTapMessage : list) {
            arrayList.add(cleverTapMessage.a());
        }
        Set<String> l8 = this.f24549b.l();
        if (l8.containsAll(arrayList)) {
            return false;
        }
        DriverSettings driverSettings = this.f24549b;
        h8 = SetsKt___SetsKt.h(l8, arrayList);
        driverSettings.Y(h8);
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        Completable n8 = this.f24550c.n(this.f24548a.t());
        Action action = new Action() { // from class: ee.mtakso.driver.service.integration.clevertap.g
            @Override // io.reactivex.functions.Action
            public final void run() {
                CleverTapService.m();
            }
        };
        final CleverTapService$start$2 cleverTapService$start$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapService$start$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "[CleverTap] Failed to identify driver");
            }
        };
        this.f24553f = n8.G(action, new Consumer() { // from class: ee.mtakso.driver.service.integration.clevertap.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CleverTapService.n(Function1.this, obj);
            }
        });
        this.f24550c.h();
        Observable<List<CleverTapMessage>> u7 = this.f24550c.u();
        final Function1<List<? extends CleverTapMessage>, Boolean> function1 = new Function1<List<? extends CleverTapMessage>, Boolean>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapService$start$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(List<CleverTapMessage> messages) {
                boolean q8;
                Intrinsics.f(messages, "messages");
                q8 = CleverTapService.this.q(messages);
                return Boolean.valueOf(q8);
            }
        };
        Observable<List<CleverTapMessage>> observeOn = u7.filter(new Predicate() { // from class: ee.mtakso.driver.service.integration.clevertap.i
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean o8;
                o8 = CleverTapService.o(Function1.this, obj);
                return o8;
            }
        }).observeOn(AndroidSchedulers.a());
        final Function1<List<? extends CleverTapMessage>, Unit> function12 = new Function1<List<? extends CleverTapMessage>, Unit>() { // from class: ee.mtakso.driver.service.integration.clevertap.CleverTapService$start$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<CleverTapMessage> messages) {
                CleverTapService cleverTapService = CleverTapService.this;
                Intrinsics.e(messages, "messages");
                cleverTapService.l(messages);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends CleverTapMessage> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        this.f24554g = observeOn.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.integration.clevertap.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CleverTapService.p(Function1.this, obj);
            }
        });
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        Disposable disposable = this.f24553f;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f24554g;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
