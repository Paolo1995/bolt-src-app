package eu.bolt.android.rib;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SerializableRouterNavigatorState.kt */
/* loaded from: classes5.dex */
public abstract class SerializableRouterNavigatorStateWithName implements SerializableRouterNavigatorState {

    /* renamed from: f  reason: collision with root package name */
    private final String f37099f;

    public SerializableRouterNavigatorStateWithName(String name) {
        Intrinsics.f(name, "name");
        this.f37099f = name;
    }

    public final String b() {
        return this.f37099f;
    }

    @Override // eu.bolt.android.rib.RouterNavigatorState
    public String name() {
        return this.f37099f;
    }
}
