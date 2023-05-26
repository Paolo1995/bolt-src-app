package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import dagger.Module;
import dagger.Provides;
import eu.bolt.android.rib.RibActivity;
import eu.bolt.coroutines.dispatchers.DispatchersBundle;
import eu.bolt.coroutines.dispatchers.DispatchersBundleImpl;
import eu.bolt.verification.sdk.VerificationSDKActivity;
import kotlin.jvm.internal.Intrinsics;

@Module
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final VerificationSDKActivity f43069a;

    public g(VerificationSDKActivity activity) {
        Intrinsics.f(activity, "activity");
        this.f43069a = activity;
    }

    @Provides
    public final v4 a() {
        return y4.f45720a.a();
    }

    @Provides
    public final DispatchersBundle b() {
        return new DispatchersBundleImpl(null, null, null, null, null, 31, null);
    }

    @Provides
    public final Activity c() {
        return this.f43069a;
    }

    @Provides
    public final FragmentActivity d() {
        return this.f43069a;
    }

    @Provides
    public final RibActivity e() {
        return this.f43069a;
    }

    @Provides
    public final VerificationSDKActivity f() {
        return this.f43069a;
    }
}
