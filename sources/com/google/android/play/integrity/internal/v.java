package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: o */
    private static final Map f14629o = new HashMap();

    /* renamed from: a */
    private final Context f14630a;

    /* renamed from: b */
    private final k f14631b;

    /* renamed from: g */
    private boolean f14636g;

    /* renamed from: h */
    private final Intent f14637h;

    /* renamed from: l */
    private ServiceConnection f14641l;

    /* renamed from: m */
    private IInterface f14642m;

    /* renamed from: n */
    private final com.google.android.play.core.integrity.q f14643n;

    /* renamed from: d */
    private final List f14633d = new ArrayList();

    /* renamed from: e */
    private final Set f14634e = new HashSet();

    /* renamed from: f */
    private final Object f14635f = new Object();

    /* renamed from: j */
    private final IBinder.DeathRecipient f14639j = new IBinder.DeathRecipient() { // from class: com.google.android.play.integrity.internal.n
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            v.h(v.this);
        }
    };

    /* renamed from: k */
    private final AtomicInteger f14640k = new AtomicInteger(0);

    /* renamed from: c */
    private final String f14632c = "IntegrityService";

    /* renamed from: i */
    private final WeakReference f14638i = new WeakReference(null);

    public v(Context context, k kVar, String str, Intent intent, com.google.android.play.core.integrity.q qVar, q qVar2, byte[] bArr) {
        this.f14630a = context;
        this.f14631b = kVar;
        this.f14637h = intent;
        this.f14643n = qVar;
    }

    public static /* synthetic */ void h(v vVar) {
        vVar.f14631b.d("reportBinderDeath", new Object[0]);
        q qVar = (q) vVar.f14638i.get();
        if (qVar != null) {
            vVar.f14631b.d("calling onBinderDied", new Object[0]);
            qVar.a();
        } else {
            vVar.f14631b.d("%s : Binder has died.", vVar.f14632c);
            for (l lVar : vVar.f14633d) {
                lVar.a(vVar.s());
            }
            vVar.f14633d.clear();
        }
        vVar.t();
    }

    public static /* bridge */ /* synthetic */ void m(v vVar, l lVar) {
        if (vVar.f14642m == null && !vVar.f14636g) {
            vVar.f14631b.d("Initiate binding to the service.", new Object[0]);
            vVar.f14633d.add(lVar);
            u uVar = new u(vVar, null);
            vVar.f14641l = uVar;
            vVar.f14636g = true;
            if (!vVar.f14630a.bindService(vVar.f14637h, uVar, 1)) {
                vVar.f14631b.d("Failed to bind to the service.", new Object[0]);
                vVar.f14636g = false;
                for (l lVar2 : vVar.f14633d) {
                    lVar2.a(new w());
                }
                vVar.f14633d.clear();
            }
        } else if (vVar.f14636g) {
            vVar.f14631b.d("Waiting to bind to the service.", new Object[0]);
            vVar.f14633d.add(lVar);
        } else {
            lVar.run();
        }
    }

    public static /* bridge */ /* synthetic */ void n(v vVar) {
        vVar.f14631b.d("linkToDeath", new Object[0]);
        try {
            vVar.f14642m.asBinder().linkToDeath(vVar.f14639j, 0);
        } catch (RemoteException e8) {
            vVar.f14631b.c(e8, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void o(v vVar) {
        vVar.f14631b.d("unlinkToDeath", new Object[0]);
        vVar.f14642m.asBinder().unlinkToDeath(vVar.f14639j, 0);
    }

    private final RemoteException s() {
        return new RemoteException(String.valueOf(this.f14632c).concat(" : Binder has died."));
    }

    public final void t() {
        synchronized (this.f14635f) {
            for (TaskCompletionSource taskCompletionSource : this.f14634e) {
                taskCompletionSource.trySetException(s());
            }
            this.f14634e.clear();
        }
    }

    public final Handler c() {
        Handler handler;
        Map map = f14629o;
        synchronized (map) {
            if (!map.containsKey(this.f14632c)) {
                HandlerThread handlerThread = new HandlerThread(this.f14632c, 10);
                handlerThread.start();
                map.put(this.f14632c, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.f14632c);
        }
        return handler;
    }

    public final IInterface e() {
        return this.f14642m;
    }

    public final void p(l lVar, final TaskCompletionSource taskCompletionSource) {
        synchronized (this.f14635f) {
            this.f14634e.add(taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.integrity.internal.m
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    v.this.q(taskCompletionSource, task);
                }
            });
        }
        synchronized (this.f14635f) {
            if (this.f14640k.getAndIncrement() > 0) {
                this.f14631b.a("Already connected to the service.", new Object[0]);
            }
        }
        c().post(new o(this, lVar.c(), lVar));
    }

    public final /* synthetic */ void q(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f14635f) {
            this.f14634e.remove(taskCompletionSource);
        }
    }

    public final void r(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f14635f) {
            this.f14634e.remove(taskCompletionSource);
        }
        synchronized (this.f14635f) {
            if (this.f14640k.get() > 0 && this.f14640k.decrementAndGet() > 0) {
                this.f14631b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            c().post(new p(this));
        }
    }
}
