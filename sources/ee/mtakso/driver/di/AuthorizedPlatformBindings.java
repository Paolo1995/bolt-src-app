package ee.mtakso.driver.di;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import ee.mtakso.driver.service.integration.clevertap.FcmCleverTapPushTokenHandler;
import ee.mtakso.driver.service.push.PushTokenHandler;

/* compiled from: PlatformModule.kt */
@Module
/* loaded from: classes3.dex */
public interface AuthorizedPlatformBindings {
    @Binds
    @IntoSet
    PushTokenHandler a(FcmCleverTapPushTokenHandler fcmCleverTapPushTokenHandler);
}
