package ee.mtakso.driver.ui.screens.boltclub;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.boltclub.model.BoltClubOfferDetailsResponse;
import ee.mtakso.driver.network.client.boltclub.model.BoltClubOffersResponse;
import ee.mtakso.driver.network.client.boltclub.model.IntegrationData;
import ee.mtakso.driver.network.client.boltclub.model.Offer;
import ee.mtakso.driver.network.client.boltclub.model.OfferGroup;
import ee.mtakso.driver.network.client.boltclub.model.Section;
import ee.mtakso.driver.ui.screens.boltclub.delegatemodel.OfferModel;
import ee.mtakso.driver.ui.screens.boltclub.delegatemodel.SectionModel;
import ee.mtakso.driver.ui.screens.boltclub.delegates.BoltClubSectionDelegate;
import ee.mtakso.driver.ui.screens.boltclub.delegates.DetailsHeaderDelegate;
import ee.mtakso.driver.ui.screens.boltclub.delegates.OfferListDelegate;
import ee.mtakso.driver.ui.screens.boltclub.delegates.SimpleFooterDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.android.engine.html.HtmlEngine;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubDataMapper.kt */
/* loaded from: classes3.dex */
public final class BoltClubDataMapper {

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f27114b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngine f27115a;

    /* compiled from: BoltClubDataMapper.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BoltClubDataMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27116a;

        static {
            int[] iArr = new int[IntegrationData.Icon.IntegrationType.values().length];
            try {
                iArr[IntegrationData.Icon.IntegrationType.BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IntegrationData.Icon.IntegrationType.ICON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f27116a = iArr;
        }
    }

    @Inject
    public BoltClubDataMapper(HtmlEngine htmlEngine) {
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f27115a = htmlEngine;
    }

    private final List<ListModel> a(BoltClubOfferDetailsResponse boltClubOfferDetailsResponse) {
        int v7;
        ArrayList arrayList = new ArrayList();
        long d8 = boltClubOfferDetailsResponse.d();
        arrayList.add(new DetailsHeaderDelegate.Model("ID_VENDOR_OFFER" + d8, new OfferModel(boltClubOfferDetailsResponse.d(), new Image.Url(boltClubOfferDetailsResponse.c()), boltClubOfferDetailsResponse.g(), boltClubOfferDetailsResponse.f(), boltClubOfferDetailsResponse.a())));
        List<Section> e8 = boltClubOfferDetailsResponse.e();
        v7 = CollectionsKt__IterablesKt.v(e8, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : e8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            Section section = (Section) obj;
            long d9 = boltClubOfferDetailsResponse.d();
            arrayList2.add(new BoltClubSectionDelegate.Model("ID_VENDOR_OFFER" + d9 + "ID_SECTION" + i8, new SectionModel(section.b(), this.f27115a.a(section.a()))));
            i8 = i9;
        }
        arrayList.addAll(arrayList2);
        IntegrationData b8 = boltClubOfferDetailsResponse.b();
        if (b8 != null) {
            int i10 = WhenMappings.f27116a[b8.d().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                arrayList.add(new ButtonItemDelegate.Model("ID_INTEGRATION_BUTTON_DIV", new Text.Value(b8.c()), null, null, null, UiKitRoundButtonType.f36161k, null, null, true, null, new Margins(Dimens.c(24), Dimens.c(24), Dimens.c(24), Dimens.c(30)), b8.b(), false, null, null, 0.0f, false, false, 254684, null));
            }
        }
        return arrayList;
    }

    public final BoltClubDetailsState b(BoltClubOfferDetailsResponse boltClubDetails) {
        String str;
        Intrinsics.f(boltClubDetails, "boltClubDetails");
        long d8 = boltClubDetails.d();
        String g8 = boltClubDetails.g();
        IntegrationData b8 = boltClubDetails.b();
        if (b8 != null) {
            str = b8.a();
        } else {
            str = null;
        }
        return new BoltClubDetailsState(d8, g8, str, a(boltClubDetails), boltClubDetails.h(), boltClubDetails.i());
    }

    public final List<ListModel> c(BoltClubOffersResponse boltClubOfferResponse) {
        int v7;
        int m8;
        boolean z7;
        Intrinsics.f(boltClubOfferResponse, "boltClubOfferResponse");
        ArrayList arrayList = new ArrayList();
        for (OfferGroup offerGroup : boltClubOfferResponse.d()) {
            arrayList.add(new ItemHeaderDelegate.Model("OFFER_GROUP_NAME" + offerGroup.a(), offerGroup.a(), 2132017743, new Color.Attr(R.attr.contentSecondary), new Color.Attr(R.attr.backTertiary), null, 32, null));
            List<Offer> b8 = offerGroup.b();
            v7 = CollectionsKt__IterablesKt.v(b8, 10);
            ArrayList arrayList2 = new ArrayList(v7);
            int i8 = 0;
            for (Object obj : b8) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                Offer offer = (Offer) obj;
                String str = "OFFER_GROUP_NAME" + offerGroup.a() + "ID_VENDOR_OFFER" + offer.c();
                OfferModel offerModel = new OfferModel(offer.c(), new Image.Url(offer.b()), offer.e(), offer.d(), offer.a());
                m8 = CollectionsKt__CollectionsKt.m(offerGroup.b());
                if (m8 != i8) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                arrayList2.add(new OfferListDelegate.Model(str, offerModel, null, z7, 4, null));
                i8 = i9;
            }
            arrayList.addAll(arrayList2);
        }
        if (!boltClubOfferResponse.d().isEmpty()) {
            arrayList.add(new SimpleFooterDelegate.Model("ID_FOOTER_DIV", new Text.Value(this.f27115a.a(boltClubOfferResponse.b().a())), 0, 0, 0, 0, null, false, 124, null));
        }
        return arrayList;
    }
}
