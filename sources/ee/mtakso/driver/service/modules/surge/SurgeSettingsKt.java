package ee.mtakso.driver.service.modules.surge;

import ee.mtakso.driver.network.client.driver.surge.SurgeMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeSettings.kt */
/* loaded from: classes3.dex */
public final class SurgeSettingsKt {
    public static final String a(SurgeSettings surgeSettings, String categoryId) {
        Map<String, String> c8;
        Intrinsics.f(surgeSettings, "<this>");
        Intrinsics.f(categoryId, "categoryId");
        SurgeMap c9 = surgeSettings.c();
        if (c9 != null && (c8 = c9.c()) != null) {
            return c8.get(categoryId);
        }
        return null;
    }

    public static final boolean b(SurgeSettings surgeSettings) {
        Intrinsics.f(surgeSettings, "<this>");
        SurgeMap c8 = surgeSettings.c();
        if (c8 == null || Intrinsics.a(c8.b(), Boolean.TRUE) || c8.d() != null) {
            return false;
        }
        return true;
    }

    public static final boolean c(SurgeSettings surgeSettings, String categoryId) {
        LinkedHashMap<String, String> a8;
        Intrinsics.f(surgeSettings, "<this>");
        Intrinsics.f(categoryId, "categoryId");
        SurgeMap c8 = surgeSettings.c();
        if (c8 != null && (a8 = c8.a()) != null) {
            return a8.containsKey(categoryId);
        }
        return false;
    }

    public static final boolean d(SurgeSettings surgeSettings, String categoryId) {
        Intrinsics.f(surgeSettings, "<this>");
        Intrinsics.f(categoryId, "categoryId");
        if (c(surgeSettings, categoryId) && Intrinsics.a(surgeSettings.a(), categoryId)) {
            return true;
        }
        return false;
    }
}
