package eu.bolt.chat.chatcore.chatsdk.mapper;

import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.data.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderMapper.kt */
/* loaded from: classes5.dex */
public final class OrderMapper {
    public final OrderHandle a(OrderHandleEntity orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        String c8 = orderHandle.c();
        if (c8 != null) {
            int b8 = (int) orderHandle.b();
            Long a8 = orderHandle.a();
            if (a8 != null) {
                return new OrderHandle(c8, b8, (int) a8.longValue());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final OrderHandleEntity b(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return new OrderHandleEntity(orderHandle.b(), orderHandle.c(), Long.valueOf(orderHandle.a()));
    }
}
