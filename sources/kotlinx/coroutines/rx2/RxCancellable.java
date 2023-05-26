package kotlinx.coroutines.rx2;

import io.reactivex.functions.Cancellable;
import kotlinx.coroutines.Job;

/* compiled from: RxCancellable.kt */
/* loaded from: classes5.dex */
public final class RxCancellable implements Cancellable {

    /* renamed from: a  reason: collision with root package name */
    private final Job f51901a;

    public RxCancellable(Job job) {
        this.f51901a = job;
    }

    @Override // io.reactivex.functions.Cancellable
    public void cancel() {
        Job.DefaultImpls.a(this.f51901a, null, 1, null);
    }
}
