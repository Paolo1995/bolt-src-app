package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import eu.bolt.android.rib.ViewBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class o0 extends ViewBuilder<x0, d> {

    /* loaded from: classes5.dex */
    public interface a {
        w0 a();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(x0 x0Var);

            @BindsInstance
            a b(ga gaVar);

            b build();

            a c(d dVar);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44369a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final w0 a(x0 view, t0 interactor, qj storyScreenRouter) {
                Intrinsics.f(view, "view");
                Intrinsics.f(interactor, "interactor");
                Intrinsics.f(storyScreenRouter, "storyScreenRouter");
                w0 w0Var = new w0(view, interactor, storyScreenRouter);
                interactor.O(w0Var);
                return w0Var;
            }
        }

        @Provides
        public static final w0 a(x0 x0Var, t0 t0Var, qj qjVar) {
            return f44369a.a(x0Var, t0Var, qjVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        v0 F();

        qj a();

        jc d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final w0 e(ViewGroup parentViewGroup, ga args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        x0 b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = b3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.c(dependency).a(b8).b(args).build().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: f */
    public x0 c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new x0(context, null, 0, 6, null);
    }
}
