package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes.dex */
public final class zzf implements ServiceConnection {
    @GuardedBy("this")
    int zza;
    final Messenger zzb;
    zzo zzc;
    @GuardedBy("this")
    final Queue<zzq<?>> zzd;
    @GuardedBy("this")
    final SparseArray<zzq<?>> zze;
    final /* synthetic */ zze zzf;

    private zzf(zze zzeVar) {
        this.zzf = zzeVar;
        this.zza = 0;
        this.zzb = new Messenger(new com.google.android.gms.internal.cloudmessaging.zze(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.android.gms.cloudmessaging.zzi
            private final zzf zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.zza.zza(message);
            }
        }));
        this.zzd = new ArrayDeque();
        this.zze = new SparseArray<>();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        scheduledExecutorService = this.zzf.zzc;
        scheduledExecutorService.execute(new Runnable(this, iBinder) { // from class: com.google.android.gms.cloudmessaging.zzk
            private final zzf zza;
            private final IBinder zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzf zzfVar = this.zza;
                IBinder iBinder2 = this.zzb;
                synchronized (zzfVar) {
                    try {
                        if (iBinder2 == null) {
                            zzfVar.zza(0, "Null service connection");
                            return;
                        }
                        try {
                            zzfVar.zzc = new zzo(iBinder2);
                            zzfVar.zza = 2;
                            zzfVar.zza();
                        } catch (RemoteException e8) {
                            zzfVar.zza(0, e8.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        scheduledExecutorService = this.zzf.zzc;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.zzm
            private final zzf zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(2, "Service disconnected");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zza(zzq<?> zzqVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i8 = this.zza;
        if (i8 == 0) {
            this.zzd.add(zzqVar);
            Preconditions.checkState(this.zza == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.zza = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
            context = this.zzf.zzb;
            if (connectionTracker.bindService(context, intent, this, 1)) {
                scheduledExecutorService = this.zzf.zzc;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.zzh
                    private final zzf zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzc();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                zza(0, "Unable to bind to service");
            }
            return true;
        } else if (i8 == 1) {
            this.zzd.add(zzqVar);
            return true;
        } else if (i8 == 2) {
            this.zzd.add(zzqVar);
            zza();
            return true;
        } else {
            if (i8 != 3 && i8 != 4) {
                int i9 = this.zza;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i9);
                throw new IllegalStateException(sb.toString());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzb() {
        Context context;
        if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.zza = 3;
            ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
            context = this.zzf.zzb;
            connectionTracker.unbindService(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzc() {
        if (this.zza == 1) {
            zza(1, "Timed out while binding");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(Message message) {
        int i8 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i8);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            zzq<?> zzqVar = this.zze.get(i8);
            if (zzqVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i8);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.zze.remove(i8);
            zzb();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                zzqVar.zza(new zzp(4, "Not supported by GmsCore"));
            } else {
                zzqVar.zza(data);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.zzf.zzc;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.zzj
            private final zzf zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final zzq<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final zzf zzfVar = this.zza;
                while (true) {
                    synchronized (zzfVar) {
                        if (zzfVar.zza != 2) {
                            return;
                        }
                        if (zzfVar.zzd.isEmpty()) {
                            zzfVar.zzb();
                            return;
                        }
                        poll = zzfVar.zzd.poll();
                        zzfVar.zze.put(poll.zza, poll);
                        scheduledExecutorService2 = zzfVar.zzf.zzc;
                        scheduledExecutorService2.schedule(new Runnable(zzfVar, poll) { // from class: com.google.android.gms.cloudmessaging.zzl
                            private final zzf zza;
                            private final zzq zzb;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zza = zzfVar;
                                this.zzb = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zza(this.zzb.zza);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = zzfVar.zzf.zzb;
                    Messenger messenger = zzfVar.zzb;
                    Message obtain = Message.obtain();
                    obtain.what = poll.zzc;
                    obtain.arg1 = poll.zza;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.zza());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.zzd);
                    obtain.setData(bundle);
                    try {
                        zzfVar.zzc.zza(obtain);
                    } catch (RemoteException e8) {
                        zzfVar.zza(2, e8.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(int i8, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i9 = this.zza;
        if (i9 == 0) {
            throw new IllegalStateException();
        }
        if (i9 != 1 && i9 != 2) {
            if (i9 == 3) {
                this.zza = 4;
                return;
            } else if (i9 == 4) {
                return;
            } else {
                int i10 = this.zza;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i10);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.zza = 4;
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        context = this.zzf.zzb;
        connectionTracker.unbindService(context, this);
        zzp zzpVar = new zzp(i8, str);
        for (zzq<?> zzqVar : this.zzd) {
            zzqVar.zza(zzpVar);
        }
        this.zzd.clear();
        for (int i11 = 0; i11 < this.zze.size(); i11++) {
            this.zze.valueAt(i11).zza(zzpVar);
        }
        this.zze.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(int i8) {
        zzq<?> zzqVar = this.zze.get(i8);
        if (zzqVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i8);
            Log.w("MessengerIpcClient", sb.toString());
            this.zze.remove(i8);
            zzqVar.zza(new zzp(3, "Timed out waiting for response"));
            zzb();
        }
    }
}
