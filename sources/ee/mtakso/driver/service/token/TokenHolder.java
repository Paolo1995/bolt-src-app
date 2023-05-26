package ee.mtakso.driver.service.token;

import ee.mtakso.driver.network.client.auth.anonymous.AccessToken;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TokenHolder.kt */
/* loaded from: classes3.dex */
public final class TokenHolder {

    /* renamed from: a  reason: collision with root package name */
    private final ReentrantLock f26048a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final PublishSubject<Notification<AccessToken>> f26049b;

    /* renamed from: c  reason: collision with root package name */
    private AccessToken f26050c;

    public TokenHolder() {
        PublishSubject<Notification<AccessToken>> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Notification<AccessToken>>()");
        this.f26049b = e8;
    }

    public final void a(Throwable reason) {
        Intrinsics.f(reason, "reason");
        ReentrantLock reentrantLock = this.f26048a;
        reentrantLock.lock();
        try {
            this.f26050c = null;
            Unit unit = Unit.f50853a;
            reentrantLock.unlock();
            this.f26049b.onNext(Notification.b(reason));
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final AccessToken b() {
        ReentrantLock reentrantLock = this.f26048a;
        reentrantLock.lock();
        try {
            return this.f26050c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Observable<Notification<AccessToken>> c() {
        return this.f26049b;
    }

    public final void d(AccessToken token) {
        Intrinsics.f(token, "token");
        ReentrantLock reentrantLock = this.f26048a;
        reentrantLock.lock();
        try {
            this.f26050c = token;
            Unit unit = Unit.f50853a;
            reentrantLock.unlock();
            this.f26049b.onNext(Notification.c(token));
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
