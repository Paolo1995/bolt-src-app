package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import android.content.Context;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.boltclub.delegates.SimpleFooterDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyFeatureData;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.util.PermissionUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyToolkitMapper.kt */
/* loaded from: classes3.dex */
public final class SafetyToolkitMapper {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f32824c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final PermissionManager f32825a;

    /* renamed from: b  reason: collision with root package name */
    private final HtmlEngine f32826b;

    /* compiled from: SafetyToolkitMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public SafetyToolkitMapper(PermissionManager permissionManager, HtmlEngine htmlEngine) {
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f32825a = permissionManager;
        this.f32826b = htmlEngine;
    }

    private final TwoLinesItemDelegate.Model<SafetyFeature> a(SafetyFeature safetyFeature, boolean z7) {
        SafetyFeatureData a8 = safetyFeature.a();
        Intrinsics.d(a8, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyFeatureData.EmergencyAssist");
        SafetyFeatureData.EmergencyAssist emergencyAssist = (SafetyFeatureData.EmergencyAssist) a8;
        Text d8 = emergencyAssist.d();
        Color.Attr attr = new Color.Attr(R.attr.contentCritical);
        Text a9 = emergencyAssist.a();
        Color.Attr attr2 = new Color.Attr(R.attr.contentSecondary);
        Image c8 = emergencyAssist.c();
        int d9 = Dimens.d(10);
        return new TwoLinesItemDelegate.Model<>("EMERGENCY_ASSIST", d8, 2132018477, attr, Integer.valueOf(d9), a9, 2132018479, attr2, new Color.Attr(R.attr.contentCritical), c8, null, null, null, null, null, null, null, null, safetyFeature, false, 0, 0, z7, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, false, false, false, 507247616, null);
    }

    private final TwoLinesItemDelegate.Model<SafetyFeature> b(SafetyFeature safetyFeature, boolean z7, boolean z8) {
        Color.Attr attr;
        Color.Attr attr2;
        Color.Attr attr3;
        SafetyFeatureData a8 = safetyFeature.a();
        Intrinsics.d(a8, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyFeatureData.ShareRideDetails");
        SafetyFeatureData.ShareRideDetails shareRideDetails = (SafetyFeatureData.ShareRideDetails) a8;
        if (z8) {
            Color.Attr attr4 = new Color.Attr(R.attr.contentPrimary);
            attr = attr4;
            attr2 = new Color.Attr(R.attr.contentSecondary);
            attr3 = new Color.Attr(R.attr.accentNeutral);
        } else {
            Color.Attr attr5 = new Color.Attr(R.attr.dynamicNeutral04);
            attr = attr5;
            attr2 = new Color.Attr(R.attr.dynamicNeutral04);
            attr3 = new Color.Attr(R.attr.dynamicNeutral04);
        }
        Text d8 = shareRideDetails.d();
        int d9 = Dimens.d(10);
        return new TwoLinesItemDelegate.Model<>("SHARE_TRIP_DETAILS", d8, 2132018477, attr, Integer.valueOf(d9), shareRideDetails.a(), 2132018479, attr2, attr3, shareRideDetails.c(), null, null, null, null, null, shareRideDetails.b(), null, null, safetyFeature, false, Dimens.d(18), Dimens.d(18), z7, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, false, false, false, 504069120, null);
    }

    private final TwoLinesItemDelegate.Model<SafetyFeature> c(SafetyFeature safetyFeature, boolean z7, boolean z8, Context context) {
        Color.Attr attr;
        Color.Attr attr2;
        Color.Attr attr3;
        Color.Attr attr4;
        TwoLinesItemDelegate.Indicator.Chip chip;
        SafetyFeatureData a8 = safetyFeature.a();
        Intrinsics.d(a8, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyFeatureData.TripAudioRecording");
        SafetyFeatureData.TripAudioRecording tripAudioRecording = (SafetyFeatureData.TripAudioRecording) a8;
        if (z8) {
            Color.Attr attr5 = new Color.Attr(R.attr.contentPrimary);
            attr2 = new Color.Attr(R.attr.contentSecondary);
            attr = attr5;
            attr3 = new Color.Attr(R.attr.accentNeutral);
        } else {
            attr = new Color.Attr(R.attr.dynamicNeutral04);
            attr2 = new Color.Attr(R.attr.dynamicNeutral04);
            attr3 = new Color.Attr(R.attr.dynamicNeutral04);
        }
        if (!PermissionUtils.f41314a.b(this.f32825a)) {
            attr4 = new Color.Attr(R.attr.dynamicOrange);
        } else {
            attr4 = attr2;
        }
        if (tripAudioRecording.h()) {
            chip = new TwoLinesItemDelegate.Indicator.Chip(TextKt.a(new Text.Resource(R.string.trip_audio_new_label, null, 2, null), context), new Color.Attr(R.attr.colorContentActionPrimary), null, null, new Color.Attr(R.attr.colorBgActionSecondary), 12, null);
        } else if (tripAudioRecording.e() != null) {
            chip = new TwoLinesItemDelegate.Indicator.Label(new Text.Value(this.f32826b.a(tripAudioRecording.e())), 2132017739, new Color.Attr(R.attr.contentPrimary));
        } else {
            chip = null;
        }
        return new TwoLinesItemDelegate.Model<>("AUDIO_RECORDING_DETAILS", tripAudioRecording.f(), 2132018477, attr, null, tripAudioRecording.a(), 2132018479, attr4, attr3, tripAudioRecording.c().a(), tripAudioRecording.c().b(), null, null, null, null, tripAudioRecording.b(), null, chip, safetyFeature, false, Dimens.d(18), Dimens.d(18), z7, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, false, false, false, 503937040, null);
    }

    public final List<ListModel> d(List<SafetyFeature> safetyFeaturesList, Context context) {
        int m8;
        int m9;
        int m10;
        Intrinsics.f(safetyFeaturesList, "safetyFeaturesList");
        Intrinsics.f(context, "context");
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (Object obj : safetyFeaturesList) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            SafetyFeature safetyFeature = (SafetyFeature) obj;
            SafetyFeatureData a8 = safetyFeature.a();
            boolean z7 = true;
            if (a8 instanceof SafetyFeatureData.EmergencyAssist) {
                m10 = CollectionsKt__CollectionsKt.m(safetyFeaturesList);
                if (i8 == m10) {
                    z7 = false;
                }
                arrayList.add(a(safetyFeature, z7));
            } else if (a8 instanceof SafetyFeatureData.ShareRideDetails) {
                m9 = CollectionsKt__CollectionsKt.m(safetyFeaturesList);
                if (i8 == m9) {
                    z7 = false;
                }
                arrayList.add(b(safetyFeature, z7, safetyFeature.b()));
            } else if (a8 instanceof SafetyFeatureData.TripAudioRecording) {
                if (!((SafetyFeatureData.TripAudioRecording) safetyFeature.a()).g()) {
                    m8 = CollectionsKt__CollectionsKt.m(safetyFeaturesList);
                    if (i8 == m8 || !safetyFeature.b()) {
                        z7 = false;
                    }
                }
                arrayList.add(c(safetyFeature, z7, safetyFeature.b(), context));
                if (((SafetyFeatureData.TripAudioRecording) safetyFeature.a()).g()) {
                    arrayList.add(new SimpleFooterDelegate.Model("AUDIO_RECORDING_FOOTER", new Text.Resource(R.string.audio_recording_footer_description, null, 2, null), 0, 0, 0, 0, null, false, 124, null));
                }
            }
            i8 = i9;
        }
        return arrayList;
    }
}
