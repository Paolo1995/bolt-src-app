package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import eu.bolt.android.rib.Builder;
import eu.bolt.verification.sdk.internal.e8;
import eu.bolt.verification.sdk.internal.l7;
import eu.bolt.verification.sdk.internal.o0;
import eu.bolt.verification.sdk.internal.vi;
import eu.bolt.verification.sdk.internal.wm;
import eu.bolt.verification.sdk.internal.yq;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class rn extends Builder<d> {

    /* loaded from: classes5.dex */
    public interface a {
        Cdo C();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a, l7.d, wm.d, o0.d, vi.d, yq.d, e8.d {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(ViewGroup viewGroup);

            a b(d dVar);

            b build();

            @BindsInstance
            a c(yn ynVar);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44870a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final Cdo a(ViewGroup view, b component, zn<Cdo> interactor, ViewGroup fullScreenContainer) {
                Intrinsics.f(view, "view");
                Intrinsics.f(component, "component");
                Intrinsics.f(interactor, "interactor");
                Intrinsics.f(fullScreenContainer, "fullScreenContainer");
                eo eoVar = new eo(view, interactor, fullScreenContainer, new wm(component), new l7(component), new o0(component), new vi(component), new yq(component), new e8(component));
                interactor.O(eoVar);
                return eoVar;
            }

            @Provides
            public final xn b(xg rxSchedulers) {
                Intrinsics.f(rxSchedulers, "rxSchedulers");
                return new xn(rxSchedulers);
            }

            @Provides
            public final zn<Cdo> c(ao impl) {
                Intrinsics.f(impl, "impl");
                return impl;
            }
        }

        @Provides
        public static final Cdo a(ViewGroup viewGroup, b bVar, zn<Cdo> znVar, ViewGroup viewGroup2) {
            return f44870a.a(viewGroup, bVar, znVar, viewGroup2);
        }

        @Provides
        public static final xn b(xg xgVar) {
            return f44870a.b(xgVar);
        }

        @Provides
        public static final zn<Cdo> c(ao aoVar) {
            return f44870a.c(aoVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends mp {
        ke i();

        co y();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rn(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final Cdo b(ViewGroup parentViewGroup, yn args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        b.a a8 = n3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.b(dependency).a(parentViewGroup).c(args).build().C();
    }
}
