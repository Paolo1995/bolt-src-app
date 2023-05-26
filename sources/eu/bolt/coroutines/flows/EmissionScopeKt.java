package eu.bolt.coroutines.flows;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: EmissionScope.kt */
/* loaded from: classes5.dex */
public final class EmissionScopeKt {

    /* renamed from: a  reason: collision with root package name */
    private static final CoroutineScope f40380a = CoroutineScopeKt.a(Dispatchers.d());

    public static final CoroutineScope a() {
        return f40380a;
    }
}
