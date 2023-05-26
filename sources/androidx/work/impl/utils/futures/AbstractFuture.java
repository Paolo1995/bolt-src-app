package androidx.work.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.a;
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
public abstract class AbstractFuture<V> implements ListenableFuture<V> {

    /* renamed from: i  reason: collision with root package name */
    static final boolean f8741i = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: j  reason: collision with root package name */
    private static final Logger f8742j = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: k  reason: collision with root package name */
    static final AtomicHelper f8743k;

    /* renamed from: l  reason: collision with root package name */
    private static final Object f8744l;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f8745f;

    /* renamed from: g  reason: collision with root package name */
    volatile Listener f8746g;

    /* renamed from: h  reason: collision with root package name */
    volatile Waiter f8747h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        abstract boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        abstract void d(Waiter waiter, Waiter waiter2);

        abstract void e(Waiter waiter, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Cancellation {

        /* renamed from: c  reason: collision with root package name */
        static final Cancellation f8748c;

        /* renamed from: d  reason: collision with root package name */
        static final Cancellation f8749d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f8750a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f8751b;

        static {
            if (AbstractFuture.f8741i) {
                f8749d = null;
                f8748c = null;
                return;
            }
            f8749d = new Cancellation(false, null);
            f8748c = new Cancellation(true, null);
        }

        Cancellation(boolean z7, Throwable th) {
            this.f8750a = z7;
            this.f8751b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f8752b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f8753a;

        Failure(Throwable th) {
            this.f8753a = (Throwable) AbstractFuture.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        static final Listener f8754d = new Listener(null, null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f8755a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f8756b;

        /* renamed from: c  reason: collision with root package name */
        Listener f8757c;

        Listener(Runnable runnable, Executor executor) {
            this.f8755a = runnable;
            this.f8756b = executor;
        }
    }

    /* loaded from: classes.dex */
    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Thread> f8758a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f8759b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f8760c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f8761d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f8762e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f8758a = atomicReferenceFieldUpdater;
            this.f8759b = atomicReferenceFieldUpdater2;
            this.f8760c = atomicReferenceFieldUpdater3;
            this.f8761d = atomicReferenceFieldUpdater4;
            this.f8762e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return a.a(this.f8761d, abstractFuture, listener, listener2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.a(this.f8762e, abstractFuture, obj, obj2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f8760c, abstractFuture, waiter, waiter2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void d(Waiter waiter, Waiter waiter2) {
            this.f8759b.lazySet(waiter, waiter2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void e(Waiter waiter, Thread thread) {
            this.f8758a.lazySet(waiter, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SetFuture<V> implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final AbstractFuture<V> f8763f;

        /* renamed from: g  reason: collision with root package name */
        final ListenableFuture<? extends V> f8764g;

        SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f8763f = abstractFuture;
            this.f8764g = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8763f.f8745f != this) {
                return;
            }
            if (AbstractFuture.f8743k.b(this.f8763f, this, AbstractFuture.j(this.f8764g))) {
                AbstractFuture.g(this.f8763f);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f8746g == listener) {
                    abstractFuture.f8746g = listener2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f8745f == obj) {
                    abstractFuture.f8745f = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f8747h == waiter) {
                    abstractFuture.f8747h = waiter2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void d(Waiter waiter, Waiter waiter2) {
            waiter.f8767b = waiter2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        void e(Waiter waiter, Thread thread) {
            waiter.f8766a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        static final Waiter f8765c = new Waiter(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f8766a;

        /* renamed from: b  reason: collision with root package name */
        volatile Waiter f8767b;

        Waiter(boolean z7) {
        }

        void a(Waiter waiter) {
            AbstractFuture.f8743k.d(this, waiter);
        }

        void b() {
            Thread thread = this.f8766a;
            if (thread != null) {
                this.f8766a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter() {
            AbstractFuture.f8743k.e(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "h"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "g"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "f"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        f8743k = synchronizedHelper;
        if (th != null) {
            f8742j.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f8744l = new Object();
    }

    private void a(StringBuilder sb) {
        try {
            Object k8 = k(this);
            sb.append("SUCCESS, result=[");
            sb.append(s(k8));
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
            listener2 = this.f8746g;
        } while (!f8743k.a(this, listener2, Listener.f8754d));
        Listener listener3 = listener;
        Listener listener4 = listener2;
        while (listener4 != null) {
            Listener listener5 = listener4.f8757c;
            listener4.f8757c = listener3;
            listener3 = listener4;
            listener4 = listener5;
        }
        return listener3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper] */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.work.impl.utils.futures.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.work.impl.utils.futures.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.work.impl.utils.futures.AbstractFuture, androidx.work.impl.utils.futures.AbstractFuture<V>] */
    static void g(AbstractFuture<?> abstractFuture) {
        Listener listener = null;
        while (true) {
            abstractFuture.n();
            abstractFuture.b();
            Listener e8 = abstractFuture.e(listener);
            while (e8 != null) {
                listener = e8.f8757c;
                Runnable runnable = e8.f8755a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.f8763f;
                    if (abstractFuture.f8745f == setFuture) {
                        if (f8743k.b(abstractFuture, setFuture, j(setFuture.f8764g))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, e8.f8756b);
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
            Logger logger = f8742j;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V i(Object obj) throws ExecutionException {
        if (!(obj instanceof Cancellation)) {
            if (!(obj instanceof Failure)) {
                if (obj == f8744l) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).f8753a);
        }
        throw c("Task was cancelled.", ((Cancellation) obj).f8751b);
    }

    static Object j(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).f8745f;
            if (obj instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj;
                if (cancellation.f8750a) {
                    if (cancellation.f8751b != null) {
                        return new Cancellation(false, cancellation.f8751b);
                    }
                    return Cancellation.f8749d;
                }
                return obj;
            }
            return obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f8741i) & isCancelled) {
            return Cancellation.f8749d;
        }
        try {
            Object k8 = k(listenableFuture);
            if (k8 == null) {
                return f8744l;
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
            waiter = this.f8747h;
        } while (!f8743k.c(this, waiter, Waiter.f8765c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f8767b;
        }
    }

    private void o(Waiter waiter) {
        waiter.f8766a = null;
        while (true) {
            Waiter waiter2 = this.f8747h;
            if (waiter2 == Waiter.f8765c) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.f8767b;
                if (waiter2.f8766a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.f8767b = waiter4;
                    if (waiter3.f8766a == null) {
                        break;
                    }
                } else if (!f8743k.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    private String s(Object obj) {
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
        Object obj = this.f8745f;
        if (obj == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8 | (obj instanceof SetFuture)) {
            if (f8741i) {
                cancellation = new Cancellation(z7, new CancellationException("Future.cancel() was called."));
            } else if (z7) {
                cancellation = Cancellation.f8748c;
            } else {
                cancellation = Cancellation.f8749d;
            }
            boolean z10 = false;
            AbstractFuture<V> abstractFuture = this;
            while (true) {
                if (f8743k.b(abstractFuture, obj, cancellation)) {
                    if (z7) {
                        abstractFuture.l();
                    }
                    g(abstractFuture);
                    if (!(obj instanceof SetFuture)) {
                        return true;
                    }
                    ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).f8764g;
                    if (listenableFuture instanceof AbstractFuture) {
                        abstractFuture = (AbstractFuture) listenableFuture;
                        obj = abstractFuture.f8745f;
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
                    obj = abstractFuture.f8745f;
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
        Listener listener = this.f8746g;
        if (listener != Listener.f8754d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f8757c = listener;
                if (f8743k.a(this, listener, listener2)) {
                    return;
                }
                listener = this.f8746g;
            } while (listener != Listener.f8754d);
            h(runnable, executor);
        }
        h(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j8, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        Locale locale;
        long nanos = timeUnit.toNanos(j8);
        if (!Thread.interrupted()) {
            Object obj = this.f8745f;
            if ((obj != null) & (!(obj instanceof SetFuture))) {
                return i(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                Waiter waiter = this.f8747h;
                if (waiter != Waiter.f8765c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (f8743k.c(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f8745f;
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
                            waiter = this.f8747h;
                        }
                    } while (waiter != Waiter.f8765c);
                    return i(this.f8745f);
                }
                return i(this.f8745f);
            }
            while (nanos > 0) {
                Object obj3 = this.f8745f;
                if ((obj3 != null) & (!(obj3 instanceof SetFuture))) {
                    return i(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
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
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f8745f instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z7;
        Object obj = this.f8745f;
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
        Object obj = this.f8745f;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + s(((SetFuture) obj).f8764g) + "]";
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(V v7) {
        if (v7 == null) {
            v7 = (V) f8744l;
        }
        if (f8743k.b(this, null, v7)) {
            g(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(Throwable th) {
        if (f8743k.b(this, null, new Failure((Throwable) d(th)))) {
            g(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        d(listenableFuture);
        Object obj = this.f8745f;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f8743k.b(this, null, j(listenableFuture))) {
                    return false;
                }
                g(this);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (f8743k.b(this, null, setFuture)) {
                try {
                    listenableFuture.f(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.f8752b;
                    }
                    f8743k.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.f8745f;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f8750a);
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
            Object obj2 = this.f8745f;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return i(obj2);
            }
            Waiter waiter = this.f8747h;
            if (waiter != Waiter.f8765c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f8743k.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f8745f;
                            } else {
                                o(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return i(obj);
                    }
                    waiter = this.f8747h;
                } while (waiter != Waiter.f8765c);
                return i(this.f8745f);
            }
            return i(this.f8745f);
        }
        throw new InterruptedException();
    }
}
