package io.netty.util.internal;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class UnpaddedInternalThreadLocalMap {
    Map<Charset, CharsetEncoder> charsetEncoderCache;
    int futureListenerStackDepth;
    Map<Class<?>, Boolean> handlerSharableCache;
    Object[] indexedVariables;
    ThreadLocalRandom random;
    StringBuilder stringBuilder;
    Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache;
    Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache;
    static final ThreadLocal<InternalThreadLocalMap> slowThreadLocalMap = new ThreadLocal<>();
    static final AtomicInteger nextIndex = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpaddedInternalThreadLocalMap(Object[] objArr) {
        this.indexedVariables = objArr;
    }
}
