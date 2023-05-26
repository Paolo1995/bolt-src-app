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
public final class pi extends ViewBuilder<oj, d> {

    /* loaded from: classes5.dex */
    public interface a {
        pj a();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(kj kjVar);

            a b(d dVar);

            b build();

            @BindsInstance
            a c(oj ojVar);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44553a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final pj a(oj view, lj interactor) {
                Intrinsics.f(view, "view");
                Intrinsics.f(interactor, "interactor");
                pj pjVar = new pj(view, interactor);
                interactor.O(pjVar);
                return pjVar;
            }
        }

        @Provides
        public static final pj a(oj ojVar, lj ljVar) {
            return f44553a.a(ojVar, ljVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends b0 {
        nj K();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pi(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: e */
    public oj c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new oj(context, null, 0, 6, null);
    }

    public final pj f(ViewGroup parentViewGroup, kj args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        oj b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = j3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.b(dependency).c(b8).a(args).build().a();
    }
}
