package io.ktor.client.plugins.contentnegotiation;

import java.io.InputStream;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: DefaultIgnoredTypesJvm.kt */
/* loaded from: classes5.dex */
public final class DefaultIgnoredTypesJvmKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<KClass<?>> f46494a;

    static {
        Set<KClass<?>> d8;
        d8 = SetsKt__SetsKt.d(Reflection.b(InputStream.class));
        f46494a = d8;
    }

    public static final Set<KClass<?>> a() {
        return f46494a;
    }
}
