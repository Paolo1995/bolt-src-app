package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class FirebaseInstallations implements FirebaseInstallationsApi {

    /* renamed from: m  reason: collision with root package name */
    private static final Object f16352m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private static final ThreadFactory f16353n = new ThreadFactory() { // from class: com.google.firebase.installations.FirebaseInstallations.1

        /* renamed from: f  reason: collision with root package name */
        private final AtomicInteger f16366f = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f16366f.getAndIncrement())));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f16354a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseInstallationServiceClient f16355b;

    /* renamed from: c  reason: collision with root package name */
    private final PersistedInstallation f16356c;

    /* renamed from: d  reason: collision with root package name */
    private final Utils f16357d;

    /* renamed from: e  reason: collision with root package name */
    private final IidStore f16358e;

    /* renamed from: f  reason: collision with root package name */
    private final RandomFidGenerator f16359f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f16360g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f16361h;

    /* renamed from: i  reason: collision with root package name */
    private final ExecutorService f16362i;

    /* renamed from: j  reason: collision with root package name */
    private String f16363j;

    /* renamed from: k  reason: collision with root package name */
    private Set<FidListener> f16364k;

    /* renamed from: l  reason: collision with root package name */
    private final List<StateListener> f16365l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.installations.FirebaseInstallations$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16367a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16368b;

        static {
            int[] iArr = new int[TokenResult.ResponseCode.values().length];
            f16368b = iArr;
            try {
                iArr[TokenResult.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16368b[TokenResult.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16368b[TokenResult.ResponseCode.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[InstallationResponse.ResponseCode.values().length];
            f16367a = iArr2;
            try {
                iArr2[InstallationResponse.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16367a[InstallationResponse.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstallations(FirebaseApp firebaseApp, @NonNull Provider<HeartBeatController> provider) {
        this(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f16353n), firebaseApp, new FirebaseInstallationServiceClient(firebaseApp.j(), provider), new PersistedInstallation(firebaseApp), Utils.c(), new IidStore(firebaseApp), new RandomFidGenerator());
    }

    private void A(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.f16360g) {
            Iterator<StateListener> it = this.f16365l.iterator();
            while (it.hasNext()) {
                if (it.next().b(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }

    private synchronized void B(String str) {
        this.f16363j = str;
    }

    private synchronized void C(PersistedInstallationEntry persistedInstallationEntry, PersistedInstallationEntry persistedInstallationEntry2) {
        if (this.f16364k.size() != 0 && !persistedInstallationEntry.d().equals(persistedInstallationEntry2.d())) {
            for (FidListener fidListener : this.f16364k) {
                fidListener.a(persistedInstallationEntry2.d());
            }
        }
    }

    private Task<InstallationTokenResult> e() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        g(new GetAuthTokenListener(this.f16357d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<String> f() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        g(new GetIdListener(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private void g(StateListener stateListener) {
        synchronized (this.f16360g) {
            this.f16365l.add(stateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void t(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.p()
            boolean r1 = r0.i()     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            if (r1 != 0) goto L22
            boolean r1 = r0.l()     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            if (r1 == 0) goto L11
            goto L22
        L11:
            if (r3 != 0) goto L1d
            com.google.firebase.installations.Utils r3 = r2.f16357d     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            boolean r3 = r3.f(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            return
        L1d:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.j(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            goto L26
        L22:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.y(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
        L26:
            r2.s(r3)
            r2.C(r0, r3)
            boolean r0 = r3.k()
            if (r0 == 0) goto L39
            java.lang.String r0 = r3.d()
            r2.B(r0)
        L39:
            boolean r0 = r3.i()
            if (r0 == 0) goto L4a
            com.google.firebase.installations.FirebaseInstallationsException r3 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r0 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r3.<init>(r0)
            r2.z(r3)
            goto L5e
        L4a:
            boolean r0 = r3.j()
            if (r0 == 0) goto L5b
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            r2.z(r3)
            goto L5e
        L5b:
            r2.A(r3)
        L5e:
            return
        L5f:
            r3 = move-exception
            r2.z(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.t(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public final void v(final boolean z7) {
        PersistedInstallationEntry q8 = q();
        if (z7) {
            q8 = q8.p();
        }
        A(q8);
        this.f16362i.execute(new Runnable() { // from class: com.google.firebase.installations.c
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseInstallations.this.t(z7);
            }
        });
    }

    private PersistedInstallationEntry j(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        TokenResult e8 = this.f16355b.e(k(), persistedInstallationEntry.d(), r(), persistedInstallationEntry.f());
        int i8 = AnonymousClass3.f16368b[e8.b().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    B(null);
                    return persistedInstallationEntry.r();
                }
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
            }
            return persistedInstallationEntry.q("BAD CONFIG");
        }
        return persistedInstallationEntry.o(e8.c(), e8.d(), this.f16357d.b());
    }

    private synchronized String m() {
        return this.f16363j;
    }

    @NonNull
    public static FirebaseInstallations n() {
        return o(FirebaseApp.k());
    }

    @NonNull
    public static FirebaseInstallations o(@NonNull FirebaseApp firebaseApp) {
        boolean z7;
        if (firebaseApp != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp.i(FirebaseInstallationsApi.class);
    }

    private PersistedInstallationEntry p() {
        PersistedInstallationEntry d8;
        synchronized (f16352m) {
            CrossProcessLock a8 = CrossProcessLock.a(this.f16354a.j(), "generatefid.lock");
            d8 = this.f16356c.d();
            if (a8 != null) {
                a8.b();
            }
        }
        return d8;
    }

    private PersistedInstallationEntry q() {
        PersistedInstallationEntry d8;
        synchronized (f16352m) {
            CrossProcessLock a8 = CrossProcessLock.a(this.f16354a.j(), "generatefid.lock");
            d8 = this.f16356c.d();
            if (d8.j()) {
                d8 = this.f16356c.b(d8.t(x(d8)));
            }
            if (a8 != null) {
                a8.b();
            }
        }
        return d8;
    }

    private void s(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (f16352m) {
            CrossProcessLock a8 = CrossProcessLock.a(this.f16354a.j(), "generatefid.lock");
            this.f16356c.b(persistedInstallationEntry);
            if (a8 != null) {
                a8.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        v(false);
    }

    private void w() {
        Preconditions.checkNotEmpty(l(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(r(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(k(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.h(l()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.g(k()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String x(PersistedInstallationEntry persistedInstallationEntry) {
        if ((!this.f16354a.l().equals("CHIME_ANDROID_SDK") && !this.f16354a.t()) || !persistedInstallationEntry.m()) {
            return this.f16359f.a();
        }
        String f8 = this.f16358e.f();
        if (TextUtils.isEmpty(f8)) {
            return this.f16359f.a();
        }
        return f8;
    }

    private PersistedInstallationEntry y(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        String str;
        if (persistedInstallationEntry.d() != null && persistedInstallationEntry.d().length() == 11) {
            str = this.f16358e.i();
        } else {
            str = null;
        }
        InstallationResponse d8 = this.f16355b.d(k(), persistedInstallationEntry.d(), r(), l(), str);
        int i8 = AnonymousClass3.f16367a[d8.e().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return persistedInstallationEntry.q("BAD CONFIG");
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        return persistedInstallationEntry.s(d8.c(), d8.d(), this.f16357d.b(), d8.b().c(), d8.b().d());
    }

    private void z(Exception exc) {
        synchronized (this.f16360g) {
            Iterator<StateListener> it = this.f16365l.iterator();
            while (it.hasNext()) {
                if (it.next().a(exc)) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<InstallationTokenResult> a(final boolean z7) {
        w();
        Task<InstallationTokenResult> e8 = e();
        this.f16361h.execute(new Runnable() { // from class: com.google.firebase.installations.a
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseInstallations.this.v(z7);
            }
        });
        return e8;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<String> getId() {
        w();
        String m8 = m();
        if (m8 != null) {
            return Tasks.forResult(m8);
        }
        Task<String> f8 = f();
        this.f16361h.execute(new Runnable() { // from class: com.google.firebase.installations.b
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseInstallations.this.u();
            }
        });
        return f8;
    }

    String k() {
        return this.f16354a.m().b();
    }

    String l() {
        return this.f16354a.m().c();
    }

    String r() {
        return this.f16354a.m().e();
    }

    FirebaseInstallations(ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationServiceClient firebaseInstallationServiceClient, PersistedInstallation persistedInstallation, Utils utils, IidStore iidStore, RandomFidGenerator randomFidGenerator) {
        this.f16360g = new Object();
        this.f16364k = new HashSet();
        this.f16365l = new ArrayList();
        this.f16354a = firebaseApp;
        this.f16355b = firebaseInstallationServiceClient;
        this.f16356c = persistedInstallation;
        this.f16357d = utils;
        this.f16358e = iidStore;
        this.f16359f = randomFidGenerator;
        this.f16361h = executorService;
        this.f16362i = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f16353n);
    }
}
