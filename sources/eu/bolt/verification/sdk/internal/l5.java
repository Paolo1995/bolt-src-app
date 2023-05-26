package eu.bolt.verification.sdk.internal;

import android.os.Environment;
import eu.bolt.android.rib.RxActivityEvents;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxConvertKt;

/* loaded from: classes5.dex */
public final class l5 {

    /* renamed from: c  reason: collision with root package name */
    private static final a f43993c = new a(null);
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f43994d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    private static final List<File> f43995e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    private static final List<File> f43996f;

    /* renamed from: a  reason: collision with root package name */
    private final RxActivityEvents f43997a;

    /* renamed from: b  reason: collision with root package name */
    private final g7 f43998b;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @DebugMetadata(c = "eu.bolt.client.stories.screenshot.DetectScreenshotsInteractor$execute$$inlined$flatMapLatest$1", f = "DetectScreenshotsInteractor.kt", l = {190}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class b extends SuspendLambda implements Function3<FlowCollector<? super File>, Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43999g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f44000h;

        /* renamed from: i  reason: collision with root package name */
        /* synthetic */ Object f44001i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ l5 f44002j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Continuation continuation, l5 l5Var) {
            super(3, continuation);
            this.f44002j = l5Var;
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: h */
        public final Object l(FlowCollector<? super File> flowCollector, Boolean bool, Continuation<? super Unit> continuation) {
            b bVar = new b(continuation, this.f44002j);
            bVar.f44000h = flowCollector;
            bVar.f44001i = bool;
            return bVar.invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43999g;
            if (i8 == 0) {
                ResultKt.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.f44000h;
                Flow d9 = ((Boolean) this.f44001i).booleanValue() ? this.f44002j.d() : FlowKt.m();
                this.f43999g = 1;
                if (FlowKt.l(flowCollector, d9, this) == d8) {
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

    /* loaded from: classes5.dex */
    public static final class c implements Flow<Boolean> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f44003f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f44004f;

            @DebugMetadata(c = "eu.bolt.client.stories.screenshot.DetectScreenshotsInteractor$inForegroundFlow$$inlined$map$1$2", f = "DetectScreenshotsInteractor.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.l5$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0071a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f44005f;

                /* renamed from: g  reason: collision with root package name */
                int f44006g;

                public C0071a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f44005f = obj;
                    this.f44006g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f44004f = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.l5.c.a.C0071a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.l5$c$a$a r0 = (eu.bolt.verification.sdk.internal.l5.c.a.C0071a) r0
                    int r1 = r0.f44006g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f44006g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.l5$c$a$a r0 = new eu.bolt.verification.sdk.internal.l5$c$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f44005f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f44006g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f44004f
                    eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent r5 = (eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent) r5
                    boolean r5 = r5.e()
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
                    r0.f44006g = r3
                    java.lang.Object r5 = r6.b(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.l5.c.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public c(Flow flow) {
            this.f44003f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f44003f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements Flow<File> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f44008f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f44009f;

            @DebugMetadata(c = "eu.bolt.client.stories.screenshot.DetectScreenshotsInteractor$inForegroundScreenshotDetectedFlow$$inlined$filter$1$2", f = "DetectScreenshotsInteractor.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.l5$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0072a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f44010f;

                /* renamed from: g  reason: collision with root package name */
                int f44011g;

                public C0072a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f44010f = obj;
                    this.f44011g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f44009f = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof eu.bolt.verification.sdk.internal.l5.d.a.C0072a
                    if (r0 == 0) goto L13
                    r0 = r7
                    eu.bolt.verification.sdk.internal.l5$d$a$a r0 = (eu.bolt.verification.sdk.internal.l5.d.a.C0072a) r0
                    int r1 = r0.f44011g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f44011g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.l5$d$a$a r0 = new eu.bolt.verification.sdk.internal.l5$d$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.f44010f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f44011g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r7)
                    goto L53
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    kotlin.ResultKt.b(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r5.f44009f
                    r2 = r6
                    java.io.File r2 = (java.io.File) r2
                    java.lang.String r2 = r2.getName()
                    java.lang.String r4 = "file.name"
                    kotlin.jvm.internal.Intrinsics.e(r2, r4)
                    java.lang.String r4 = "screenshot"
                    boolean r2 = kotlin.text.StringsKt.O(r2, r4, r3)
                    if (r2 == 0) goto L53
                    r0.f44011g = r3
                    java.lang.Object r6 = r7.b(r6, r0)
                    if (r6 != r1) goto L53
                    return r1
                L53:
                    kotlin.Unit r6 = kotlin.Unit.f50853a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.l5.d.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public d(Flow flow) {
            this.f44008f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super File> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f44008f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    static {
        List<String> n8;
        int v7;
        int v8;
        n8 = CollectionsKt__CollectionsKt.n("Pictures", "DCIM");
        f43994d = n8;
        v7 = CollectionsKt__IterablesKt.v(n8, 10);
        ArrayList<File> arrayList = new ArrayList(v7);
        for (String str : n8) {
            arrayList.add(new File(str, "Screenshots"));
        }
        f43995e = arrayList;
        v8 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v8);
        for (File file : arrayList) {
            arrayList2.add(new File(Environment.getExternalStorageDirectory(), file.getPath()));
        }
        f43996f = arrayList2;
    }

    @Inject
    public l5(RxActivityEvents rxActivityEvents, g7 fileCreationEventsRepository) {
        Intrinsics.f(rxActivityEvents, "rxActivityEvents");
        Intrinsics.f(fileCreationEventsRepository, "fileCreationEventsRepository");
        this.f43997a = rxActivityEvents;
        this.f43998b = fileCreationEventsRepository;
    }

    private final Flow<Boolean> c() {
        return FlowKt.i(FlowKt.j(new c(RxConvertKt.b(this.f43997a.f()))), 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<File> d() {
        int v7;
        List<File> list = f43996f;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (File file : list) {
            arrayList.add(this.f43998b.a(file));
        }
        return new d(FlowKt.C(arrayList));
    }

    public Flow<File> a() {
        return FlowKt.I(c(), new b(null, this));
    }
}
