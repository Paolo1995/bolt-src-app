package eu.bolt.coroutines.base;

import eu.bolt.coroutines.CoroutinesConfig;
import eu.bolt.logger.Logger;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes5.dex */
public final class DefaultCoroutineExceptionHandlerKt$DefaultCoroutineExceptionHandler$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Logger f40343g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ String f40344h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultCoroutineExceptionHandlerKt$DefaultCoroutineExceptionHandler$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, Logger logger, String str) {
        super(key);
        this.f40343g = logger;
        this.f40344h = str;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void k0(CoroutineContext coroutineContext, Throwable th) {
        if (th instanceof CancellationException) {
            Logger logger = this.f40343g;
            String str = this.f40344h;
            String message = th.getMessage();
            logger.b(str + " CoroutineScope cancelled. Cause = " + message);
        } else if (!CoroutinesConfig.f40333a.a()) {
            Logger logger2 = this.f40343g;
            String str2 = this.f40344h;
            logger2.a(th, str2 + " CoroutineScope handle error");
        } else {
            throw th;
        }
    }
}
