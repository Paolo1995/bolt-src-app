package org.koin.core.instance;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.InstanceCreationException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.mp.KoinPlatformTools;

/* compiled from: InstanceFactory.kt */
/* loaded from: classes5.dex */
public abstract class InstanceFactory<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f52756b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final BeanDefinition<T> f52757a;

    /* compiled from: InstanceFactory.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InstanceFactory(BeanDefinition<T> beanDefinition) {
        Intrinsics.f(beanDefinition, "beanDefinition");
        this.f52757a = beanDefinition;
    }

    public T a(InstanceContext context) {
        Intrinsics.f(context, "context");
        Koin a8 = context.a();
        Logger d8 = a8.d();
        String str = "| (+) '" + this.f52757a + '\'';
        Level level = Level.DEBUG;
        if (d8.b(level)) {
            d8.a(level, str);
        }
        try {
            ParametersHolder b8 = context.b();
            if (b8 == null) {
                b8 = ParametersHolderKt.a();
            }
            return this.f52757a.b().s(context.c(), b8);
        } catch (Exception e8) {
            String d9 = KoinPlatformTools.f52811a.d(e8);
            Logger d10 = a8.d();
            String str2 = "* Instance creation error : could not create instance for '" + this.f52757a + "': " + d9;
            Level level2 = Level.ERROR;
            if (d10.b(level2)) {
                d10.a(level2, str2);
            }
            throw new InstanceCreationException("Could not create instance for '" + this.f52757a + '\'', e8);
        }
    }

    public abstract T b(InstanceContext instanceContext);

    public final BeanDefinition<T> c() {
        return this.f52757a;
    }
}
