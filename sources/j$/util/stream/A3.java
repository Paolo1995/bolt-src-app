package j$.util.stream;

/* loaded from: classes2.dex */
final class A3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f50367a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f50368b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A3(Runnable runnable, Runnable runnable2) {
        this.f50367a = runnable;
        this.f50368b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f50367a.run();
            this.f50368b.run();
        } catch (Throwable th) {
            try {
                this.f50368b.run();
            } catch (Throwable th2) {
                try {
                    th.addSuppressed(th2);
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
