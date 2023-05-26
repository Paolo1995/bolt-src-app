package ee.mtakso.driver.network.client;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHandle.kt */
/* loaded from: classes3.dex */
public final class OrderHandleKt {
    public static final OrderHandle a(Bundle bundle) {
        Intrinsics.f(bundle, "bundle");
        OrderHandle b8 = b(bundle);
        Intrinsics.c(b8);
        return b8;
    }

    public static final OrderHandle b(Bundle bundle) {
        Intrinsics.f(bundle, "bundle");
        String string = bundle.getString("system");
        long j8 = bundle.getLong("city_id", -1L);
        long j9 = bundle.getLong("order_id", -1L);
        if (string != null && j8 != -1 && j9 != -1) {
            return new OrderHandle(string, j8, j9);
        }
        return null;
    }

    public static final OrderHandle c(String jsonString, Gson gson) {
        Intrinsics.f(jsonString, "jsonString");
        Intrinsics.f(gson, "gson");
        try {
            return (OrderHandle) gson.fromJson(jsonString, new TypeToken<OrderHandle>() { // from class: ee.mtakso.driver.network.client.OrderHandleKt$readFromJson$type$1
            }.getType());
        } catch (Exception e8) {
            Kalev.e(e8, "Error parsing order handle");
            return null;
        }
    }

    public static final Bundle d(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "<this>");
        return e(orderHandle, new Bundle());
    }

    public static final Bundle e(OrderHandle orderHandle, Bundle bundle) {
        Intrinsics.f(orderHandle, "<this>");
        Intrinsics.f(bundle, "bundle");
        bundle.putLong("order_id", orderHandle.b());
        bundle.putLong("city_id", orderHandle.a());
        bundle.putString("system", orderHandle.c());
        return bundle;
    }
}
