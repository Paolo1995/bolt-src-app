package ee.mtakso.driver.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import ee.mtakso.driver.platform.push.PushManager;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.service.push.handler.CleverTapPushHandler;
import ee.mtakso.driver.service.push.handler.DefaultPushHandler;
import ee.mtakso.driver.service.push.handler.SupportPushHandler;

/* compiled from: PushBindings.kt */
@Module
/* loaded from: classes3.dex */
public interface PushBindings {
    @Binds
    PushManager a(PushManagerImpl pushManagerImpl);

    @Binds
    @IntoSet
    PushHandler b(SupportPushHandler supportPushHandler);

    @Binds
    @IntoSet
    PushHandler c(DefaultPushHandler defaultPushHandler);

    @Binds
    @IntoSet
    PushHandler d(CleverTapPushHandler cleverTapPushHandler);
}
