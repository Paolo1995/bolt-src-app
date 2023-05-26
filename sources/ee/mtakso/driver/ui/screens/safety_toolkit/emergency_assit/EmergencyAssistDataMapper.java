package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpResponder;
import ee.mtakso.driver.network.client.emergencyassist.reverse_geocode.EmergencyAssistReverseGeocodeResponse;
import ee.mtakso.driver.network.client.vehicle.Car;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.FooterEmergencyHelpDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.earnings.network.DriverImage;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: EmergencyAssistDataMapper.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistDataMapper {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f32666c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverImageMapper f32667a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f32668b;

    /* compiled from: EmergencyAssistDataMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmergencyAssistDataMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32669a;

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
            f32669a = iArr;
        }
    }

    @Inject
    public EmergencyAssistDataMapper(DriverImageMapper imageMapper, DriverProvider driverProvider) {
        Intrinsics.f(imageMapper, "imageMapper");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f32667a = imageMapper;
        this.f32668b = driverProvider;
    }

    private final String b(EmergencyAssistReverseGeocodeResponse emergencyAssistReverseGeocodeResponse) {
        boolean z7;
        String b8 = emergencyAssistReverseGeocodeResponse.b();
        if (b8.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            String a8 = emergencyAssistReverseGeocodeResponse.a().a();
            if (a8 == null) {
                a8 = "";
            }
            return a8;
        }
        return b8;
    }

    private final EmergencyAssistType c(ExternalHelpResponder externalHelpResponder) {
        if (externalHelpResponder == null) {
            return EmergencyAssistType.LOCAL_AUTHORITY;
        }
        return EmergencyAssistType.THIRD_PARTY;
    }

    private final EmergencyAssistFooterData d(ExternalHelpResponder externalHelpResponder) {
        Image image;
        if (externalHelpResponder == null) {
            return null;
        }
        DriverImage a8 = externalHelpResponder.a();
        if (a8 != null) {
            image = this.f32667a.a(a8);
        } else {
            image = null;
        }
        return new EmergencyAssistFooterData(new Text.Resource(R.string.powered_by, null, 2, null), image);
    }

    private final SafetyToolkitVehicleInfo e(Car car) {
        List C0;
        Object W;
        List C02;
        Object h02;
        String s02;
        if (car != null) {
            String c8 = car.c();
            C0 = StringsKt__StringsKt.C0(car.b(), new String[]{","}, false, 0, 6, null);
            W = CollectionsKt___CollectionsKt.W(C0);
            C02 = StringsKt__StringsKt.C0(car.b(), new String[]{","}, false, 0, 6, null);
            h02 = CollectionsKt___CollectionsKt.h0(C02);
            s02 = StringsKt__StringsKt.s0((String) h02, " ");
            return new SafetyToolkitVehicleInfo(c8, (String) W, s02);
        }
        return null;
    }

    private final Text f(SafetyToolkitVehicleInfo safetyToolkitVehicleInfo, View view) {
        SpannableString spannableString = new SpannableString("•");
        SpannableString spannableString2 = new SpannableString(" " + ((Object) spannableString) + " ");
        Context context = view.getContext();
        Intrinsics.e(context, "view.context");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextUtilsKt.b(context, R.attr.dynamicNeutral03));
        Context context2 = view.getContext();
        Intrinsics.e(context2, "view.context");
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(ContextUtilsKt.b(context2, R.attr.dynamicNeutral03));
        SpannableString spannableString3 = new SpannableString(safetyToolkitVehicleInfo.c());
        SpannableString spannableString4 = new SpannableString(safetyToolkitVehicleInfo.b());
        SpannableString spannableString5 = new SpannableString(safetyToolkitVehicleInfo.a());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) spannableString3).append((CharSequence) spannableString2).append((CharSequence) spannableString4).append((CharSequence) spannableString2).append((CharSequence) spannableString5);
        int length = spannableString3.length();
        int length2 = spannableString3.length() + spannableString2.length();
        spannableStringBuilder.setSpan(foregroundColorSpan, length, length2, 33);
        int length3 = length2 + spannableString4.length();
        spannableStringBuilder.setSpan(foregroundColorSpan2, length3, spannableString2.length() + length3, 33);
        return new Text.Value(spannableStringBuilder);
    }

    public final List<ListModel> a(EmergencyAssistUIData emergencyAssistUIData, View view) {
        ButtonItemDelegate.Model model;
        int i8;
        ButtonItemDelegate.Model model2;
        List<ListModel> H0;
        List e8;
        Intrinsics.f(emergencyAssistUIData, "emergencyAssistUIData");
        Intrinsics.f(view, "view");
        ArrayList arrayList = new ArrayList();
        int i9 = WhenMappings.f32669a[emergencyAssistUIData.d().ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                arrayList.add(new InfoBlockDelegate.Model("infoblockthirdpartywarning", null, null, null, null, new Text.Resource(R.string.give_the_operator_information, null, 2, null), new Color.Attr(R.attr.infoBlockTextWarningSecondary), null, null, new Color.Attr(R.attr.infoBlockBackgroundTintWarning), new Image.Res(R.drawable.ic_common_alert), new Color.Attr(R.attr.infoBlockIconTintWarning), Dimens.c(16), Dimens.c(16), new Margins(Dimens.c(12), Dimens.c(12), Dimens.c(12), Dimens.c(12)), 414, null));
                e8 = CollectionsKt__CollectionsJVMKt.e(emergencyAssistUIData.c());
                model = new ButtonItemDelegate.Model("emergencyAssistCall", new Text.Resource(R.string.call_local_authority, e8), null, null, null, UiKitRoundButtonType.f36163m, null, null, true, null, new Margins(Dimens.c(24), Dimens.c(24), Dimens.c(24), Dimens.c(16)), emergencyAssistUIData, false, null, null, 0.0f, false, false, 254684, null);
                i8 = 2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            i8 = 2;
            model = new ButtonItemDelegate.Model("emergencyAssistSosAction", new Text.Resource(R.string.emergency_assist_get_sos_help, null, 2, null), null, null, null, UiKitRoundButtonType.f36163m, null, null, true, null, new Margins(Dimens.c(24), Dimens.c(24), Dimens.c(24), Dimens.c(16)), emergencyAssistUIData, false, null, null, 0.0f, false, false, 254684, null);
        }
        arrayList.add(new TwoLinesItemDelegate.Model("emergencyAssistLocation", new Text.Resource(R.string.estimated_location, null, i8, null), 2132017742, new Color.Attr(R.attr.contentSecondary), null, new Text.Value(emergencyAssistUIData.a()), 2132017739, new Color.Attr(R.attr.contentPrimary), null, null, null, null, null, null, null, null, null, null, null, false, 0, 0, true, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, false, false, false, 506986256, null));
        SafetyToolkitVehicleInfo e9 = emergencyAssistUIData.e();
        if (e9 != null) {
            arrayList.add(new TwoLinesItemDelegate.Model("emergemncyAssistvehicleinfo", new Text.Resource(R.string.vehicle_info, null, 2, null), 2132017742, new Color.Attr(R.attr.contentSecondary), null, f(e9, view), 2132017739, new Color.Attr(R.attr.contentPrimary), null, null, null, null, null, null, null, null, null, null, null, false, 0, 0, false, null, null, null, false, false, false, 532152080, null));
            model2 = model;
        } else {
            model2 = model;
        }
        arrayList.add(model2);
        if (emergencyAssistUIData.b() != null) {
            arrayList.add(new FooterEmergencyHelpDelegate.Model("footer", emergencyAssistUIData.b()));
        }
        H0 = CollectionsKt___CollectionsKt.H0(arrayList);
        return H0;
    }

    public final EmergencyAssistUIData g(ExternalHelpProviderResponse emergencyHelp, EmergencyAssistReverseGeocodeResponse geoCode, Car car) {
        Intrinsics.f(emergencyHelp, "emergencyHelp");
        Intrinsics.f(geoCode, "geoCode");
        return new EmergencyAssistUIData(c(emergencyHelp.a()), b(geoCode), this.f32668b.n().s(), e(car), d(emergencyHelp.a()));
    }
}
