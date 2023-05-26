package ee.mtakso.driver.di.modules;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.OtherPermissionHelper;
import ee.mtakso.driver.utils.AppResolver;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UtilsModule_ProvidesOtherPermissionHelperFactory implements Factory<OtherPermissionHelper> {
    public static OtherPermissionHelper a(UtilsModule utilsModule, AppResolver appResolver, Context context) {
        return (OtherPermissionHelper) Preconditions.checkNotNullFromProvides(utilsModule.e(appResolver, context));
    }
}
