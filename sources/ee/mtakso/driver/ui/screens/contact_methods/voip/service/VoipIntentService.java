package ee.mtakso.driver.ui.screens.contact_methods.voip.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.service.voip.VoipService;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipIntentService.kt */
/* loaded from: classes3.dex */
public final class VoipIntentService extends Service {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f28106g = new Companion(null);
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public VoipService f28107f;

    /* compiled from: VoipIntentService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, String action) {
            Intrinsics.f(context, "context");
            Intrinsics.f(action, "action");
            Intent intent = new Intent(context, VoipIntentService.class);
            intent.setAction(action);
            return intent;
        }
    }

    public final VoipService a() {
        VoipService voipService = this.f28107f;
        if (voipService != null) {
            return voipService;
        }
        Intrinsics.w("voipService");
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Injector.f20166d.b().h(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i8, int i9) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (str != null && str.hashCode() == -856671737 && str.equals("decline_call")) {
            a().w();
            stopSelf(i9);
        }
        return super.onStartCommand(intent, i8, i9);
    }
}
