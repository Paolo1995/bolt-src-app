package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CompletionHandler.kt */
/* loaded from: classes5.dex */
public abstract class CancelHandlerBase implements Function1<Throwable, Unit> {
    public abstract void b(Throwable th);
}
