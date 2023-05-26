package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import eu.bolt.android.rib.Builder;
import eu.bolt.client.updateapp.rib.UpdateAppRibBuilder;
import eu.bolt.verification.sdk.internal.pi;
import eu.bolt.verification.sdk.internal.sh;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class vi extends Builder<d> {

    /* loaded from: classes5.dex */
    public interface a {
        bj d();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a, sh.d, pi.d, UpdateAppRibBuilder.ParentComponent {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(ViewGroup viewGroup);

            a b(d dVar);

            b build();

            @BindsInstance
            a c(xi xiVar);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f45454a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final bj a(ViewGroup viewGroup, b component, yi interactor) {
                Intrinsics.f(viewGroup, "viewGroup");
                Intrinsics.f(component, "component");
                Intrinsics.f(interactor, "interactor");
                bj bjVar = new bj(viewGroup, interactor, new sh(component), new pi(component), new UpdateAppRibBuilder(component));
                interactor.O(bjVar);
                return bjVar;
            }
        }

        @Provides
        public static final bj a(ViewGroup viewGroup, b bVar, yi yiVar) {
            return f45454a.a(viewGroup, bVar, yiVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends b0 {
        aj j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vi(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final bj b(ViewGroup parentView, xi args) {
        Intrinsics.f(parentView, "parentView");
        Intrinsics.f(args, "args");
        b.a a8 = k3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.b(dependency).a(parentView).c(args).build().d();
    }
}
