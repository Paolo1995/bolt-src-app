package kotlinx.coroutines;

import java.lang.Throwable;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: Debug.common.kt */
/* loaded from: classes5.dex */
public interface CopyableThrowable<T extends Throwable & CopyableThrowable<T>> {
    T a();
}
