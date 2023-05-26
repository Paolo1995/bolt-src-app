package ee.mtakso.voip_client.sinch;

import com.sinch.android.rtc.calling.Call;
import com.sinch.android.rtc.calling.CallDetails;
import com.sinch.android.rtc.calling.CallDirection;
import com.sinch.android.rtc.calling.CallEndCause;
import com.sinch.android.rtc.calling.CallListener;
import com.sinch.android.rtc.calling.CallState;
import ee.mtakso.voip_client.VoipCall;
import ee.mtakso.voip_client.VoipConnection;
import ee.mtakso.voip_client.VoipPeer;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Date;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SinchCall.kt */
/* loaded from: classes5.dex */
public final class SinchCall implements VoipCall {

    /* renamed from: l  reason: collision with root package name */
    public static final Companion f36545l = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final Call f36546b;

    /* renamed from: c  reason: collision with root package name */
    private final VoipConnection f36547c;

    /* renamed from: d  reason: collision with root package name */
    private final VoipPeer f36548d;

    /* renamed from: e  reason: collision with root package name */
    private final SinchCallDelegate f36549e;

    /* renamed from: f  reason: collision with root package name */
    private final BehaviorSubject<VoipCall.State> f36550f;

    /* renamed from: g  reason: collision with root package name */
    private final BehaviorSubject<VoipCall.EndReason> f36551g;

    /* renamed from: h  reason: collision with root package name */
    private final InternalCallListener f36552h;

    /* renamed from: i  reason: collision with root package name */
    private VoipCall.State f36553i;

    /* renamed from: j  reason: collision with root package name */
    private final VoipConnection f36554j;

    /* renamed from: k  reason: collision with root package name */
    private final VoipPeer f36555k;

    /* compiled from: SinchCall.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* compiled from: SinchCall.kt */
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f36556a;

