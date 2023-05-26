package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MultiInstanceInvalidationClient {

    /* renamed from: a  reason: collision with root package name */
    final Context f7497a;

    /* renamed from: b  reason: collision with root package name */
    final String f7498b;

    /* renamed from: c  reason: collision with root package name */
    int f7499c;

    /* renamed from: d  reason: collision with root package name */
    final InvalidationTracker f7500d;

    /* renamed from: e  reason: collision with root package name */
    final InvalidationTracker.Observer f7501e;

    /* renamed from: f  reason: collision with root package name */
    IMultiInstanceInvalidationService f7502f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f7503g;

    /* renamed from: h  reason: collision with root package name */
    final IMultiInstanceInvalidationCallback f7504h = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient.1
        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void b(final String[] strArr) {
            MultiInstanceInvalidationClient.this.f7503g.execute(new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.1.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiInstanceInvalidationClient.this.f7500d.f(strArr);
                }
            });
        }
    };

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f7505i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    final ServiceConnection f7506j;

    /* renamed from: k  reason: collision with root package name */
    final Runnable f7507k;

    /* renamed from: l  reason: collision with root package name */
    final Runnable f7508l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiInstanceInvalidationClient(Context context, String str, Intent intent, InvalidationTracker invalidationTracker, Executor executor) {
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MultiInstanceInvalidationClient.this.f7502f = IMultiInstanceInvalidationService.Stub.y(iBinder);
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f7503g.execute(multiInstanceInvalidationClient.f7507k);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f7503g.execute(multiInstanceInvalidationClient.f7508l);
                MultiInstanceInvalidationClient.this.f7502f = null;
            }
        };
        this.f7506j = serviceConnection;
        this.f7507k = new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.f7502f;
                    if (iMultiInstanceInvalidationService != null) {
                        multiInstanceInvalidationClient.f7499c = iMultiInstanceInvalidationService.n(multiInstanceInvalidationClient.f7504h, multiInstanceInvalidationClient.f7498b);
                        MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                        multiInstanceInvalidationClient2.f7500d.a(multiInstanceInvalidationClient2.f7501e);
                    }
                } catch (RemoteException e8) {
                    Log.w("ROOM", "Cannot register multi-instance invalidation callback", e8);
                }
            }
        };
        this.f7508l = new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.4
            @Override // java.lang.Runnable
            public void run() {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.f7500d.i(multiInstanceInvalidationClient.f7501e);
            }
        };
        Context applicationContext = context.getApplicationContext();
        this.f7497a = applicationContext;
        this.f7498b = str;
        this.f7500d = invalidationTracker;
        this.f7503g = executor;
        this.f7501e = new InvalidationTracker.Observer((String[]) invalidationTracker.f7473a.keySet().toArray(new String[0])) { // from class: androidx.room.MultiInstanceInvalidationClient.5
            @Override // androidx.room.InvalidationTracker.Observer
            boolean a() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void b(@NonNull Set<String> set) {
                if (MultiInstanceInvalidationClient.this.f7505i.get()) {
                    return;
                }
                try {
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.f7502f;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.l(multiInstanceInvalidationClient.f7499c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException e8) {
                    Log.w("ROOM", "Cannot broadcast invalidation", e8);
                }
            }
        };
        applicationContext.bindService(intent, serviceConnection, 1);
    }
}
