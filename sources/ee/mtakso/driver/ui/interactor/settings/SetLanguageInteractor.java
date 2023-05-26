package ee.mtakso.driver.ui.interactor.settings;

import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment;
import ee.mtakso.driver.utils.RxUtils;
import eu.bolt.driver.core.language.Language;
import eu.bolt.driver.core.language.LanguageUtils;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.Translations;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SetLanguageInteractor.kt */
/* loaded from: classes3.dex */
public final class SetLanguageInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final LanguageManager f26910a;

    /* renamed from: b  reason: collision with root package name */
    private final TranslationManager f26911b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverClient f26912c;

    /* renamed from: d  reason: collision with root package name */
    private final DateTimeConverter f26913d;

    /* renamed from: e  reason: collision with root package name */
    private final RoutingManager f26914e;

    @Inject
    public SetLanguageInteractor(LanguageManager languageManager, TranslationManager translationManager, DriverClient driverClient, DateTimeConverter dateTimeConverter, RoutingManager routingManager) {
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(translationManager, "translationManager");
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Intrinsics.f(routingManager, "routingManager");
        this.f26910a = languageManager;
        this.f26911b = translationManager;
        this.f26912c = driverClient;
        this.f26913d = dateTimeConverter;
        this.f26914e = routingManager;
    }

    private final void f() {
        List k8;
        this.f26913d.d();
        RoutingManager routingManager = this.f26914e;
        k8 = CollectionsKt__CollectionsKt.k();
        routingManager.b(new RoutingCommand.ActivityClass(new RoutingState(SimpleActivity.class, k8), SimpleActivity.class, SimpleActivity.f27004l.c(HomeFragment.class, null, false), 0), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource h(final Language language, final SetLanguageInteractor this$0) {
        Intrinsics.f(language, "$language");
        Intrinsics.f(this$0, "this$0");
        if (Intrinsics.a(language, this$0.f26910a.f())) {
            return Completable.g();
        }
        this$0.f26911b.j();
        this$0.f26910a.m(language);
        Single<Translations> l8 = this$0.f26911b.l(LanguageUtils.f40820a.b(language));
        final SetLanguageInteractor$setLanguage$1$1 setLanguageInteractor$setLanguage$1$1 = new Function1<Single<Translations>, SingleSource<Translations>>() { // from class: ee.mtakso.driver.ui.interactor.settings.SetLanguageInteractor$setLanguage$1$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<Translations> invoke(Single<Translations> it) {
                Intrinsics.f(it, "it");
                return RxUtils.c(it);
            }
        };
        Single<R> e8 = l8.e(new SingleTransformer() { // from class: ee.mtakso.driver.ui.interactor.settings.c
            @Override // io.reactivex.SingleTransformer
            public final SingleSource a(Single single) {
                SingleSource i8;
                i8 = SetLanguageInteractor.i(Function1.this, single);
                return i8;
            }
        });
        final Function1<Translations, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<Translations, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.ui.interactor.settings.SetLanguageInteractor$setLanguage$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(Translations it) {
                DriverClient driverClient;
                Intrinsics.f(it, "it");
                driverClient = SetLanguageInteractor.this.f26912c;
                return driverClient.E(language.b());
            }
        };
        return e8.r(new Function() { // from class: ee.mtakso.driver.ui.interactor.settings.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource j8;
                j8 = SetLanguageInteractor.j(Function1.this, obj);
                return j8;
            }
        }).v().z(AndroidSchedulers.a()).m(new Action() { // from class: ee.mtakso.driver.ui.interactor.settings.e
            @Override // io.reactivex.functions.Action
            public final void run() {
                SetLanguageInteractor.k(SetLanguageInteractor.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource i(Function1 tmp0, Single p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (SingleSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SetLanguageInteractor this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f();
    }

    public final Completable g(final Language language) {
        Intrinsics.f(language, "language");
        Completable j8 = Completable.j(new Callable() { // from class: ee.mtakso.driver.ui.interactor.settings.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CompletableSource h8;
                h8 = SetLanguageInteractor.h(Language.this, this);
                return h8;
            }
        });
        Intrinsics.e(j8, "defer {\n            if (…}\n            }\n        }");
        return j8;
    }
}
