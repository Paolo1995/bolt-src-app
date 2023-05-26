package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class FirebaseApp {

    /* renamed from: k  reason: collision with root package name */
    private static final Object f15374k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private static final Executor f15375l = new UiExecutor();

    /* renamed from: m  reason: collision with root package name */
    static final Map<String, FirebaseApp> f15376m = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    private final Context f15377a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15378b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseOptions f15379c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentRuntime f15380d;

    /* renamed from: g  reason: collision with root package name */
    private final Lazy<DataCollectionConfigStorage> f15383g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DefaultHeartBeatController> f15384h;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f15381e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f15382f = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    private final List<BackgroundStateChangeListener> f15385i = new CopyOnWriteArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final List<Object> f15386j = new CopyOnWriteArrayList();

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* loaded from: classes.dex */
    public static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<GlobalBackgroundStateListener> f15387a = new AtomicReference<>();

        private GlobalBackgroundStateListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f15387a.get() == null) {
                    GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                    if (androidx.camera.view.e.a(f15387a, null, globalBackgroundStateListener)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(globalBackgroundStateListener);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z7) {
            synchronized (FirebaseApp.f15374k) {
                Iterator it = new ArrayList(FirebaseApp.f15376m.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.f15381e.get()) {
                        firebaseApp.x(z7);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class UiExecutor implements Executor {

        /* renamed from: f  reason: collision with root package name */
        private static final Handler f15388f = new Handler(Looper.getMainLooper());

        private UiExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            f15388f.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes.dex */
    public static class UserUnlockReceiver extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference<UserUnlockReceiver> f15389b = new AtomicReference<>();

        /* renamed from: a  reason: collision with root package name */
        private final Context f15390a;

        public UserUnlockReceiver(Context context) {
            this.f15390a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f15389b.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                if (androidx.camera.view.e.a(f15389b, null, userUnlockReceiver)) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f15390a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f15374k) {
                for (FirebaseApp firebaseApp : FirebaseApp.f15376m.values()) {
                    firebaseApp.o();
                }
            }
            c();
        }
    }

    protected FirebaseApp(final Context context, String str, FirebaseOptions firebaseOptions) {
        this.f15377a = (Context) Preconditions.checkNotNull(context);
        this.f15378b = Preconditions.checkNotEmpty(str);
        this.f15379c = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        ComponentRuntime e8 = ComponentRuntime.h(f15375l).d(ComponentDiscovery.c(context, ComponentDiscoveryService.class).b()).c(new FirebaseCommonRegistrar()).b(Component.p(context, Context.class, new Class[0])).b(Component.p(this, FirebaseApp.class, new Class[0])).b(Component.p(firebaseOptions, FirebaseOptions.class, new Class[0])).e();
        this.f15380d = e8;
        this.f15383g = new Lazy<>(new Provider() { // from class: com.google.firebase.a
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                DataCollectionConfigStorage u7;
                u7 = FirebaseApp.this.u(context);
                return u7;
            }
        });
        this.f15384h = e8.c(DefaultHeartBeatController.class);
        g(new BackgroundStateChangeListener() { // from class: com.google.firebase.b
            @Override // com.google.firebase.FirebaseApp.BackgroundStateChangeListener
            public final void onBackgroundStateChanged(boolean z7) {
                FirebaseApp.this.v(z7);
            }
        });
    }

    private void h() {
        Preconditions.checkState(!this.f15382f.get(), "FirebaseApp was deleted");
    }

    @NonNull
    public static FirebaseApp k() {
        FirebaseApp firebaseApp;
        synchronized (f15374k) {
            firebaseApp = f15376m.get("[DEFAULT]");
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!UserManagerCompat.a(this.f15377a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + l());
            UserUnlockReceiver.b(this.f15377a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + l());
        this.f15380d.k(t());
        this.f15384h.get().n();
    }

    public static FirebaseApp p(@NonNull Context context) {
        synchronized (f15374k) {
            if (f15376m.containsKey("[DEFAULT]")) {
                return k();
            }
            FirebaseOptions a8 = FirebaseOptions.a(context);
            if (a8 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return q(context, a8);
        }
    }

    @NonNull
    public static FirebaseApp q(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        return r(context, firebaseOptions, "[DEFAULT]");
    }

    @NonNull
    public static FirebaseApp r(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions, @NonNull String str) {
        boolean z7;
        FirebaseApp firebaseApp;
        GlobalBackgroundStateListener.b(context);
        String w7 = w(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f15374k) {
            Map<String, FirebaseApp> map = f15376m;
            if (!map.containsKey(w7)) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkState(z7, "FirebaseApp name " + w7 + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, w7, firebaseOptions);
            map.put(w7, firebaseApp);
        }
        firebaseApp.o();
        return firebaseApp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DataCollectionConfigStorage u(Context context) {
        return new DataCollectionConfigStorage(context, n(), (Publisher) this.f15380d.get(Publisher.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(boolean z7) {
        if (!z7) {
            this.f15384h.get().n();
        }
    }

    private static String w(@NonNull String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z7) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (BackgroundStateChangeListener backgroundStateChangeListener : this.f15385i) {
            backgroundStateChangeListener.onBackgroundStateChanged(z7);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.f15378b.equals(((FirebaseApp) obj).l());
    }

    @KeepForSdk
    public void g(BackgroundStateChangeListener backgroundStateChangeListener) {
        h();
        if (this.f15381e.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.f15385i.add(backgroundStateChangeListener);
    }

    public int hashCode() {
        return this.f15378b.hashCode();
    }

    @KeepForSdk
    public <T> T i(Class<T> cls) {
        h();
        return (T) this.f15380d.get(cls);
    }

    @NonNull
    public Context j() {
        h();
        return this.f15377a;
    }

    @NonNull
    public String l() {
        h();
        return this.f15378b;
    }

    @NonNull
    public FirebaseOptions m() {
        h();
        return this.f15379c;
    }

    @KeepForSdk
    public String n() {
        return Base64Utils.encodeUrlSafeNoPadding(l().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(m().c().getBytes(Charset.defaultCharset()));
    }

    @KeepForSdk
    public boolean s() {
        h();
        return this.f15383g.get().b();
    }

    @KeepForSdk
    public boolean t() {
        return "[DEFAULT]".equals(l());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f15378b).add("options", this.f15379c).toString();
    }
}
