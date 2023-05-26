package io.ktor.utils.io.jvm.javaio;

import androidx.concurrent.futures.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoopKt;
import kotlinx.coroutines.Job;

/* compiled from: Blocking.kt */
/* loaded from: classes5.dex */
abstract class BlockingAdapter {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f47475f = AtomicReferenceFieldUpdater.newUpdater(BlockingAdapter.class, Object.class, "state");

    /* renamed from: a  reason: collision with root package name */
    private final Job f47476a;

    /* renamed from: b  reason: collision with root package name */
    private final Continuation<Unit> f47477b;

    /* renamed from: c  reason: collision with root package name */
    private final DisposableHandle f47478c;

    /* renamed from: d  reason: collision with root package name */
    private int f47479d;

    /* renamed from: e  reason: collision with root package name */
    private int f47480e;
    volatile /* synthetic */ int result;
    volatile /* synthetic */ Object state;

    public BlockingAdapter() {
        this(null, 1, null);
    }

    public BlockingAdapter(Job job) {
        this.f47476a = job;
        Continuation<Unit> continuation = new Continuation<Unit>() { // from class: io.ktor.utils.io.jvm.javaio.BlockingAdapter$end$1

            /* renamed from: f  reason: collision with root package name */
            private final CoroutineContext f47484f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                CoroutineContext coroutineContext;
                if (BlockingAdapter.this.g() != null) {
                    coroutineContext = UnsafeBlockingTrampoline.f47508h.s0(BlockingAdapter.this.g());
                } else {
                    coroutineContext = UnsafeBlockingTrampoline.f47508h;
                }
                this.f47484f = coroutineContext;
            }

            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return this.f47484f;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                Object obj2;
                boolean z7;
                boolean z8;
                boolean a8;
                Throwable e8;
                DisposableHandle disposableHandle;
                Job g8;
                Object e9 = Result.e(obj);
                if (e9 == null) {
                    e9 = Unit.f50853a;
                }
                BlockingAdapter blockingAdapter = BlockingAdapter.this;
                do {
                    obj2 = blockingAdapter.state;
                    z7 = obj2 instanceof Thread;
                    if (z7) {
                        z8 = true;
                    } else {
                        z8 = obj2 instanceof Continuation;
                    }
                    if (z8) {
                        a8 = true;
                    } else {
                        a8 = Intrinsics.a(obj2, this);
                    }
                    if (!a8) {
                        return;
                    }
                } while (!a.a(BlockingAdapter.f47475f, blockingAdapter, obj2, e9));
                if (z7) {
                    PollersKt.a().b(obj2);
                } else if ((obj2 instanceof Continuation) && (e8 = Result.e(obj)) != null) {
                    ((Continuation) obj2).resumeWith(Result.b(ResultKt.a(e8)));
                }
                if (Result.g(obj) && !(Result.e(obj) instanceof CancellationException) && (g8 = BlockingAdapter.this.g()) != null) {
                    Job.DefaultImpls.a(g8, null, 1, null);
                }
                disposableHandle = BlockingAdapter.this.f47478c;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                }
            }
        };
        this.f47477b = continuation;
        this.state = this;
        this.result = 0;
        this.f47478c = job != null ? job.X(new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.jvm.javaio.BlockingAdapter$disposable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Continuation continuation2;
                if (th != null) {
                    continuation2 = BlockingAdapter.this.f47477b;
                    Result.Companion companion = Result.f50818g;
                    continuation2.resumeWith(Result.b(ResultKt.a(th)));
                }
            }
        }) : null;
        ((Function1) TypeIntrinsics.e(new BlockingAdapter$block$1(this, null), 1)).invoke(continuation);
        if (!(this.state != this)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final void i(Thread thread) {
        if (this.state != thread) {
            return;
        }
        if (!PollersKt.b()) {
            BlockingKt.a().warn("Blocking network thread detected. \nIt can possible lead to a performance decline or even a deadlock.\nPlease make sure you're using blocking IO primitives like InputStream and OutputStream only in \nthe context of Dispatchers.IO:\n```\nwithContext(Dispatchers.IO) {\n    myInputStream.read()\n}\n```");
        }
        while (true) {
            long b8 = EventLoopKt.b();
            if (this.state == thread) {
                if (b8 > 0) {
                    PollersKt.a().a(b8);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object j(Continuation<Object> continuation) {
        Continuation c8;
        Object obj;
        Continuation continuation2;
        Object d8;
        Object obj2 = null;
        while (true) {
            Object obj3 = this.state;
            if (obj3 instanceof Thread) {
                continuation2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
                obj = obj3;
            } else if (Intrinsics.a(obj3, this)) {
                c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
                obj = obj2;
                continuation2 = c8;
            } else {
                throw new IllegalStateException("Already suspended or in finished state");
            }
            if (!a.a(f47475f, this, obj3, continuation2)) {
                obj2 = obj;
            } else {
                if (obj != null) {
                    PollersKt.a().b(obj);
                }
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                return d8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(int i8) {
        this.result = i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e() {
        return this.f47480e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        return this.f47479d;
    }

    public final Job g() {
        return this.f47476a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object h(Continuation<? super Unit> continuation);

    public final void k() {
        DisposableHandle disposableHandle = this.f47478c;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Continuation<Unit> continuation = this.f47477b;
        Result.Companion companion = Result.f50818g;
        continuation.resumeWith(Result.b(ResultKt.a(new CancellationException("Stream closed"))));
    }

    public final int l(Object jobToken) {
        Object obj;
        Object noWhenBranchMatchedException;
        Intrinsics.f(jobToken, "jobToken");
        Thread thread = Thread.currentThread();
        Continuation continuation = null;
        do {
            obj = this.state;
            if (obj instanceof Continuation) {
                continuation = (Continuation) obj;
                noWhenBranchMatchedException = thread;
            } else if (obj instanceof Unit) {
                return this.result;
            } else {
                if (!(obj instanceof Throwable)) {
                    if (!(obj instanceof Thread)) {
                        if (!Intrinsics.a(obj, this)) {
                            noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        } else {
                            throw new IllegalStateException("Not yet started");
                        }
                    } else {
                        throw new IllegalStateException("There is already thread owning adapter");
                    }
                } else {
                    throw ((Throwable) obj);
                }
            }
            Intrinsics.e(noWhenBranchMatchedException, "when (value) {\n         …Exception()\n            }");
        } while (!a.a(f47475f, this, obj, noWhenBranchMatchedException));
        Intrinsics.c(continuation);
        continuation.resumeWith(Result.b(jobToken));
        Intrinsics.e(thread, "thread");
        i(thread);
        Object obj2 = this.state;
        if (!(obj2 instanceof Throwable)) {
            return this.result;
        }
        throw ((Throwable) obj2);
    }

    public final int m(byte[] buffer, int i8, int i9) {
        Intrinsics.f(buffer, "buffer");
        this.f47479d = i8;
        this.f47480e = i9;
        return l(buffer);
    }

    public /* synthetic */ BlockingAdapter(Job job, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : job);
    }
}
