package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.android.gms.common.Scopes;
import dagger.Lazy;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.ServerResponseKt;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultRequest;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.code.Native;
import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import eu.bolt.driver.core.time.SystemUptimeSource;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnonymousAuthClient.kt */
/* loaded from: classes3.dex */
public final class AnonymousAuthClient {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceInfo f21428a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy<AnonymousAuthApi> f21429b;

    /* renamed from: c  reason: collision with root package name */
    private final CompositeResponseTransformer f21430c;

    /* renamed from: d  reason: collision with root package name */
    private final SystemUptimeSource f21431d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverAuthAnonymousApi f21432e;

    /* renamed from: f  reason: collision with root package name */
    private final StoreIntegrityVerificationResultToRequestMapper f21433f;

    /* compiled from: AnonymousAuthClient.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21434a;

        static {
            int[] iArr = new int[VerificationChannel.values().length];
            try {
                iArr[VerificationChannel.SMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationChannel.CALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationChannel.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VerificationChannel.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f21434a = iArr;
        }
    }

    @Inject
    public AnonymousAuthClient(DeviceInfo deviceInfo, Lazy<AnonymousAuthApi> anonymousApi, CompositeResponseTransformer transformer, SystemUptimeSource timeSource, DriverAuthAnonymousApi driverAuthApi, StoreIntegrityVerificationResultToRequestMapper storeVerificationResultMapper) {
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(anonymousApi, "anonymousApi");
        Intrinsics.f(transformer, "transformer");
        Intrinsics.f(timeSource, "timeSource");
        Intrinsics.f(driverAuthApi, "driverAuthApi");
        Intrinsics.f(storeVerificationResultMapper, "storeVerificationResultMapper");
        this.f21428a = deviceInfo;
        this.f21429b = anonymousApi;
        this.f21430c = transformer;
        this.f21431d = timeSource;
        this.f21432e = driverAuthApi;
        this.f21433f = storeVerificationResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthConfigurationResponse B(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthConfigurationResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccessToken D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AccessToken) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TargetingParameters F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (TargetingParameters) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VerificationCode H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (VerificationCode) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VerificationCode J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (VerificationCode) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VerificationCode M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (VerificationCode) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RefreshToken o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (RefreshToken) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthResult q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthResult) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RefreshToken t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (RefreshToken) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthResult.Success v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthResult.Success) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConfirmAuthenticationResponse x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ConfirmAuthenticationResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccessToken z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AccessToken) tmp0.invoke(obj);
    }

    public final Single<AuthConfigurationResponse> A(AuthenticationConfigurationAuthMethod authMethod, AuthenticationConfigurationAppStore appStore) {
        Intrinsics.f(authMethod, "authMethod");
        Intrinsics.f(appStore, "appStore");
        Single<ServerResponse<AuthConfigurationResponse>> b8 = this.f21432e.b(authMethod.getValue(), appStore.getValue());
        final AnonymousAuthClient$getAuthenticationConfiguration$1 anonymousAuthClient$getAuthenticationConfiguration$1 = new Function1<ServerResponse<AuthConfigurationResponse>, AuthConfigurationResponse>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$getAuthenticationConfiguration$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthConfigurationResponse invoke(ServerResponse<AuthConfigurationResponse> it) {
                Intrinsics.f(it, "it");
                return (AuthConfigurationResponse) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthConfigurationResponse B;
                B = AnonymousAuthClient.B(Function1.this, obj);
                return B;
            }
        });
        Intrinsics.e(x7, "driverAuthApi.getAuthent…it.exposeData()\n        }");
        return x7;
    }

    public final Single<AccessToken> C(String refreshToken) {
        Intrinsics.f(refreshToken, "refreshToken");
        Single<ServerResponse<AccessToken>> d8 = this.f21429b.get().d(refreshToken);
        final AnonymousAuthClient$getPartnerAccessToken$1 anonymousAuthClient$getPartnerAccessToken$1 = new Function1<ServerResponse<AccessToken>, AccessToken>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$getPartnerAccessToken$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AccessToken invoke(ServerResponse<AccessToken> it) {
                Intrinsics.f(it, "it");
                return (AccessToken) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = d8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AccessToken D;
                D = AnonymousAuthClient.D(Function1.this, obj);
                return D;
            }
        });
        Intrinsics.e(x7, "anonymousApi.get().getPa… .map { it.exposeData() }");
        return x7;
    }

    public final Single<TargetingParameters> E() {
        Single<ServerResponse<TargetingParameters>> g8 = this.f21432e.g();
        final AnonymousAuthClient$getPreLoginTargetingParameters$1 anonymousAuthClient$getPreLoginTargetingParameters$1 = new Function1<ServerResponse<TargetingParameters>, TargetingParameters>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$getPreLoginTargetingParameters$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final TargetingParameters invoke(ServerResponse<TargetingParameters> it) {
                Intrinsics.f(it, "it");
                return (TargetingParameters) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TargetingParameters F;
                F = AnonymousAuthClient.F(Function1.this, obj);
                return F;
            }
        });
        Intrinsics.e(x7, "driverAuthApi.getPreLogi… .map { it.exposeData() }");
        return x7;
    }

    public final Single<VerificationCode> G(String token, VerificationChannel channel) {
        String str;
        Intrinsics.f(token, "token");
        Intrinsics.f(channel, "channel");
        int i8 = WhenMappings.f21434a[channel.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalArgumentException("Unexpected channel: " + channel);
                }
                str = Scopes.EMAIL;
            } else {
                str = "call";
            }
        } else {
            str = "sms";
        }
        Single<ServerResponse<VerificationCode>> d8 = this.f21432e.d(token, str, this.f21428a.c(), this.f21428a.b(), this.f21428a.d());
        final AnonymousAuthClient$requestNewCode$1 anonymousAuthClient$requestNewCode$1 = new Function1<ServerResponse<VerificationCode>, VerificationCode>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$requestNewCode$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final VerificationCode invoke(ServerResponse<VerificationCode> it) {
                Intrinsics.f(it, "it");
                return (VerificationCode) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = d8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VerificationCode H;
                H = AnonymousAuthClient.H(Function1.this, obj);
                return H;
            }
        });
        Intrinsics.e(x7, "driverAuthApi\n          … .map { it.exposeData() }");
        return x7;
    }

    public final Single<VerificationCode> I(String phonePrefix, String phone, String verificationToken, VerificationChannel channel) {
        String str;
        Intrinsics.f(phonePrefix, "phonePrefix");
        Intrinsics.f(phone, "phone");
        Intrinsics.f(verificationToken, "verificationToken");
        Intrinsics.f(channel, "channel");
        int i8 = WhenMappings.f21434a[channel.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalArgumentException("Unexpected channel: " + channel);
                }
                str = Scopes.EMAIL;
            } else {
                str = "call";
            }
        } else {
            str = "sms";
        }
        Single<ServerResponse<VerificationCode>> a8 = this.f21429b.get().a(new PhoneResendAuthenticationRequest("+" + phonePrefix + phone, verificationToken, str));
        final AnonymousAuthClient$restartPhoneAuthentication$1 anonymousAuthClient$restartPhoneAuthentication$1 = new Function1<ServerResponse<VerificationCode>, VerificationCode>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$restartPhoneAuthentication$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final VerificationCode invoke(ServerResponse<VerificationCode> it) {
                Intrinsics.f(it, "it");
                return (VerificationCode) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VerificationCode J;
                J = AnonymousAuthClient.J(Function1.this, obj);
                return J;
            }
        });
        Intrinsics.e(x7, "anonymousApi.get()\n     … .map { it.exposeData() }");
        return x7;
    }

    public final Completable K(String email) {
        Intrinsics.f(email, "email");
        Completable v7 = this.f21432e.f(email, this.f21428a.a(), this.f21428a.c(), this.f21428a.b(), this.f21428a.d()).v();
        Intrinsics.e(v7, "driverAuthApi.sendMagicL…         .ignoreElement()");
        return v7;
    }

    public final Single<VerificationCode> L(String phonePrefix, String phone, boolean z7, StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        String str;
        Intrinsics.f(phonePrefix, "phonePrefix");
        Intrinsics.f(phone, "phone");
        String str2 = "+" + phonePrefix + phone;
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest = null;
        if (z7) {
            str = Native.bolt_native_1lira(str2);
        } else {
            str = null;
        }
        AnonymousAuthApi anonymousAuthApi = this.f21429b.get();
        if (storeIntegrityVerificationResult != null) {
            storeIntegrityVerificationResultRequest = this.f21433f.a(storeIntegrityVerificationResult);
        }
        Single<ServerResponse<VerificationCode>> c8 = anonymousAuthApi.c(new PhoneAuthenticationRequest(str2, str, storeIntegrityVerificationResultRequest));
        final AnonymousAuthClient$startPhoneAuthentication$2 anonymousAuthClient$startPhoneAuthentication$2 = new Function1<ServerResponse<VerificationCode>, VerificationCode>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$startPhoneAuthentication$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final VerificationCode invoke(ServerResponse<VerificationCode> it) {
                Intrinsics.f(it, "it");
                return (VerificationCode) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = c8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VerificationCode M;
                M = AnonymousAuthClient.M(Function1.this, obj);
                return M;
            }
        });
        Intrinsics.e(x7, "anonymousApi.get()\n     … .map { it.exposeData() }");
        return x7;
    }

    public final Single<RefreshToken> n(String username, String password) {
        Intrinsics.f(username, "username");
        Intrinsics.f(password, "password");
        Single<ServerResponse<RefreshToken>> i8 = this.f21432e.i(username, password, this.f21428a.a(), this.f21428a.c(), this.f21428a.b(), this.f21428a.d());
        final AnonymousAuthClient$authenticateDriver$1 anonymousAuthClient$authenticateDriver$1 = new Function1<ServerResponse<RefreshToken>, RefreshToken>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$authenticateDriver$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final RefreshToken invoke(ServerResponse<RefreshToken> it) {
                Intrinsics.f(it, "it");
                return (RefreshToken) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = i8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RefreshToken o8;
                o8 = AnonymousAuthClient.o(Function1.this, obj);
                return o8;
            }
        });
        Intrinsics.e(x7, "driverAuthApi.authentica… .map { it.exposeData() }");
        return x7;
    }

    public final Single<AuthResult> p(String username, String password, boolean z7, StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        String str;
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest;
        Intrinsics.f(username, "username");
        Intrinsics.f(password, "password");
        DriverAuthAnonymousApi driverAuthAnonymousApi = this.f21432e;
        String c8 = this.f21428a.c();
        String b8 = this.f21428a.b();
        String d8 = this.f21428a.d();
        if (z7) {
            str = Native.bolt_native_1lira(username);
        } else {
            str = null;
        }
        if (storeIntegrityVerificationResult != null) {
            storeIntegrityVerificationResultRequest = this.f21433f.a(storeIntegrityVerificationResult);
        } else {
            storeIntegrityVerificationResultRequest = null;
        }
        Single<ServerResponse<AuthResultResponse>> e8 = driverAuthAnonymousApi.e(new StartAuthenticationRequest(username, password, c8, b8, d8, str, storeIntegrityVerificationResultRequest));
        final Function1<ServerResponse<AuthResultResponse>, AuthResult> function1 = new Function1<ServerResponse<AuthResultResponse>, AuthResult>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$authenticateDriver2Fa$2

            /* compiled from: AnonymousAuthClient.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f21437a;

                static {
                    int[] iArr = new int[AuthState.values().length];
                    try {
                        iArr[AuthState.TWO_FACTOR_REQUIRED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AuthState.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AuthState.PASSWORD_CHANGE_REQUIRED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[AuthState.UNKNOWN.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f21437a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthResult invoke(ServerResponse<AuthResultResponse> it) {
                SystemUptimeSource systemUptimeSource;
                Intrinsics.f(it, "it");
                AuthResultResponse authResultResponse = (AuthResultResponse) BasicServerResponseKt.a(it);
                int i8 = WhenMappings.f21437a[authResultResponse.d().ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4) {
                                throw new NoWhenBranchMatchedException();
                            }
                            throw new IllegalStateException("Unexpected auth state: " + it);
                        }
                        return AuthResult.PasswordChangeRequired.f21459f;
                    }
                    String c9 = authResultResponse.c();
                    if (c9 != null) {
                        return new AuthResult.Success(c9);
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                String h8 = authResultResponse.h();
                if (h8 != null) {
                    VerificationChannel e9 = authResultResponse.e();
                    if (e9 != null) {
                        String g8 = authResultResponse.g();
                        if (g8 != null) {
                            Integer f8 = authResultResponse.f();
                            if (f8 != null) {
                                int intValue = f8.intValue();
                                Integer b9 = authResultResponse.b();
                                if (b9 != null) {
                                    int intValue2 = b9.intValue();
                                    List<VerificationChannel> a8 = authResultResponse.a();
                                    if (a8 != null) {
                                        systemUptimeSource = AnonymousAuthClient.this.f21431d;
                                        return new AuthResult.Verification(h8, e9, g8, intValue, intValue2, a8, systemUptimeSource.b());
                                    }
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
        };
        Single x7 = e8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthResult q8;
                q8 = AnonymousAuthClient.q(Function1.this, obj);
                return q8;
            }
        });
        Intrinsics.e(x7, "fun authenticateDriver2F…    }\n            }\n    }");
        return x7;
    }

    public final Single<RefreshToken> r(String magicToken) {
        Intrinsics.f(magicToken, "magicToken");
        return SingleExtKt.g(this.f21429b.get().b(magicToken, this.f21428a.a(), this.f21428a.c(), this.f21428a.b(), this.f21428a.d()), this.f21430c);
    }

    public final Single<RefreshToken> s(String magicToken, StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest;
        Intrinsics.f(magicToken, "magicToken");
        DriverAuthAnonymousApi driverAuthAnonymousApi = this.f21432e;
        String a8 = this.f21428a.a();
        String c8 = this.f21428a.c();
        String b8 = this.f21428a.b();
        String d8 = this.f21428a.d();
        if (storeIntegrityVerificationResult != null) {
            storeIntegrityVerificationResultRequest = this.f21433f.a(storeIntegrityVerificationResult);
        } else {
            storeIntegrityVerificationResultRequest = null;
        }
        Single<ServerResponse<RefreshToken>> h8 = driverAuthAnonymousApi.h(new AuthenticateWithMagicLinkRequest(magicToken, a8, c8, b8, d8, storeIntegrityVerificationResultRequest));
        final AnonymousAuthClient$authenticateWithMagicLink$2 anonymousAuthClient$authenticateWithMagicLink$2 = new Function1<ServerResponse<RefreshToken>, RefreshToken>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$authenticateWithMagicLink$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final RefreshToken invoke(ServerResponse<RefreshToken> it) {
                Intrinsics.f(it, "it");
                return (RefreshToken) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = h8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RefreshToken t7;
                t7 = AnonymousAuthClient.t(Function1.this, obj);
                return t7;
            }
        });
        Intrinsics.e(x7, "driverAuthApi.authentica… .map { it.exposeData() }");
        return x7;
    }

    public final Single<AuthResult.Success> u(String token, String code) {
        Intrinsics.f(token, "token");
        Intrinsics.f(code, "code");
        Single<ServerResponse<RefreshToken>> c8 = this.f21432e.c(token, code, this.f21428a.c(), this.f21428a.b(), this.f21428a.d());
        final AnonymousAuthClient$confirmAuthentication$1 anonymousAuthClient$confirmAuthentication$1 = new Function1<ServerResponse<RefreshToken>, AuthResult.Success>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$confirmAuthentication$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthResult.Success invoke(ServerResponse<RefreshToken> it) {
                Intrinsics.f(it, "it");
                return new AuthResult.Success(((RefreshToken) BasicServerResponseKt.a(it)).a());
            }
        };
        Single x7 = c8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthResult.Success v7;
                v7 = AnonymousAuthClient.v(Function1.this, obj);
                return v7;
            }
        });
        Intrinsics.e(x7, "driverAuthApi\n          …freshToken)\n            }");
        return x7;
    }

    public final Single<ConfirmAuthenticationResponse> w(String token, String code) {
        Intrinsics.f(token, "token");
        Intrinsics.f(code, "code");
        Single<ee.mtakso.driver.network.response.ServerResponse<ConfirmAuthenticationResponse>> e8 = this.f21429b.get().e(token, code, this.f21428a.c(), this.f21428a.b(), this.f21428a.d());
        final AnonymousAuthClient$confirmPhoneAuthentication$1 anonymousAuthClient$confirmPhoneAuthentication$1 = new Function1<ee.mtakso.driver.network.response.ServerResponse<ConfirmAuthenticationResponse>, ConfirmAuthenticationResponse>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$confirmPhoneAuthentication$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ConfirmAuthenticationResponse invoke(ee.mtakso.driver.network.response.ServerResponse<ConfirmAuthenticationResponse> it) {
                Intrinsics.f(it, "it");
                return (ConfirmAuthenticationResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = e8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConfirmAuthenticationResponse x8;
                x8 = AnonymousAuthClient.x(Function1.this, obj);
                return x8;
            }
        });
        Intrinsics.e(x7, "anonymousApi.get()\n     …xposeData()\n            }");
        return x7;
    }

    public final Single<AccessToken> y(String refreshToken) {
        Intrinsics.f(refreshToken, "refreshToken");
        Single<ServerResponse<AccessToken>> a8 = this.f21432e.a(refreshToken);
        final AnonymousAuthClient$getAccessToken$1 anonymousAuthClient$getAccessToken$1 = new Function1<ServerResponse<AccessToken>, AccessToken>() { // from class: ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient$getAccessToken$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AccessToken invoke(ServerResponse<AccessToken> it) {
                Intrinsics.f(it, "it");
                return (AccessToken) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.auth.anonymous.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AccessToken z7;
                z7 = AnonymousAuthClient.z(Function1.this, obj);
                return z7;
            }
        });
        Intrinsics.e(x7, "driverAuthApi.getAccessT… .map { it.exposeData() }");
        return x7;
    }
}
