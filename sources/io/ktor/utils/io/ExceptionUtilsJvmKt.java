package io.ktor.utils.io;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: ExceptionUtilsJvm.kt */
/* loaded from: classes5.dex */
public final class ExceptionUtilsJvmKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f47354a = d(Throwable.class, -1);

    /* renamed from: b  reason: collision with root package name */
    private static final ReentrantReadWriteLock f47355b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> f47356c = new WeakHashMap<>();

    private static final Function1<Throwable, Throwable> a(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length != 2 || !Intrinsics.a(parameterTypes[0], String.class) || !Intrinsics.a(parameterTypes[1], Throwable.class)) {
                    return null;
                }
                return new Function1<Throwable, Throwable>() { // from class: io.ktor.utils.io.ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: b */
                    public final Throwable invoke(Throwable e8) {
                        Object b8;
                        Object newInstance;
                        Intrinsics.f(e8, "e");
                        try {
                            Result.Companion companion = Result.f50818g;
                            newInstance = constructor.newInstance(e8.getMessage(), e8);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.f50818g;
                            b8 = Result.b(ResultKt.a(th));
                        }
                        if (newInstance != null) {
                            b8 = Result.b((Throwable) newInstance);
                            if (Result.g(b8)) {
                                b8 = null;
                            }
                            return (Throwable) b8;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            Class<?> cls = parameterTypes[0];
            if (Intrinsics.a(cls, Throwable.class)) {
                return new Function1<Throwable, Throwable>() { // from class: io.ktor.utils.io.ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: b */
                    public final Throwable invoke(Throwable e8) {
                        Object b8;
                        Object newInstance;
                        Intrinsics.f(e8, "e");
                        try {
                            Result.Companion companion = Result.f50818g;
                            newInstance = constructor.newInstance(e8);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.f50818g;
                            b8 = Result.b(ResultKt.a(th));
                        }
                        if (newInstance != null) {
                            b8 = Result.b((Throwable) newInstance);
                            if (Result.g(b8)) {
                                b8 = null;
                            }
                            return (Throwable) b8;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            if (!Intrinsics.a(cls, String.class)) {
                return null;
            }
            return new Function1<Throwable, Throwable>() { // from class: io.ktor.utils.io.ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Throwable invoke(Throwable e8) {
                    Object b8;
                    Object newInstance;
                    Intrinsics.f(e8, "e");
                    try {
                        Result.Companion companion = Result.f50818g;
                        newInstance = constructor.newInstance(e8.getMessage());
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.f50818g;
                        b8 = Result.b(ResultKt.a(th));
                    }
                    if (newInstance != null) {
                        Throwable th2 = (Throwable) newInstance;
                        th2.initCause(e8);
                        b8 = Result.b(th2);
                        if (Result.g(b8)) {
                            b8 = null;
                        }
                        return (Throwable) b8;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
            };
        }
        return new Function1<Throwable, Throwable>() { // from class: io.ktor.utils.io.ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Throwable invoke(Throwable e8) {
                Object b8;
                Object newInstance;
                Intrinsics.f(e8, "e");
                try {
                    Result.Companion companion = Result.f50818g;
                    newInstance = constructor.newInstance(new Object[0]);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f50818g;
                    b8 = Result.b(ResultKt.a(th));
                }
                if (newInstance != null) {
                    Throwable th2 = (Throwable) newInstance;
                    th2.initCause(e8);
                    b8 = Result.b(th2);
                    if (Result.g(b8)) {
                        b8 = null;
                    }
                    return (Throwable) b8;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
        };
    }

    private static final int b(Class<?> cls, int i8) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            Intrinsics.e(declaredFields, "declaredFields");
            int i9 = 0;
            for (Field field : declaredFields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i9++;
                }
            }
            i8 += i9;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i8;
    }

    static /* synthetic */ int c(Class cls, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 0;
        }
        return b(cls, i8);
    }

    private static final int d(Class<?> cls, int i8) {
        Integer b8;
        JvmClassMappingKt.c(cls);
        try {
            Result.Companion companion = Result.f50818g;
            b8 = Result.b(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        Integer valueOf = Integer.valueOf(i8);
        if (Result.g(b8)) {
            b8 = valueOf;
        }
        return ((Number) b8).intValue();
    }

    public static final <E extends Throwable> E e(E exception, Throwable cause) {
        Object b8;
        ReentrantReadWriteLock.ReadLock readLock;
        int i8;
        ReentrantReadWriteLock.WriteLock writeLock;
        Function1<Throwable, Throwable> function1;
        int i9;
        Intrinsics.f(exception, "exception");
        Intrinsics.f(cause, "cause");
        Object obj = null;
        if (exception instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.f50818g;
                b8 = Result.b(((CopyableThrowable) exception).a());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f50818g;
                b8 = Result.b(ResultKt.a(th));
            }
            if (!Result.g(b8)) {
                obj = b8;
            }
            return (E) obj;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f47355b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            Function1<Throwable, Throwable> function12 = f47356c.get(exception.getClass());
            if (function12 != null) {
                return (E) function12.invoke(exception);
            }
            int i10 = 0;
            if (f47354a != d(exception.getClass(), 0)) {
                readLock = reentrantReadWriteLock.readLock();
                if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                    i9 = reentrantReadWriteLock.getReadHoldCount();
                } else {
                    i9 = 0;
                }
                for (int i11 = 0; i11 < i8; i11++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f47356c.put(exception.getClass(), new Function1() { // from class: io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$4$1
                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: b */
                        public final Void invoke(Throwable it) {
                            Intrinsics.f(it, "it");
                            return null;
                        }
                    });
                    Unit unit = Unit.f50853a;
                    return null;
                } finally {
                    while (i10 < i8) {
                        readLock.lock();
                        i10++;
                    }
                    writeLock.unlock();
                }
            }
            Constructor<?>[] constructors = exception.getClass().getConstructors();
            Intrinsics.e(constructors, "exception.javaClass.constructors");
            Function1<Throwable, Throwable> function13 = null;
            for (Constructor constructor : ArraysKt.b0(constructors, new Comparator() { // from class: io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t7, T t8) {
                    int a8;
                    a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((Constructor) t8).getParameterTypes().length), Integer.valueOf(((Constructor) t7).getParameterTypes().length));
                    return a8;
                }
            })) {
                Intrinsics.e(constructor, "constructor");
                function13 = a(constructor);
                if (function13 != null) {
                    break;
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f47355b;
            readLock = reentrantReadWriteLock2.readLock();
            if (reentrantReadWriteLock2.getWriteHoldCount() == 0) {
                i8 = reentrantReadWriteLock2.getReadHoldCount();
            } else {
                i8 = 0;
            }
            for (int i12 = 0; i12 < i8; i12++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                AbstractMap abstractMap = f47356c;
                Class<?> cls = exception.getClass();
                if (function13 == null) {
                    function1 = new Function1() { // from class: io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$5$1
                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: b */
                        public final Void invoke(Throwable it) {
                            Intrinsics.f(it, "it");
                            return null;
                        }
                    };
                } else {
                    function1 = function13;
                }
                abstractMap.put(cls, function1);
                Unit unit2 = Unit.f50853a;
                while (i10 < i8) {
                    readLock.lock();
                    i10++;
                }
                writeLock.unlock();
                if (function13 == null) {
                    return null;
                }
                return (E) function13.invoke(cause);
            } finally {
                while (i10 < i8) {
                    readLock.lock();
                    i10++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
