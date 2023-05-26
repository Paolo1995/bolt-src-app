package eu.bolt.verification.sdk.internal;

import androidx.fragment.app.FragmentActivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.rib.RxActivityEvents;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class uf implements Factory<tf> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FragmentActivity> f45353a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<qf> f45354b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<yg> f45355c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<am> f45356d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RxActivityEvents> f45357e;

    public uf(Provider<FragmentActivity> provider, Provider<qf> provider2, Provider<yg> provider3, Provider<am> provider4, Provider<RxActivityEvents> provider5) {
        this.f45353a = provider;
        this.f45354b = provider2;
        this.f45355c = provider3;
        this.f45356d = provider4;
        this.f45357e = provider5;
    }

    public static tf b(FragmentActivity fragmentActivity, qf qfVar, yg ygVar, am amVar, RxActivityEvents rxActivityEvents) {
        return new tf(fragmentActivity, qfVar, ygVar, amVar, rxActivityEvents);
    }

    public static uf c(Provider<FragmentActivity> provider, Provider<qf> provider2, Provider<yg> provider3, Provider<am> provider4, Provider<RxActivityEvents> provider5) {
        return new uf(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public tf get() {
        return b(this.f45353a.get(), this.f45354b.get(), this.f45355c.get(), this.f45356d.get(), this.f45357e.get());
    }
}
