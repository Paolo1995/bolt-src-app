package ee.mtakso.driver.service.modules.tile;

import com.google.gson.Gson;
import ee.mtakso.driver.service.modules.tile.FeatureProperties;
import eu.bolt.driver.maps.tile.mvt.MvtFeature;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeaturePropertiesFactory.kt */
/* loaded from: classes3.dex */
public final class FeaturePropertiesFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f25348a;

    @Inject
    public FeaturePropertiesFactory(Gson gson) {
        Intrinsics.f(gson, "gson");
        this.f25348a = gson;
    }

    public final FeatureProperties a(MvtFeature feature) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        Intrinsics.f(feature, "feature");
        Object obj = feature.d().get("type");
        String str17 = null;
        String str18 = null;
        String str19 = null;
        LabelL10nContext labelL10nContext = null;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -1710695651:
                    if (str.equals("LocationAwareLine")) {
                        Object obj2 = feature.d().get("stroke");
                        if (obj2 instanceof String) {
                            str2 = (String) obj2;
                        } else {
                            str2 = null;
                        }
                        Object obj3 = feature.d().get("stroke_dark");
                        if (obj3 instanceof String) {
                            str3 = (String) obj3;
                        } else {
                            str3 = null;
                        }
                        Object obj4 = feature.d().get("outside_stroke");
                        if (obj4 instanceof String) {
                            str4 = (String) obj4;
                        } else {
                            str4 = null;
                        }
                        Object obj5 = feature.d().get("outside_stroke_dark");
                        if (obj5 instanceof String) {
                            str17 = (String) obj5;
                        }
                        return new FeatureProperties.LocationAwareLine(str, str2, str3, str4, str17);
                    }
                    break;
                case 73174740:
                    if (str.equals("Label")) {
                        Object obj6 = feature.d().get("title_html");
                        if (obj6 instanceof String) {
                            str5 = (String) obj6;
                        } else {
                            str5 = null;
                        }
                        Object obj7 = feature.d().get("title_background");
                        if (obj7 instanceof String) {
                            str6 = (String) obj7;
                        } else {
                            str6 = null;
                        }
                        Object obj8 = feature.d().get("title_background_dark");
                        if (obj8 instanceof String) {
                            str7 = (String) obj8;
                        } else {
                            str7 = null;
                        }
                        Object obj9 = feature.d().get("icon");
                        if (obj9 instanceof String) {
                            str8 = (String) obj9;
                        } else {
                            str8 = null;
                        }
                        Object obj10 = feature.d().get("localized_title_html_key");
                        if (obj10 instanceof String) {
                            str9 = (String) obj10;
                        } else {
                            str9 = null;
                        }
                        Object obj11 = feature.d().get("l10n_context_json");
                        if (obj11 instanceof String) {
                            str10 = (String) obj11;
                        } else {
                            str10 = null;
                        }
                        if (str10 != null) {
                            labelL10nContext = (LabelL10nContext) this.f25348a.fromJson(str10, (Class<Object>) LabelL10nContext.class);
                        }
                        return new FeatureProperties.Label(str, str5, str6, str7, str8, str9, labelL10nContext);
                    }
                    break;
                case 173469041:
                    if (str.equals("LocationAwarePolygon")) {
                        Object obj12 = feature.d().get("fill");
                        if (obj12 instanceof String) {
                            str11 = (String) obj12;
                        } else {
                            str11 = null;
                        }
                        Object obj13 = feature.d().get("fill_dark");
                        if (obj13 instanceof String) {
                            str12 = (String) obj13;
                        } else {
                            str12 = null;
                        }
                        Object obj14 = feature.d().get("outside_fill");
                        if (obj14 instanceof String) {
                            str13 = (String) obj14;
                        } else {
                            str13 = null;
                        }
                        Object obj15 = feature.d().get("outside_fill_dark");
                        if (obj15 instanceof String) {
                            str19 = (String) obj15;
                        }
                        return new FeatureProperties.LocationAwarePolygon(str, str11, str12, str13, str19);
                    }
                    break;
                case 1267133722:
                    if (str.equals("Polygon")) {
                        Object obj16 = feature.d().get("fill");
                        if (obj16 instanceof String) {
                            str14 = (String) obj16;
                        } else {
                            str14 = null;
                        }
                        Object obj17 = feature.d().get("fill_dark");
                        if (obj17 instanceof String) {
                            str15 = (String) obj17;
                        } else {
                            str15 = null;
                        }
                        Object obj18 = feature.d().get("stroke");
                        if (obj18 instanceof String) {
                            str16 = (String) obj18;
                        } else {
                            str16 = null;
                        }
                        Object obj19 = feature.d().get("stroke_dark");
                        if (obj19 instanceof String) {
                            str18 = (String) obj19;
                        }
                        return new FeatureProperties.Polygon(str, str14, str15, str16, str18);
                    }
                    break;
            }
        }
        return FeatureProperties.Empty.f25324a;
    }
}
