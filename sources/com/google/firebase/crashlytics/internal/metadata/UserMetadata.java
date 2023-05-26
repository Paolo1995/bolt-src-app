package com.google.firebase.crashlytics.internal.metadata;

import androidx.camera.view.e;
import androidx.fragment.app.FragmentTransaction;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import j$.util.Spliterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class UserMetadata {

    /* renamed from: a  reason: collision with root package name */
    private final MetaDataStore f15766a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsBackgroundWorker f15767b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15768c;

    /* renamed from: d  reason: collision with root package name */
    private final SerializeableKeysMap f15769d = new SerializeableKeysMap(false);

    /* renamed from: e  reason: collision with root package name */
    private final SerializeableKeysMap f15770e = new SerializeableKeysMap(true);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicMarkableReference<String> f15771f = new AtomicMarkableReference<>(null, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class SerializeableKeysMap {

        /* renamed from: a  reason: collision with root package name */
        final AtomicMarkableReference<KeysMap> f15772a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference<Callable<Void>> f15773b = new AtomicReference<>(null);

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15774c;

        public SerializeableKeysMap(boolean z7) {
            int i8;
            this.f15774c = z7;
            if (z7) {
                i8 = FragmentTransaction.TRANSIT_EXIT_MASK;
            } else {
                i8 = Spliterator.IMMUTABLE;
            }
            this.f15772a = new AtomicMarkableReference<>(new KeysMap(64, i8), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Void c() throws Exception {
            this.f15773b.set(null);
            e();
            return null;
        }

        private void d() {
            Callable callable = new Callable() { // from class: com.google.firebase.crashlytics.internal.metadata.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void c8;
                    c8 = UserMetadata.SerializeableKeysMap.this.c();
                    return c8;
                }
            };
            if (e.a(this.f15773b, null, callable)) {
                UserMetadata.this.f15767b.h(callable);
            }
        }

        private void e() {
            Map<String, String> map;
            synchronized (this) {
                if (this.f15772a.isMarked()) {
                    map = this.f15772a.getReference().a();
                    AtomicMarkableReference<KeysMap> atomicMarkableReference = this.f15772a;
                    atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                } else {
                    map = null;
                }
            }
            if (map != null) {
                UserMetadata.this.f15766a.l(UserMetadata.this.f15768c, map, this.f15774c);
            }
        }

        public Map<String, String> b() {
            return this.f15772a.getReference().a();
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                if (!this.f15772a.getReference().d(str, str2)) {
                    return false;
                }
                AtomicMarkableReference<KeysMap> atomicMarkableReference = this.f15772a;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                d();
                return true;
            }
        }
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        this.f15768c = str;
        this.f15766a = new MetaDataStore(fileStore);
        this.f15767b = crashlyticsBackgroundWorker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object h() throws Exception {
        k();
        return null;
    }

    public static UserMetadata i(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        MetaDataStore metaDataStore = new MetaDataStore(fileStore);
        UserMetadata userMetadata = new UserMetadata(str, fileStore, crashlyticsBackgroundWorker);
        userMetadata.f15769d.f15772a.getReference().e(metaDataStore.g(str, false));
        userMetadata.f15770e.f15772a.getReference().e(metaDataStore.g(str, true));
        userMetadata.f15771f.set(metaDataStore.h(str), false);
        return userMetadata;
    }

    public static String j(String str, FileStore fileStore) {
        return new MetaDataStore(fileStore).h(str);
    }

    private void k() {
        boolean z7;
        String str;
        synchronized (this.f15771f) {
            z7 = false;
            if (this.f15771f.isMarked()) {
                str = g();
                this.f15771f.set(str, false);
                z7 = true;
            } else {
                str = null;
            }
        }
        if (z7) {
            this.f15766a.m(this.f15768c, str);
        }
    }

    public Map<String, String> e() {
        return this.f15769d.b();
    }

    public Map<String, String> f() {
        return this.f15770e.b();
    }

    public String g() {
        return this.f15771f.getReference();
    }

    public boolean l(String str, String str2) {
        return this.f15769d.f(str, str2);
    }

    public void m(String str) {
        String c8 = KeysMap.c(str, Spliterator.IMMUTABLE);
        synchronized (this.f15771f) {
            if (CommonUtils.A(c8, this.f15771f.getReference())) {
                return;
            }
            this.f15771f.set(c8, true);
            this.f15767b.h(new Callable() { // from class: z.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object h8;
                    h8 = UserMetadata.this.h();
                    return h8;
                }
            });
        }
    }
}
