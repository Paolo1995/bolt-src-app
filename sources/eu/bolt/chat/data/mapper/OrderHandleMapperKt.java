package eu.bolt.chat.data.mapper;

import eu.bolt.chat.data.OrderHandle;
import eu.bolt.chat.network.data.OrderHandleNet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHandleMapper.kt */
/* loaded from: classes5.dex */
public final class OrderHandleMapperKt {
    public static final OrderHandle a(OrderHandleNet orderHandleNet) {
        Intrinsics.f(orderHandleNet, "<this>");
        return new OrderHandle(orderHandleNet.c(), orderHandleNet.b(), orderHandleNet.a());
    }
}
