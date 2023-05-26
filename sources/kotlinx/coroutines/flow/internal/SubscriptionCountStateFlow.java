package kotlinx.coroutines.flow.internal;

import com.google.android.gms.common.api.Api;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes5.dex */
public final class SubscriptionCountStateFlow extends SharedFlowImpl<Integer> implements StateFlow<Integer> {
    public SubscriptionCountStateFlow(int i8) {
        super(1, Api.BaseClientBuilder.API_PRIORITY_OTHER, BufferOverflow.DROP_OLDEST);
        d(Integer.valueOf(i8));
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    /* renamed from: Y */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(L().intValue());
        }
        return valueOf;
    }

    public final boolean Z(int i8) {
        boolean d8;
        synchronized (this) {
            d8 = d(Integer.valueOf(L().intValue() + i8));
        }
        return d8;
    }
}
