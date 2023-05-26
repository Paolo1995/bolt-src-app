package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SetsJVM.kt */
/* loaded from: classes5.dex */
public class SetsKt__SetsJVMKt {
    public static <T> Set<T> a(T t7) {
        Set<T> singleton = Collections.singleton(t7);
        Intrinsics.e(singleton, "singleton(element)");
        return singleton;
    }
}
