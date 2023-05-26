package org.koin.core.registry;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.mp.KoinPlatformTools;

/* compiled from: PropertyRegistry.kt */
/* loaded from: classes5.dex */
public final class PropertyRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final Koin f52785a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f52786b;

    public PropertyRegistry(Koin _koin) {
        Intrinsics.f(_koin, "_koin");
        this.f52785a = _koin;
        this.f52786b = KoinPlatformTools.f52811a.e();
    }
}
