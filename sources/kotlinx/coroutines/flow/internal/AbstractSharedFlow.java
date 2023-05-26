package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes5.dex */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {

    /* renamed from: f  reason: collision with root package name */
    private S[] f51662f;

    /* renamed from: g  reason: collision with root package name */
    private int f51663g;

    /* renamed from: h  reason: collision with root package name */
    private int f51664h;

    /* renamed from: i  reason: collision with root package name */
    private SubscriptionCountStateFlow f51665i;

    public static final /* synthetic */ int c(AbstractSharedFlow abstractSharedFlow) {
        return abstractSharedFlow.f51663g;
    }

    public static final /* synthetic */ AbstractSharedFlowSlot[] f(AbstractSharedFlow abstractSharedFlow) {
        return abstractSharedFlow.f51662f;
    }

    public final StateFlow<Integer> e() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this.f51665i;
            if (subscriptionCountStateFlow == null) {
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.f51663g);
                this.f51665i = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S h() {
        S s7;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            S[] sArr = this.f51662f;
            if (sArr == null) {
                sArr = j(2);
                this.f51662f = sArr;
            } else if (this.f51663g >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                Intrinsics.e(copyOf, "copyOf(this, newSize)");
                this.f51662f = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                sArr = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
            }
            int i8 = this.f51664h;
            do {
                s7 = sArr[i8];
                if (s7 == null) {
                    s7 = i();
                    sArr[i8] = s7;
                }
                i8++;
                if (i8 >= sArr.length) {
                    i8 = 0;
                }
            } while (!s7.a(this));
            this.f51664h = i8;
            this.f51663g++;
            subscriptionCountStateFlow = this.f51665i;
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.Z(1);
        }
        return s7;
    }

    protected abstract S i();

    protected abstract S[] j(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(S s7) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i8;
        Continuation<Unit>[] b8;
        synchronized (this) {
            int i9 = this.f51663g - 1;
            this.f51663g = i9;
            subscriptionCountStateFlow = this.f51665i;
            if (i9 == 0) {
                this.f51664h = 0;
            }
            b8 = s7.b(this);
        }
        for (Continuation<Unit> continuation : b8) {
            if (continuation != null) {
                Result.Companion companion = Result.f50818g;
                continuation.resumeWith(Result.b(Unit.f50853a));
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.Z(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int l() {
        return this.f51663g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S[] m() {
        return this.f51662f;
    }
}
