package eu.bolt.driver.chat.service.repo;

import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.network.model.OrderHandleNetworkModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Util.kt */
/* loaded from: classes5.dex */
public final class UtilKt {
    public static final OrderHandleEntity a(OrderHandleNetworkModel model) {
        Intrinsics.f(model, "model");
        return new OrderHandleEntity(model.b(), model.c(), model.a());
    }
}
