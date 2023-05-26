package ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer;

import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoAnswerInteractor.kt */
/* loaded from: classes3.dex */
public final class NoAnswerInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final VoipService f28056a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipRxLifecycleTransfromer f28057b;

    /* renamed from: c  reason: collision with root package name */
    private final VoipOrderInformationDelegate f28058c;

    @Inject
    public NoAnswerInteractor(VoipService voipService, VoipRxLifecycleTransfromer rxVoipLifecycleTransfromer, VoipOrderInformationDelegate voipOrderInformationDelegate) {
        Intrinsics.f(voipService, "voipService");
        Intrinsics.f(rxVoipLifecycleTransfromer, "rxVoipLifecycleTransfromer");
        Intrinsics.f(voipOrderInformationDelegate, "voipOrderInformationDelegate");
        this.f28056a = voipService;
        this.f28057b = rxVoipLifecycleTransfromer;
        this.f28058c = voipOrderInformationDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VoipOrderInformationDelegate.VoipCallAndOrderInfo d(VoipRxLifecycleTransfromer.CallWithStateAndEndReason callInfo, VoipOrderInformationDelegate.VoipOrderInfo orderInfo) {
        Intrinsics.f(callInfo, "callInfo");
        Intrinsics.f(orderInfo, "orderInfo");
        return new VoipOrderInformationDelegate.VoipCallAndOrderInfo(callInfo, orderInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NoAnswerCallDetails e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (NoAnswerCallDetails) tmp0.invoke(obj);
    }

    public Observable<NoAnswerCallDetails> c() {
        Observable combineLatest = Observable.combineLatest(this.f28057b.e(), this.f28058c.q(), new BiFunction() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.d
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                VoipOrderInformationDelegate.VoipCallAndOrderInfo d8;
                d8 = NoAnswerInteractor.d((VoipRxLifecycleTransfromer.CallWithStateAndEndReason) obj, (VoipOrderInformationDelegate.VoipOrderInfo) obj2);
                return d8;
            }
        });
        final NoAnswerInteractor$observeScreenData$2 noAnswerInteractor$observeScreenData$2 = new Function1<VoipOrderInformationDelegate.VoipCallAndOrderInfo, NoAnswerCallDetails>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerInteractor$observeScreenData$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final NoAnswerCallDetails invoke(VoipOrderInformationDelegate.VoipCallAndOrderInfo voipCallAndOrderInfo) {
                String str;
                Intrinsics.f(voipCallAndOrderInfo, "<name for destructuring parameter 0>");
                VoipRxLifecycleTransfromer.CallWithStateAndEndReason a8 = voipCallAndOrderInfo.a();
                VoipOrderInformationDelegate.VoipOrderInfo b8 = voipCallAndOrderInfo.b();
                String b9 = a8.a().e().b();
                Long l8 = null;
                if (b8 != null) {
                    str = b8.a();
                } else {
                    str = null;
                }
                if (b8 != null) {
                    l8 = b8.c();
                }
                return new NoAnswerCallDetails(b9, str, l8);
            }
        };
        Observable<NoAnswerCallDetails> map = combineLatest.map(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NoAnswerCallDetails e8;
                e8 = NoAnswerInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(map, "combineLatest(\n         …      )\n                }");
        return map;
    }

    public final void f() {
        this.f28056a.I();
    }
}
