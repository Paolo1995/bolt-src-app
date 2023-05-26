package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import dagger.Module;
import dagger.Provides;
import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
/* loaded from: classes5.dex */
public abstract class xo {

    /* renamed from: a  reason: collision with root package name */
    public static final a f45688a = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Provides
        public final VerificationAnalyticsManager a(VerificationSDKConfiguration configuration) {
            Intrinsics.f(configuration, "configuration");
            return configuration.m();
        }

        @Provides
        public final ib b(FragmentActivity activity) {
            Intrinsics.f(activity, "activity");
            return new ib(activity);
        }

        @Provides
        public final ke c(le compat, ne helperMarshmallow) {
            Intrinsics.f(compat, "compat");
            Intrinsics.f(helperMarshmallow, "helperMarshmallow");
            return Build.VERSION.SDK_INT >= 23 ? helperMarshmallow : compat;
        }

        @Provides
        public final kn d(v1 mapper, VerificationSDKConfiguration configuration) {
            Intrinsics.f(mapper, "mapper");
            Intrinsics.f(configuration, "configuration");
            return mapper.a(configuration.d());
        }

        @Provides
        public final s e(VerificationAnalyticsManager analyticsManager) {
            Intrinsics.f(analyticsManager, "analyticsManager");
            return new t(new r(), new v(), analyticsManager);
        }

        @Provides
        public final yg f(Context context) {
            Intrinsics.f(context, "context");
            yg e8 = yg.e(bf.f42318a.a(context, "_verification_preferences"));
            Intrinsics.e(e8, "create(PreferencesCreato…ntext, DEFAULT_PREF_KEY))");
            return e8;
        }

        @Provides
        public final RxPermissions g(FragmentActivity activity) {
            Intrinsics.f(activity, "activity");
            return new RxPermissions(activity);
        }

        @Provides
        public final y h(VerificationSDKConfiguration configuration) {
            Intrinsics.f(configuration, "configuration");
            Retrofit.Builder retrofitBuilder = configuration.g().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            String e8 = configuration.e();
            Intrinsics.e(retrofitBuilder, "retrofitBuilder");
            return new y(e8, retrofitBuilder);
        }

        @Provides
        public final f0 i(VerificationSDKConfiguration configuration) {
            Intrinsics.f(configuration, "configuration");
            Retrofit.Builder retrofitBuilder = configuration.g().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            String e8 = configuration.e();
            Intrinsics.e(retrofitBuilder, "retrofitBuilder");
            return new f0(e8, retrofitBuilder);
        }

        @Provides
        public final jr j(VerificationSDKConfiguration configuration) {
            Intrinsics.f(configuration, "configuration");
            return new kr(configuration.h(), configuration.f(), configuration.i(), configuration.j(), configuration.c(), configuration.k());
        }
    }

    @Provides
    public static final VerificationAnalyticsManager a(VerificationSDKConfiguration verificationSDKConfiguration) {
        return f45688a.a(verificationSDKConfiguration);
    }

    @Provides
    public static final ib b(FragmentActivity fragmentActivity) {
        return f45688a.b(fragmentActivity);
    }

    @Provides
    public static final ke c(le leVar, ne neVar) {
        return f45688a.c(leVar, neVar);
    }

    @Provides
    public static final kn d(v1 v1Var, VerificationSDKConfiguration verificationSDKConfiguration) {
        return f45688a.d(v1Var, verificationSDKConfiguration);
    }

    @Provides
    public static final s e(VerificationAnalyticsManager verificationAnalyticsManager) {
        return f45688a.e(verificationAnalyticsManager);
    }

    @Provides
    public static final yg f(Context context) {
        return f45688a.f(context);
    }

    @Provides
    public static final RxPermissions g(FragmentActivity fragmentActivity) {
        return f45688a.g(fragmentActivity);
    }

    @Provides
    public static final y h(VerificationSDKConfiguration verificationSDKConfiguration) {
        return f45688a.h(verificationSDKConfiguration);
    }

    @Provides
    public static final f0 i(VerificationSDKConfiguration verificationSDKConfiguration) {
        return f45688a.i(verificationSDKConfiguration);
    }

    @Provides
    public static final jr j(VerificationSDKConfiguration verificationSDKConfiguration) {
        return f45688a.j(verificationSDKConfiguration);
    }
}
