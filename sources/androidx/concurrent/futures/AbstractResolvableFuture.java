package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {

    /* renamed from: i  reason: collision with root package name */
    static final boolean f4286i = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: j  reason: collision with root package name */
    private static final Logger f4287j = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* renamed from: k  reason: collision with root package name */
    static final AtomicHelper f4288k;

    /* renamed from: l  reason: collision with root package name */
    private static final Object f4289l;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f4290f;

    /* renamed from: g  reason: collision with root package name */
    volatile Listener f4291g;

    /* renamed from: h  reason: collision with root package name */
    volatile Waiter f4292h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        abstract void d(Waiter waiter, Waiter waiter2);

        abstract void e(Waiter waiter, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Cancellation {

        /* renamed from: c  reason: collision with root package name */
        static final Cancellation f4293c;

        /* renamed from: d  reason: collision with root package name */
        static final Cancellation f4294d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f4295a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f4296b;

        static {
            if (AbstractResolvableFuture.f4286i) {
                f4294d = null;
                f4293c = null;
                return;
            }
            f4294d = new Cancellation(false, null);
            f4293c = new Cancellation(true, null);
        }

        Cancellation(boolean z7, Throwable th) {
            this.f4295a = z7;
            this.f4296b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f4297b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f4298a;

        Failure(Throwable th) {
            this.f4298a = (Throwable) AbstractResolvableFuture.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        static final Listener f4299d = new Listener(null, null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f4300a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f4301b;

        /* renamed from: c  reason: collision with root package name */
        Listener f4302c;

        Listener(Runnable runnable, Executor executor) {
            this.f4300a = runnable;
            this.f4301b = executor;
        }
    }

    /* loaded from: classes.dex */
    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Thread> f4303a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f4304b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> f4305c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> f4306d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f4307e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f4303a = atomicReferenceFieldUpdater;
            this.f4304b = atomicReferenceFieldUpdater2;
            this.f4305c = atomicReferenceFieldUpdater3;
            this.f4306d = atomicReferenceFieldUpdater4;
            this.f4307e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            return a.a(this.f4306d, abstractResolvableFuture, listener, listener2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return a.a(this.f4307e, abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f4305c, abstractResolvableFuture, waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void d(Waiter waiter, Waiter waiter2) {
            this.f4304b.lazySet(waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void e(Waiter waiter, Thread thread) {
            this.f4303a.lazySet(waiter, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SetFuture<V> implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final AbstractResolvableFuture<V> f4308f;

        /* renamed from: g  reason: collision with root package name */
        final ListenableFuture<? extends V> f4309g;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4308f.f4290f != this) {
                return;
            }
            if (AbstractResolvableFuture.f4288k.b(this.f4308f, this, AbstractResolvableFuture.j(this.f4309g))) {
                AbstractResolvableFuture.g(this.f4308f);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f4291g == listener) {
                    abstractResolvableFuture.f4291g = listener2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f4290f == obj) {
                    abstractResolvableFuture.f4290f = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f4292h == waiter) {
                    abstractResolvableFuture.f4292h = waiter2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void d(Waiter waiter, Waiter waiter2) {
            waiter.f4312b = waiter2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void e(Waiter waiter, Thread thread) {
            waiter.f4311a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        static final Waiter f4310c = new Waiter(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f4311a;

        /* renamed from: b  reason: collision with root package name */
        volatile Waiter f4312b;

        Waiter(boolean z7) {
        }

        void a(Waiter waiter) {
            AbstractResolvableFuture.f4288k.d(this, waiter);
        }

        void b() {
            Thread thread = this.f4311a;
            if (thread != null) {
                this.f4311a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter() {
            AbstractResolvableFuture.f4288k.e(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "h"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "g"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "f"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        f4288k = synchronizedHelper;
        if (th != null) {
            f4287j.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f4289l = new Object();
    }

    private void a(StringBuilder sb) {
        try {
            Object k8 = k(this);
            sb.append("SUCCESS, result=[");
            sb.append(r(k8));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e8) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e8.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e9) {
            sb.append("FAILURE, cause=[");
            sb.append(e9.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @NonNull
    static <T> T d(T t7) {
        t7.getClass();
        return t7;
    }

    private Listener e(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.f4291g;
        } while (!f4288k.a(this, listener2, Listener.f4299d));
        Listener listener3 = listener;
        Listener listener4 = listener2;
        while (listener4 != null) {
            Listener listener5 = listener4.f4302c;
            listener4.f4302c = listener3;
            listener3 = listener4;
            listener4 = listener5;
        }
        return listener3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper] */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.concurrent.futures.AbstractResolvableFuture<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.concurrent.futures.AbstractResolvableFuture] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.concurrent.futures.AbstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture<V>] */
    static void g(AbstractResolvableFuture<?> abstractResolvableFuture) {
        Listener listener = null;
        while (true) {
            abstractResolvableFuture.n();
            abstractResolvableFuture.b();
            Listener e8 = abstractResolvableFuture.e(listener);
            while (e8 != null) {
                listener = e8.f4302c;
                Runnable runnable = e8.f4300a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractResolvableFuture = setFuture.f4308f;
                    if (abstractResolvableFuture.f4290f == setFuture) {
                        if (f4288k.b(abstractResolvableFuture, setFuture, j(setFuture.f4309g))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, e8.f4301b);
                }
                e8 = listener;
            }
            return;
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            Logger logger = f4287j;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V i(Object obj) throws ExecutionException {
        if (!(obj instanceof Cancellation)) {
            if (!(obj instanceof Failure)) {
                if (obj == f4289l) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).f4298a);
        }
        throw c("Task was cancelled.", ((Cancellation) obj).f4296b);
    }

    static Object j(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).f4290f;
            if (obj instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj;
                if (cancellation.f4295a) {
                    if (cancellation.f4296b != null) {
                        return new Cancellation(false, cancellation.f4296b);
                    }
                    return Cancellation.f4294d;
                }
                return obj;
            }
            return obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f4286i) & isCancelled) {
            return Cancellation.f4294d;
        }
        try {
            Object k8 = k(listenableFuture);
            if (k8 == null) {
                return f4289l;
            }
            return k8;
        } catch (CancellationException e8) {
            if (!isCancelled) {
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e8));
            }
            return new Cancellation(false, e8);
        } catch (ExecutionException e9) {
            return new Failure(e9.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    private static <V> V k(Future<V> future) throws ExecutionException {
        V v7;
        boolean z7 = false;
        while (true) {
            try {
                v7 = future.get();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return v7;
    }

    private void n() {
        Waiter waiter;
        do {
            waiter = this.f4292h;
        } while (!f4288k.c(this, waiter, Waiter.f4310c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f4312b;
        }
    }

    private void o(Waiter waiter) {
        waiter.f4311a = null;
        while (true) {
            Waiter waiter2 = this.f4292h;
            if (waiter2 == Waiter.f4310c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f4312b;
                if (waiter2.f4311a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f4312b = waiter4;
                    if (waiter3.f4311a == null) {
                        break;
                    }
                } else if (!f4288k.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    private String r(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        boolean z8;
        Cancellation cancellation;
        boolean z9;
        Object obj = this.f4290f;
        if (obj == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8 | (obj instanceof SetFuture)) {
            if (f4286i) {
                cancellation = new Cancellation(z7, new CancellationException("Future.cancel() was called."));
            } else if (z7) {
                cancellation = Cancellation.f4293c;
            } else {
                cancellation = Cancellation.f4294d;
            }
            boolean z10 = false;
            AbstractResolvableFuture<V> abstractResolvableFuture = this;
            while (true) {
                if (f4288k.b(abstractResolvableFuture, obj, cancellation)) {
                    if (z7) {
                        abstractResolvableFuture.l();
                    }
                    g(abstractResolvableFuture);
                    if (!(obj instanceof SetFuture)) {
                        return true;
                    }
                    ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).f4309g;
                    if (listenableFuture instanceof AbstractResolvableFuture) {
                        abstractResolvableFuture = (AbstractResolvableFuture) listenableFuture;
                        obj = abstractResolvableFuture.f4290f;
                        if (obj == null) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (!(z9 | (obj instanceof SetFuture))) {
                            return true;
                        }
                        z10 = true;
                    } else {
                        listenableFuture.cancel(z7);
                        return true;
                    }
                } else {
                    obj = abstractResolvableFuture.f4290f;
                    if (!(obj instanceof SetFuture)) {
                        return z10;
                    }
                }
            }
        } else {
            return false;
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void f(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        Listener listener = this.f4291g;
        if (listener != Listener.f4299d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f4302c = listener;
                if (f4288k.a(this, listener, listener2)) {
                    return;
                }
                listener = this.f4291g;
            } while (listener != Listener.f4299d);
            h(runnable, executor);
        }
        h(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j8, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        Locale locale;
        long nanos = timeUnit.toNanos(j8);
        if (!Thread.interrupted()) {
            Object obj = this.f4290f;
            if ((obj != null) & (!(obj instanceof SetFuture))) {
                return i(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                Waiter waiter = this.f4292h;
                if (waiter != Waiter.f4310c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (f4288k.c(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f4290f;
                                    if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                                        return i(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    o(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            o(waiter2);
                        } else {
                            waiter = this.f4292h;
                        }
                    } while (waiter != Waiter.f4310c);
                    return i(this.f4290f);
                }
                return i(this.f4290f);
            }
            while (nanos > 0) {
                Object obj3 = this.f4290f;
                if ((obj3 != null) & (!(obj3 instanceof SetFuture))) {
                    return i(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j8 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j9 = -nanos;
                long convert = timeUnit.convert(j9, TimeUnit.NANOSECONDS);
                long nanos2 = j9 - timeUnit.toNanos(convert);
                int i8 = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z7 = i8 == 0 || nanos2 > 1000;
                if (i8 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z7) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z7) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractResolvableFuture);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f4290f instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z7;
        Object obj = this.f4290f;
        if (obj != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        return (!(obj instanceof SetFuture)) & z7;
    }

    protected void l() {
    }

    protected String m() {
        Object obj = this.f4290f;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + r(((SetFuture) obj).f4309g) + "]";
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(V v7) {
        if (v7 == null) {
            v7 = (V) f4289l;
        }
        if (f4288k.b(this, null, v7)) {
            g(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(Throwable th) {
        if (f4288k.b(this, null, new Failure((Throwable) d(th)))) {
            g(this);
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = m();
            } catch (RuntimeException e8) {
                str = "Exception thrown from implementation: " + e8.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f4290f;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return i(obj2);
            }
            Waiter waiter = this.f4292h;
            if (waiter != Waiter.f4310c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f4288k.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f4290f;
                            } else {
                                o(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return i(obj);
                    }
                    waiter = this.f4292h;
                } while (waiter != Waiter.f4310c);
                return i(this.f4290f);
            }
            return i(this.f4290f);
        }
        throw new InterruptedException();
    }
}
