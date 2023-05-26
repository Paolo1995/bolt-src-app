package com.google.firebase.abt.component;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes.dex */
final /* synthetic */ class AbtRegistrar$$Lambda$1 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final AbtRegistrar$$Lambda$1 f15414a = new AbtRegistrar$$Lambda$1();

    private AbtRegistrar$$Lambda$1() {
    }

    public static ComponentFactory b() {
        return f15414a;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return AbtRegistrar.lambda$getComponents$0(componentContainer);
    }
}
