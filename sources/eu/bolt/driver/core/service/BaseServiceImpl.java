package eu.bolt.driver.core.service;

import eu.bolt.kalev.Kalev;
import io.reactivex.disposables.Disposable;

/* compiled from: BaseServiceImpl.kt */
/* loaded from: classes5.dex */
public abstract class BaseServiceImpl implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private Disposable f40936a;

    public abstract Disposable a();

    @Override // eu.bolt.driver.core.service.BaseService
    public boolean start() {
        Disposable disposable = this.f40936a;
        if (disposable != null && !disposable.isDisposed()) {
            Kalev.l("Already running");
            return false;
        }
        this.f40936a = a();
        return true;
    }

    @Override // eu.bolt.driver.core.service.BaseService
    public void stop() {
        Disposable disposable = this.f40936a;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
