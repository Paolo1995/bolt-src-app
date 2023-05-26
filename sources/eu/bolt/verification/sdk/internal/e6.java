package eu.bolt.verification.sdk.internal;

import android.view.View;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.DynamicTransitionFactoryArgs;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController;
import eu.bolt.android.rib.transition.RibGenericTransition;
import eu.bolt.android.rib.transition.RibImmediateTransition;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes5.dex */
public final class e6 {

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function1<DynamicTransitionFactoryArgs, Unit> {

        /* renamed from: f */
        public static final a f42730f = new a();

        a() {
            super(1);
        }

        public final void b(DynamicTransitionFactoryArgs it) {
            Intrinsics.f(it, "it");
            DynamicStateController.g(it.a(), false, 1, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DynamicTransitionFactoryArgs dynamicTransitionFactoryArgs) {
            b(dynamicTransitionFactoryArgs);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> {

        /* renamed from: f */
        final /* synthetic */ Function1<DynamicTransitionFactoryArgs, Unit> f42731f;

        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<BaseDynamicRouter.DynamicState, Unit> {

            /* renamed from: f */
            final /* synthetic */ Function1<DynamicTransitionFactoryArgs, Unit> f42732f;

            /* renamed from: g */
            final /* synthetic */ DynamicTransitionFactoryArgs f42733g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(Function1<? super DynamicTransitionFactoryArgs, Unit> function1, DynamicTransitionFactoryArgs dynamicTransitionFactoryArgs) {
                super(1);
                this.f42732f = function1;
                this.f42733g = dynamicTransitionFactoryArgs;
            }

            public final void b(BaseDynamicRouter.DynamicState it) {
                Intrinsics.f(it, "it");
                this.f42732f.invoke(this.f42733g);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseDynamicRouter.DynamicState dynamicState) {
                b(dynamicState);
                return Unit.f50853a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super DynamicTransitionFactoryArgs, Unit> function1) {
            super(1);
            this.f42731f = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState> invoke(DynamicTransitionFactoryArgs args) {
            Intrinsics.f(args, "args");
            Function0<Router> c8 = args.c();
            Intrinsics.d(c8, "null cannot be cast to non-null type kotlin.Function0<eu.bolt.android.rib.ViewRouter<out eu.bolt.client.design.bottomsheet.DesignBottomSheetPanel>>");
            return new eg(args.b(), (Function0) TypeIntrinsics.e(c8, 0), new a(this.f42731f, args));
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f */
        public static final c f42734f = new c();

        c() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            Intrinsics.f(ribGenericTransition, "$this$null");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> {

        /* renamed from: f */
        final /* synthetic */ Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> f42735f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> function1) {
            super(1);
            this.f42735f = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState> invoke(DynamicTransitionFactoryArgs it) {
            Intrinsics.f(it, "it");
            Function0<Router> c8 = it.c();
            Intrinsics.d(c8, "null cannot be cast to non-null type kotlin.Function0<eu.bolt.android.rib.ViewRouter<*>>");
            RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition = new RibGenericTransition<>(it.b(), (Function0) TypeIntrinsics.e(c8, 0));
            this.f42735f.invoke(ribGenericTransition);
            return ribGenericTransition;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<RibImmediateTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f */
        public static final e f42736f = new e();

        e() {
            super(1);
        }

        public final void b(RibImmediateTransition<BaseDynamicRouter.DynamicState> ribImmediateTransition) {
            Intrinsics.f(ribImmediateTransition, "$this$null");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibImmediateTransition<BaseDynamicRouter.DynamicState> ribImmediateTransition) {
            b(ribImmediateTransition);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends Lambda implements Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> {

        /* renamed from: f */
        final /* synthetic */ Function1<RibImmediateTransition<BaseDynamicRouter.DynamicState>, Unit> f42737f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(Function1<? super RibImmediateTransition<BaseDynamicRouter.DynamicState>, Unit> function1) {
            super(1);
            this.f42737f = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState> invoke(DynamicTransitionFactoryArgs it) {
            Intrinsics.f(it, "it");
            RibImmediateTransition<BaseDynamicRouter.DynamicState> ribImmediateTransition = new RibImmediateTransition<>(it.b(), it.c(), null, null, 12, null);
            this.f42737f.invoke(ribImmediateTransition);
            return ribImmediateTransition;
        }
    }

    public static final <T extends View> Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> a(BaseDynamicRouter<?> baseDynamicRouter, Function1<? super DynamicTransitionFactoryArgs, Unit> closeListener) {
        Intrinsics.f(baseDynamicRouter, "<this>");
        Intrinsics.f(closeListener, "closeListener");
        return c(new b(closeListener));
    }

    public static /* synthetic */ Function1 b(BaseDynamicRouter baseDynamicRouter, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = a.f42730f;
        }
        return a(baseDynamicRouter, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> c(Function1<? super DynamicTransitionFactoryArgs, ? extends RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> factory) {
        Intrinsics.f(factory, "factory");
        return factory;
    }

    public static final Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> d(BaseDynamicRouter<?> baseDynamicRouter, Function1<? super RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> config) {
        Intrinsics.f(baseDynamicRouter, "<this>");
        Intrinsics.f(config, "config");
        return c(new d(config));
    }

    public static /* synthetic */ Function1 e(BaseDynamicRouter baseDynamicRouter, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = c.f42734f;
        }
        return d(baseDynamicRouter, function1);
    }

    public static final Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> f(BaseDynamicRouter<?> baseDynamicRouter, Function1<? super RibImmediateTransition<BaseDynamicRouter.DynamicState>, Unit> config) {
        Intrinsics.f(baseDynamicRouter, "<this>");
        Intrinsics.f(config, "config");
        return c(new f(config));
    }

    public static /* synthetic */ Function1 g(BaseDynamicRouter baseDynamicRouter, Function1 function1, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            function1 = e.f42736f;
        }
        return f(baseDynamicRouter, function1);
    }
}
