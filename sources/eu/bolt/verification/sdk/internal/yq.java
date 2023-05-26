package eu.bolt.verification.sdk.internal;

import android.app.Activity;
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
public final class yq extends ViewBuilder<hr, d> {

    /* loaded from: classes5.dex */
    public interface a {
        gr a();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(td tdVar);

            @BindsInstance
            a b(hr hrVar);

            b build();

            a c(d dVar);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f45785a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final gr a(hr view, ar interactor) {
                Intrinsics.f(view, "view");
                Intrinsics.f(interactor, "interactor");
                gr grVar = new gr(view, interactor);
                interactor.O(grVar);
                return grVar;
            }
        }

        @Provides
        public static final gr a(hr hrVar, ar arVar) {
            return f45785a.a(hrVar, arVar);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends b0 {
        jc e();

        Activity f();

        lr h();

        cr t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yq(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final gr e(ViewGroup parentViewGroup, td args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        hr b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = o3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.c(dependency).a(args).b(b8).build().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: f */
    public hr c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new hr(context, null, 0, 6, null);
    }
}
