package org.koin.ext;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.mp.KoinPlatformTools;

/* compiled from: KClassExt.kt */
/* loaded from: classes5.dex */
public final class KClassExtKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<KClass<?>, String> f52809a = KoinPlatformTools.f52811a.e();

    public static final String a(KClass<?> kClass) {
        Intrinsics.f(kClass, "<this>");
        String str = f52809a.get(kClass);
        if (str == null) {
            return b(kClass);
        }
        return str;
    }

    public static final String b(KClass<?> kClass) {
        Intrinsics.f(kClass, "<this>");
        String c8 = KoinPlatformTools.f52811a.c(kClass);
        f52809a.put(kClass, c8);
        return c8;
    }
}
