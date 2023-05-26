package androidx.core.os;

/* loaded from: classes.dex */
public final class CancellationSignal {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5797a;

    /* renamed from: b  reason: collision with root package name */
    private OnCancelListener f5798b;

    /* renamed from: c  reason: collision with root package name */
    private Object f5799c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5800d;

    /* loaded from: classes.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static void a(Object obj) {
            ((android.os.CancellationSignal) obj).cancel();
        }

        static android.os.CancellationSignal b() {
            return new android.os.CancellationSignal();
        }
    }

    /* loaded from: classes.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    private void c() {
        while (this.f5800d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f5797a) {
                return;
            }
            this.f5797a = true;
            this.f5800d = true;
            OnCancelListener onCancelListener = this.f5798b;
            Object obj = this.f5799c;
            if (onCancelListener != null) {
                try {
                    onCancelListener.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f5800d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                Api16Impl.a(obj);
            }
            synchronized (this) {
                this.f5800d = false;
                notifyAll();
            }
        }
    }

    public void b(OnCancelListener onCancelListener) {
        synchronized (this) {
            c();
            if (this.f5798b == onCancelListener) {
                return;
            }
            this.f5798b = onCancelListener;
            if (this.f5797a && onCancelListener != null) {
                onCancelListener.onCancel();
            }
        }
    }
}
