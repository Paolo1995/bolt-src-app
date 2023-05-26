package ee.mtakso.driver.di.authorised;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushTokenHandler;
import ee.mtakso.driver.service.push.handler.ChatPushHandlerWrapper;
import ee.mtakso.driver.service.push.handler.InternalTokenHandler;
import ee.mtakso.driver.service.push.handler.NewOrderPushHandler;
import ee.mtakso.driver.service.push.handler.OrderTerminatedPushHandler;
import ee.mtakso.driver.service.push.handler.RateAppPushHandler;
import ee.mtakso.driver.service.push.handler.RouteUpdatePushHandler;
import ee.mtakso.driver.service.push.handler.ScheduledOrderPushHandler;
import ee.mtakso.driver.service.push.handler.TipsPushHandler;
import ee.mtakso.driver.service.push.handler.VoipPushHandler;

/* compiled from: PushBindings.kt */
@Module
/* loaded from: classes3.dex */
public interface PushBindings {
    @Binds
    @IntoSet
    PushHandler a(NewOrderPushHandler newOrderPushHandler);

    @Binds
    @IntoSet
    PushHandler b(OrderTerminatedPushHandler orderTerminatedPushHandler);

    @Binds
    @IntoSet
    PushHandler c(RateAppPushHandler rateAppPushHandler);

    @Binds
    @IntoSet
    PushTokenHandler d(InternalTokenHandler internalTokenHandler);

    @Binds
    @IntoSet
    PushHandler e(ScheduledOrderPushHandler scheduledOrderPushHandler);

    @Binds
    @IntoSet
    PushHandler f(ChatPushHandlerWrapper chatPushHandlerWrapper);

    @Binds
    @IntoSet
    PushHandler g(TipsPushHandler tipsPushHandler);

    @Binds
    @IntoSet
    PushHandler h(RouteUpdatePushHandler routeUpdatePushHandler);

    @Binds
    @IntoSet
    PushHandler i(VoipPushHandler voipPushHandler);
}
