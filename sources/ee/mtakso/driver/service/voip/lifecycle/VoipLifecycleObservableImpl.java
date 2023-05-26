package ee.mtakso.driver.service.voip.lifecycle;

import ee.mtakso.voip_client.VoipCall;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipLifecycleObservableImpl.kt */
@Singleton
/* loaded from: classes3.dex */
public final class VoipLifecycleObservableImpl {

    /* renamed from: a  reason: collision with root package name */
    private final Set<VoipLifecycleObserver> f26146a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<VoipLifecycleObserver> f26147b;

    /* compiled from: VoipLifecycleObservableImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26148a;

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
            f26148a = iArr;
        }
    }

    @Inject
    public VoipLifecycleObservableImpl(Set<VoipLifecycleObserver> rawIncomingCallObservers, Set<VoipLifecycleObserver> rawOutgoingCallObservers) {
        Set<VoipLifecycleObserver> K0;
        Set<VoipLifecycleObserver> K02;
        Intrinsics.f(rawIncomingCallObservers, "rawIncomingCallObservers");
        Intrinsics.f(rawOutgoingCallObservers, "rawOutgoingCallObservers");
        K0 = CollectionsKt___CollectionsKt.K0(rawIncomingCallObservers);
        this.f26146a = K0;
        K02 = CollectionsKt___CollectionsKt.K0(rawOutgoingCallObservers);
        this.f26147b = K02;
    }

    public final void a(VoipCall.Type type, Function1<? super VoipLifecycleObserver, Unit> predicate) {
        Set<VoipLifecycleObserver> set;
        Intrinsics.f(type, "type");
        Intrinsics.f(predicate, "predicate");
        synchronized (this) {
            int i8 = WhenMappings.f26148a[type.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    set = this.f26147b;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                set = this.f26146a;
            }
            for (VoipLifecycleObserver voipLifecycleObserver : set) {
                predicate.invoke(voipLifecycleObserver);
            }
            Unit unit = Unit.f50853a;
        }
    }
}
