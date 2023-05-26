package org.koin.core.instance;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;
import org.koin.mp.KoinPlatformTools;

/* compiled from: SingleInstanceFactory.kt */
/* loaded from: classes5.dex */
public final class SingleInstanceFactory<T> extends InstanceFactory<T> {

    /* renamed from: c  reason: collision with root package name */
    private T f52761c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleInstanceFactory(BeanDefinition<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.f(beanDefinition, "beanDefinition");
    }

    private final T e() {
        T t7 = this.f52761c;
        if (t7 != null) {
            return t7;
        }
        throw new IllegalStateException("Single instance created couldn't return value".toString());
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T a(InstanceContext context) {
        Intrinsics.f(context, "context");
        if (this.f52761c == null) {
            return (T) super.a(context);
        }
        return e();
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T b(final InstanceContext context) {
        Intrinsics.f(context, "context");
        KoinPlatformTools.f52811a.f(this, new Function0<Unit>(this) { // from class: org.koin.core.instance.SingleInstanceFactory$get$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ SingleInstanceFactory<T> f52762f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f52762f = this;
            }

            public final void b() {
                if (!this.f52762f.f(context)) {
                    SingleInstanceFactory<T> singleInstanceFactory = this.f52762f;
                    ((SingleInstanceFactory) singleInstanceFactory).f52761c = singleInstanceFactory.a(context);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        return e();
    }

    public boolean f(InstanceContext instanceContext) {
        if (this.f52761c != null) {
            return true;
        }
        return false;
    }
}