            static {
                int[] iArr = new int[CallDirection.values().length];
                try {
                    iArr[CallDirection.INCOMING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallDirection.OUTGOING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f36556a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final VoipCall.Type c(CallDirection callDirection) {
            int i8 = WhenMappings.f36556a[callDirection.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    return VoipCall.Type.OUTGOING;
                }
                throw new NoWhenBranchMatchedException();
            }
            return VoipCall.Type.INCOMING;
        }

        public final VoipCall b(Call sinchCall, VoipConnection connection, VoipPeer peer, SinchCallDelegate sinchCallDelegate) {
            Intrinsics.f(sinchCall, "sinchCall");
            Intrinsics.f(connection, "connection");
            Intrinsics.f(peer, "peer");
            Intrinsics.f(sinchCallDelegate, "sinchCallDelegate");
            return new SinchCall(sinchCall, connection, peer, sinchCallDelegate, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SinchCall.kt */
    /* loaded from: classes5.dex */
    public final class InternalCallListener implements CallListener {
        public InternalCallListener() {
        }

        @Override // com.sinch.android.rtc.calling.CallListener
        public void onCallEnded(Call call) {
            boolean z7;
            CallEndCause callEndCause;
            if (Intrinsics.a(SinchCall.this.f36546b, call)) {
                VoipCall.State state = SinchCall.this.f36553i;
                VoipCall.State state2 = VoipCall.State.ENDED;
                if (state == state2) {
                    return;
                }
                if (SinchCall.this.getType() == VoipCall.Type.INCOMING) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                CallDetails details = SinchCall.this.f36546b.getDetails();
                if (details != null) {
                    callEndCause = details.getEndCause();
                } else {
                    callEndCause = null;
                }
                if (callEndCause == null) {
                    return;
                }
                SinchCall.this.f36549e.onCallEnded(call);
                SinchCall.this.n(state2);
                VoipCall.EndReason c8 = SinchEndedReasonExtsKt.c(callEndCause, z7);
                SinchCall.this.f36549e.g().c("On call ended: %s", c8);
                SinchCall.this.f36551g.onNext(c8);
            }
        }

        @Override // com.sinch.android.rtc.calling.CallListener
        public void onCallEstablished(Call call) {
            if (!Intrinsics.a(SinchCall.this.f36546b, call)) {
                return;
            }
            SinchCall.this.f36549e.onCallEstablished(call);
            SinchCall.this.n(VoipCall.State.ESTABLISHED);
            SinchCall.this.f36549e.g().c("Call established %s", call);
        }

        @Override // com.sinch.android.rtc.calling.CallListener
        public void onCallProgressing(Call call) {
            SinchCall.this.f36549e.g().c("Call progressing: %s", call);
            VoipCall.State state = SinchCall.this.f36553i;
            VoipCall.State state2 = VoipCall.State.ESTABLISHING;
            if (state != state2) {
                SinchCall.this.f36549e.onCallProgressing(call);
                SinchCall.this.n(state2);
            }
        }
    }

    private SinchCall(Call call, VoipConnection voipConnection, VoipPeer voipPeer, SinchCallDelegate sinchCallDelegate) {
        this.f36546b = call;
        this.f36547c = voipConnection;
        this.f36548d = voipPeer;
        this.f36549e = sinchCallDelegate;
        BehaviorSubject<VoipCall.State> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<VoipCall.State>()");
        this.f36550f = e8;
        BehaviorSubject<VoipCall.EndReason> e9 = BehaviorSubject.e();
        Intrinsics.e(e9, "create<VoipCall.EndReason>()");
        this.f36551g = e9;
        InternalCallListener internalCallListener = new InternalCallListener();
        this.f36552h = internalCallListener;
        this.f36553i = VoipCall.State.CREATED;
        call.addCallListener(internalCallListener);
        this.f36554j = voipConnection;
        this.f36555k = voipPeer;
    }

    public /* synthetic */ SinchCall(Call call, VoipConnection voipConnection, VoipPeer voipPeer, SinchCallDelegate sinchCallDelegate, DefaultConstructorMarker defaultConstructorMarker) {
        this(call, voipConnection, voipPeer, sinchCallDelegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(VoipCall.State state) {
        this.f36553i = state;
        this.f36550f.onNext(state);
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public VoipCall c() {
        if (this.f36546b.getState() != CallState.ENDED) {
            return this;
        }
        o();
        return f36545l.b(this.f36549e.f(this.f36546b, this.f36547c.a()), this.f36547c, this.f36548d, this.f36549e);
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public void d() {
        VoipCall.State state = this.f36553i;
        VoipCall.State state2 = VoipCall.State.ENDED;
        if (state == state2) {
            return;
        }
        this.f36546b.hangup();
        this.f36549e.onCallEnded(this.f36546b);
        n(state2);
        this.f36551g.onNext(VoipCall.EndReason.HANG_UP);
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public VoipPeer e() {
        return this.f36555k;
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public void f() {
        if (this.f36546b.getState() != CallState.INITIATING) {
            return;
        }
        n(VoipCall.State.ESTABLISHING);
        this.f36546b.answer();
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public VoipConnection g() {
        return this.f36554j;
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public String getId() {
        String callId = this.f36546b.getCallId();
        Intrinsics.e(callId, "sinchCall.callId");
        return callId;
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public VoipCall.State getState() {
        return this.f36553i;
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public VoipCall.Type getType() {
        Companion companion = f36545l;
        CallDirection direction = this.f36546b.getDirection();
        Intrinsics.e(direction, "sinchCall.direction");
        return companion.c(direction);
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public Observable<VoipCall.State> h() {
        Observable<VoipCall.State> startWith = this.f36550f.startWith((BehaviorSubject<VoipCall.State>) this.f36553i);
        Intrinsics.e(startWith, "callStatusSubject.startWith(internalState)");
        return startWith;
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public Observable<VoipCall.EndReason> i() {
        return this.f36551g;
    }

    @Override // ee.mtakso.voip_client.VoipCall
    public long j() {
        Date date;
        CallDetails details = this.f36546b.getDetails();
        if (details != null) {
            date = details.getEstablishedTime();
        } else {
            date = null;
        }
        if (date == null) {
            return 0L;
        }
        return (System.currentTimeMillis() - date.getTime()) / 1000;
    }

    public void o() {
        if (this.f36553i != VoipCall.State.ENDED) {
            d();
        }
        this.f36546b.removeCallListener(this.f36552h);
    }
}
