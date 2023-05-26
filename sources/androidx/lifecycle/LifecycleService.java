package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {

    /* renamed from: f  reason: collision with root package name */
    private final ServiceLifecycleDispatcher f6690f = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f6690f.a();
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        this.f6690f.b();
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f6690f.c();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f6690f.d();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(@NonNull Intent intent, int i8) {
        this.f6690f.e();
        super.onStart(intent, i8);
    }

    @Override // android.app.Service
    public int onStartCommand(@NonNull Intent intent, int i8, int i9) {
        return super.onStartCommand(intent, i8, i9);
    }
}
