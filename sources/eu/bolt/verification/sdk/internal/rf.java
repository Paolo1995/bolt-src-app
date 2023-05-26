package eu.bolt.verification.sdk.internal;

import com.tbruyelle.rxpermissions2.RxPermissions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class rf implements Factory<qf> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RxPermissions> f44811a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<xg> f44812b;

    public rf(Provider<RxPermissions> provider, Provider<xg> provider2) {
        this.f44811a = provider;
        this.f44812b = provider2;
    }

    public static qf b(RxPermissions rxPermissions, xg xgVar) {
        return new qf(rxPermissions, xgVar);
    }

    public static rf c(Provider<RxPermissions> provider, Provider<xg> provider2) {
        return new rf(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public qf get() {
        return b(this.f44811a.get(), this.f44812b.get());
    }
}
