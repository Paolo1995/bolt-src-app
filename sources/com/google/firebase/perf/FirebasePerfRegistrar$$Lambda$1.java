package com.google.firebase.perf;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes3.dex */
final /* synthetic */ class FirebasePerfRegistrar$$Lambda$1 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final FirebasePerfRegistrar$$Lambda$1 f16646a = new FirebasePerfRegistrar$$Lambda$1();

    private FirebasePerfRegistrar$$Lambda$1() {
    }

    public static ComponentFactory b() {
        return f16646a;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return FirebasePerfRegistrar.lambda$getComponents$0(componentContainer);
    }
}
