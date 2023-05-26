package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import eu.bolt.android.rib.ViewBuilder;
import eu.bolt.verification.sdk.internal.n6;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class o5 extends ViewBuilder<u5, d> {

    /* loaded from: classes5.dex */
    public interface a {
        t5 d();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends n6.d, a {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(u5 u5Var);

            a b(d dVar);

            b build();

            @BindsInstance
            a c(q5 q5Var);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f44412a = new c();

        private c() {
        }

        @Provides
        public static final t5 a(b component, u5 view, r5 interactor) {
            Intrinsics.f(component, "component");
            Intrinsics.f(view, "view");
            Intrinsics.f(interactor, "interactor");
            t5 t5Var = new t5(view, interactor, new n6(component));
            interactor.O(t5Var);
            return t5Var;
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends b0 {
        qj a();

        ib b();

        y6 c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o5(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final t5 e(ViewGroup parentViewGroup, q5 args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        u5 b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = d3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.b(dependency).c(args).a(b8).build().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: f */
    public u5 c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new u5(context, null, 0, 6, null);
    }
}
