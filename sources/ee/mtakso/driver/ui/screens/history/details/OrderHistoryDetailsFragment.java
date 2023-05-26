package ee.mtakso.driver.ui.screens.history.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderHandleKt;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams;
import ee.mtakso.driver.network.client.contact.ContactOption;
import ee.mtakso.driver.network.client.contact.ContactOptionsUseCase;
import ee.mtakso.driver.network.client.order.OrderStop;
import ee.mtakso.driver.network.client.order.PreviousOrderDetails;
import ee.mtakso.driver.network.client.order.PriceReviewState;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseActivity;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsConfig;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.history.details.banner.InfoBannerState;
import ee.mtakso.driver.ui.screens.history.details.banner.RecordingDuration;
import ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog;
import ee.mtakso.driver.ui.screens.history.details.file_upload.RetryFileUploadFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate;
import ee.mtakso.driver.ui.screens.support.SupportFragment;
import ee.mtakso.driver.ui.screens.waybill.WaybillFragment;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.uicore.components.views.order_stops_view.ItemType;
import ee.mtakso.driver.uicore.components.views.order_stops_view.Stop;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.android.audio_recording_engine.engine.UploadParams;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapController;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.container.MapContainer;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.IconMapPoint;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHistoryDetailsFragment.kt */
/* loaded from: classes3.dex */
public final class OrderHistoryDetailsFragment extends BazeMvvmFragment<OrderHistoryDetailsViewModel> {
    public static final Companion E = new Companion(null);
    private final int A;
    private ActivityResultLauncher<Intent> B;
    private final Lazy C;
    public Map<Integer, View> D;

    /* renamed from: o  reason: collision with root package name */
    private final DateTimeConverter f29426o;

    /* renamed from: p  reason: collision with root package name */
    private final MapProvider f29427p;

    /* renamed from: q  reason: collision with root package name */
    private final AppThemeManager f29428q;

    /* renamed from: r  reason: collision with root package name */
    private final RoutingManager f29429r;

    /* renamed from: s  reason: collision with root package name */
    private final DriverConfig f29430s;

    /* renamed from: t  reason: collision with root package name */
    private final DriverProvider f29431t;

    /* renamed from: u  reason: collision with root package name */
    private final HtmlEngine f29432u;

    /* renamed from: v  reason: collision with root package name */
    private final FragmentFactory f29433v;

    /* renamed from: w  reason: collision with root package name */
    private final Lazy f29434w;

    /* renamed from: x  reason: collision with root package name */
    private DriverAppPlugin f29435x;

    /* renamed from: y  reason: collision with root package name */
    private PreviousOrderDetails f29436y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f29437z;

