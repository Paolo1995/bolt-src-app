package com.clevertap.android.sdk.task;

import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class Task<TResult> {

    /* renamed from: a  reason: collision with root package name */
    protected final CleverTapInstanceConfig f11801a;

    /* renamed from: b  reason: collision with root package name */
    protected final Executor f11802b;

    /* renamed from: c  reason: collision with root package name */
    protected final Executor f11803c;

    /* renamed from: e  reason: collision with root package name */
    protected TResult f11805e;

    /* renamed from: h  reason: collision with root package name */
    private final String f11808h;

    /* renamed from: d  reason: collision with root package name */
    protected final List<Object> f11804d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    protected final List<SuccessExecutable<TResult>> f11806f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    protected STATE f11807g = STATE.READY_TO_RUN;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public enum STATE {
        FAILED,
        SUCCESS,
        READY_TO_RUN,
        RUNNING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task(CleverTapInstanceConfig cleverTapInstanceConfig, Executor executor, Executor executor2, String str) {
        this.f11803c = executor;
        this.f11802b = executor2;
        this.f11801a = cleverTapInstanceConfig;
        this.f11808h = str;
    }

    private Runnable e(final String str, final Callable<TResult> callable) {
        return new Runnable() { // from class: com.clevertap.android.sdk.task.Task.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger n8 = Task.this.f11801a.n();
                    n8.r(Task.this.f11808h + " Task: " + str + " starting on..." + Thread.currentThread().getName());
                    Object call = callable.call();
                    Logger n9 = Task.this.f11801a.n();
                    n9.r(Task.this.f11808h + " Task: " + str + " executed successfully on..." + Thread.currentThread().getName());
                    Task.this.g(call);
                } catch (Exception e8) {
                    Task.this.f(e8);
                    Logger n10 = Task.this.f11801a.n();
                    n10.u(Task.this.f11808h + " Task: " + str + " failed to execute on..." + Thread.currentThread().getName(), e8);
                    e8.printStackTrace();
                }
            }
        };
    }

    @NonNull
    public Task<TResult> b(@NonNull OnSuccessListener<TResult> onSuccessListener) {
        return c(this.f11802b, onSuccessListener);
    }

    @NonNull
    public Task<TResult> c(@NonNull Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        if (onSuccessListener != null) {
            this.f11806f.add(new SuccessExecutable<>(executor, onSuccessListener, this.f11801a));
        }
        return this;
    }

    public void d(String str, Callable<TResult> callable) {
        this.f11803c.execute(e(str, callable));
    }

    void f(Exception exc) {
        i(STATE.FAILED);
        Iterator<Object> it = this.f11804d.iterator();
        while (it.hasNext()) {
            ((Executable) it.next()).a(exc);
        }
    }

    void g(TResult tresult) {
        i(STATE.SUCCESS);
        h(tresult);
        for (SuccessExecutable<TResult> successExecutable : this.f11806f) {
            successExecutable.a(this.f11805e);
        }
    }

    void h(TResult tresult) {
        this.f11805e = tresult;
    }

    void i(STATE state) {
        this.f11807g = state;
    }

    public Future<?> j(String str, Callable<TResult> callable) {
        Executor executor = this.f11803c;
        if (executor instanceof ExecutorService) {
            return ((ExecutorService) executor).submit(e(str, callable));
        }
        throw new UnsupportedOperationException("Can't use this method without ExecutorService, Use Execute alternatively ");
    }
}
