package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class Registrar$$Lambda$1 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    static final ComponentFactory f16322a = new Registrar$$Lambda$1();

    private Registrar$$Lambda$1() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return Registrar.lambda$getComponents$1$Registrar(componentContainer);
    }
}
