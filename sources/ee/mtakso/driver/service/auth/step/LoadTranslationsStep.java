package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.RxUtils;
import ee.mtakso.driver.utils.flow.FlowStep;
import eu.bolt.driver.core.language.LanguageUtils;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.Translations;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadTranslationsStep.kt */
/* loaded from: classes3.dex */
public final class LoadTranslationsStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final long f23829a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f23830b;

    /* renamed from: c  reason: collision with root package name */
    private final TranslationManager f23831c;

    /* renamed from: d  reason: collision with root package name */
    private final LanguageManager f23832d;

    public LoadTranslationsStep(long j8, DriverProvider driverProvider, TranslationManager translationManager, LanguageManager languageManager) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(translationManager, "translationManager");
        Intrinsics.f(languageManager, "languageManager");
        this.f23829a = j8;
        this.f23830b = driverProvider;
        this.f23831c = translationManager;
        this.f23832d = languageManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource c(Function1 tmp0, Single p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (SingleSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.TranslationUpdate d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.TranslationUpdate) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Single<Translations> l8 = this.f23831c.l(LanguageUtils.f40820a.b(this.f23832d.k(this.f23830b.u(this.f23829a).v())));
        final LoadTranslationsStep$call$translationSingle$1 loadTranslationsStep$call$translationSingle$1 = new Function1<Single<Translations>, SingleSource<Translations>>() { // from class: ee.mtakso.driver.service.auth.step.LoadTranslationsStep$call$translationSingle$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<Translations> invoke(Single<Translations> it) {
                Intrinsics.f(it, "it");
                return RxUtils.c(it);
            }
        };
        Single<R> e8 = l8.e(new SingleTransformer() { // from class: ee.mtakso.driver.service.auth.step.l
            @Override // io.reactivex.SingleTransformer
            public final SingleSource a(Single single) {
                SingleSource c8;
                c8 = LoadTranslationsStep.c(Function1.this, single);
                return c8;
            }
        });
        final LoadTranslationsStep$call$translationSingle$2 loadTranslationsStep$call$translationSingle$2 = new Function1<Translations, AuthStepResult.TranslationUpdate>() { // from class: ee.mtakso.driver.service.auth.step.LoadTranslationsStep$call$translationSingle$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.TranslationUpdate invoke(Translations it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.TranslationUpdate(true);
            }
        };
        Single D = e8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.TranslationUpdate d8;
                d8 = LoadTranslationsStep.d(Function1.this, obj);
                return d8;
            }
        }).D(new AuthStepResult.TranslationUpdate(false));
        Intrinsics.e(D, "translationManager\n     …TranslationUpdate(false))");
        Observable<AuthStepResult> concatWith = Observable.just(new AuthStepResult.Message("Loading translations")).concatWith(D);
        Intrinsics.e(concatWith, "just<AuthStepResult>(Aut…atWith(translationSingle)");
        return concatWith;
    }
}
