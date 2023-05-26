package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import eu.bolt.android.rib.ViewBuilder;
import eu.bolt.verification.sdk.internal.p2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l7 extends ViewBuilder<v7, d> {

    /* loaded from: classes5.dex */
    public interface a {
        u7 d();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a, p2.d {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            a a(d dVar);

            @BindsInstance
            a b(v7 v7Var);

            b build();

            @BindsInstance
            a c(q7 q7Var);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44018a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final u7 a(v7 view, b component, r7 interactor, ViewGroup fullScreenContainer) {
                Intrinsics.f(view, "view");
                Intrinsics.f(component, "component");
                Intrinsics.f(interactor, "interactor");
                Intrinsics.f(fullScreenContainer, "fullScreenContainer");
                u7 u7Var = new u7(view, interactor, fullScreenContainer, new p2(component));
                interactor.O(u7Var);
                return u7Var;
            }
        }

        @Provides
        public static final u7 a(v7 v7Var, b bVar, r7 r7Var, ViewGroup viewGroup) {
            return f44018a.a(v7Var, bVar, r7Var, viewGroup);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends mp {
        t7 D();

        xn g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l7(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final u7 e(ViewGroup parentViewGroup, q7 args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        v7 b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = f3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.a(dependency).b(b8).c(args).build().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: f */
    public v7 c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new v7(context, null, 0, 6, null);
    }
}
