package eu.bolt.driver.voip;

import ee.mtakso.voip_client.VoipCall;
import ee.mtakso.voip_client.VoipClient;
import ee.mtakso.voip_client.VoipConnection;
import ee.mtakso.voip_client.VoipLogger;
import ee.mtakso.voip_client.VoipPeer;
import eu.bolt.driver.core.permission.PermissionManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.io.Closeable;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipSession.kt */
/* loaded from: classes5.dex */
public final class VoipSession implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    private final VoipClient f41615f;

    /* renamed from: g  reason: collision with root package name */
    private final PermissionManager f41616g;

    /* renamed from: h  reason: collision with root package name */
    private final VoipLogger f41617h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f41618i;

    /* renamed from: j  reason: collision with root package name */
    private final PublishSubject<VoipCall> f41619j;

    public VoipSession(VoipClient client, PermissionManager permissionManager, VoipLogger logger) {
        Intrinsics.f(client, "client");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(logger, "logger");
        this.f41615f = client;
        this.f41616g = permissionManager;
        this.f41617h = logger;
        PublishSubject<VoipCall> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<VoipCall>()");
        this.f41619j = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<CallData> Y(final VoipCall voipCall) {
        Observable<VoipCall.State> h8 = voipCall.h();
        final VoipSession$observeCallUpdates$callState$1 voipSession$observeCallUpdates$callState$1 = new Function1<VoipCall.State, Boolean>() { // from class: eu.bolt.driver.voip.VoipSession$observeCallUpdates$callState$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(VoipCall.State it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it != VoipCall.State.ENDED) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<VoipCall.State> filter = h8.filter(new Predicate() { // from class: eu.bolt.driver.voip.b
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean Z;
                Z = VoipSession.Z(Function1.this, obj);
                return Z;
            }
        });
        final Function1<VoipCall.State, CallData> function1 = new Function1<VoipCall.State, CallData>() { // from class: eu.bolt.driver.voip.VoipSession$observeCallUpdates$callState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CallData invoke(VoipCall.State it) {
                Intrinsics.f(it, "it");
                return new CallData(VoipCall.this, null);
            }
        };
        Observable<R> map = filter.map(new Function() { // from class: eu.bolt.driver.voip.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CallData c02;
                c02 = VoipSession.c0(Function1.this, obj);
                return c02;
            }
        });
        Observable<VoipCall.EndReason> i8 = voipCall.i();
        final Function1<VoipCall.EndReason, CallData> function12 = new Function1<VoipCall.EndReason, CallData>() { // from class: eu.bolt.driver.voip.VoipSession$observeCallUpdates$endReason$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CallData invoke(VoipCall.EndReason it) {
                Intrinsics.f(it, "it");
                return new CallData(VoipCall.this, it);
            }
        };
        Observable<CallData> mergeWith = map.mergeWith(i8.map(new Function() { // from class: eu.bolt.driver.voip.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CallData d02;
                d02 = VoipSession.d0(Function1.this, obj);
                return d02;
            }
        }));
        Intrinsics.e(mergeWith, "callState.mergeWith(endReason)");
        return mergeWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallData c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CallData) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallData d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CallData) tmp0.invoke(obj);
    }

    private final boolean l(String str) {
        if (this.f41618i) {
            String format = String.format(str, Arrays.copyOf(new Object[]{"session is closed"}, 1));
            Intrinsics.e(format, "format(this, *args)");
            this.f41617h.a(new IllegalStateException(format), format, new Object[0]);
            return false;
        } else if (w()) {
            return true;
        } else {
            String format2 = String.format(str, Arrays.copyOf(new Object[]{"insufficient permission"}, 1));
            Intrinsics.e(format2, "format(this, *args)");
            this.f41617h.a(new IllegalStateException(format2), format2, new Object[0]);
            return false;
        }
    }

    private final boolean w() {
        if (this.f41616g.o("android.permission.RECORD_AUDIO").d() != PermissionManager.PermissionStatus.GRANTED) {
            return false;
        }
        return true;
    }

    public final void C0() {
        VoipClient voipClient = this.f41615f;
        voipClient.a(!voipClient.d());
    }

    public final void D0() {
        VoipClient voipClient = this.f41615f;
        voipClient.b(!voipClient.e());
    }

    public final boolean F() {
        return this.f41615f.isRunning();
    }

    public final boolean I() {
        return this.f41615f.e();
    }

    public final Observable<CallData> N() {
        Observable<VoipCall> X = X();
        final Function1<VoipCall, ObservableSource<? extends CallData>> function1 = new Function1<VoipCall, ObservableSource<? extends CallData>>() { // from class: eu.bolt.driver.voip.VoipSession$observeActiveCallUpdates$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends CallData> invoke(VoipCall it) {
                Observable Y;
                Intrinsics.f(it, "it");
                Y = VoipSession.this.Y(it);
                return Y;
            }
        };
        Observable switchMap = X.switchMap(new Function() { // from class: eu.bolt.driver.voip.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource O;
                O = VoipSession.O(Function1.this, obj);
                return O;
            }
        });
        Intrinsics.e(switchMap, "fun observeActiveCallUpd…veCallUpdates(it) }\n    }");
        return switchMap;
    }

    public final Observable<VoipCall> X() {
        Observable<VoipCall> mergeWith = f0().mergeWith(k0());
        Intrinsics.e(mergeWith, "observeIncomingCalls().m…h(observeOutgoingCalls())");
        return mergeWith;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f41618i = true;
        this.f41615f.destroy();
        this.f41619j.onComplete();
    }

    public final Observable<VoipCall> f0() {
        return this.f41615f.i();
    }

    public final void h() {
        l("Failed to accept incoming call. Reason: %s");
        VoipCall q8 = q();
        if (q8 != null) {
            q8.f();
        } else {
            this.f41617h.a(new NullPointerException("Failed to accept incoming call. Reason: call is null"), "Failed to accept incoming call. Reason: call is null", new Object[0]);
        }
    }

    public final void k(VoipPeer peer, VoipConnection connection) {
        Intrinsics.f(peer, "peer");
        Intrinsics.f(connection, "connection");
        l("Failed to start new call. Reason: %s");
        this.f41619j.onNext(this.f41615f.l(peer, connection));
    }

    public final Observable<VoipCall> k0() {
        return this.f41619j;
    }

    public final boolean m(Map<String, String> data) {
        Intrinsics.f(data, "data");
        return this.f41615f.h(data);
    }

    public final VoipCall q() {
        return this.f41615f.j();
    }

    public final Observable<VoipClient.StartStatus> s0() {
        return this.f41615f.k();
    }

    public final void t() {
        VoipCall q8 = q();
        if (q8 != null) {
            q8.d();
        } else {
            this.f41617h.a(new NullPointerException("Failed to finish active call. Reason: call is null"), "Failed to finish active call. Reason: call is null", new Object[0]);
        }
    }

    public final void v0() {
        l("Failed to restart last call. Reason: %s");
        VoipCall c8 = this.f41615f.c();
        if (c8 != null) {
            this.f41619j.onNext(c8);
        } else {
            this.f41617h.a(new IllegalStateException("Redial failed. New call is null"), "Redial failed. New call is null", new Object[0]);
        }
    }

    public final boolean y() {
        return this.f41615f.d();
    }
}
