package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzga extends Thread {
    final /* synthetic */ zzgb zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd = false;

    public zzga(zzgb zzgbVar, String str, BlockingQueue blockingQueue) {
        this.zza = zzgbVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        zzga zzgaVar;
        zzga zzgaVar2;
        obj = this.zza.zzh;
        synchronized (obj) {
            if (!this.zzd) {
                semaphore = this.zza.zzi;
                semaphore.release();
                obj2 = this.zza.zzh;
                obj2.notifyAll();
                zzgb zzgbVar = this.zza;
                zzgaVar = zzgbVar.zzb;
                if (this == zzgaVar) {
                    zzgbVar.zzb = null;
                } else {
                    zzgaVar2 = zzgbVar.zzc;
                    if (this == zzgaVar2) {
                        zzgbVar.zzc = null;
                    } else {
                        zzgbVar.zzs.zzay().zzd().zza("Current scheduler thread is neither worker nor network");
                    }
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzs.zzay().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        int i8;
        Object obj;
        boolean z7 = false;
        while (!z7) {
            try {
                semaphore = this.zza.zzi;
                semaphore.acquire();
                z7 = true;
            } catch (InterruptedException e8) {
                zzc(e8);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfz zzfzVar = (zzfz) this.zzc.poll();
                if (zzfzVar != null) {
                    if (true != zzfzVar.zza) {
                        i8 = 10;
                    } else {
                        i8 = threadPriority;
                    }
                    Process.setThreadPriority(i8);
                    zzfzVar.run();
                } else {
                    synchronized (this.zzb) {
                        if (this.zzc.peek() == null) {
                            zzgb.zzr(this.zza);
                            try {
                                this.zzb.wait(DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS);
                            } catch (InterruptedException e9) {
                                zzc(e9);
                            }
                        }
                    }
                    obj = this.zza.zzh;
                    synchronized (obj) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            return;
                        }
                    }
                }
            }
        } finally {
            zzb();
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }
}
