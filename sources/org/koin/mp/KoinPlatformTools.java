package org.koin.mp;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: KoinPlatformTools.kt */
/* loaded from: classes5.dex */
public final class KoinPlatformTools {

    /* renamed from: a  reason: collision with root package name */
    public static final KoinPlatformTools f52811a = new KoinPlatformTools();

    private KoinPlatformTools() {
    }

    public final LazyThreadSafetyMode a() {
        return LazyThreadSafetyMode.SYNCHRONIZED;
    }

    public final String b() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.e(uuid, "randomUUID().toString()");
        return uuid;
    }

    public final String c(KClass<?> kClass) {
        Intrinsics.f(kClass, "kClass");
        String name = JvmClassMappingKt.a(kClass).getName();
        Intrinsics.e(name, "kClass.java.name");
        return name;
    }

    public final String d(Exception e8) {
        String f02;
        boolean Q;
        Intrinsics.f(e8, "e");
        StringBuilder sb = new StringBuilder();
        sb.append(e8);
        sb.append("\n\t");
        StackTraceElement[] stackTrace = e8.getStackTrace();
        Intrinsics.e(stackTrace, "e.stackTrace");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.e(className, "it.className");
            Q = StringsKt__StringsKt.Q(className, "sun.reflect", false, 2, null);
            if (!(!Q)) {
                break;
            }
            arrayList.add(stackTraceElement);
        }
        f02 = CollectionsKt___CollectionsKt.f0(arrayList, "\n\t", null, null, 0, null, null, 62, null);
        sb.append(f02);
        return sb.toString();
    }

    public final <K, V> Map<K, V> e() {
        return new ConcurrentHashMap();
    }

    public final <R> R f(Object lock, Function0<? extends R> block) {
        R invoke;
        Intrinsics.f(lock, "lock");
        Intrinsics.f(block, "block");
        synchronized (lock) {
            invoke = block.invoke();
        }
        return invoke;
    }
}
