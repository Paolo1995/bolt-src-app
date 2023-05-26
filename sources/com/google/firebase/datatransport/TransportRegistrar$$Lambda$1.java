package com.google.firebase.datatransport;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes3.dex */
final /* synthetic */ class TransportRegistrar$$Lambda$1 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final TransportRegistrar$$Lambda$1 f16202a = new TransportRegistrar$$Lambda$1();

    private TransportRegistrar$$Lambda$1() {
    }

    public static ComponentFactory b() {
        return f16202a;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return TransportRegistrar.lambda$getComponents$0(componentContainer);
    }
}
