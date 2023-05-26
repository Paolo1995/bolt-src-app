package eu.bolt.verification.sdk.internal;

import android.graphics.Rect;
import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RibExtensionsKt;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$string;
import eu.bolt.verification.sdk.internal.b7;
import eu.bolt.verification.sdk.internal.bn;
import eu.bolt.verification.sdk.internal.cf;
import eu.bolt.verification.sdk.internal.gc;
import eu.bolt.verification.sdk.internal.k7;
import eu.bolt.verification.sdk.internal.l6;
import eu.bolt.verification.sdk.internal.ll;
import eu.bolt.verification.sdk.internal.m6;
import eu.bolt.verification.sdk.internal.mg;
import eu.bolt.verification.sdk.internal.q;
import eu.bolt.verification.sdk.internal.u;
import eu.bolt.verification.sdk.internal.y6;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.rx2.RxAwaitKt;

/* loaded from: classes5.dex */
public final class fn extends BaseRibInteractor<in> implements y6 {
    private static final a K = new a(null);
    private final CoActivityEvents A;
    private final xg B;
    private final bg C;
    private final o1 D;
    private final g1 E;
    private final dl F;
    private final String G;
    private boolean H;
    private q1 I;
    private mg.a J;

    /* renamed from: n  reason: collision with root package name */
    private final en f43012n;

    /* renamed from: o  reason: collision with root package name */
    private final hn f43013o;

    /* renamed from: p  reason: collision with root package name */
    private final bn f43014p;

    /* renamed from: q  reason: collision with root package name */
    private final cf f43015q;

    /* renamed from: r  reason: collision with root package name */
    private final x1 f43016r;

    /* renamed from: s  reason: collision with root package name */
    private final v8 f43017s;

    /* renamed from: t  reason: collision with root package name */
    private final mn f43018t;

    /* renamed from: u  reason: collision with root package name */
    private final i1 f43019u;

    /* renamed from: v  reason: collision with root package name */
    private final mg f43020v;

    /* renamed from: w  reason: collision with root package name */
    private final ke f43021w;

    /* renamed from: x  reason: collision with root package name */
    private final sf f43022x;

    /* renamed from: y  reason: collision with root package name */
    private final xf f43023y;

    /* renamed from: z  reason: collision with root package name */
    private final RxActivityEvents f43024z;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43025a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f43026b;

