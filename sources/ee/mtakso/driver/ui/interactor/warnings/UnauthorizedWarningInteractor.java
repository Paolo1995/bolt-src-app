package ee.mtakso.driver.ui.interactor.warnings;

import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthState;
import ee.mtakso.driver.service.connectivity.ConnectionMessage;
import ee.mtakso.driver.service.connectivity.ConnectionMessageManager;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnauthorizedWarningInteractor.kt */
/* loaded from: classes3.dex */
public final class UnauthorizedWarningInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final ConnectionMessageManager f26938a;

    /* renamed from: b  reason: collision with root package name */
    private final AuthManager f26939b;

    /* renamed from: c  reason: collision with root package name */
    private final GeoLocationManager f26940c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnauthorizedWarningInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Event {

        /* renamed from: a  reason: collision with root package name */
        private final WarningMessage f26941a;

        /* renamed from: b  reason: collision with root package name */
        private final WarningMessage f26942b;

        public Event(WarningMessage connection, WarningMessage location) {
            Intrinsics.f(connection, "connection");
            Intrinsics.f(location, "location");
            this.f26941a = connection;
            this.f26942b = location;
        }

        public final WarningMessage a() {
            return this.f26941a;
        }

        public final WarningMessage b() {
            return this.f26942b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Event) {
                Event event = (Event) obj;
                return Intrinsics.a(this.f26941a, event.f26941a) && Intrinsics.a(this.f26942b, event.f26942b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f26941a.hashCode() * 31) + this.f26942b.hashCode();
        }

        public String toString() {
            WarningMessage warningMessage = this.f26941a;
            WarningMessage warningMessage2 = this.f26942b;
            return "Event(connection=" + warningMessage + ", location=" + warningMessage2 + ")";
        }
    }

    @Inject
    public UnauthorizedWarningInteractor(ConnectionMessageManager connectionMessageManager, AuthManager authManager, GeoLocationManager geoLocationManager) {
        Intrinsics.f(connectionMessageManager, "connectionMessageManager");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(geoLocationManager, "geoLocationManager");
        this.f26938a = connectionMessageManager;
        this.f26939b = authManager;
        this.f26940c = geoLocationManager;
    }

    private final Observable<WarningMessage> h() {
        Observable<ConnectionMessage> c8 = this.f26938a.c();
        final UnauthorizedWarningInteractor$observeConnectionWarnings$1 unauthorizedWarningInteractor$observeConnectionWarnings$1 = new Function1<ConnectionMessage, WarningMessage>() { // from class: ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor$observeConnectionWarnings$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final WarningMessage invoke(ConnectionMessage connection) {
                Intrinsics.f(connection, "connection");
                return new WarningMessage.Connection(connection);
            }
        };
        Observable<WarningMessage> startWith = c8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.warnings.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                WarningMessage i8;
                i8 = UnauthorizedWarningInteractor.i(Function1.this, obj);
                return i8;
            }
        }).startWith((Observable<R>) WarningMessage.Empty.f26953a);
        Intrinsics.e(startWith, "connectionMessageManager…ith(WarningMessage.Empty)");
        return startWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WarningMessage i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (WarningMessage) tmp0.invoke(obj);
    }

    private final Observable<WarningMessage> j() {
        Observable<AuthState> startWith = this.f26939b.t().startWith((Observable<AuthState>) this.f26939b.h());
        final UnauthorizedWarningInteractor$observeLocationWarnings$1 unauthorizedWarningInteractor$observeLocationWarnings$1 = new Function1<AuthState, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor$observeLocationWarnings$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(AuthState it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it == AuthState.LOGGED_IN) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<AuthState> filter = startWith.filter(new Predicate() { // from class: ee.mtakso.driver.ui.interactor.warnings.g
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean k8;
                k8 = UnauthorizedWarningInteractor.k(Function1.this, obj);
                return k8;
            }
        });
        final Function1<AuthState, ObservableSource<? extends GeoLocationManagerState>> function1 = new Function1<AuthState, ObservableSource<? extends GeoLocationManagerState>>() { // from class: ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor$observeLocationWarnings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends GeoLocationManagerState> invoke(AuthState it) {
                GeoLocationManager geoLocationManager;
                Intrinsics.f(it, "it");
                geoLocationManager = UnauthorizedWarningInteractor.this.f26940c;
                return geoLocationManager.v();
            }
        };
        Observable<R> flatMap = filter.flatMap(new Function() { // from class: ee.mtakso.driver.ui.interactor.warnings.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource l8;
                l8 = UnauthorizedWarningInteractor.l(Function1.this, obj);
                return l8;
            }
        });
        final UnauthorizedWarningInteractor$observeLocationWarnings$3 unauthorizedWarningInteractor$observeLocationWarnings$3 = new Function1<GeoLocationManagerState, WarningMessage>() { // from class: ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor$observeLocationWarnings$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final WarningMessage invoke(GeoLocationManagerState location) {
                Intrinsics.f(location, "location");
                return new WarningMessage.Location(location);
            }
        };
        Observable<WarningMessage> startWith2 = flatMap.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.warnings.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                WarningMessage m8;
                m8 = UnauthorizedWarningInteractor.m(Function1.this, obj);
                return m8;
            }
        }).startWith((Observable) WarningMessage.Empty.f26953a);
        Intrinsics.e(startWith2, "private fun observeLocat…rningMessage.Empty)\n    }");
        return startWith2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WarningMessage m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (WarningMessage) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Event o(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Event) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WarningMessage p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (WarningMessage) tmp0.invoke(obj);
    }

    public final Observable<WarningMessage> n() {
        Observable<WarningMessage> h8 = h();
        Observable<WarningMessage> j8 = j();
        final UnauthorizedWarningInteractor$observeWarnings$1 unauthorizedWarningInteractor$observeWarnings$1 = new Function2<WarningMessage, WarningMessage, Event>() { // from class: ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor$observeWarnings$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final UnauthorizedWarningInteractor.Event s(WarningMessage connection, WarningMessage location) {
                Intrinsics.f(connection, "connection");
                Intrinsics.f(location, "location");
                return new UnauthorizedWarningInteractor.Event(connection, location);
            }
        };
        Observable combineLatest = Observable.combineLatest(h8, j8, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.warnings.d
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                UnauthorizedWarningInteractor.Event o8;
                o8 = UnauthorizedWarningInteractor.o(Function2.this, obj, obj2);
                return o8;
            }
        });
        final UnauthorizedWarningInteractor$observeWarnings$2 unauthorizedWarningInteractor$observeWarnings$2 = new Function1<Event, WarningMessage>() { // from class: ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor$observeWarnings$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final WarningMessage invoke(UnauthorizedWarningInteractor.Event event) {
                Intrinsics.f(event, "event");
                if (WarningMessageKt.a(event.b(), event.a()) >= 0) {
                    return event.b();
                }
                return event.a();
            }
        };
        Observable<WarningMessage> map = combineLatest.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.warnings.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                WarningMessage p8;
                p8 = UnauthorizedWarningInteractor.p(Function1.this, obj);
                return p8;
            }
        });
        Intrinsics.e(map, "combineLatest(\n         …          }\n            }");
        return map;
    }
}
