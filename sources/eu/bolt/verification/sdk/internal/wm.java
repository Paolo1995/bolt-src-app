package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import eu.bolt.android.rib.ViewBuilder;
import eu.bolt.verification.sdk.internal.o5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class wm extends ViewBuilder<jn, d> {

    /* loaded from: classes5.dex */
    public interface a {
        in d();
    }

    @Component(dependencies = {d.class}, modules = {c.class})
    /* loaded from: classes5.dex */
    public interface b extends a, o5.d {

        @Component.Builder
        /* loaded from: classes5.dex */
        public interface a {
            @BindsInstance
            a a(jn jnVar);

            @BindsInstance
            a b(en enVar);

            b build();

            a c(d dVar);
        }
    }

    @Module
    /* loaded from: classes5.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f45575a = new a(null);

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Provides
            public final AppCompatActivity a(Activity activity) {
                Intrinsics.f(activity, "activity");
                return (AppCompatActivity) activity;
            }

            @Provides
            public final PreviewView b(jn view) {
                Intrinsics.f(view, "view");
                PreviewView previewView = view.getBinding().f43864e;
                Intrinsics.e(previewView, "view.binding.cameraPreview");
                return previewView;
            }

            @Provides
            public final in c(jn view, b component, fn interactor, ViewGroup fullScreenContainer) {
                Intrinsics.f(view, "view");
                Intrinsics.f(component, "component");
                Intrinsics.f(interactor, "interactor");
                Intrinsics.f(fullScreenContainer, "fullScreenContainer");
                in inVar = new in(view, interactor, fullScreenContainer, new o5(component));
                interactor.O(inVar);
                return inVar;
            }
        }

        @Provides
        public static final AppCompatActivity a(Activity activity) {
            return f45575a.a(activity);
        }

        @Provides
        public static final PreviewView b(jn jnVar) {
            return f45575a.b(jnVar);
        }

        @Provides
        public static final in c(jn jnVar, b bVar, fn fnVar, ViewGroup viewGroup) {
            return f45575a.c(jnVar, bVar, fnVar, viewGroup);
        }
    }

    /* loaded from: classes5.dex */
    public interface d extends mp {
        hn A();

        xn g();

        ke i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wm(d dependency) {
        super(dependency);
        Intrinsics.f(dependency, "dependency");
    }

    public final in e(ViewGroup parentViewGroup, en args) {
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Intrinsics.f(args, "args");
        jn b8 = b(parentViewGroup);
        Intrinsics.e(b8, "createView(parentViewGroup)");
        b.a a8 = l3.a();
        d dependency = a();
        Intrinsics.e(dependency, "dependency");
        return a8.c(dependency).a(b8).b(args).build().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.ViewBuilder
    /* renamed from: f */
    public jn c(LayoutInflater inflater, ViewGroup parentViewGroup) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parentViewGroup, "parentViewGroup");
        Context context = parentViewGroup.getContext();
        Intrinsics.e(context, "parentViewGroup.context");
        return new jn(context, null, 0, 6, null);
    }
}
