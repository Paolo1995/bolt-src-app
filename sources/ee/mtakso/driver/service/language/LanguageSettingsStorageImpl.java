package ee.mtakso.driver.service.language;

import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import eu.bolt.driver.core.ui.translation.language.LanguageSettingsStorage;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageSettingsStorageImpl.kt */
/* loaded from: classes3.dex */
public final class LanguageSettingsStorageImpl implements LanguageSettingsStorage {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f24592a;

    @Inject
    public LanguageSettingsStorageImpl(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f24592a = driverProvider;
    }

    @Override // eu.bolt.driver.core.ui.translation.language.LanguageSettingsStorage
    public String a() {
        DriverSettings y7 = this.f24592a.y();
        if (y7 != null) {
            return y7.v();
        }
        return null;
    }

    @Override // eu.bolt.driver.core.ui.translation.language.LanguageSettingsStorage
    public void b(String language) {
        Intrinsics.f(language, "language");
        this.f24592a.v().e0(language);
    }
}
