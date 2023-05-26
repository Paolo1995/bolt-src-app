package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.AutoStartPermissionHelper;
import ee.mtakso.driver.utils.AppResolver;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UtilsModule_ProvidesAutoStartPermissionHelperFactory implements Factory<AutoStartPermissionHelper> {
    public static AutoStartPermissionHelper a(UtilsModule utilsModule, AppResolver appResolver) {
        return (AutoStartPermissionHelper) Preconditions.checkNotNullFromProvides(utilsModule.c(appResolver));
    }
}
