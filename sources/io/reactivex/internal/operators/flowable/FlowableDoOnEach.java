package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Consumer<? super T> f47864h;

    /* renamed from: i  reason: collision with root package name */
    final Consumer<? super Throwable> f47865i;

    /* renamed from: j  reason: collision with root package name */
    final Action f47866j;

    /* renamed from: k  reason: collision with root package name */
    final Action f47867k;

    /* loaded from: classes5.dex */
    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: k  reason: collision with root package name */
        final Consumer<? super T> f47868k;

        /* renamed from: l  reason: collision with root package name */
        final Consumer<? super Throwable> f47869l;

        /* renamed from: m  reason: collision with root package name */
        final Action f47870m;

        /* renamed from: n  reason: collision with root package name */
        final Action f47871n;

        DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(conditionalSubscriber);
            this.f47868k = consumer;
            this.f47869l = consumer2;
            this.f47870m = action;
            this.f47871n = action2;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return i(i8);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean h(T t7) {
            if (this.f49762i) {
                return false;
            }
            try {
                this.f47868k.accept(t7);
                return this.f49759f.h(t7);
            } catch (Throwable th) {
                g(th);
                return false;
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f49762i) {
                return;
            }
            try {
                this.f47870m.run();
                this.f49762i = true;
                this.f49759f.onComplete();
                try {
                    this.f47871n.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            } catch (Throwable th2) {
                g(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f49762i) {
                RxJavaPlugins.s(th);
                return;
            }
            boolean z7 = true;
            this.f49762i = true;
            try {
                this.f47869l.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f49759f.onError(new CompositeException(th, th2));
                z7 = false;
            }
            if (z7) {
                this.f49759f.onError(th);
            }
            try {
                this.f47871n.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f49762i) {
                return;
            }
            if (this.f49763j != 0) {
                this.f49759f.onNext(null);
                return;
            }
            try {
                this.f47868k.accept(t7);
                this.f49759f.onNext(t7);
            } catch (Throwable th) {
                g(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            try {
                T poll = this.f49761h.poll();
                if (poll != null) {
                    try {
                        this.f47868k.accept(poll);
                    } catch (Throwable th) {
                        try {
                            Exceptions.b(th);
                            this.f47869l.accept(th);
                            throw ExceptionHelper.c(th);
                        } finally {
                            this.f47871n.run();
                        }
                    }
                } else if (this.f49763j == 1) {
                    this.f47870m.run();
                }
                return poll;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                try {
                    this.f47869l.accept(th2);
                    throw ExceptionHelper.c(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {

        /* renamed from: k  reason: collision with root package name */
        final Consumer<? super T> f47872k;

        /* renamed from: l  reason: collision with root package name */
        final Consumer<? super Throwable> f47873l;

        /* renamed from: m  reason: collision with root package name */
        final Action f47874m;

        /* renamed from: n  reason: collision with root package name */
        final Action f47875n;

        DoOnEachSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(subscriber);
            this.f47872k = consumer;
            this.f47873l = consumer2;
            this.f47874m = action;
            this.f47875n = action2;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return i(i8);
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f49767i) {
                return;
            }
            try {
                this.f47874m.run();
                this.f49767i = true;
                this.f49764f.onComplete();
                try {
                    this.f47875n.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            } catch (Throwable th2) {
                g(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f49767i) {
                RxJavaPlugins.s(th);
                return;
            }
            boolean z7 = true;
            this.f49767i = true;
            try {
                this.f47873l.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f49764f.onError(new CompositeException(th, th2));
                z7 = false;
            }
            if (z7) {
                this.f49764f.onError(th);
            }
            try {
                this.f47875n.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f49767i) {
                return;
            }
            if (this.f49768j != 0) {
                this.f49764f.onNext(null);
                return;
            }
            try {
                this.f47872k.accept(t7);
                this.f49764f.onNext(t7);
            } catch (Throwable th) {
                g(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            try {
                T poll = this.f49766h.poll();
                if (poll != null) {
                    try {
                        this.f47872k.accept(poll);
                    } catch (Throwable th) {
                        try {
                            Exceptions.b(th);
                            this.f47873l.accept(th);
                            throw ExceptionHelper.c(th);
                        } finally {
                            this.f47875n.run();
                        }
                    }
                } else if (this.f49768j == 1) {
                    this.f47874m.run();
                }
                return poll;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                try {
                    this.f47873l.accept(th2);
                    throw ExceptionHelper.c(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }
    }

    public FlowableDoOnEach(Flowable<T> flowable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(flowable);
        this.f47864h = consumer;
        this.f47865i = consumer2;
        this.f47866j = action;
        this.f47867k = action2;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f47792g.Y(new DoOnEachConditionalSubscriber((ConditionalSubscriber) subscriber, this.f47864h, this.f47865i, this.f47866j, this.f47867k));
        } else {
            this.f47792g.Y(new DoOnEachSubscriber(subscriber, this.f47864h, this.f47865i, this.f47866j, this.f47867k));
        }
    }
}
