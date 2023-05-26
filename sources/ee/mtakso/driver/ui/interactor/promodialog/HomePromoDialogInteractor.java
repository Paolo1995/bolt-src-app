package ee.mtakso.driver.ui.interactor.promodialog;

import android.annotation.SuppressLint;
import android.os.Build;
import ee.mtakso.driver.network.client.contact.ContactConfiguration;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.network.client.training.TrainingClient;
import ee.mtakso.driver.network.client.training.TrainingModal;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettingsInMemory;
import ee.mtakso.driver.service.contact.ContactOptionsService;
import ee.mtakso.driver.service.settings.AutoAcceptanceState;
import ee.mtakso.driver.service.settings.CategorySelectionAutoAcceptanceState;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.ui.interactor.modaldialog.PromoDialogEvent;
import ee.mtakso.driver.ui.interactor.modaldialog.SingleModalDialogInteractor;
import ee.mtakso.driver.ui.interactor.promodialog.PromoDialog;
import ee.mtakso.driver.ui.interactor.score.DriverScoreItem;
import ee.mtakso.driver.ui.interactor.score.DriverScoreManager;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.StorageUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.util.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomePromoDialogInteractor.kt */
/* loaded from: classes3.dex */
public final class HomePromoDialogInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f26796a;

    /* renamed from: b  reason: collision with root package name */
    private final SingleModalDialogInteractor f26797b;

    /* renamed from: c  reason: collision with root package name */
    private final DispatchSettingsManager f26798c;

    /* renamed from: d  reason: collision with root package name */
    private final OnBoardingManager f26799d;

    /* renamed from: e  reason: collision with root package name */
    private final ContactOptionsService f26800e;

    /* renamed from: f  reason: collision with root package name */
    private final PermissionManager f26801f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverSettingsInMemory f26802g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverScoreManager f26803h;

    /* renamed from: i  reason: collision with root package name */
    private final TrainingClient f26804i;

    @Inject
    public HomePromoDialogInteractor(DriverProvider driverProvider, SingleModalDialogInteractor singleModalDialogInteractor, DispatchSettingsManager dispatchSettingsManager, OnBoardingManager onBoardingManager, ContactOptionsService contactOptionsService, PermissionManager permissionManager, DriverSettingsInMemory driverSettingsInMemory, DriverScoreManager driverScoreManager, TrainingClient trainingClient) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(singleModalDialogInteractor, "singleModalDialogInteractor");
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        Intrinsics.f(onBoardingManager, "onBoardingManager");
        Intrinsics.f(contactOptionsService, "contactOptionsService");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(driverSettingsInMemory, "driverSettingsInMemory");
        Intrinsics.f(driverScoreManager, "driverScoreManager");
        Intrinsics.f(trainingClient, "trainingClient");
        this.f26796a = driverProvider;
        this.f26797b = singleModalDialogInteractor;
        this.f26798c = dispatchSettingsManager;
        this.f26799d = onBoardingManager;
        this.f26800e = contactOptionsService;
        this.f26801f = permissionManager;
        this.f26802g = driverSettingsInMemory;
        this.f26803h = driverScoreManager;
        this.f26804i = trainingClient;
    }

    private final boolean A() {
        DriverConfig d8 = this.f26796a.d();
        if (d8 != null && d8.P()) {
            return true;
        }
        return false;
    }

    private final boolean B() {
        if (this.f26796a.w().R() || this.f26799d.c() || this.f26800e.q(ContactConfiguration.Type.VOIP) == null || this.f26801f.o("android.permission.RECORD_AUDIO").d() == PermissionManager.PermissionStatus.GRANTED) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<Optional<PromoDialog>> k() {
        Single<CategorySelectionAutoAcceptanceState> firstOrError = this.f26798c.v().subscribeOn(AndroidSchedulers.a()).firstOrError();
        Single<Optional<DriverScoreItem>> C = this.f26803h.j(false).C(new Function() { // from class: ee.mtakso.driver.ui.interactor.promodialog.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional l8;
                l8 = HomePromoDialogInteractor.l((Throwable) obj);
                return l8;
            }
        });
        final HomePromoDialogInteractor$checkPromoDialogs$2 homePromoDialogInteractor$checkPromoDialogs$2 = new Function2<CategorySelectionAutoAcceptanceState, Optional<DriverScoreItem>, CategorySelectionAutoAcceptanceStateDriverScoreItem>() { // from class: ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor$checkPromoDialogs$2
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final CategorySelectionAutoAcceptanceStateDriverScoreItem s(CategorySelectionAutoAcceptanceState autoAcceptance, Optional<DriverScoreItem> driverScore) {
                Intrinsics.f(autoAcceptance, "autoAcceptance");
                Intrinsics.f(driverScore, "driverScore");
                return new CategorySelectionAutoAcceptanceStateDriverScoreItem(autoAcceptance, driverScore.c());
            }
        };
        Single z7 = firstOrError.X(C, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.promodialog.c
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CategorySelectionAutoAcceptanceStateDriverScoreItem m8;
                m8 = HomePromoDialogInteractor.m(Function2.this, obj, obj2);
                return m8;
            }
        }).z(AndroidSchedulers.a());
        final Function1<CategorySelectionAutoAcceptanceStateDriverScoreItem, SingleSource<? extends Optional<PromoDialog>>> function1 = new Function1<CategorySelectionAutoAcceptanceStateDriverScoreItem, SingleSource<? extends Optional<PromoDialog>>>() { // from class: ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor$checkPromoDialogs$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Optional<PromoDialog>> invoke(CategorySelectionAutoAcceptanceStateDriverScoreItem autoAcceptanceDriverScore) {
                AutoAcceptanceState autoAcceptanceState;
                boolean z8;
                Single p8;
                Intrinsics.f(autoAcceptanceDriverScore, "autoAcceptanceDriverScore");
                CategorySelectionAutoAcceptanceState a8 = autoAcceptanceDriverScore.a();
                if (a8 != null) {
                    autoAcceptanceState = a8.a();
                } else {
                    autoAcceptanceState = null;
                }
                if (autoAcceptanceState != AutoAcceptanceState.DISABLED) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                p8 = HomePromoDialogInteractor.this.p(Boolean.valueOf(z8), autoAcceptanceDriverScore.b());
                return p8;
            }
        };
        Single r7 = z7.r(new Function() { // from class: ee.mtakso.driver.ui.interactor.promodialog.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource n8;
                n8 = HomePromoDialogInteractor.n(Function1.this, obj);
                return n8;
            }
        });
        final Function1<Optional<PromoDialog>, Optional<PromoDialog>> function12 = new Function1<Optional<PromoDialog>, Optional<PromoDialog>>() { // from class: ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor$checkPromoDialogs$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<PromoDialog> invoke(Optional<PromoDialog> optionalDialog) {
                DriverSettingsInMemory driverSettingsInMemory;
                Intrinsics.f(optionalDialog, "optionalDialog");
                if (!optionalDialog.d()) {
                    driverSettingsInMemory = HomePromoDialogInteractor.this.f26802g;
                    driverSettingsInMemory.b(true);
                }
                return optionalDialog;
            }
        };
        Single<Optional<PromoDialog>> x7 = r7.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.promodialog.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional o8;
                o8 = HomePromoDialogInteractor.o(Function1.this, obj);
                return o8;
            }
        });
        Intrinsics.e(x7, "private fun checkPromoDi… optionalDialog\n        }");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional l(Throwable it) {
        Intrinsics.f(it, "it");
        return Optional.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CategorySelectionAutoAcceptanceStateDriverScoreItem m(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CategorySelectionAutoAcceptanceStateDriverScoreItem) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<Optional<PromoDialog>> p(Boolean bool, DriverScoreItem driverScoreItem) {
        Double d8;
        if (A() && !y()) {
            Single a8 = SingleExtKt.a(this.f26804i.h());
            final HomePromoDialogInteractor$createPromoDialog$1 homePromoDialogInteractor$createPromoDialog$1 = new Function1<TrainingModal, Optional<PromoDialog>>() { // from class: ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor$createPromoDialog$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Optional<PromoDialog> invoke(TrainingModal trainingModal) {
                    Intrinsics.f(trainingModal, "<name for destructuring parameter 0>");
                    return Optional.f(new PromoDialog.Training(trainingModal.a()));
                }
            };
            Single<Optional<PromoDialog>> x7 = a8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.promodialog.f
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Optional q8;
                    q8 = HomePromoDialogInteractor.q(Function1.this, obj);
                    return q8;
                }
            });
            Intrinsics.e(x7, "trainingClient.getStartT…g(dlg))\n                }");
            return x7;
        }
        Object obj = null;
        if (y()) {
            obj = PromoDialog.NotificationPermission.f26825a;
        } else if (v()) {
            obj = PromoDialog.AutoNavigation.f26820a;
        } else if (u(bool)) {
            obj = PromoDialog.AutoAcceptance.f26819a;
        } else if (B()) {
            obj = PromoDialog.Voip.f26829a;
        } else if (z()) {
            obj = PromoDialog.QuickAccess.f26826a;
        } else {
            if (driverScoreItem != null) {
                d8 = Double.valueOf(driverScoreItem.d());
            } else {
                d8 = null;
            }
            if (w(d8)) {
                if (driverScoreItem != null) {
                    obj = new PromoDialog.DriverScoreDropped(((int) (100 - driverScoreItem.d())) + "%");
                }
            } else if (x()) {
                obj = PromoDialog.LowStorage.f26824a;
            }
        }
        Single<Optional<PromoDialog>> w7 = Single.w(Optional.f(obj));
        Intrinsics.e(w7, "just(Optional.of(dialog))");
        return w7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<Optional<PromoDialog>> t(ModalDialogResponse.Dialog dialog) {
        this.f26802g.b(true);
        Single<Optional<PromoDialog>> w7 = Single.w(Optional.f(new PromoDialog.Dynamic(dialog)));
        Intrinsics.e(w7, "just(\n            Option…g\n            )\n        )");
        return w7;
    }

    private final boolean u(Boolean bool) {
        if (Intrinsics.a(bool, Boolean.TRUE) && !this.f26796a.w().e()) {
            return true;
        }
        return false;
    }

    private final boolean v() {
        return !this.f26796a.w().g().a();
    }

    private final boolean w(Double d8) {
        if (d8 != null && this.f26796a.q().k() && this.f26796a.n().e() && d8.doubleValue() <= 97.0d && !this.f26796a.v().p()) {
            return true;
        }
        return false;
    }

    private final boolean x() {
        if (!this.f26796a.v().A() && !StorageUtils.f36324a.a()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private final boolean y() {
        boolean z7;
        int C = this.f26796a.v().C();
        PermissionManager.PermissionInfo o8 = this.f26801f.o("android.permission.POST_NOTIFICATIONS");
        PermissionManager.Companion companion = PermissionManager.f40899f;
        if (!companion.a(o8) && !companion.b(o8)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (Build.VERSION.SDK_INT < 33 || C % 4 != 0 || !z7) {
            return false;
        }
        return true;
    }

    private final boolean z() {
        return !this.f26796a.w().G();
    }

    public final Single<Optional<PromoDialog>> r(PromoDialogEvent event) {
        Intrinsics.f(event, "event");
        if (this.f26802g.a()) {
            Single<Optional<PromoDialog>> w7 = Single.w(Optional.a());
            Intrinsics.e(w7, "just(Optional.empty())");
            return w7;
        }
        Single<Optional<ModalDialogResponse>> D = this.f26797b.a(event.c()).D(Optional.a());
        final Function1<Optional<ModalDialogResponse>, SingleSource<? extends Optional<PromoDialog>>> function1 = new Function1<Optional<ModalDialogResponse>, SingleSource<? extends Optional<PromoDialog>>>() { // from class: ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor$getPromoDailog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Optional<PromoDialog>> invoke(Optional<ModalDialogResponse> it) {
                Single k8;
                Single t7;
                Intrinsics.f(it, "it");
                ModalDialogResponse c8 = it.c();
                if (c8 == null) {
                    k8 = HomePromoDialogInteractor.this.k();
                    return k8;
                } else if (c8 instanceof ModalDialogResponse.Dialog) {
                    t7 = HomePromoDialogInteractor.this.t((ModalDialogResponse.Dialog) c8);
                    return t7;
                } else if (c8 instanceof ModalDialogResponse.Story) {
                    Single w8 = Single.w(Optional.f(new PromoDialog.Story((ModalDialogResponse.Story) c8)));
                    Intrinsics.e(w8, "{\n                      …                        }");
                    return w8;
                } else if (c8 instanceof ModalDialogResponse.Banner) {
                    Single error = Single.error(new IllegalArgumentException("Unsupported modal type Banner"));
                    Intrinsics.e(error, "error(IllegalArgumentExc…rted modal type Banner\"))");
                    return error;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        };
        Single r7 = D.r(new Function() { // from class: ee.mtakso.driver.ui.interactor.promodialog.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource s7;
                s7 = HomePromoDialogInteractor.s(Function1.this, obj);
                return s7;
            }
        });
        Intrinsics.e(r7, "fun getPromoDailog(event…    }\n            }\n    }");
        return r7;
    }
}
