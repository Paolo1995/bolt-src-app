package ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress;

import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallDetails;
import ee.mtakso.driver.utils.TimeUtils;
import ee.mtakso.voip_client.VoipCall;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InprogressCallInteractor.kt */
/* loaded from: classes3.dex */
public final class InprogressCallInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final VoipService f28023a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipRxLifecycleTransfromer f28024b;

    /* renamed from: c  reason: collision with root package name */
    private final VoipOrderInformationDelegate f28025c;

    /* renamed from: d  reason: collision with root package name */
    private final PublishSubject<Unit> f28026d;

    /* compiled from: InprogressCallInteractor.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28027a;

        static {
            int[] iArr = new int[VoipCall.Type.values().length];
            try {
                iArr[VoipCall.Type.INCOMING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoipCall.Type.OUTGOING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28027a = iArr;
        }
    }

    @Inject
    public InprogressCallInteractor(VoipService voipService, VoipRxLifecycleTransfromer rxVoipRxLifecycleTransfromer, VoipOrderInformationDelegate voipOrderInformationDelegate) {
        Intrinsics.f(voipService, "voipService");
        Intrinsics.f(rxVoipRxLifecycleTransfromer, "rxVoipRxLifecycleTransfromer");
        Intrinsics.f(voipOrderInformationDelegate, "voipOrderInformationDelegate");
        this.f28023a = voipService;
        this.f28024b = rxVoipRxLifecycleTransfromer;
        this.f28025c = voipOrderInformationDelegate;
        PublishSubject<Unit> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f28026d = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(VoipCall voipCall) {
        Long l8;
        TimeUtils timeUtils = TimeUtils.f36328a;
        if (voipCall != null) {
            l8 = Long.valueOf(voipCall.j());
        } else {
            l8 = null;
        }
        return timeUtils.b(l8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VoipOrderInformationDelegate.VoipCallAndOrderInfo j(VoipRxLifecycleTransfromer.CallWithStateAndEndReason callInfo, VoipOrderInformationDelegate.VoipOrderInfo orderInfo, Unit unit, Long l8) {
        Intrinsics.f(callInfo, "callInfo");
        Intrinsics.f(orderInfo, "orderInfo");
        Intrinsics.f(unit, "<anonymous parameter 2>");
        Intrinsics.f(l8, "<anonymous parameter 3>");
        return new VoipOrderInformationDelegate.VoipCallAndOrderInfo(callInfo, orderInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InprogressCallDetails k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (InprogressCallDetails) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InprogressCallDetails.ConnectionState n(VoipCall.State state) {
        if (VoipCall.f36509a.a(state, VoipCall.State.ESTABLISHING)) {
            return InprogressCallDetails.ConnectionState.ESTABLISHED;
        }
        return InprogressCallDetails.ConnectionState.ESTABLISHING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InprogressCallDetails.ConnectionType o(VoipCall.Type type) {
        int i8 = WhenMappings.f28027a[type.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return InprogressCallDetails.ConnectionType.OUTGOING;
            }
            throw new NoWhenBranchMatchedException();
        }
        return InprogressCallDetails.ConnectionType.INCOMING;
    }

    public final void h() {
        this.f28023a.w();
    }

    public Observable<InprogressCallDetails> i() {
        Observable combineLatest = Observable.combineLatest(this.f28024b.e(), this.f28025c.q(), this.f28026d.startWith((PublishSubject<Unit>) Unit.f50853a), Observable.interval(1L, TimeUnit.SECONDS), new Function4() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.g
            @Override // io.reactivex.functions.Function4
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4) {
                VoipOrderInformationDelegate.VoipCallAndOrderInfo j8;
                j8 = InprogressCallInteractor.j((VoipRxLifecycleTransfromer.CallWithStateAndEndReason) obj, (VoipOrderInformationDelegate.VoipOrderInfo) obj2, (Unit) obj3, (Long) obj4);
                return j8;
            }
        });
        final Function1<VoipOrderInformationDelegate.VoipCallAndOrderInfo, InprogressCallDetails> function1 = new Function1<VoipOrderInformationDelegate.VoipCallAndOrderInfo, InprogressCallDetails>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallInteractor$observeScreenData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final InprogressCallDetails invoke(VoipOrderInformationDelegate.VoipCallAndOrderInfo voipCallAndOrderInfo) {
                String str;
                Long l8;
                String g8;
                InprogressCallDetails.ConnectionState n8;
                InprogressCallDetails.ConnectionType o8;
                VoipService voipService;
                VoipService voipService2;
                Intrinsics.f(voipCallAndOrderInfo, "<name for destructuring parameter 0>");
                VoipRxLifecycleTransfromer.CallWithStateAndEndReason a8 = voipCallAndOrderInfo.a();
                VoipOrderInformationDelegate.VoipOrderInfo b8 = voipCallAndOrderInfo.b();
                VoipCall a9 = a8.a();
                String b9 = a9.e().b();
                if (b8 != null) {
                    str = b8.a();
                } else {
                    str = null;
                }
                if (b8 != null) {
                    l8 = b8.c();
                } else {
                    l8 = null;
                }
                g8 = InprogressCallInteractor.this.g(a9);
                VoipCall.State b10 = a8.b();
                n8 = InprogressCallInteractor.this.n(a8.b());
                o8 = InprogressCallInteractor.this.o(a9.getType());
                voipService = InprogressCallInteractor.this.f28023a;
                boolean C = voipService.C();
                voipService2 = InprogressCallInteractor.this.f28023a;
                return new InprogressCallDetails(b9, str, l8, g8, b10, n8, o8, C, voipService2.D());
            }
        };
        Observable<InprogressCallDetails> map = combineLatest.map(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                InprogressCallDetails k8;
                k8 = InprogressCallInteractor.k(Function1.this, obj);
                return k8;
            }
        });
        Intrinsics.e(map, "override fun observeScre…)\n                }\n    }");
        return map;
    }

    public final void l() {
        this.f28023a.J();
        this.f28026d.onNext(Unit.f50853a);
    }

    public final void m() {
        this.f28023a.K();
        this.f28026d.onNext(Unit.f50853a);
    }
}
