package org.koin.core.instance;

import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;

/* compiled from: FactoryInstanceFactory.kt */
/* loaded from: classes5.dex */
public final class FactoryInstanceFactory<T> extends InstanceFactory<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FactoryInstanceFactory(BeanDefinition<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.f(beanDefinition, "beanDefinition");
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T b(InstanceContext context) {
        Intrinsics.f(context, "context");
        return a(context);
    }
}
