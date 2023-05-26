package eu.bolt.verification.sdk.internal;

import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class s8 {

    /* renamed from: a  reason: collision with root package name */
    private final ub f44973a;

    /* renamed from: b  reason: collision with root package name */
    private final xg f44974b;

    @Inject
    public s8(ub localeRepository, xg rxSchedulers) {
        Intrinsics.f(localeRepository, "localeRepository");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        this.f44973a = localeRepository;
        this.f44974b = rxSchedulers;
    }

    public Observable<rg> a() {
        Observable<rg> distinctUntilChanged = this.f44973a.a().observeOn(this.f44974b.b()).distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "localeRepository.observe…  .distinctUntilChanged()");
        return distinctUntilChanged;
    }
}
