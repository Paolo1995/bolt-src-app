package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class SnackbarManager {

    /* renamed from: e  reason: collision with root package name */
    private static SnackbarManager f14200e;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Object f14201a = new Object();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f14202b = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.d((SnackbarRecord) message.obj);
            return true;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private SnackbarRecord f14203c;

    /* renamed from: d  reason: collision with root package name */
    private SnackbarRecord f14204d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        void a(int i8);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SnackbarRecord {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<Callback> f14206a;

        /* renamed from: b  reason: collision with root package name */
        int f14207b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14208c;

        SnackbarRecord(int i8, Callback callback) {
            this.f14206a = new WeakReference<>(callback);
            this.f14207b = i8;
        }

        boolean a(Callback callback) {
            if (callback != null && this.f14206a.get() == callback) {
                return true;
            }
            return false;
        }
    }

    private SnackbarManager() {
    }

    private boolean a(@NonNull SnackbarRecord snackbarRecord, int i8) {
        Callback callback = snackbarRecord.f14206a.get();
        if (callback != null) {
            this.f14202b.removeCallbacksAndMessages(snackbarRecord);
            callback.a(i8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SnackbarManager c() {
        if (f14200e == null) {
            f14200e = new SnackbarManager();
        }
        return f14200e;
    }

    private boolean g(Callback callback) {
        SnackbarRecord snackbarRecord = this.f14203c;
        if (snackbarRecord != null && snackbarRecord.a(callback)) {
            return true;
        }
        return false;
    }

    private boolean h(Callback callback) {
        SnackbarRecord snackbarRecord = this.f14204d;
        if (snackbarRecord != null && snackbarRecord.a(callback)) {
            return true;
        }
        return false;
    }

    private void m(@NonNull SnackbarRecord snackbarRecord) {
        int i8 = snackbarRecord.f14207b;
        if (i8 == -2) {
            return;
        }
        if (i8 <= 0) {
            if (i8 == -1) {
                i8 = 1500;
            } else {
                i8 = 2750;
            }
        }
        this.f14202b.removeCallbacksAndMessages(snackbarRecord);
        Handler handler = this.f14202b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i8);
    }

    private void o() {
        SnackbarRecord snackbarRecord = this.f14204d;
        if (snackbarRecord != null) {
            this.f14203c = snackbarRecord;
            this.f14204d = null;
            Callback callback = snackbarRecord.f14206a.get();
            if (callback != null) {
                callback.b();
            } else {
                this.f14203c = null;
            }
        }
    }

    public void b(Callback callback, int i8) {
        synchronized (this.f14201a) {
            if (g(callback)) {
                a(this.f14203c, i8);
            } else if (h(callback)) {
                a(this.f14204d, i8);
            }
        }
    }

    void d(@NonNull SnackbarRecord snackbarRecord) {
        synchronized (this.f14201a) {
            if (this.f14203c == snackbarRecord || this.f14204d == snackbarRecord) {
                a(snackbarRecord, 2);
            }
        }
    }

    public boolean e(Callback callback) {
        boolean g8;
        synchronized (this.f14201a) {
            g8 = g(callback);
        }
        return g8;
    }

    public boolean f(Callback callback) {
        boolean z7;
        synchronized (this.f14201a) {
            if (!g(callback) && !h(callback)) {
                z7 = false;
            }
            z7 = true;
        }
        return z7;
    }

    public void i(Callback callback) {
        synchronized (this.f14201a) {
            if (g(callback)) {
                this.f14203c = null;
                if (this.f14204d != null) {
                    o();
                }
            }
        }
    }

    public void j(Callback callback) {
        synchronized (this.f14201a) {
            if (g(callback)) {
                m(this.f14203c);
            }
        }
    }

    public void k(Callback callback) {
        synchronized (this.f14201a) {
            if (g(callback)) {
                SnackbarRecord snackbarRecord = this.f14203c;
                if (!snackbarRecord.f14208c) {
                    snackbarRecord.f14208c = true;
                    this.f14202b.removeCallbacksAndMessages(snackbarRecord);
                }
            }
        }
    }

    public void l(Callback callback) {
        synchronized (this.f14201a) {
            if (g(callback)) {
                SnackbarRecord snackbarRecord = this.f14203c;
                if (snackbarRecord.f14208c) {
                    snackbarRecord.f14208c = false;
                    m(snackbarRecord);
                }
            }
        }
    }

    public void n(int i8, Callback callback) {
        synchronized (this.f14201a) {
            if (g(callback)) {
                SnackbarRecord snackbarRecord = this.f14203c;
                snackbarRecord.f14207b = i8;
                this.f14202b.removeCallbacksAndMessages(snackbarRecord);
                m(this.f14203c);
                return;
            }
            if (h(callback)) {
                this.f14204d.f14207b = i8;
            } else {
                this.f14204d = new SnackbarRecord(i8, callback);
            }
            SnackbarRecord snackbarRecord2 = this.f14203c;
            if (snackbarRecord2 != null && a(snackbarRecord2, 4)) {
                return;
            }
            this.f14203c = null;
            o();
        }
    }
}
