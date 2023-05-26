package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: f  reason: collision with root package name */
    int f7516f = 0;

    /* renamed from: g  reason: collision with root package name */
    final HashMap<Integer, String> f7517g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> f7518h = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        /* renamed from: a */
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.f7517g.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final IMultiInstanceInvalidationService.Stub f7519i = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService.2
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void l(int i8, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f7518h) {
                String str = MultiInstanceInvalidationService.this.f7517g.get(Integer.valueOf(i8));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f7518h.beginBroadcast();
                for (int i9 = 0; i9 < beginBroadcast; i9++) {
                    int intValue = ((Integer) MultiInstanceInvalidationService.this.f7518h.getBroadcastCookie(i9)).intValue();
                    String str2 = MultiInstanceInvalidationService.this.f7517g.get(Integer.valueOf(intValue));
                    if (i8 != intValue && str.equals(str2)) {
                        try {
                            MultiInstanceInvalidationService.this.f7518h.getBroadcastItem(i9).b(strArr);
                        } catch (RemoteException e8) {
                            Log.w("ROOM", "Error invoking a remote callback", e8);
                        }
                    }
                }
                MultiInstanceInvalidationService.this.f7518h.finishBroadcast();
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int n(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f7518h) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i8 = multiInstanceInvalidationService.f7516f + 1;
                multiInstanceInvalidationService.f7516f = i8;
                if (multiInstanceInvalidationService.f7518h.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i8))) {
                    MultiInstanceInvalidationService.this.f7517g.put(Integer.valueOf(i8), str);
                    return i8;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f7516f--;
                return 0;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void x(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i8) {
            synchronized (MultiInstanceInvalidationService.this.f7518h) {
                MultiInstanceInvalidationService.this.f7518h.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.f7517g.remove(Integer.valueOf(i8));
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        return this.f7519i;
    }
}
