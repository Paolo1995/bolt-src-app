package ee.mtakso.driver.service.voip.lifecycle.observers;

import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver;
import ee.mtakso.voip_client.VoipCall;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipRxLifecycleTransfromer.kt */
@Singleton
/* loaded from: classes3.dex */
public final class VoipRxLifecycleTransfromer implements VoipLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<CallWithStateAndEndReason> f26168a;

    @Inject
    public VoipRxLifecycleTransfromer() {
        BehaviorSubject<CallWithStateAndEndReason> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<CallWithStateAndEndReason>()");
        this.f26168a = e8;
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void a(VoipCall call) {
        Intrinsics.f(call, "call");
        this.f26168a.onNext(new CallWithStateAndEndReason(call, VoipCall.State.ESTABLISHING, null, 4, null));
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void b(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
        this.f26168a.onNext(new CallWithStateAndEndReason(call, VoipCall.State.ENDED, endReason));
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void c(VoipCall call) {
        Intrinsics.f(call, "call");
        this.f26168a.onNext(new CallWithStateAndEndReason(call, VoipCall.State.ESTABLISHED, null, 4, null));
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void d(VoipCall call) {
        Intrinsics.f(call, "call");
        this.f26168a.onNext(new CallWithStateAndEndReason(call, VoipCall.State.CREATED, null, 4, null));
    }

    public final BehaviorSubject<CallWithStateAndEndReason> e() {
        return this.f26168a;
    }

    /* compiled from: VoipRxLifecycleTransfromer.kt */
    /* loaded from: classes3.dex */
    public static final class CallWithStateAndEndReason {

        /* renamed from: a  reason: collision with root package name */
        private final VoipCall f26169a;

        /* renamed from: b  reason: collision with root package name */
        private final VoipCall.State f26170b;

        /* renamed from: c  reason: collision with root package name */
        private final VoipCall.EndReason f26171c;

        public CallWithStateAndEndReason(VoipCall call, VoipCall.State state, VoipCall.EndReason endReason) {
            Intrinsics.f(call, "call");
            Intrinsics.f(state, "state");
            this.f26169a = call;
            this.f26170b = state;
            this.f26171c = endReason;
        }

        public final VoipCall a() {
            return this.f26169a;
        }

        public final VoipCall.State b() {
            return this.f26170b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CallWithStateAndEndReason) {
                CallWithStateAndEndReason callWithStateAndEndReason = (CallWithStateAndEndReason) obj;
                return Intrinsics.a(this.f26169a, callWithStateAndEndReason.f26169a) && this.f26170b == callWithStateAndEndReason.f26170b && this.f26171c == callWithStateAndEndReason.f26171c;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f26169a.hashCode() * 31) + this.f26170b.hashCode()) * 31;
            VoipCall.EndReason endReason = this.f26171c;
            return hashCode + (endReason == null ? 0 : endReason.hashCode());
        }

        public String toString() {
            VoipCall voipCall = this.f26169a;
            VoipCall.State state = this.f26170b;
            VoipCall.EndReason endReason = this.f26171c;
            return "CallWithStateAndEndReason(call=" + voipCall + ", state=" + state + ", endReason=" + endReason + ")";
        }

        public /* synthetic */ CallWithStateAndEndReason(VoipCall voipCall, VoipCall.State state, VoipCall.EndReason endReason, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(voipCall, state, (i8 & 4) != 0 ? null : endReason);
        }
    }
}
