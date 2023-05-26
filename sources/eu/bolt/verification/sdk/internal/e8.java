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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e8 extends ViewBuilder<m8, d> {

    /* loaded from: classes5.dex */
    public interface a {
        k8 d();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends n6.d, a {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            a a(d dVar);

            @BindsInstance
            a b(m8 m8Var);

            b build();

            @BindsInstance
            a c(h8 h8Var);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f42750a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final k8 a(b component, m8 view, i8 interactor) {
                Intrinsics.f(component, "component");
                Intrinsics.f(view, "view");
                Intrinsics.f(interactor, "interactor");
                k8 k8Var = new k8(view, interactor, new n6(component));
                interactor.O(k8Var);
                return k8Var;
            }
        }

        @Provides
        public static final k8 a(b bVar, m8 m8Var, i8 i8Var) {
            return f42750a.a(bVar, m8Var, i8Var);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends b0 {
        qj a();

        ib b();

        y6 c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e8(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final k8 e(ViewGroup parentViewGroup, h8 args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        m8 b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = g3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.a(dependency).b(b8).c(args).build().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: f */
    public m8 c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new m8(context, null, 0, 6, null);
    }
}
