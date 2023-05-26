package ee.mtakso.voip_client;

import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipCall.kt */
/* loaded from: classes5.dex */
public interface VoipCall {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f36509a = Companion.f36510a;

    /* compiled from: VoipCall.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f36510a = new Companion();

        private Companion() {
        }

        public final boolean a(State state, State state2) {
            Intrinsics.f(state, "<this>");
            Intrinsics.f(state2, "state");
            if (state.c() > state2.c()) {
                return true;
            }
            return false;
        }

        public final boolean b(State state, State state2) {
            Intrinsics.f(state, "<this>");
            Intrinsics.f(state2, "state");
            if (state.c() < state2.c()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: VoipCall.kt */
    /* loaded from: classes5.dex */
    public enum EndReason {
        HANG_UP,
        NO_ANSWER_FROM_INCOMING_CONNECTION,
        NO_ANSWER_FROM_OUTGOING_CONNECTION,
        DECLINED_FROM_OUTGOING_CONNECTION,
        OTHER_DEVICE_ANSWERED,
        ERROR
    }

    /* compiled from: VoipCall.kt */
    /* loaded from: classes5.dex */
    public enum State {
        CREATED(0),
        ESTABLISHING(1),
        ESTABLISHED(2),
        ENDED(3);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f36523f;

        State(int i8) {
            this.f36523f = i8;
        }

        public final int c() {
            return this.f36523f;
        }
    }

    /* compiled from: VoipCall.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        INCOMING,
        OUTGOING
    }

    VoipCall c();

    void d();

    VoipPeer e();

    void f();

    VoipConnection g();

    String getId();

    State getState();

    Type getType();

    Observable<State> h();

    Observable<EndReason> i();

    long j();
}
