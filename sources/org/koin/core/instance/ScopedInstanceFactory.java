package org.koin.core.instance;

import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: ScopedInstanceFactory.kt */
/* loaded from: classes5.dex */
public final class ScopedInstanceFactory<T> extends InstanceFactory<T> {

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, T> f52758c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopedInstanceFactory(BeanDefinition<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.f(beanDefinition, "beanDefinition");
        this.f52758c = new HashMap<>();
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T a(InstanceContext context) {
        Intrinsics.f(context, "context");
        if (this.f52758c.get(context.c().h()) == null) {
            return (T) super.a(context);
        }
        T t7 = this.f52758c.get(context.c().h());
        if (t7 != null) {
            return t7;
        }
        throw new IllegalStateException(("Scoped instance not found for " + context.c().h() + " in " + c()).toString());
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T b(final InstanceContext context) {
        Intrinsics.f(context, "context");
        if (Intrinsics.a(context.c().j(), c().e())) {
            KoinPlatformTools.f52811a.f(this, new Function0<Unit>(this) { // from class: org.koin.core.instance.ScopedInstanceFactory$get$1

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ ScopedInstanceFactory<T> f52759f;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.f52759f = this;
                }

                public final void b() {
                    HashMap hashMap;
                    if (!this.f52759f.f(context)) {
                        hashMap = ((ScopedInstanceFactory) this.f52759f).f52758c;
                        hashMap.put(context.c().h(), this.f52759f.a(context));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
            T t7 = this.f52758c.get(context.c().h());
            if (t7 != null) {
                return t7;
            }
            throw new IllegalStateException(("Scoped instance not found for " + context.c().h() + " in " + c()).toString());
        }
        throw new IllegalStateException(("Wrong Scope: trying to open instance for " + context.c().h() + " in " + c()).toString());
    }

    public void e(Scope scope) {
        if (scope != null) {
            Function1<T, Unit> a8 = c().a().a();
            if (a8 != null) {
                a8.invoke(this.f52758c.get(scope.h()));
            }
            this.f52758c.remove(scope.h());
        }
    }

    public boolean f(InstanceContext instanceContext) {
        String str;
        Scope c8;
        HashMap<String, T> hashMap = this.f52758c;
        if (instanceContext != null && (c8 = instanceContext.c()) != null) {
            str = c8.h();
        } else {
            str = null;
        }
        if (hashMap.get(str) != null) {
            return true;
        }
        return false;
    }
}
