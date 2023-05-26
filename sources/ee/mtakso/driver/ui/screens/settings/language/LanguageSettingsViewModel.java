package ee.mtakso.driver.ui.screens.settings.language;

import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData;
import ee.mtakso.driver.ui.interactor.settings.GetLanguageSettingsInteractor;
import ee.mtakso.driver.ui.interactor.settings.LanguageSettings;
import ee.mtakso.driver.ui.interactor.settings.SetLanguageInteractor;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.driver.core.language.Language;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageSettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class LanguageSettingsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GetLanguageSettingsInteractor f33199f;

    /* renamed from: g  reason: collision with root package name */
    private final SetLanguageInteractor f33200g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f33201h;

    /* renamed from: i  reason: collision with root package name */
    private final SingleLiveData<LanguageSettings> f33202i;

    @Inject
    public LanguageSettingsViewModel(GetLanguageSettingsInteractor getLanguageSettingsInteractor, SetLanguageInteractor setLanguageInteractor) {
        Intrinsics.f(getLanguageSettingsInteractor, "getLanguageSettingsInteractor");
        Intrinsics.f(setLanguageInteractor, "setLanguageInteractor");
        this.f33199f = getLanguageSettingsInteractor;
        this.f33200g = setLanguageInteractor;
        this.f33202i = new SingleLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H() {
        Kalev.b("Language was set");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f33202i.t(this.f33199f.b(), new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                BaseViewModel.A(LanguageSettingsViewModel.this, it, null, 2, null);
            }
        });
    }

    public final SingleLiveData<LanguageSettings> F() {
        return this.f33202i;
    }

    public final void G(Language language) {
        Intrinsics.f(language, "language");
        if (!DisposableExtKt.b(this.f33201h)) {
            return;
        }
        Completable j8 = j(this.f33200g.g(language));
        Action action = new Action() { // from class: a5.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                LanguageSettingsViewModel.H();
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsViewModel$selectLanguage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "Failed to update language");
                BaseViewModel.A(LanguageSettingsViewModel.this, error, null, 2, null);
            }
        };
        this.f33201h = j8.G(action, new Consumer() { // from class: a5.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LanguageSettingsViewModel.I(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f33201h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
