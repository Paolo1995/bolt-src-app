package ee.mtakso.driver.service;

import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.disposables.Disposable;

/* compiled from: BaseServiceImpl.kt */
/* loaded from: classes3.dex */
public abstract class BaseServiceImpl implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private Disposable f23402a;

    public abstract Disposable e();

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        if (!DisposableExtKt.b(this.f23402a)) {
            Kalev.l("Already running");
            return false;
        }
        this.f23402a = e();
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        Disposable disposable = this.f23402a;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
