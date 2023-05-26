package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import dagger.BindsInstance;
import dagger.Component;
import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import eu.bolt.verification.sdk.internal.rn;

@Component(modules = {g.class, xo.class})
/* loaded from: classes5.dex */
public interface ln extends rn.d {

    @Component.Builder
    /* loaded from: classes5.dex */
    public interface a {
        @BindsInstance
        a a(ViewGroup viewGroup);

        @BindsInstance
        a b(VerificationSDKConfiguration verificationSDKConfiguration);

        ln build();

        @BindsInstance
        a c(co coVar);

        a d(g gVar);
    }
}
