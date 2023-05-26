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
public final class n6 extends ViewBuilder<w6, d> {

    /* loaded from: classes5.dex */
    public interface a {
        v6 a();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(s6 s6Var);

            a b(d dVar);

            b build();

            @BindsInstance
            a c(w6 w6Var);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44293a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final v6 a(w6 view, t6 interactor, qj storyScreenRouter) {
                Intrinsics.f(view, "view");
                Intrinsics.f(interactor, "interactor");
                Intrinsics.f(storyScreenRouter, "storyScreenRouter");
                v6 v6Var = new v6(view, interactor, storyScreenRouter);
                interactor.O(v6Var);
                return v6Var;
            }
        }

        @Provides
        public static final v6 a(w6 w6Var, t6 t6Var, qj qjVar) {
            return f44293a.a(w6Var, t6Var, qjVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends b0 {
        qj a();

        y6 c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n6(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final v6 e(ViewGroup parentViewGroup, s6 args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        w6 b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = e3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.b(dependency).c(b8).a(args).build().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: f */
    public w6 c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new w6(context, null, 0, 6, null);
    }
}
