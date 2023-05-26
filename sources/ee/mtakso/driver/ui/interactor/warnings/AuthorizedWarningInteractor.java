package ee.mtakso.driver.ui.interactor.warnings;

import ee.mtakso.driver.network.client.driver.PollMessage;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.connectivity.ConnectionMessage;
import ee.mtakso.driver.service.connectivity.ConnectionMessageManager;
import ee.mtakso.driver.service.polling.message.PollMessageManager;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizedWarningInteractor.kt */
/* loaded from: classes3.dex */
public final class AuthorizedWarningInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final ConnectionMessageManager f26929a;

    /* renamed from: b  reason: collision with root package name */
    private final PollMessageManager f26930b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f26931c;

    @Inject
    public AuthorizedWarningInteractor(ConnectionMessageManager connectionMessageManager, PollMessageManager pollMessageManager, DriverProvider driverProvider) {
        Intrinsics.f(connectionMessageManager, "connectionMessageManager");
        Intrinsics.f(pollMessageManager, "pollMessageManager");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f26929a = connectionMessageManager;
        this.f26930b = pollMessageManager;
        this.f26931c = driverProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WarningMessage.Connection f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (WarningMessage.Connection) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WarningMessage h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (WarningMessage) tmp0.invoke(obj);
    }

    public final Observable<WarningMessage> e() {
        Observable<ConnectionMessage> c8 = this.f26929a.c();
        final AuthorizedWarningInteractor$observeWarnings$1 authorizedWarningInteractor$observeWarnings$1 = new Function1<ConnectionMessage, WarningMessage.Connection>() { // from class: ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor$observeWarnings$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final WarningMessage.Connection invoke(ConnectionMessage connection) {
                Intrinsics.f(connection, "connection");
                return new WarningMessage.Connection(connection);
            }
        };
        ObservableSource map = c8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.warnings.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                WarningMessage.Connection f8;
                f8 = AuthorizedWarningInteractor.f(Function1.this, obj);
                return f8;
            }
        });
        Observable<Optional<PollMessage>> b8 = this.f26930b.b();
        final Function1<Optional<PollMessage>, Boolean> function1 = new Function1<Optional<PollMessage>, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor$observeWarnings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Optional<PollMessage> it) {
                DriverProvider driverProvider;
                Intrinsics.f(it, "it");
                driverProvider = AuthorizedWarningInteractor.this.f26931c;
                return Boolean.valueOf(driverProvider.q().H());
            }
        };
        Observable<Optional<PollMessage>> filter = b8.filter(new Predicate() { // from class: ee.mtakso.driver.ui.interactor.warnings.b
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean g8;
                g8 = AuthorizedWarningInteractor.g(Function1.this, obj);
                return g8;
            }
        });
        final AuthorizedWarningInteractor$observeWarnings$3 authorizedWarningInteractor$observeWarnings$3 = new Function1<Optional<PollMessage>, WarningMessage>() { // from class: ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor$observeWarnings$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final WarningMessage invoke(Optional<PollMessage> optional) {
                Intrinsics.f(optional, "optional");
                if (optional.d()) {
                    return WarningMessage.Empty.f26953a;
                }
                PollMessage b9 = optional.b();
                Intrinsics.e(b9, "optional.value");
                return new WarningMessage.Polling(b9);
            }
        };
        Observable<WarningMessage> distinctUntilChanged = Observable.merge(map, filter.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.warnings.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                WarningMessage h8;
                h8 = AuthorizedWarningInteractor.h(Function1.this, obj);
                return h8;
            }
        })).distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "fun observeWarnings(): O…tinctUntilChanged()\n    }");
        return distinctUntilChanged;
    }
}
