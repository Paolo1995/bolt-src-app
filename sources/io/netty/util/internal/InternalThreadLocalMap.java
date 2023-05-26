package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.Spliterator;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
    private static final int STRING_BUILDER_INITIAL_SIZE;
    private static final int STRING_BUILDER_MAX_SIZE;
    public static final Object UNSET;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(InternalThreadLocalMap.class);
        logger = internalLoggerFactory;
        UNSET = new Object();
        int i8 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.initialSize", Spliterator.IMMUTABLE);
        STRING_BUILDER_INITIAL_SIZE = i8;
        internalLoggerFactory.debug("-Dio.netty.threadLocalMap.stringBuilder.initialSize: {}", Integer.valueOf(i8));
        int i9 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.maxSize", 4096);
        STRING_BUILDER_MAX_SIZE = i9;
        internalLoggerFactory.debug("-Dio.netty.threadLocalMap.stringBuilder.maxSize: {}", Integer.valueOf(i9));
    }

    private InternalThreadLocalMap() {
        super(newIndexedVariableTable());
    }

    private void expandIndexedVariableTableAndSet(int i8, Object obj) {
        Object[] objArr = this.indexedVariables;
        int length = objArr.length;
        int i9 = (i8 >>> 1) | i8;
        int i10 = i9 | (i9 >>> 2);
        int i11 = i10 | (i10 >>> 4);
        int i12 = i11 | (i11 >>> 8);
        Object[] copyOf = Arrays.copyOf(objArr, (i12 | (i12 >>> 16)) + 1);
        Arrays.fill(copyOf, length, copyOf.length, UNSET);
        copyOf[i8] = obj;
        this.indexedVariables = copyOf;
    }

    private static InternalThreadLocalMap fastGet(FastThreadLocalThread fastThreadLocalThread) {
        InternalThreadLocalMap threadLocalMap = fastThreadLocalThread.threadLocalMap();
        if (threadLocalMap == null) {
            InternalThreadLocalMap internalThreadLocalMap = new InternalThreadLocalMap();
            fastThreadLocalThread.setThreadLocalMap(internalThreadLocalMap);
            return internalThreadLocalMap;
        }
        return threadLocalMap;
    }

    public static InternalThreadLocalMap get() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            return fastGet((FastThreadLocalThread) currentThread);
        }
        return slowGet();
    }

    public static InternalThreadLocalMap getIfSet() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            return ((FastThreadLocalThread) currentThread).threadLocalMap();
        }
        return UnpaddedInternalThreadLocalMap.slowThreadLocalMap.get();
    }

    private static Object[] newIndexedVariableTable() {
        Object[] objArr = new Object[32];
        Arrays.fill(objArr, UNSET);
        return objArr;
    }

    public static int nextVariableIndex() {
        AtomicInteger atomicInteger = UnpaddedInternalThreadLocalMap.nextIndex;
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement >= 0) {
            return andIncrement;
        }
        atomicInteger.decrementAndGet();
        throw new IllegalStateException("too many thread-local indexed variables");
    }

    public static void remove() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            ((FastThreadLocalThread) currentThread).setThreadLocalMap(null);
        } else {
            UnpaddedInternalThreadLocalMap.slowThreadLocalMap.remove();
        }
    }

    private static InternalThreadLocalMap slowGet() {
        ThreadLocal<InternalThreadLocalMap> threadLocal = UnpaddedInternalThreadLocalMap.slowThreadLocalMap;
        InternalThreadLocalMap internalThreadLocalMap = threadLocal.get();
        if (internalThreadLocalMap == null) {
            InternalThreadLocalMap internalThreadLocalMap2 = new InternalThreadLocalMap();
            threadLocal.set(internalThreadLocalMap2);
            return internalThreadLocalMap2;
        }
        return internalThreadLocalMap;
    }

    public Map<Charset, CharsetEncoder> charsetEncoderCache() {
        Map<Charset, CharsetEncoder> map = this.charsetEncoderCache;
        if (map == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            this.charsetEncoderCache = identityHashMap;
            return identityHashMap;
        }
        return map;
    }

    public int futureListenerStackDepth() {
        return this.futureListenerStackDepth;
    }

    public Map<Class<?>, Boolean> handlerSharableCache() {
        Map<Class<?>, Boolean> map = this.handlerSharableCache;
        if (map == null) {
            WeakHashMap weakHashMap = new WeakHashMap(4);
            this.handlerSharableCache = weakHashMap;
            return weakHashMap;
        }
        return map;
    }

    public Object indexedVariable(int i8) {
        Object[] objArr = this.indexedVariables;
        if (i8 < objArr.length) {
            return objArr[i8];
        }
        return UNSET;
    }

    public boolean isIndexedVariableSet(int i8) {
        Object[] objArr = this.indexedVariables;
        if (i8 < objArr.length && objArr[i8] != UNSET) {
            return true;
        }
        return false;
    }

    public ThreadLocalRandom random() {
        ThreadLocalRandom threadLocalRandom = this.random;
        if (threadLocalRandom == null) {
            ThreadLocalRandom threadLocalRandom2 = new ThreadLocalRandom();
            this.random = threadLocalRandom2;
            return threadLocalRandom2;
        }
        return threadLocalRandom;
    }

    public Object removeIndexedVariable(int i8) {
        Object[] objArr = this.indexedVariables;
        if (i8 < objArr.length) {
            Object obj = objArr[i8];
            objArr[i8] = UNSET;
            return obj;
        }
        return UNSET;
    }

    public void setFutureListenerStackDepth(int i8) {
        this.futureListenerStackDepth = i8;
    }

    public boolean setIndexedVariable(int i8, Object obj) {
        Object[] objArr = this.indexedVariables;
        if (i8 < objArr.length) {
            Object obj2 = objArr[i8];
            objArr[i8] = obj;
            if (obj2 == UNSET) {
                return true;
            }
            return false;
        }
        expandIndexedVariableTableAndSet(i8, obj);
        return true;
    }

    public StringBuilder stringBuilder() {
        StringBuilder sb = this.stringBuilder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder(STRING_BUILDER_INITIAL_SIZE);
            this.stringBuilder = sb2;
            return sb2;
        }
        if (sb.capacity() > STRING_BUILDER_MAX_SIZE) {
            sb.setLength(STRING_BUILDER_INITIAL_SIZE);
            sb.trimToSize();
        }
        sb.setLength(0);
        return sb;
    }

    public Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache() {
        Map<Class<?>, Map<String, TypeParameterMatcher>> map = this.typeParameterMatcherFindCache;
        if (map == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            this.typeParameterMatcherFindCache = identityHashMap;
            return identityHashMap;
        }
        return map;
    }

    public Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache() {
        Map<Class<?>, TypeParameterMatcher> map = this.typeParameterMatcherGetCache;
        if (map == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            this.typeParameterMatcherGetCache = identityHashMap;
            return identityHashMap;
        }
        return map;
    }
}
