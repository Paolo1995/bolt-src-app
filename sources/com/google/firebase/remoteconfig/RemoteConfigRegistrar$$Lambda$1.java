package com.google.firebase.remoteconfig;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes3.dex */
final /* synthetic */ class RemoteConfigRegistrar$$Lambda$1 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final RemoteConfigRegistrar$$Lambda$1 f17051a = new RemoteConfigRegistrar$$Lambda$1();

    private RemoteConfigRegistrar$$Lambda$1() {
    }

    public static ComponentFactory b() {
        return f17051a;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return RemoteConfigRegistrar.lambda$getComponents$0(componentContainer);
    }
}