    /* compiled from: OrderHistoryDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a(OrderHandle orderHandle) {
            Intrinsics.f(orderHandle, "orderHandle");
            return SimpleActivity.Companion.f(SimpleActivity.f27004l, OrderHistoryDetailsFragment.class, OrderHandleKt.d(orderHandle), false, 0, 12, null);
        }
    }

    /* compiled from: OrderHistoryDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29438a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f29439b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f29440c;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.PICK_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.PICK_UP_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.FINAL_DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29438a = iArr;
            int[] iArr2 = new int[OrderState.values().length];
            try {
                iArr2[OrderState.ORDER_STATE_CLIENT_DID_NOT_SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[OrderState.ORDER_STATE_CLIENT_CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[OrderState.ORDER_STATE_DRIVER_REJECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[OrderState.ORDER_STATE_FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            f29439b = iArr2;
            int[] iArr3 = new int[PriceReviewState.values().length];
            try {
                iArr3[PriceReviewState.REQUESTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[PriceReviewState.MANUAL_REVIEW_REQUESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[PriceReviewState.FRAUD_REVIEW_REQUESTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            f29440c = iArr3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OrderHistoryDetailsFragment(BaseUiDependencies deps, DateTimeConverter dateTimeConverter, MapProvider mapProvider, AppThemeManager appThemeManager, RoutingManager routingManager, DriverConfig driverConfig, DriverProvider driverProvider, HtmlEngine htmlEngine, FragmentFactory fragmentFactory) {
        super(deps, R.layout.fragment_order_history_details, null, 4, null);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(driverConfig, "driverConfig");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        this.D = new LinkedHashMap();
        this.f29426o = dateTimeConverter;
        this.f29427p = mapProvider;
        this.f29428q = appThemeManager;
        this.f29429r = routingManager;
        this.f29430s = driverConfig;
        this.f29431t = driverProvider;
        this.f29432u = htmlEngine;
        this.f29433v = fragmentFactory;
        b8 = LazyKt__LazyJVMKt.b(new Function0<OrderHandle>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$orderHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final OrderHandle invoke() {
                Bundle requireArguments = OrderHistoryDetailsFragment.this.requireArguments();
                Intrinsics.e(requireArguments, "requireArguments()");
                return OrderHandleKt.a(requireArguments);
            }
        });
        this.f29434w = b8;
        this.A = 2132017818;
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ee.mtakso.driver.ui.screens.history.details.i
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                OrderHistoryDetailsFragment.O0(OrderHistoryDetailsFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.e(registerForActivityResult, "registerForActivityResul…erHandle)\n        }\n    }");
        this.B = registerForActivityResult;
        b9 = LazyKt__LazyJVMKt.b(new Function0<LowStorageDialogDelegate>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$lowStorageDialogDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final LowStorageDialogDelegate invoke() {
                Context requireContext = OrderHistoryDetailsFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                return new LowStorageDialogDelegate(requireContext);
            }
        });
        this.C = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(OrderHistoryDetailsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void F0() {
        FragmentFactory fragmentFactory = this.f29433v;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b((FileUploadConfirmationDialog) FragmentFactoryUtils.b(fragmentFactory, requireContext, FileUploadConfirmationDialog.class, FileUploadConfirmationDialog.f29539o.a(r0())), this, "TAG_FILE_UPLOAD_CONFIRMATION_DIALOG");
    }

    private final void H0(List<OrderStop> list) {
        int d8;
        IconMapPoint iconMapPoint;
        DriverAppPlugin driverAppPlugin = this.f29435x;
        if (driverAppPlugin != null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            int i8 = 0;
            for (Object obj : list) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                GeoCoordinate a8 = OrderStopExtKt.a((OrderStop) obj);
                if (a8 == null) {
                    iconMapPoint = null;
                } else {
                    if (i8 == 0) {
                        Context requireContext = requireContext();
                        Intrinsics.e(requireContext, "requireContext()");
                        d8 = ContextUtilsKt.d(requireContext, R.attr.markerMapPickup);
                    } else if (i8 == size - 1) {
                        Context requireContext2 = requireContext();
                        Intrinsics.e(requireContext2, "requireContext()");
                        d8 = ContextUtilsKt.d(requireContext2, R.attr.markerMapDestinationHistory);
                    } else {
                        Context requireContext3 = requireContext();
                        Intrinsics.e(requireContext3, "requireContext()");
                        d8 = ContextUtilsKt.d(requireContext3, R.attr.markerMapMidStop);
                    }
                    iconMapPoint = new IconMapPoint(a8, d8);
                }
                if (iconMapPoint != null) {
                    arrayList.add(iconMapPoint);
                }
                i8 = i9;
            }
            driverAppPlugin.B(arrayList);
        }
        ((MapContainer) d0(R.id.rideDetailsMap)).a();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void I0(ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetails r10) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment.I0(ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetails):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void J0(ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetails r6) {
        /*
            r5 = this;
            ee.mtakso.driver.network.client.order.PreviousOrderDetails r6 = r6.a()
            int r0 = ee.mtakso.driver.R.id.rideDetailsCallClientLayout
            android.view.View r0 = r5.d0(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r1 = "rideDetailsCallClientLayout"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r1 = 0
            r2 = 2
            r3 = 0
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r0, r1, r1, r2, r3)
            int r0 = ee.mtakso.driver.R.id.tvTipsInfo
            android.view.View r0 = r5.d0(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "tvTipsInfo"
            kotlin.jvm.internal.Intrinsics.e(r0, r4)
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r0, r1, r1, r2, r3)
            java.lang.String r0 = r6.e()
            if (r0 == 0) goto L36
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L34
            goto L36
        L34:
            r0 = 0
            goto L37
        L36:
            r0 = 1
        L37:
            if (r0 == 0) goto L52
            int r6 = ee.mtakso.driver.R.id.rideDetailsPropertiesRideTypeLayout
            android.view.View r6 = r5.d0(r6)
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            r0 = 8
            r6.setVisibility(r0)
            int r6 = ee.mtakso.driver.R.id.rideDetailsPropertiesLayout
            android.view.View r6 = r5.d0(r6)
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            r6.setVisibility(r0)
            goto L7a
        L52:
            int r0 = ee.mtakso.driver.R.id.rideDetailsPropertiesRideTypeLayout
            android.view.View r0 = r5.d0(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r0.setVisibility(r1)
            int r0 = ee.mtakso.driver.R.id.rideDetailsPropertiesLayout
            android.view.View r0 = r5.d0(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r0.setVisibility(r1)
            int r0 = ee.mtakso.driver.R.id.rideDetailsPrice
            android.view.View r0 = r5.d0(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r6.e()
            r0.setText(r1)
            r5.Q0(r6)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment.J0(ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetails):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(DriverAppPlugin driverAppPlugin) {
        if (getView() == null) {
            return;
        }
        this.f29435x = driverAppPlugin;
        driverAppPlugin.o(AppThemeUtils.f34255a.c(this.f29428q.d()));
        this.f29437z = true;
        M().t0(r0());
        LiveData<OrderHistoryDetails> C0 = M().C0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<OrderHistoryDetails, Unit> function1 = new Function1<OrderHistoryDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderHistoryDetails order) {
                OrderHistoryDetailsFragment orderHistoryDetailsFragment = OrderHistoryDetailsFragment.this;
                Intrinsics.e(order, "order");
                orderHistoryDetailsFragment.P0(order);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderHistoryDetails orderHistoryDetails) {
                b(orderHistoryDetails);
                return Unit.f50853a;
            }
        };
        C0.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.history.details.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderHistoryDetailsFragment.L0(Function1.this, obj);
            }
        });
        LiveData<List<ContactOption>> y02 = M().y0();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<List<? extends ContactOption>, Unit> function12 = new Function1<List<? extends ContactOption>, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$start$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<? extends ContactOption> contacts) {
                Group rideDetailsCallGroup = (Group) OrderHistoryDetailsFragment.this.d0(R.id.rideDetailsCallGroup);
                Intrinsics.e(rideDetailsCallGroup, "rideDetailsCallGroup");
                Intrinsics.e(contacts, "contacts");
                ViewExtKt.e(rideDetailsCallGroup, !contacts.isEmpty(), 0, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ContactOption> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        y02.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.history.details.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderHistoryDetailsFragment.M0(Function1.this, obj);
            }
        });
        if (this.f29431t.q().J() && this.f29430s.Q()) {
            LiveData<InfoBannerState> z02 = M().z0();
            LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
            final Function1<InfoBannerState, Unit> function13 = new Function1<InfoBannerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$start$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(InfoBannerState it) {
                    OrderHandle r02;
                    OrderHistoryDetailsFragment orderHistoryDetailsFragment = OrderHistoryDetailsFragment.this;
                    Intrinsics.e(it, "it");
                    r02 = OrderHistoryDetailsFragment.this.r0();
                    orderHistoryDetailsFragment.T0(it, r02);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InfoBannerState infoBannerState) {
                    b(infoBannerState);
                    return Unit.f50853a;
                }
            };
            z02.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.history.details.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    OrderHistoryDetailsFragment.N0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(OrderHistoryDetailsFragment this$0, ActivityResult result) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(result, "result");
        if (result.b() == -1 || result.b() == 0) {
            this$0.M().t0(this$0.r0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void P0(ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetails r24) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment.P0(ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetails):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void Q0(ee.mtakso.driver.network.client.order.PreviousOrderDetails r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.h()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L11
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto Lf
            goto L11
        Lf:
            r0 = 0
            goto L12
        L11:
            r0 = 1
        L12:
            r3 = 8
            if (r0 == 0) goto L2e
            java.lang.Long r0 = r9.j()
            if (r0 != 0) goto L2e
            java.lang.Long r0 = r9.i()
            if (r0 != 0) goto L2e
            int r9 = ee.mtakso.driver.R.id.rideDetailsMetricsLayout
            android.view.View r9 = r8.d0(r9)
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            r9.setVisibility(r3)
            return
        L2e:
            java.lang.String r0 = r9.h()
            if (r0 == 0) goto L3d
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L3b
            goto L3d
        L3b:
            r0 = 0
            goto L3e
        L3d:
            r0 = 1
        L3e:
            if (r0 != 0) goto L50
            int r0 = ee.mtakso.driver.R.id.rideDetailsDistance
            android.view.View r0 = r8.d0(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = r9.h()
            r0.setText(r4)
            goto L5b
        L50:
            int r0 = ee.mtakso.driver.R.id.rideDetailsDistanceLayout
            android.view.View r0 = r8.d0(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.setVisibility(r3)
        L5b:
            java.lang.Long r0 = r9.j()
            java.lang.Long r9 = r9.i()
            if (r0 == 0) goto Lbe
            if (r9 == 0) goto Lbe
            long r3 = r9.longValue()
            long r5 = r0.longValue()
            long r3 = r3 - r5
            int r9 = ee.mtakso.driver.R.id.rideDetailsDuration
            android.view.View r9 = r8.d0(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.f51021a
            r0 = 2
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MINUTES
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            long r3 = r6.convert(r3, r7)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r5[r1] = r3
            r1 = 2131953302(0x7f130696, float:1.9543071E38)
            java.lang.String r1 = r8.getString(r1)
            java.lang.String r3 = "getString(R.string.minutes)"
            kotlin.jvm.internal.Intrinsics.e(r1, r3)
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r4 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.e(r3, r4)
            java.lang.String r1 = r1.toLowerCase(r3)
            java.lang.String r3 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.e(r1, r3)
            r5[r2] = r1
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r5, r0)
            java.lang.String r1 = "%d %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            java.lang.String r1 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r9.setText(r0)
            goto Lc9
        Lbe:
            int r9 = ee.mtakso.driver.R.id.rideDetailsDurationLayout
            android.view.View r9 = r8.d0(r9)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            r9.setVisibility(r3)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment.Q0(ee.mtakso.driver.network.client.order.PreviousOrderDetails):void");
    }

    private final void R0(Text text, Text text2) {
        q0().x(new PopupToolbarAppearance(0, text, false, text2, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$updateToolbarAppearance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                RoutingManager routingManager;
                OrderHandle r02;
                routingManager = OrderHistoryDetailsFragment.this.f29429r;
                WaybillFragment.Companion companion = WaybillFragment.f33614r;
                r02 = OrderHistoryDetailsFragment.this.r0();
                RoutingManager.d(routingManager, companion.a(r02), false, 2, null);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, null, null, null, null, 485, null));
    }

    static /* synthetic */ void S0(OrderHistoryDetailsFragment orderHistoryDetailsFragment, Text text, Text text2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            text2 = null;
        }
        orderHistoryDetailsFragment.R0(text, text2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(final InfoBannerState infoBannerState, OrderHandle orderHandle) {
        int i8 = R.id.tripAudioInfoBlock;
        ((AppCompatTextView) d0(i8).findViewById(R.id.f19833m7)).setText(getString(R.string.audio_recording_info_message));
        View d02 = d0(i8);
        int i9 = R.id.subDefinition;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        ((AppCompatTextView) d02.findViewById(i9)).setTextColor(ContextUtilsKt.b(requireContext, R.attr.contentSecondary));
        if (Intrinsics.a(infoBannerState, InfoBannerState.Initial.f29526a)) {
            View tripAudioInfoBlock = d0(i8);
            Intrinsics.e(tripAudioInfoBlock, "tripAudioInfoBlock");
            ViewExtKt.e(tripAudioInfoBlock, false, 0, 2, null);
            View divider = d0(R.id.f19837u3);
            Intrinsics.e(divider, "divider");
            ViewExtKt.e(divider, false, 0, 2, null);
        } else if (infoBannerState instanceof InfoBannerState.ShareWithCSState) {
            M().O0();
            View divider2 = d0(R.id.f19837u3);
            Intrinsics.e(divider2, "divider");
            ViewExtKt.e(divider2, false, 0, 3, null);
            View tripAudioInfoBlock2 = d0(i8);
            Intrinsics.e(tripAudioInfoBlock2, "tripAudioInfoBlock");
            ViewExtKt.e(tripAudioInfoBlock2, false, 0, 3, null);
            ((AppCompatTextView) d0(i8).findViewById(R.id.gc)).setText(s0(o0(((InfoBannerState.ShareWithCSState) infoBannerState).a())));
            ((AppCompatTextView) d0(i8).findViewById(i9)).setText(this.f29432u.a(getString(R.string.send_file_to_cs)));
            Context requireContext2 = requireContext();
            Intrinsics.e(requireContext2, "requireContext()");
            ((AppCompatTextView) d0(i8).findViewById(i9)).setTextColor(ContextUtilsKt.b(requireContext2, R.attr.contentPrimary));
            ((AppCompatTextView) d0(i8).findViewById(i9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.history.details.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderHistoryDetailsFragment.U0(OrderHistoryDetailsFragment.this, infoBannerState, view);
                }
            });
        } else if (Intrinsics.a(infoBannerState, InfoBannerState.UnsharedFileExpiredState.f29530a)) {
            M().O0();
            View divider3 = d0(R.id.f19837u3);
            Intrinsics.e(divider3, "divider");
            ViewExtKt.e(divider3, false, 0, 3, null);
            View tripAudioInfoBlock3 = d0(i8);
            Intrinsics.e(tripAudioInfoBlock3, "tripAudioInfoBlock");
            ViewExtKt.e(tripAudioInfoBlock3, false, 0, 3, null);
            ((AppCompatTextView) d0(i8).findViewById(R.id.gc)).setText(getString(R.string.audio_recording_expired));
            ((AppCompatTextView) d0(i8).findViewById(i9)).setText(getString(R.string.recording_expired));
            Context requireContext3 = requireContext();
            Intrinsics.e(requireContext3, "requireContext()");
            ((AppCompatTextView) d0(i8).findViewById(i9)).setTextColor(ContextUtilsKt.b(requireContext3, R.attr.contentSecondary));
        } else if (infoBannerState instanceof InfoBannerState.FileSharedAndAvailable) {
            M().O0();
            View divider4 = d0(R.id.f19837u3);
            Intrinsics.e(divider4, "divider");
            ViewExtKt.e(divider4, false, 0, 3, null);
            View tripAudioInfoBlock4 = d0(i8);
            Intrinsics.e(tripAudioInfoBlock4, "tripAudioInfoBlock");
            ViewExtKt.e(tripAudioInfoBlock4, false, 0, 3, null);
            InfoBannerState.FileSharedAndAvailable fileSharedAndAvailable = (InfoBannerState.FileSharedAndAvailable) infoBannerState;
            ((AppCompatTextView) d0(i8).findViewById(R.id.gc)).setText(s0(o0(fileSharedAndAvailable.a())));
            ((AppCompatTextView) d0(i8).findViewById(i9)).setText(getString(R.string.recording_sent, fileSharedAndAvailable.b()));
        } else if (infoBannerState instanceof InfoBannerState.FileSharedAndExpired) {
            M().O0();
            View divider5 = d0(R.id.f19837u3);
            Intrinsics.e(divider5, "divider");
            ViewExtKt.e(divider5, false, 0, 3, null);
            View tripAudioInfoBlock5 = d0(i8);
            Intrinsics.e(tripAudioInfoBlock5, "tripAudioInfoBlock");
            ViewExtKt.e(tripAudioInfoBlock5, false, 0, 3, null);
            ((AppCompatTextView) d0(i8).findViewById(R.id.gc)).setText(getString(R.string.audio_recording_expired));
            ((AppCompatTextView) d0(i8).findViewById(i9)).setText(getString(R.string.recording_sent, ((InfoBannerState.FileSharedAndExpired) infoBannerState).a()));
        } else if (infoBannerState instanceof InfoBannerState.LoadingState) {
            View divider6 = d0(R.id.f19837u3);
            Intrinsics.e(divider6, "divider");
            ViewExtKt.e(divider6, false, 0, 3, null);
            View tripAudioInfoBlock6 = d0(i8);
            Intrinsics.e(tripAudioInfoBlock6, "tripAudioInfoBlock");
            ViewExtKt.e(tripAudioInfoBlock6, false, 0, 3, null);
            ((AppCompatTextView) d0(i8).findViewById(R.id.gc)).setText(s0(o0(((InfoBannerState.LoadingState) infoBannerState).a())));
            ((AppCompatTextView) d0(i8).findViewById(i9)).setText(getString(R.string.loading_status));
            M().t0(orderHandle);
        } else if (infoBannerState instanceof InfoBannerState.ErrorState) {
            M().O0();
            View divider7 = d0(R.id.f19837u3);
            Intrinsics.e(divider7, "divider");
            ViewExtKt.e(divider7, false, 0, 3, null);
            View tripAudioInfoBlock7 = d0(i8);
            Intrinsics.e(tripAudioInfoBlock7, "tripAudioInfoBlock");
            ViewExtKt.e(tripAudioInfoBlock7, false, 0, 3, null);
            ((AppCompatTextView) d0(i8).findViewById(R.id.gc)).setText(s0(o0(((InfoBannerState.ErrorState) infoBannerState).a())));
            ((AppCompatTextView) d0(i8).findViewById(i9)).setText(this.f29432u.a(getString(R.string.recording_error_status)));
            ((AppCompatTextView) d0(i8).findViewById(i9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.history.details.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderHistoryDetailsFragment.V0(OrderHistoryDetailsFragment.this, infoBannerState, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(OrderHistoryDetailsFragment this$0, InfoBannerState infoBannerState, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(infoBannerState, "$infoBannerState");
        this$0.y0(((InfoBannerState.ShareWithCSState) infoBannerState).b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(OrderHistoryDetailsFragment this$0, InfoBannerState infoBannerState, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(infoBannerState, "$infoBannerState");
        this$0.x0(((InfoBannerState.ErrorState) infoBannerState).a());
    }

    private final List<Stop> m0(List<Stop> list, OrderState orderState) {
        List<Stop> J0;
        List<Stop> J02;
        List<Stop> J03;
        List<Stop> J04;
        List<Stop> J05;
        List<Stop> J06;
        switch (WhenMappings.f29439b[orderState.ordinal()]) {
            case 1:
                J0 = CollectionsKt___CollectionsKt.J0(list);
                ItemType itemType = ItemType.RIDE_CANCELLED;
                String string = getString(R.string.history_ride_rider_didnt_show);
                Intrinsics.e(string, "getString(R.string.history_ride_rider_didnt_show)");
                Context requireContext = requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                int b8 = ContextUtilsKt.b(requireContext, R.attr.accentOrange);
                Context requireContext2 = requireContext();
                Intrinsics.e(requireContext2, "requireContext()");
                J0.add(new Stop(itemType, null, string, null, b8, ContextUtilsKt.d(requireContext2, R.attr.markerRouteCancelled), 0, 72, null));
                return J0;
            case 2:
                J02 = CollectionsKt___CollectionsKt.J0(list);
                ItemType itemType2 = ItemType.RIDE_DECLINED;
                String string2 = getString(R.string.history_ride_didnot_respond);
                Intrinsics.e(string2, "getString(R.string.history_ride_didnot_respond)");
                Context requireContext3 = requireContext();
                Intrinsics.e(requireContext3, "requireContext()");
                int b9 = ContextUtilsKt.b(requireContext3, R.attr.contentCritical);
                Context requireContext4 = requireContext();
                Intrinsics.e(requireContext4, "requireContext()");
                J02.add(new Stop(itemType2, null, string2, null, b9, ContextUtilsKt.d(requireContext4, R.attr.markerRouteRejected), 0, 72, null));
                return J02;
            case 3:
                J03 = CollectionsKt___CollectionsKt.J0(list);
                ItemType itemType3 = ItemType.RIDE_CANCELLED;
                String string3 = getString(R.string.history_ride_rider_cancelled);
                Intrinsics.e(string3, "getString(R.string.history_ride_rider_cancelled)");
                Context requireContext5 = requireContext();
                Intrinsics.e(requireContext5, "requireContext()");
                int b10 = ContextUtilsKt.b(requireContext5, R.attr.accentOrange);
                Context requireContext6 = requireContext();
                Intrinsics.e(requireContext6, "requireContext()");
                J03.add(new Stop(itemType3, null, string3, null, b10, ContextUtilsKt.d(requireContext6, R.attr.markerRouteCancelled), 0, 72, null));
                return J03;
            case 4:
                J04 = CollectionsKt___CollectionsKt.J0(list);
                ItemType itemType4 = ItemType.RIDE_DECLINED;
                String string4 = getString(R.string.history_ride_declined);
                Intrinsics.e(string4, "getString(R.string.history_ride_declined)");
                Context requireContext7 = requireContext();
                Intrinsics.e(requireContext7, "requireContext()");
                int b11 = ContextUtilsKt.b(requireContext7, R.attr.contentCritical);
                Context requireContext8 = requireContext();
                Intrinsics.e(requireContext8, "requireContext()");
                J04.add(new Stop(itemType4, null, string4, null, b11, ContextUtilsKt.d(requireContext8, R.attr.markerRouteRejected), 0, 72, null));
                return J04;
            case 5:
                J05 = CollectionsKt___CollectionsKt.J0(list);
                ItemType itemType5 = ItemType.RIDE_CANCELLED;
                String string5 = getString(R.string.auto_cancelled_payment_failed);
                Intrinsics.e(string5, "getString(R.string.auto_cancelled_payment_failed)");
                Context requireContext9 = requireContext();
                Intrinsics.e(requireContext9, "requireContext()");
                int b12 = ContextUtilsKt.b(requireContext9, R.attr.accentOrange);
                Context requireContext10 = requireContext();
                Intrinsics.e(requireContext10, "requireContext()");
                J05.add(new Stop(itemType5, null, string5, null, b12, ContextUtilsKt.d(requireContext10, R.attr.markerRouteCancelled), 0, 72, null));
                return J05;
            case 6:
                return list;
            default:
                Kalev.d("Unexpected order state " + orderState);
                J06 = CollectionsKt___CollectionsKt.J0(list);
                ItemType itemType6 = ItemType.RIDE_DECLINED;
                String string6 = getString(R.string.error);
                Intrinsics.e(string6, "getString(R.string.error)");
                Context requireContext11 = requireContext();
                Intrinsics.e(requireContext11, "requireContext()");
                int b13 = ContextUtilsKt.b(requireContext11, R.attr.contentCritical);
                Context requireContext12 = requireContext();
                Intrinsics.e(requireContext12, "requireContext()");
                J06.add(new Stop(itemType6, null, string6, null, b13, ContextUtilsKt.d(requireContext12, R.attr.markerRouteRejected), 0, 72, null));
                return J06;
        }
    }

    private final String n0(long j8) {
        if (j8 > 0) {
            String format = this.f29426o.c("HH:mm").format(Long.valueOf(j8 * 1000));
            Intrinsics.e(format, "dateTimeConverter.getDat….format(timeStamp * 1000)");
            return format;
        }
        return "";
    }

    private final RecordingDuration o0(Long l8) {
        if (l8 != null) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long j8 = 60;
            return new RecordingDuration((int) (timeUnit.toHours(l8.longValue()) % 24), (int) (timeUnit.toMinutes(l8.longValue()) % j8), (int) (timeUnit.toSeconds(l8.longValue()) % j8));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LowStorageDialogDelegate p0() {
        return (LowStorageDialogDelegate) this.C.getValue();
    }

    private final Navigator q0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrderHandle r0() {
        return (OrderHandle) this.f29434w.getValue();
    }

    private final CharSequence s0(RecordingDuration recordingDuration) {
        if (recordingDuration == null) {
            String string = getString(R.string.audio_recording_title);
            Intrinsics.e(string, "getString(R.string.audio_recording_title)");
            return string;
        } else if (recordingDuration.b() != 0 && recordingDuration.a() != 0) {
            String string2 = getString(R.string.audio_recording_banner_hr_min, Integer.valueOf(recordingDuration.a()), Integer.valueOf(recordingDuration.b()));
            Intrinsics.e(string2, "{\n                getStr…ration.min)\n            }");
            return string2;
        } else if (recordingDuration.a() != 0) {
            String string3 = getString(R.string.audio_recording_banner_hr, Integer.valueOf(recordingDuration.a()));
            Intrinsics.e(string3, "{\n                getStr…tion.hours)\n            }");
            return string3;
        } else if (recordingDuration.b() != 0) {
            String string4 = getString(R.string.audio_recording_banner_min, Integer.valueOf(recordingDuration.b()));
            Intrinsics.e(string4, "{\n                getStr…ration.min)\n            }");
            return string4;
        } else if (recordingDuration.c() != 0) {
            String string5 = getString(R.string.audio_recording_banner_sec, Integer.valueOf(recordingDuration.c()));
            Intrinsics.e(string5, "{\n                getStr…ration.sec)\n            }");
            return string5;
        } else {
            String string6 = getString(R.string.audio_recording_title);
            Intrinsics.e(string6, "getString(R.string.audio_recording_title)");
            return string6;
        }
    }

    private final ItemType t0(int i8, int i9) {
        if (i9 == 1) {
            return ItemType.PICK_UP_ONLY;
        }
        if (i8 == i9 - 1) {
            return ItemType.FINAL_DESTINATION;
        }
        if (i8 == 0) {
            return ItemType.PICK_UP;
        }
        return ItemType.COMMON;
    }

    private final void u0(String str) {
        M().l0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        Navigator.DefaultImpls.b(q0(), RetryFileUploadFragment.class, RetryFileUploadFragment.f29549s.a(r0()), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(String str) {
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        FragmentActivity requireActivity = requireActivity();
        Bundle d8 = SupportFragment.Companion.d(SupportFragment.f33440u, str, null, 2, null);
        Intrinsics.e(requireActivity, "requireActivity()");
        this.B.launch(companion.g(requireActivity, SupportFragment.class, d8, false));
    }

    private final void x0(Long l8) {
        M().J0(l8);
    }

    private final void y0(WebAppLaunchParams webAppLaunchParams) {
        M().S0();
        List<UploadParams> f8 = M().H0().f();
        if (f8 != null && f8.isEmpty() && webAppLaunchParams != null) {
            u0(webAppLaunchParams.a());
        } else {
            F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(OrderHistoryDetailsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        ContactMethodsBaseActivity.Companion companion = ContactMethodsBaseActivity.f27750n;
        Context requireContext = this$0.requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        Bundle a8 = ContactOptionsFragment.F.a(new ContactOptionsConfig(false, null, ContactOptionsUseCase.HISTORY, this$0.r0(), 3, null));
        Intent intent = new Intent(requireContext, ContactMethodsBaseActivity.class);
        intent.putExtra("dialog_class_argument", ContactOptionsFragment.class);
        if (a8 != null) {
            intent.putExtra("dialog_extra_params", a8);
        }
        intent.addFlags(268500992);
        requireContext.startActivity(intent);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.D.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.A);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: G0 */
    public OrderHistoryDetailsViewModel Q() {
        BaseUiDependencies E2;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E2 = E();
        return (OrderHistoryDetailsViewModel) new ViewModelProvider(requireActivity, E2.d()).a(OrderHistoryDetailsViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.error);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        String k8 = ApiExceptionUtils.k(throwable, requireContext);
        String string2 = getString(R.string.ok_lowercase);
        Intrinsics.e(string2, "getString(R.string.ok_lowercase)");
        NotificationDialog d8 = NotificationDialog.Companion.d(companion, string, k8, string2, throwable, null, 16, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(d8, requireActivity, "error");
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.D;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        S0(this, new Text.Resource(R.string.ride_history, null, 2, null), null, 2, null);
        LowStorageDialogDelegate p02 = p0();
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Intrinsics.e(supportFragmentManager, "requireActivity().supportFragmentManager");
        p02.d(supportFragmentManager);
        ((MapContainer) d0(R.id.rideDetailsMap)).c(AppThemeUtils.f34255a.c(this.f29428q.d()));
        getChildFragmentManager().beginTransaction().replace(R.id.f542rideDetailsMap, this.f29427p.a(new Function1<MapController, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$onViewCreated$mapFragment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapController it) {
                Intrinsics.f(it, "it");
                OrderHistoryDetailsFragment.this.K0((DriverAppPlugin) it.a("driver"));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapController mapController) {
                b(mapController);
                return Unit.f50853a;
            }
        }), "ride_details_map").commit();
        if (bundle == null) {
            M().W0(r0());
        }
        Group rideDetailsCallGroup = (Group) d0(R.id.rideDetailsCallGroup);
        Intrinsics.e(rideDetailsCallGroup, "rideDetailsCallGroup");
        ViewExtKt.e(rideDetailsCallGroup, false, 0, 2, null);
        ((LinearLayout) d0(R.id.rideDetailsCallClientLayout)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.history.details.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderHistoryDetailsFragment.z0(OrderHistoryDetailsFragment.this, view2);
            }
        });
        ((LinearLayout) d0(R.id.supportContainer)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.history.details.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderHistoryDetailsFragment.A0(OrderHistoryDetailsFragment.this, view2);
            }
        });
        LiveData<String> E0 = M().E0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                SupportFragment.Companion companion = SupportFragment.f33440u;
                Context requireContext = OrderHistoryDetailsFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                SupportFragment.Companion.f(companion, requireContext, str, null, 4, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        E0.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.history.details.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderHistoryDetailsFragment.B0(Function1.this, obj);
            }
        });
        LiveEvent<String> F0 = M().F0();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner2, "viewLifecycleOwner");
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                OrderHistoryDetailsFragment orderHistoryDetailsFragment = OrderHistoryDetailsFragment.this;
                Intrinsics.e(it, "it");
                orderHistoryDetailsFragment.w0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        F0.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.history.details.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderHistoryDetailsFragment.C0(Function1.this, obj);
            }
        });
        LiveEvent<Unit> G0 = M().G0();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner3, "viewLifecycleOwner");
        final Function1<Unit, Unit> function13 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                OrderHistoryDetailsFragment.this.v0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        G0.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.history.details.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderHistoryDetailsFragment.D0(Function1.this, obj);
            }
        });
        LiveEvent<Unit> B0 = M().B0();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner4, "viewLifecycleOwner");
        final Function1<Unit, Unit> function14 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment$onViewCreated$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                LowStorageDialogDelegate p03;
                p03 = OrderHistoryDetailsFragment.this.p0();
                FragmentActivity requireActivity = OrderHistoryDetailsFragment.this.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                p03.b(requireActivity);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        B0.i(viewLifecycleOwner4, new Observer() { // from class: ee.mtakso.driver.ui.screens.history.details.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderHistoryDetailsFragment.E0(Function1.this, obj);
            }
        });
    }
}
