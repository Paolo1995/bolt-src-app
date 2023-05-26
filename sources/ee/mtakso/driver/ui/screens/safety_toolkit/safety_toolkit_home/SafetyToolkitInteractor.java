package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistType;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.RecorderEventState;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyFeatureData;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Lottie;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.util.PermissionUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: SafetyToolkitInteractor.kt */
/* loaded from: classes3.dex */
public final class SafetyToolkitInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f32805a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverConfig f32806b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverSettings f32807c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderProvider f32808d;

    /* renamed from: e  reason: collision with root package name */
    private final EmergencyAssistManager f32809e;

    /* renamed from: f  reason: collision with root package name */
    private final PermissionManager f32810f;

    /* renamed from: g  reason: collision with root package name */
    private final AudioRecordingManager f32811g;

    /* renamed from: h  reason: collision with root package name */
    private final BehaviorSubject<Boolean> f32812h;

    /* compiled from: SafetyToolkitInteractor.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32813a;

        static {
            int[] iArr = new int[EmergencyAssistType.values().length];
            try {
                iArr[EmergencyAssistType.THIRD_PARTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EmergencyAssistType.LOCAL_AUTHORITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f32813a = iArr;
        }
    }

    @Inject
    public SafetyToolkitInteractor(DriverProvider driverProvider, DriverConfig driverConfig, DriverSettings driverSettings, OrderProvider orderProvider, EmergencyAssistManager emergencyAssistManager, PermissionManager permissionManager, AudioRecordingManager audioRecordingManager) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverConfig, "driverConfig");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(emergencyAssistManager, "emergencyAssistManager");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        this.f32805a = driverProvider;
        this.f32806b = driverConfig;
        this.f32807c = driverSettings;
        this.f32808d = orderProvider;
        this.f32809e = emergencyAssistManager;
        this.f32810f = permissionManager;
        this.f32811g = audioRecordingManager;
        BehaviorSubject<Boolean> f8 = BehaviorSubject.f(Boolean.valueOf(PermissionUtils.f41314a.b(permissionManager)));
        Intrinsics.e(f8, "createDefault(\n        P…(permissionManager)\n    )");
        this.f32812h = f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C() {
        return this.f32807c.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n(RecorderState recorderState) {
        if (recorderState instanceof RecorderState.InProgress) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            String format = String.format("<timer timestamp=\"%s\" format=\"mm':'ss\" type=\"count_up\"/>", Arrays.copyOf(new Object[]{String.valueOf(TimeUnit.MILLISECONDS.toSeconds(((RecorderState.InProgress) recorderState).a()) - 1)}, 1));
            Intrinsics.e(format, "format(format, *args)");
            return format;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Text o(EmergencyAssistType emergencyAssistType, boolean z7) {
        Text.Resource resource;
        if (emergencyAssistType == null) {
            return null;
        }
        int i8 = WhenMappings.f32813a[emergencyAssistType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                resource = new Text.Resource(R.string.emergency_call_description, null, 2, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (z7) {
            resource = new Text.Resource(R.string.request_in_progress, null, 2, null);
        } else {
            resource = new Text.Resource(R.string.emergency_assist_get_sos_help, null, 2, null);
        }
        return resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Text p(EmergencyAssistType emergencyAssistType) {
        int i8 = WhenMappings.f32813a[emergencyAssistType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return new Text.Resource(R.string.emergency_call_title, null, 2, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        return new Text.Resource(R.string.emergency_assist_title, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EmergencyAssistType q(ExternalHelpProviderResponse externalHelpProviderResponse) {
        if (externalHelpProviderResponse.a() == null) {
            return EmergencyAssistType.LOCAL_AUTHORITY;
        }
        return EmergencyAssistType.THIRD_PARTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LeftIcon r(RecorderState recorderState, boolean z7) {
        boolean z8;
        Integer valueOf = Integer.valueOf((int) R.attr.dynamicNeutral04);
        if (!z7) {
            return new LeftIcon(LeftIconType.IMAGE, new Image.Res(R.drawable.ic_audio_recording_24), valueOf, null);
        }
        if (Intrinsics.a(recorderState, RecorderState.Initial.f36679a)) {
            z8 = true;
        } else {
            z8 = recorderState instanceof RecorderState.Paused;
        }
        if (z8) {
            return new LeftIcon(LeftIconType.IMAGE, new Image.Res(R.drawable.ic_audio_recording_24), Integer.valueOf((int) R.attr.accentNeutral), null);
        }
        if (Intrinsics.a(recorderState, RecorderState.Complete.f36677a)) {
            return new LeftIcon(LeftIconType.IMAGE, new Image.Res(R.drawable.ic_audio_recording_24), valueOf, null);
        }
        if (recorderState instanceof RecorderState.InProgress) {
            return new LeftIcon(LeftIconType.LOTTIE, null, Integer.valueOf((int) R.attr.linkAlternative), new Lottie.Res(R.raw.lottie_anim_audio_in_progress_icon));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Text s(boolean z7) {
        if (z7) {
            return new Text.Resource(R.string.share_trip_details_description, null, 2, null);
        }
        return new Text.Resource(R.string.share_trip_details_description_inactive, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<RecorderEventState, Text> t(boolean z7, boolean z8, RecorderState recorderState) {
        if (!z7) {
            return new Pair<>(new RecorderEventState.GrantPermission(null, 1, null), new Text.Resource(R.string.grant_permission_to_record, null, 2, null));
        }
        if (!z8) {
            return new Pair<>(new RecorderEventState.AvailableDuringActiveState(null, 1, null), new Text.Resource(R.string.available_during_active_trips, null, 2, null));
        }
        if (Intrinsics.a(recorderState, RecorderState.Complete.f36677a)) {
            return new Pair<>(new RecorderEventState.StartRecording(null, 1, null), new Text.Resource(R.string.start_recording, null, 2, null));
        }
        if (recorderState instanceof RecorderState.InProgress) {
            return new Pair<>(new RecorderEventState.Recording(null, 1, null), new Text.Resource(R.string.recording_in_progress, null, 2, null));
        }
        if (Intrinsics.a(recorderState, RecorderState.Initial.f36679a)) {
            return new Pair<>(new RecorderEventState.StartRecording(null, 1, null), new Text.Resource(R.string.start_recording, null, 2, null));
        }
        if (recorderState instanceof RecorderState.Paused) {
            return new Pair<>(new RecorderEventState.Paused(null, 1, null), new Text.Resource(R.string.recording_paused, null, 2, null));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Observable<Boolean> u() {
        Observable<List<OrderDetails>> a8 = this.f32808d.a();
        final SafetyToolkitInteractor$observeHasActiveOrder$1 safetyToolkitInteractor$observeHasActiveOrder$1 = new Function1<List<? extends OrderDetails>, Boolean>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitInteractor$observeHasActiveOrder$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(List<? extends OrderDetails> it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (OrderProviderUtils.i(it) != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<Boolean> distinctUntilChanged = a8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean v7;
                v7 = SafetyToolkitInteractor.v(Function1.this, obj);
                return v7;
            }
        }).distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "orderProvider.observeOrd…  .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    private final Observable<Boolean> x() {
        return this.f32812h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ToolkitState z(Function5 tmp0, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ToolkitState) tmp0.t(obj, obj2, obj3, obj4, obj5);
    }

    public final void B() {
        this.f32812h.onNext(Boolean.valueOf(PermissionUtils.f41314a.b(this.f32810f)));
    }

    public final void D() {
        if (this.f32806b.Q()) {
            if (this.f32807c.M()) {
                DriverSettings driverSettings = this.f32807c;
                driverSettings.l0(driverSettings.L() + 1);
            }
            if (this.f32807c.L() == 3) {
                E();
            }
        }
    }

    public final void E() {
        if (this.f32806b.Q()) {
            this.f32807c.m0(false);
        }
    }

    public final BehaviorSubject<ExternalHelpProviderResponse> w() {
        return this.f32809e.z();
    }

    public final Observable<List<SafetyFeature>> y() {
        Observable<Boolean> u7 = u();
        BehaviorSubject<ExternalHelpProviderResponse> z7 = this.f32809e.z();
        BehaviorSubject<Boolean> y7 = this.f32809e.y();
        Observable<RecorderState> f8 = this.f32811g.f();
        Observable<Boolean> x7 = x();
        final SafetyToolkitInteractor$observeSafetyToolkitItems$1 safetyToolkitInteractor$observeSafetyToolkitItems$1 = new Function5<Boolean, ExternalHelpProviderResponse, Boolean, RecorderState, Boolean, ToolkitState>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitInteractor$observeSafetyToolkitItems$1
            @Override // kotlin.jvm.functions.Function5
            /* renamed from: b */
            public final ToolkitState t(Boolean hasActiveOrder, ExternalHelpProviderResponse incidentData, Boolean hasActiveIncident, RecorderState recorderState, Boolean recordAudioPermissionGranted) {
                Intrinsics.f(hasActiveOrder, "hasActiveOrder");
                Intrinsics.f(incidentData, "incidentData");
                Intrinsics.f(hasActiveIncident, "hasActiveIncident");
                Intrinsics.f(recorderState, "recorderState");
                Intrinsics.f(recordAudioPermissionGranted, "recordAudioPermissionGranted");
                return new ToolkitState(hasActiveOrder.booleanValue(), incidentData, hasActiveIncident.booleanValue(), recorderState, recordAudioPermissionGranted.booleanValue());
            }
        };
        Observable combineLatest = Observable.combineLatest(u7, z7, y7, f8, x7, new io.reactivex.functions.Function5() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.f
            @Override // io.reactivex.functions.Function5
            public final Object a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                ToolkitState z8;
                z8 = SafetyToolkitInteractor.z(Function5.this, obj, obj2, obj3, obj4, obj5);
                return z8;
            }
        });
        final Function1<ToolkitState, List<? extends SafetyFeature>> function1 = new Function1<ToolkitState, List<? extends SafetyFeature>>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitInteractor$observeSafetyToolkitItems$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<SafetyFeature> invoke(ToolkitState it) {
                DriverProvider driverProvider;
                DriverProvider driverProvider2;
                DriverConfig driverConfig;
                Pair t7;
                LeftIcon r7;
                String n8;
                boolean C;
                Text s7;
                EmergencyAssistType q8;
                Text p8;
                Text o8;
                Intrinsics.f(it, "it");
                driverProvider = SafetyToolkitInteractor.this.f32805a;
                boolean L = driverProvider.q().L();
                driverProvider2 = SafetyToolkitInteractor.this.f32805a;
                boolean I = driverProvider2.n().I();
                driverConfig = SafetyToolkitInteractor.this.f32806b;
                boolean Q = driverConfig.Q();
                boolean b8 = it.b();
                ArrayList arrayList = new ArrayList();
                if (I) {
                    q8 = SafetyToolkitInteractor.this.q(it.c());
                    p8 = SafetyToolkitInteractor.this.p(q8);
                    o8 = SafetyToolkitInteractor.this.o(q8, it.a());
                    arrayList.add(new SafetyFeature(true, new SafetyFeatureData.EmergencyAssist(q8, p8, o8, new Image.Res(R.drawable.ic_emergency_assist_24), it.a())));
                }
                Image.Res res = null;
                if (L) {
                    Text.Resource resource = new Text.Resource(R.string.share_trip_details_title, null, 2, null);
                    s7 = SafetyToolkitInteractor.this.s(b8);
                    arrayList.add(new SafetyFeature(b8, new SafetyFeatureData.ShareRideDetails(resource, s7, new Image.Res(R.drawable.ic_share_trip_24), new Image.Res(R.drawable.ic_info))));
                }
                if (Q) {
                    t7 = SafetyToolkitInteractor.this.t(it.d(), b8, it.e());
                    Text.Resource resource2 = new Text.Resource(R.string.audio_recording_title, null, 2, null);
                    Text text = (Text) t7.e();
                    r7 = SafetyToolkitInteractor.this.r(it.e(), b8);
                    if (!b8 || !it.d()) {
                        res = new Image.Res(R.drawable.ic_info);
                    }
                    n8 = SafetyToolkitInteractor.this.n(it.e());
                    C = SafetyToolkitInteractor.this.C();
                    arrayList.add(new SafetyFeature(b8, new SafetyFeatureData.TripAudioRecording(resource2, text, r7, n8, res, C, it.b(), (RecorderEventState) t7.d())));
                }
                return arrayList;
            }
        };
        Observable<List<SafetyFeature>> map = combineLatest.map(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List A;
                A = SafetyToolkitInteractor.A(Function1.this, obj);
                return A;
            }
        });
        Intrinsics.e(map, "fun observeSafetyToolkit…     list\n        }\n    }");
        return map;
    }
}
