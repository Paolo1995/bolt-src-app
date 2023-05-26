package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.annotation.NonNull;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f16258f = new ThreadFactory() { // from class: com.google.firebase.heartbeatinfo.a
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread m8;
            m8 = DefaultHeartBeatController.m(runnable);
            return m8;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeartBeatInfoStorage> f16259a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f16260b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserAgentPublisher> f16261c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<HeartBeatConsumer> f16262d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f16263e;

    private DefaultHeartBeatController(final Context context, final String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider) {
        this(new Provider() { // from class: com.google.firebase.heartbeatinfo.e
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                HeartBeatInfoStorage k8;
                k8 = DefaultHeartBeatController.k(context, str);
                return k8;
            }
        }, set, new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f16258f), provider, context);
    }

    @NonNull
    public static Component<DefaultHeartBeatController> h() {
        return Component.d(DefaultHeartBeatController.class, HeartBeatController.class, HeartBeatInfo.class).b(Dependency.j(Context.class)).b(Dependency.j(FirebaseApp.class)).b(Dependency.l(HeartBeatConsumer.class)).b(Dependency.k(UserAgentPublisher.class)).f(new ComponentFactory() { // from class: com.google.firebase.heartbeatinfo.d
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                DefaultHeartBeatController i8;
                i8 = DefaultHeartBeatController.i(componentContainer);
                return i8;
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DefaultHeartBeatController i(ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).n(), componentContainer.b(HeartBeatConsumer.class), componentContainer.c(UserAgentPublisher.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String j() throws Exception {
        String byteArrayOutputStream;
        synchronized (this) {
            HeartBeatInfoStorage heartBeatInfoStorage = this.f16259a.get();
            List<HeartBeatResult> c8 = heartBeatInfoStorage.c();
            heartBeatInfoStorage.b();
            JSONArray jSONArray = new JSONArray();
            for (int i8 = 0; i8 < c8.size(); i8++) {
                HeartBeatResult heartBeatResult = c8.get(i8);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", heartBeatResult.c());
                jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.b()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
            try {
                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return byteArrayOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HeartBeatInfoStorage k(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void l() throws Exception {
        synchronized (this) {
            this.f16259a.get().k(System.currentTimeMillis(), this.f16261c.get().a());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread m(Runnable runnable) {
        return new Thread(runnable, "heartbeat-information-executor");
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    public Task<String> a() {
        if (!UserManagerCompat.a(this.f16260b)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.f16263e, new Callable() { // from class: com.google.firebase.heartbeatinfo.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String j8;
                j8 = DefaultHeartBeatController.this.j();
                return j8;
            }
        });
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    @NonNull
    public synchronized HeartBeatInfo.HeartBeat b(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = this.f16259a.get();
        if (heartBeatInfoStorage.i(currentTimeMillis)) {
            heartBeatInfoStorage.g();
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    public Task<Void> n() {
        if (this.f16262d.size() <= 0) {
            return Tasks.forResult(null);
        }
        if (!UserManagerCompat.a(this.f16260b)) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.f16263e, new Callable() { // from class: com.google.firebase.heartbeatinfo.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void l8;
                l8 = DefaultHeartBeatController.this.l();
                return l8;
            }
        });
    }

    DefaultHeartBeatController(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        this.f16259a = provider;
        this.f16262d = set;
        this.f16263e = executor;
        this.f16261c = provider2;
        this.f16260b = context;
    }
}
