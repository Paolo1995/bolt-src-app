package ee.mtakso.driver.di.modules;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.CustomNotificationManagerHelper;
import ee.mtakso.driver.utils.AppResolver;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UtilsModule_ProvidesCustomNotificationManagerHelperFactory implements Factory<CustomNotificationManagerHelper> {
    public static CustomNotificationManagerHelper a(UtilsModule utilsModule, AppResolver appResolver, Context context) {
        return (CustomNotificationManagerHelper) Preconditions.checkNotNullFromProvides(utilsModule.d(appResolver, context));
    }
}
