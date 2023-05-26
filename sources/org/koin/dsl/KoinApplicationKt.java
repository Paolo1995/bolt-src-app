package org.koin.dsl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.koin.core.KoinApplication;

/* compiled from: KoinApplication.kt */
/* loaded from: classes5.dex */
public final class KoinApplicationKt {
    public static final KoinApplication a(Function1<? super KoinApplication, Unit> function1) {
        KoinApplication a8 = KoinApplication.f52735c.a();
        if (function1 != null) {
            function1.invoke(a8);
        }
        a8.a();
        return a8;
    }
}
