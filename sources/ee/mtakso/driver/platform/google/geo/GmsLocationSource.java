package ee.mtakso.driver.platform.google.geo;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.HandlerThread;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import ee.mtakso.driver.platform.geo.GeoLocationAvailability;
import ee.mtakso.driver.platform.geo.GeoLocationCallback;
import ee.mtakso.driver.platform.geo.GeoLocationSource;
import ee.mtakso.driver.platform.geo.LocationSettingsResult;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GmsLocationSource.kt */
@Singleton
/* loaded from: classes3.dex */
public final class GmsLocationSource implements GeoLocationSource {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23300a;

    /* renamed from: b  reason: collision with root package name */
    private final ReentrantLock f23301b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f23302c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f23303d;

    /* renamed from: e  reason: collision with root package name */
    private GeoLocationCallback f23304e;

    /* renamed from: f  reason: collision with root package name */
    private final GmsLocationSource$locationCallback$1 f23305f;

    /* JADX WARN: Type inference failed for: r2v6, types: [ee.mtakso.driver.platform.google.geo.GmsLocationSource$locationCallback$1] */
    @Inject
    public GmsLocationSource(Context context) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(context, "context");
        this.f23300a = context;
        this.f23301b = new ReentrantLock();
        b8 = LazyKt__LazyJVMKt.b(new Function0<FusedLocationProviderClient>() { // from class: ee.mtakso.driver.platform.google.geo.GmsLocationSource$client$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final FusedLocationProviderClient invoke() {
                Context context2;
                context2 = GmsLocationSource.this.f23300a;
                return LocationServices.getFusedLocationProviderClient(context2);
            }
        });
        this.f23302c = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<HandlerThread>() { // from class: ee.mtakso.driver.platform.google.geo.GmsLocationSource$locationHandlerThread$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final HandlerThread invoke() {
                HandlerThread handlerThread = new HandlerThread("Location-Google");
                handlerThread.start();
                return handlerThread;
            }
        });
        this.f23303d = b9;
        this.f23305f = new LocationCallback() { // from class: ee.mtakso.driver.platform.google.geo.GmsLocationSource$locationCallback$1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                GeoLocationCallback geoLocationCallback;
                geoLocationCallback = GmsLocationSource.this.f23304e;
                if (geoLocationCallback == null) {
                    Kalev.e(new NullPointerException("Location callback is null"), "Location callback is null");
                } else if (locationAvailability == null) {
                    Kalev.e(new NullPointerException("Location availability is null"), "Location availability is null");
                } else {
                    geoLocationCallback.a(new GeoLocationAvailability(locationAvailability.isLocationAvailable()));
                }
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                Location location;
                GeoLocationCallback geoLocationCallback;
                if (locationResult != null) {
                    location = locationResult.getLastLocation();
                } else {
                    location = null;
                }
                geoLocationCallback = GmsLocationSource.this.f23304e;
                if (geoLocationCallback == null) {
                    Kalev.e(new NullPointerException("Location callback is null"), "Location callback is null");
                } else if (location == null) {
                    Kalev.e(new NullPointerException("Location is null"), "Location is null");
                } else {
                    geoLocationCallback.onLocationChanged(location);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(GmsLocationSource this$0, CompletableEmitter receiver, Exception it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(receiver, "$receiver");
        Intrinsics.f(it, "it");
        this$0.f23301b.unlock();
        this$0.f23304e = null;
        receiver.onError(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GmsLocationSource this$0, GeoLocationCallback callback, CompletableEmitter it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(callback, "$callback");
        Intrinsics.f(it, "it");
        this$0.y(it, callback);
    }

    private final void C(final CompletableEmitter completableEmitter) {
        Task<Void> removeLocationUpdates = t().removeLocationUpdates(this.f23305f);
        final Function1<Void, Unit> function1 = new Function1<Void, Unit>() { // from class: ee.mtakso.driver.platform.google.geo.GmsLocationSource$stopLocationUpdates$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Void r22) {
                ReentrantLock reentrantLock;
                reentrantLock = GmsLocationSource.this.f23301b;
                reentrantLock.unlock();
                GmsLocationSource.this.f23304e = null;
                completableEmitter.onComplete();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
                b(r12);
                return Unit.f50853a;
            }
        };
        removeLocationUpdates.addOnSuccessListener(new OnSuccessListener() { // from class: ee.mtakso.driver.platform.google.geo.e
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GmsLocationSource.E(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: ee.mtakso.driver.platform.google.geo.f
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GmsLocationSource.F(CompletableEmitter.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(GmsLocationSource this$0, CompletableEmitter it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.C(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(CompletableEmitter receiver, Exception it) {
        Intrinsics.f(receiver, "$receiver");
        Intrinsics.f(it, "it");
        receiver.onError(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(GmsLocationSource this$0, SingleEmitter it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.v(it);
    }

    private final FusedLocationProviderClient t() {
        return (FusedLocationProviderClient) this.f23302c.getValue();
    }

    private final HandlerThread u() {
        return (HandlerThread) this.f23303d.getValue();
    }

    private final void v(final SingleEmitter<LocationSettingsResult> singleEmitter) {
        Task<LocationSettingsResponse> checkLocationSettings = LocationServices.getSettingsClient(this.f23300a).checkLocationSettings(new LocationSettingsRequest.Builder().addLocationRequest(LocationRequest.create()).build());
        final Function1<LocationSettingsResponse, Unit> function1 = new Function1<LocationSettingsResponse, Unit>() { // from class: ee.mtakso.driver.platform.google.geo.GmsLocationSource$requestLocationSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(LocationSettingsResponse locationSettingsResponse) {
                singleEmitter.onSuccess(LocationSettingsResult.Ok.f23283a);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocationSettingsResponse locationSettingsResponse) {
                b(locationSettingsResponse);
                return Unit.f50853a;
            }
        };
        checkLocationSettings.addOnSuccessListener(new OnSuccessListener() { // from class: ee.mtakso.driver.platform.google.geo.h
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GmsLocationSource.w(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: ee.mtakso.driver.platform.google.geo.i
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GmsLocationSource.x(SingleEmitter.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(SingleEmitter receiver, Exception exc) {
        Intrinsics.f(receiver, "$receiver");
        Intrinsics.f(exc, "exc");
        if (exc instanceof ApiException) {
            int statusCode = ((ApiException) exc).getStatusCode();
            if (statusCode != 6) {
                if (statusCode != 8502) {
                    receiver.onSuccess(new LocationSettingsResult.Error(exc));
                    return;
                } else {
                    receiver.onSuccess(LocationSettingsResult.SettingsChangeUnavailable.f23285a);
                    return;
                }
            }
            receiver.onSuccess(new LocationSettingsResult.ResolvableError(exc));
            return;
        }
        receiver.onSuccess(new LocationSettingsResult.Error(exc));
    }

    private final void y(final CompletableEmitter completableEmitter, GeoLocationCallback geoLocationCallback) {
        if (!this.f23301b.tryLock()) {
            Kalev.h("Already running");
            completableEmitter.onError(new IllegalStateException("Location source already running"));
            return;
        }
        this.f23304e = geoLocationCallback;
        LocationRequest create = LocationRequest.create();
        create.setInterval(500L);
        create.setFastestInterval(500L);
        create.setPriority(100);
        create.setSmallestDisplacement(0.0f);
        Task<Void> requestLocationUpdates = t().requestLocationUpdates(create, this.f23305f, u().getLooper());
        final Function1<Void, Unit> function1 = new Function1<Void, Unit>() { // from class: ee.mtakso.driver.platform.google.geo.GmsLocationSource$requestLocationUpdates$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Void r12) {
                CompletableEmitter.this.onComplete();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
                b(r12);
                return Unit.f50853a;
            }
        };
        requestLocationUpdates.addOnSuccessListener(new OnSuccessListener() { // from class: ee.mtakso.driver.platform.google.geo.c
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GmsLocationSource.z(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: ee.mtakso.driver.platform.google.geo.d
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GmsLocationSource.A(GmsLocationSource.this, completableEmitter, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.platform.geo.GeoLocationSource
    public Single<LocationSettingsResult> a() {
        Single<LocationSettingsResult> f8 = Single.f(new SingleOnSubscribe() { // from class: ee.mtakso.driver.platform.google.geo.g
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                GmsLocationSource.s(GmsLocationSource.this, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create {\n            req…ionSettings(it)\n        }");
        return f8;
    }

    @Override // ee.mtakso.driver.platform.geo.GeoLocationSource
    public Completable b() {
        Completable i8 = Completable.i(new CompletableOnSubscribe() { // from class: ee.mtakso.driver.platform.google.geo.b
            @Override // io.reactivex.CompletableOnSubscribe
            public final void a(CompletableEmitter completableEmitter) {
                GmsLocationSource.D(GmsLocationSource.this, completableEmitter);
            }
        });
        Intrinsics.e(i8, "create {\n            sto…tionUpdates(it)\n        }");
        return i8;
    }

    @Override // ee.mtakso.driver.platform.geo.GeoLocationSource
    public void c(LocationSettingsResult.ResolvableError state, Fragment fragment, int i8) {
        Intrinsics.f(state, "state");
        Intrinsics.f(fragment, "fragment");
        Exception a8 = state.a();
        Intrinsics.d(a8, "null cannot be cast to non-null type com.google.android.gms.common.api.ResolvableApiException");
        fragment.startIntentSenderForResult(((ResolvableApiException) a8).getResolution().getIntentSender(), i8, null, 0, 0, 0, null);
    }

    @Override // ee.mtakso.driver.platform.geo.GeoLocationSource
    public Completable d(final GeoLocationCallback callback) {
        Intrinsics.f(callback, "callback");
        Completable i8 = Completable.i(new CompletableOnSubscribe() { // from class: ee.mtakso.driver.platform.google.geo.a
            @Override // io.reactivex.CompletableOnSubscribe
            public final void a(CompletableEmitter completableEmitter) {
                GmsLocationSource.B(GmsLocationSource.this, callback, completableEmitter);
            }
        });
        Intrinsics.e(i8, "create {\n            req…s(it, callback)\n        }");
        return i8;
    }

    @Override // ee.mtakso.driver.platform.geo.GeoLocationSource
    public void e(LocationSettingsResult.ResolvableError state, Activity activity, int i8) {
        Intrinsics.f(state, "state");
        Intrinsics.f(activity, "activity");
        Exception a8 = state.a();
        Intrinsics.d(a8, "null cannot be cast to non-null type com.google.android.gms.common.api.ResolvableApiException");
        ((ResolvableApiException) a8).startResolutionForResult(activity, i8);
    }
}
