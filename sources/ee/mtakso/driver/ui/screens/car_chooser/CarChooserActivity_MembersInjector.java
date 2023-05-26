package ee.mtakso.driver.ui.screens.car_chooser;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.theme.AppThemeManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CarChooserActivity_MembersInjector implements MembersInjector<CarChooserActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity.appThemeManager")
    public static void a(CarChooserActivity carChooserActivity, AppThemeManager appThemeManager) {
        carChooserActivity.f27658p = appThemeManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity.urlLauncher")
    public static void b(CarChooserActivity carChooserActivity, CompositeUrlLauncher compositeUrlLauncher) {
        carChooserActivity.f27657o = compositeUrlLauncher;
    }
}
