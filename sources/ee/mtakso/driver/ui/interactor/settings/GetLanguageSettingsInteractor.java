package ee.mtakso.driver.ui.interactor.settings;

import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetLanguageSettingsInteractor.kt */
/* loaded from: classes3.dex */
public final class GetLanguageSettingsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final LanguageManager f26905a;

    @Inject
    public GetLanguageSettingsInteractor(LanguageManager languageManager) {
        Intrinsics.f(languageManager, "languageManager");
        this.f26905a = languageManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LanguageSettings c(GetLanguageSettingsInteractor this$0) {
        Intrinsics.f(this$0, "this$0");
        return new LanguageSettings(this$0.f26905a.j(), this$0.f26905a.d(), this$0.f26905a.f());
    }

    public final Single<LanguageSettings> b() {
        Single<LanguageSettings> u7 = Single.u(new Callable() { // from class: ee.mtakso.driver.ui.interactor.settings.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LanguageSettings c8;
                c8 = GetLanguageSettingsInteractor.c(GetLanguageSettingsInteractor.this);
                return c8;
            }
        });
        Intrinsics.e(u7, "fromCallable {\n         …)\n            )\n        }");
        return u7;
    }
}
