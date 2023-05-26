package eu.bolt.driver.voip.service.call.tone;

import ee.mtakso.voip_client.VoipCall;
import eu.bolt.driver.core.service.BaseServiceImpl;
import eu.bolt.driver.voip.CallData;
import eu.bolt.driver.voip.VoipSession;
import eu.bolt.driver.voip.service.call.tone.ToneService;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToneService.kt */
/* loaded from: classes5.dex */
public final class ToneService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final VoipSession f41648b;

    /* renamed from: c  reason: collision with root package name */
    private final ToneManager f41649c;

    /* compiled from: ToneService.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41650a;

        static {
            int[] iArr = new int[VoipCall.State.values().length];
            try {
                iArr[VoipCall.State.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoipCall.State.ESTABLISHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VoipCall.State.ESTABLISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VoipCall.State.ENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f41650a = iArr;
        }
    }

    public ToneService(VoipSession voipSession, ToneManager toneManager) {
        Intrinsics.f(voipSession, "voipSession");
        Intrinsics.f(toneManager, "toneManager");
        this.f41648b = voipSession;
        this.f41649c = toneManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(CallData callData) {
        int i8 = WhenMappings.f41650a[callData.a().getState().ordinal()];
        if (i8 != 2) {
            if (i8 != 3) {
                if (i8 == 4) {
                    this.f41649c.d();
                    return;
                }
                return;
            }
            this.f41649c.d();
        } else if (callData.a().getType() == VoipCall.Type.OUTGOING) {
            this.f41649c.b();
        }
    }

    @Override // eu.bolt.driver.core.service.BaseServiceImpl
    public Disposable a() {
        Observable<CallData> N = this.f41648b.N();
        final ToneService$doStart$1 toneService$doStart$1 = new ToneService$doStart$1(this);
        Disposable subscribe = N.subscribe(new Consumer() { // from class: l7.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ToneService.d(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "voipSession.observeActiv…be(::onActiveCallUpdated)");
        return subscribe;
    }
}
