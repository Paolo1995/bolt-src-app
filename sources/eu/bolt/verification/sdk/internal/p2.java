package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import eu.bolt.android.rib.ViewBuilder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class p2 extends ViewBuilder<y2, d> {

    /* loaded from: classes5.dex */
    public interface a {
        w2 a();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(o2 o2Var);

            @BindsInstance
            a b(y2 y2Var);

            b build();

            a c(d dVar);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public interface c {
    }

    /* loaded from: classes5.dex */
    public interface d extends b0 {
        s2 J();

        ib b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final w2 e(ViewGroup parentViewGroup, o2 args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        y2 b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = c3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.c(dependency).a(args).b(b8).build().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: f */
    public y2 c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new y2(context, null, 0, 6, null);
    }
}
