package eu.bolt.verification.sdk.internal;

import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.verification.sdk.internal.g8;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.rx2.RxConvertKt;

/* loaded from: classes5.dex */
public final class n8 implements g8 {

    /* renamed from: a  reason: collision with root package name */
    private final m8 f44304a;

    /* loaded from: classes5.dex */
    public static final class a implements Flow<g8.b.a> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f44305f;

        /* renamed from: eu.bolt.verification.sdk.internal.n8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0076a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f44306f;

            @DebugMetadata(c = "eu.bolt.client.ribsshared.error.fullscreen.FullscreenErrorPresenterImpl$observeUiEventsFlow$$inlined$map$1$2", f = "FullscreenErrorPresenterImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.n8$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0077a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f44307f;

                /* renamed from: g  reason: collision with root package name */
                int f44308g;

                public C0077a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f44307f = obj;
                    this.f44308g |= Integer.MIN_VALUE;
                    return C0076a.this.b(null, this);
                }
            }

            public C0076a(FlowCollector flowCollector) {
                this.f44306f = flowCollector;
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
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.n8.a.C0076a.C0077a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.n8$a$a$a r0 = (eu.bolt.verification.sdk.internal.n8.a.C0076a.C0077a) r0
                    int r1 = r0.f44308g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f44308g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.n8$a$a$a r0 = new eu.bolt.verification.sdk.internal.n8$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f44307f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f44308g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f44306f
                    kotlin.Unit r5 = (kotlin.Unit) r5
                    eu.bolt.verification.sdk.internal.g8$b$a r5 = eu.bolt.verification.sdk.internal.g8.b.a.f43131a
                    r0.f44308g = r3
                    java.lang.Object r5 = r6.b(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.n8.a.C0076a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public a(Flow flow) {
            this.f44305f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super g8.b.a> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f44305f.a(new C0076a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    @Inject
    public n8(m8 view) {
        Intrinsics.f(view, "view");
        this.f44304a = view;
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Observable<g8.b> h() {
        return g8.a.a(this);
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Flow<g8.b> p() {
        return new a(RxConvertKt.b(this.f44304a.getBinding().f43567b.a0()));
    }

    @Override // eu.bolt.verification.sdk.internal.g8
    public void u(DesignToolbarView.c cVar) {
        Unit unit;
        if (cVar != null) {
            this.f44304a.getBinding().f43567b.setHomeButtonIcon(cVar);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            DesignToolbarView designToolbarView = this.f44304a.getBinding().f43567b;
            Intrinsics.e(designToolbarView, "view.binding.fullScreenErrorToolbar");
            designToolbarView.setVisibility(8);
        }
    }
}
