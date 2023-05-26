package kotlinx.coroutines.flow;

import com.google.android.gms.common.api.Api;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: SharedFlow.kt */
/* loaded from: classes5.dex */
public final class SharedFlowKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f51638a = new Symbol("NO_VALUE");

    public static final <T> MutableSharedFlow<T> a(int i8, int i9, BufferOverflow bufferOverflow) {
        boolean z7;
        boolean z8;
        boolean z9 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i9 >= 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (i8 <= 0 && i9 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                    z9 = false;
                }
                if (z9) {
                    int i10 = i9 + i8;
                    if (i10 < 0) {
                        i10 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    }
                    return new SharedFlowImpl(i8, i10, bufferOverflow);
                }
                throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
            }
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i9).toString());
        }
        throw new IllegalArgumentException(("replay cannot be negative, but was " + i8).toString());
    }

    public static /* synthetic */ MutableSharedFlow b(int i8, int i9, BufferOverflow bufferOverflow, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        if ((i10 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return a(i8, i9, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object e(Object[] objArr, long j8) {
        return objArr[(objArr.length - 1) & ((int) j8)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Object[] objArr, long j8, Object obj) {
        objArr[(objArr.length - 1) & ((int) j8)] = obj;
    }
}
