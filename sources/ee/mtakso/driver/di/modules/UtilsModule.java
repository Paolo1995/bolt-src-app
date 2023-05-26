package ee.mtakso.driver.di.modules;

import android.content.Context;
import androidx.fragment.app.FragmentFactory;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.helper.AutoStartPermissionHelper;
import ee.mtakso.driver.helper.CustomNotificationManagerHelper;
import ee.mtakso.driver.helper.OtherPermissionHelper;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.driver.core.permission.PermissionInitiatorTracker;

@Module(includes = {HtmlEngineModule.class})
/* loaded from: classes3.dex */
public class UtilsModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public FragmentFactory a() {
        return new FragmentFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PermissionInitiatorTracker b(DeviceSettings deviceSettings) {
        return new PermissionInitiatorTracker(deviceSettings.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public AutoStartPermissionHelper c(AppResolver appResolver) {
        return new AutoStartPermissionHelper(appResolver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public CustomNotificationManagerHelper d(AppResolver appResolver, Context context) {
        return new CustomNotificationManagerHelper(appResolver, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public OtherPermissionHelper e(AppResolver appResolver, Context context) {
        return new OtherPermissionHelper(appResolver, context);
    }
}