        static {
            int[] iArr = new int[k7.a.values().length];
            try {
                iArr[k7.a.CLOSE_FORM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[k7.a.GO_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f43025a = iArr;
            int[] iArr2 = new int[q1.values().length];
            try {
                iArr2[q1.FRONT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[q1.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f43026b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.camera.VerificationCameraRibInteractor$closeForm$1", f = "VerificationCameraRibInteractor.kt", l = {327}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43027g;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43027g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable b8 = fn.this.f43016r.b();
                this.f43027g = 1;
                if (RxAwaitKt.a(b8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.camera.VerificationCameraRibInteractor$goBack$1", f = "VerificationCameraRibInteractor.kt", l = {339}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43029g;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43029g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Completable e8 = fn.this.f43017s.e();
                this.f43029g = 1;
                if (RxAwaitKt.a(e8, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.camera.VerificationCameraRibInteractor$observeActivityEvents$1", f = "VerificationCameraRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class e extends SuspendLambda implements Function2<ActivityLifecycleEvent, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43031g;

        e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(ActivityLifecycleEvent activityLifecycleEvent, Continuation<? super Unit> continuation) {
            return ((e) create(activityLifecycleEvent, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f43031g == 0) {
                ResultKt.b(obj);
                fn.this.f0();
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.camera.VerificationCameraRibInteractor$observeActivityEvents$2", f = "VerificationCameraRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class f extends SuspendLambda implements Function2<ActivityLifecycleEvent, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43033g;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(ActivityLifecycleEvent activityLifecycleEvent, Continuation<? super Unit> continuation) {
            return ((f) create(activityLifecycleEvent, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f43033g == 0) {
                ResultKt.b(obj);
                fn.this.h0();
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g extends Lambda implements Function1<ActivityLifecycleEvent, Unit> {
        g() {
            super(1);
        }

        public final void b(ActivityLifecycleEvent it) {
            Intrinsics.f(it, "it");
            fn.this.f0();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
            b(activityLifecycleEvent);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class h extends Lambda implements Function1<ActivityLifecycleEvent, Unit> {
        h() {
            super(1);
        }

        public final void b(ActivityLifecycleEvent it) {
            Intrinsics.f(it, "it");
            fn.this.h0();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
            b(activityLifecycleEvent);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.camera.VerificationCameraRibInteractor$observeUiEvents$1", f = "VerificationCameraRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class i extends SuspendLambda implements Function2<bn.b, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43037g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f43038h;

        i(Continuation<? super i> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            i iVar = new i(continuation);
            iVar.f43038h = obj;
            return iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(bn.b bVar, Continuation<? super Unit> continuation) {
            return ((i) create(bVar, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f43037g == 0) {
                ResultKt.b(obj);
                bn.b bVar = (bn.b) this.f43038h;
                if (bVar instanceof bn.b.a) {
                    x.a(Boxing.a(fn.this.z(false)));
                } else if (bVar instanceof bn.b.C0038b) {
                    bn.b.C0038b c0038b = (bn.b.C0038b) bVar;
                    fn.this.V(c0038b.c(), c0038b.b(), c0038b.a());
                } else if (bVar instanceof bn.b.c) {
                    fn.this.j0();
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.camera.VerificationCameraRibInteractor$requestCameraPermission$1", f = "VerificationCameraRibInteractor.kt", l = {281}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43040g;

        j(Continuation<? super j> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new j(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43040g;
            if (i8 == 0) {
                ResultKt.b(obj);
                Single<vf> a8 = fn.this.f43022x.a(je.CAMERA, new gc.a(R$string.support_attachment_camera_rationale));
                this.f43040g = 1;
                obj = RxAwaitKt.b(a8, this);
                if (obj == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            if (((vf) obj).a()) {
                fn.this.f0();
            } else {
                fn.this.b();
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class k extends Lambda implements Function1<vf, Unit> {
        k() {
            super(1);
        }

        public final void b(vf permissionResult) {
            Intrinsics.f(permissionResult, "permissionResult");
            if (permissionResult.a()) {
                fn.this.f0();
            } else {
                fn.this.b();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(vf vfVar) {
            b(vfVar);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.verification.core.rib.camera.VerificationCameraRibInteractor$takePicture$1", f = "VerificationCameraRibInteractor.kt", l = {207, 216}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        Object f43043g;

        /* renamed from: h  reason: collision with root package name */
        int f43044h;

        /* renamed from: i  reason: collision with root package name */
        int f43045i;

        /* renamed from: j  reason: collision with root package name */
        int f43046j;

        /* renamed from: k  reason: collision with root package name */
        private /* synthetic */ Object f43047k;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ int f43049m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ int f43050n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ Rect f43051o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(int i8, int i9, Rect rect, Continuation<? super l> continuation) {
            super(2, continuation);
            this.f43049m = i8;
            this.f43050n = i9;
            this.f43051o = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            l lVar = new l(this.f43049m, this.f43050n, this.f43051o, continuation);
            lVar.f43047k = obj;
            return lVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.fn.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class m extends Lambda implements Function0<Unit> {
        m() {
            super(0);
        }

        public final void b() {
            fn.this.f43014p.b();
            fn.this.f43013o.i(fn.this.f43012n.f());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class n extends Lambda implements Function1<Throwable, Unit> {
        n() {
            super(1);
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            fn.this.f43014p.b();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    @Inject
    public fn(en args, hn ribListener, bn presenter, cf cropPhotoInteractor, x1 closeFormInteractor, v8 goBackInteractor, mn fileProvider, i1 cameraDelegate, mg ribWindowController, ke permissionHelper, sf requestPermissionHelper, xf resourcesProvider, RxActivityEvents rxActivityEvents, CoActivityEvents coActivityEvents, xg rxSchedulers, bg analyticsManager, o1 cameraThemeMapper, g1 cameraResultAspectRatioCalculator, dl targetingManager) {
        Intrinsics.f(args, "args");
        Intrinsics.f(ribListener, "ribListener");
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(cropPhotoInteractor, "cropPhotoInteractor");
        Intrinsics.f(closeFormInteractor, "closeFormInteractor");
        Intrinsics.f(goBackInteractor, "goBackInteractor");
        Intrinsics.f(fileProvider, "fileProvider");
        Intrinsics.f(cameraDelegate, "cameraDelegate");
        Intrinsics.f(ribWindowController, "ribWindowController");
        Intrinsics.f(permissionHelper, "permissionHelper");
        Intrinsics.f(requestPermissionHelper, "requestPermissionHelper");
        Intrinsics.f(resourcesProvider, "resourcesProvider");
        Intrinsics.f(rxActivityEvents, "rxActivityEvents");
        Intrinsics.f(coActivityEvents, "coActivityEvents");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(analyticsManager, "analyticsManager");
        Intrinsics.f(cameraThemeMapper, "cameraThemeMapper");
        Intrinsics.f(cameraResultAspectRatioCalculator, "cameraResultAspectRatioCalculator");
        Intrinsics.f(targetingManager, "targetingManager");
        this.f43012n = args;
        this.f43013o = ribListener;
        this.f43014p = presenter;
        this.f43015q = cropPhotoInteractor;
        this.f43016r = closeFormInteractor;
        this.f43017s = goBackInteractor;
        this.f43018t = fileProvider;
        this.f43019u = cameraDelegate;
        this.f43020v = ribWindowController;
        this.f43021w = permissionHelper;
        this.f43022x = requestPermissionHelper;
        this.f43023y = resourcesProvider;
        this.f43024z = rxActivityEvents;
        this.A = coActivityEvents;
        this.B = rxSchedulers;
        this.C = analyticsManager;
        this.D = cameraThemeMapper;
        this.E = cameraResultAspectRatioCalculator;
        this.F = targetingManager;
        this.G = "VerificationCamera";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(int i8, int i9, Rect rect) {
        this.f43014p.a();
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new l(i8, i9, rect, null), 3, null);
            return;
        }
        Completable z7 = i1.c(this.f43019u, this.f43012n.g(), null, 10000L, 2, null).v().d(this.f43015q.f(new cf.a(i8, i9, rect, this.f43018t.c(this.f43012n.l()), this.f43018t.b(this.f43012n.l())))).z(this.B.c());
        Intrinsics.e(z7, "cameraDelegate.takePhoto…erveOn(rxSchedulers.main)");
        BaseRibInteractor.S(this, ug.p(z7, new m(), new n(), null, 4, null), null, 1, null);
    }

    private final void a() {
        x6 j8 = this.f43012n.j();
        if (j8 == null) {
            ll.a aVar = ll.f44093f;
            j8 = new x6(null, null, false, ll.a.b(aVar, R$string.verification_camera_permission_dialog_title, null, 2, null), u4.f45317s, ll.a.b(aVar, R$string.verification_camera_permission_dialog_message, null, 2, null), null, null, new j6(ll.a.b(aVar, R$string.allow, null, 2, null), l6.b.f44014f, m6.a.f44156g), new j6(ll.a.b(aVar, R$string.back, null, 2, null), l6.a.f44013f, m6.b.f44157g), null, null, new z6("camera_permission", null, 2, null), null, 11459, null);
        }
        DynamicStateController1Arg.k(((in) L()).f1(), new q5(j8, new u.c(this.f43012n.e(), this.f43012n.l()), null, 4, null), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new c(null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f43016r.b(), null, null, null, 7, null), null, 1, null);
        }
    }

    private final void c() {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new d(null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.p(this.f43017s.e(), null, null, null, 7, null), null, 1, null);
        }
    }

    private final void d0() {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.F(this, null, null, new j(null), 3, null);
        } else {
            BaseRibInteractor.S(this, ug.t(this.f43022x.a(je.CAMERA, new gc.a(R$string.support_attachment_camera_rationale)), new k(), null, null, 6, null), null, 1, null);
        }
    }

    private final void e() {
        if (((Boolean) this.F.a(b7.a.C0036a.f42287b)).booleanValue()) {
            BaseScopeOwner.H(this, this.A.u(), new e(null), null, null, null, false, 30, null);
            BaseScopeOwner.H(this, this.A.p(), new f(null), null, null, null, false, 30, null);
            return;
        }
        BaseRibInteractor.S(this, ug.r(this.f43024z.o(), new g(), null, null, null, null, 30, null), null, 1, null);
        BaseRibInteractor.S(this, ug.r(this.f43024z.k(), new h(), null, null, null, null, 30, null), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f0() {
        /*
            r4 = this;
            eu.bolt.verification.sdk.internal.ke r0 = r4.f43021w
            boolean r0 = r0.a()
            if (r0 == 0) goto L4a
            eu.bolt.verification.sdk.internal.q1 r0 = r4.I
            r1 = -1
            if (r0 != 0) goto Lf
            r0 = -1
            goto L17
        Lf:
            int[] r2 = eu.bolt.verification.sdk.internal.fn.b.f43026b
            int r0 = r0.ordinal()
            r0 = r2[r0]
        L17:
            if (r0 == r1) goto L29
            r1 = 1
            if (r0 == r1) goto L26
            r1 = 2
            if (r0 != r1) goto L20
            goto L29
        L20:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L26:
            androidx.camera.core.CameraSelector r0 = androidx.camera.core.CameraSelector.f3052b
            goto L2b
        L29:
            androidx.camera.core.CameraSelector r0 = androidx.camera.core.CameraSelector.f3053c
        L2b:
            java.lang.String r1 = "when (currentCameraType)…BACK_CAMERA\n            }"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            eu.bolt.verification.sdk.internal.i1 r1 = r4.f43019u
            eu.bolt.verification.sdk.internal.g1 r2 = r4.E
            eu.bolt.verification.sdk.internal.q1 r3 = r4.I
            if (r3 != 0) goto L3a
            eu.bolt.verification.sdk.internal.q1 r3 = eu.bolt.verification.sdk.internal.q1.BACK
        L3a:
            android.util.Size r2 = r2.b(r3)
            r3 = 100
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.g(r0, r2, r3)
            r4.l0()
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.fn.f0():void");
    }

    private final void g() {
        BaseScopeOwner.H(this, this.f43014p.p(), new i(null), null, null, null, false, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        if (this.f43021w.a()) {
            this.f43019u.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        this.H = !this.H;
        l0();
    }

    private final void l0() {
        this.f43014p.f(this.H);
        this.f43019u.j(this.H);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void A(z6 z6Var) {
        this.C.d(new q.g(this.f43012n.e(), this.f43012n.l()));
        DynamicStateController.g(((in) L()).f1(), false, 1, null);
        if (Intrinsics.a(z6Var != null ? z6Var.a() : null, "camera_permission")) {
            d0();
        }
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        q1 c8;
        mg.a b8;
        super.K(bundle);
        this.H = bundle != null ? bundle.b("flashlight_enabled", false) : false;
        if (bundle == null || (c8 = (q1) RibExtensionsKt.b(bundle, "camera_type")) == null) {
            c8 = this.f43012n.c();
        }
        this.I = c8;
        if (bundle == null || (b8 = (mg.a) RibExtensionsKt.b(bundle, "window_config")) == null) {
            b8 = this.f43020v.b();
        }
        this.J = b8;
        wl a8 = this.D.a(this.f43012n.m());
        this.f43020v.c(!Intrinsics.a(a8, qb.f44642g));
        this.f43020v.f(false);
        this.f43020v.d(Integer.valueOf(this.f43023y.d(a8.c())));
        this.f43020v.a();
        mg.b.a(this.f43020v, this.f43023y.d(R$color.A), false, 2, null);
        g();
        e();
        this.f43014p.i(this.f43012n.n());
        this.f43014p.c(this.f43012n.d());
        this.f43014p.l(this.f43012n.h(), a8);
        this.f43014p.j(this.f43012n.i());
        this.f43014p.t(this.f43012n.a());
        q1 q1Var = this.I;
        if (q1Var != null) {
            this.f43014p.x(this.E.c(q1Var));
        }
        k7.b k8 = this.f43012n.k();
        if (k8 != null) {
            this.C.b(this, new u.d(k8.b(), k8.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void P() {
        h0();
        mg.a aVar = this.J;
        if (aVar != null) {
            this.f43020v.g(aVar);
        }
        super.P();
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void m(z6 z6Var) {
        this.C.d(new q.h(this.f43012n.e(), this.f43012n.l()));
        b();
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void o(Serializable serializable) {
        y6.a.b(this, serializable);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public Flow<k6> p(z6 z6Var) {
        return y6.a.d(this, z6Var);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void q(z6 z6Var) {
        y6.a.e(this, z6Var);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public Flow<k6> r(z6 z6Var) {
        return y6.a.c(this, z6Var);
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void s() {
        super.s();
        if (this.f43021w.a()) {
            return;
        }
        a();
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void t(z6 z6Var) {
        y6.a.a(this, z6Var);
    }

    @Override // eu.bolt.verification.sdk.internal.y6
    public void u(z6 z6Var) {
        y6.a.f(this, z6Var);
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void x(Bundle outState) {
        Intrinsics.f(outState, "outState");
        super.x(outState);
        outState.f("flashlight_enabled", this.H);
        outState.h("camera_type", this.I);
        outState.h("window_config", this.J);
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        eu.bolt.verification.sdk.internal.e b8 = this.f43012n.b();
        if (b8 != null) {
            this.C.d(new q.i(b8.a(), b8.b()));
        }
        int i8 = b.f43025a[this.f43012n.a().ordinal()];
        if (i8 == 1) {
            b();
        } else if (i8 == 2) {
            c();
        }
        return true;
    }
}
