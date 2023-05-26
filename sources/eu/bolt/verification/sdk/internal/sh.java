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
public final class sh extends ViewBuilder<hi, d> {

    /* loaded from: classes5.dex */
    public interface a {
        ii a();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(di diVar);

            a b(d dVar);

            b build();

            @BindsInstance
            a c(hi hiVar);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44980a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final ii a(hi view, ei interactor) {
                Intrinsics.f(view, "view");
                Intrinsics.f(interactor, "interactor");
                ii iiVar = new ii(view, interactor);
                interactor.O(iiVar);
                return iiVar;
            }
        }

        @Provides
        public static final ii a(hi hiVar, ei eiVar) {
            return f44980a.a(hiVar, eiVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends b0 {
        gi u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sh(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: e */
    public hi c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new hi(context, null, 0, 6, null);
    }

    public final ii f(ViewGroup parentViewGroup, di storiesRibArgs) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(storiesRibArgs, "storiesRibArgs");
        hi b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = h3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.b(dependency).a(storiesRibArgs).c(b8).build().a();
    }
}
