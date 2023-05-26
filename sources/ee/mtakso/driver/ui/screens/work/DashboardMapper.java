package ee.mtakso.driver.ui.screens.work;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.dashboard.ButtonAppearance;
import ee.mtakso.driver.network.client.dashboard.ContentItemBadge;
import ee.mtakso.driver.network.client.dashboard.ContentItemCounter;
import ee.mtakso.driver.network.client.dashboard.ContentItemTag;
import ee.mtakso.driver.network.client.dashboard.CounterState;
import ee.mtakso.driver.network.client.dashboard.DashboardContentItem;
import ee.mtakso.driver.network.client.dashboard.DriverHomeScreenResponse;
import ee.mtakso.driver.network.client.dashboard.HomeScreenItem;
import ee.mtakso.driver.network.client.dashboard.HomeScreenItemPayload;
import ee.mtakso.driver.network.client.dashboard.TagSeverity;
import ee.mtakso.driver.ui.screens.work.dashboard.DashboardState;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardBannerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.LayoutListModel;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardMapper.kt */
/* loaded from: classes5.dex */
public final class DashboardMapper {

    /* compiled from: DashboardMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33632a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f33633b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f33634c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f33635d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ int[] f33636e;

        static {
            int[] iArr = new int[HomeScreenItemPayload.TitleAppearanceType.values().length];
            try {
                iArr[HomeScreenItemPayload.TitleAppearanceType.CHIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f33632a = iArr;
            int[] iArr2 = new int[TagSeverity.values().length];
            try {
                iArr2[TagSeverity.PROMO.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[TagSeverity.CRITICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[TagSeverity.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            f33633b = iArr2;
            int[] iArr3 = new int[CounterState.values().length];
            try {
                iArr3[CounterState.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[CounterState.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f33634c = iArr3;
            int[] iArr4 = new int[HomeScreenItemPayload.TitleAppearanceColor.values().length];
            try {
                iArr4[HomeScreenItemPayload.TitleAppearanceColor.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr4[HomeScreenItemPayload.TitleAppearanceColor.ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f33635d = iArr4;
            int[] iArr5 = new int[ButtonAppearance.values().length];
            try {
                iArr5[ButtonAppearance.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr5[ButtonAppearance.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr5[ButtonAppearance.CRITICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            f33636e = iArr5;
        }
    }

    private final UiKitRoundButtonType a(ButtonAppearance buttonAppearance) {
        int i8 = WhenMappings.f33636e[buttonAppearance.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return UiKitRoundButtonType.f36163m;
                }
                throw new NoWhenBranchMatchedException();
            }
            return UiKitRoundButtonType.f36162l;
        }
        return UiKitRoundButtonType.f36161k;
    }

    private final Color b(CounterState counterState) {
        int i8 = WhenMappings.f33634c[counterState.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return new Color.Attr(R.attr.dynamicGreen03);
            }
            throw new NoWhenBranchMatchedException();
        }
        return new Color.Attr(R.attr.dynamicNeutral01);
    }

    private final Image c(CounterState counterState) {
        int i8 = WhenMappings.f33634c[counterState.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return new Image.Res(R.drawable.ic_check_green_outline_16dp);
            }
            throw new NoWhenBranchMatchedException();
        }
        return null;
    }

    private final DashboardBannerDelegate.Model e(String str, HomeScreenItemPayload.Banner banner) {
        boolean z7;
        Text.Value value = new Text.Value(banner.d());
        Text.Value value2 = new Text.Value(banner.b());
        Image.Url url = new Image.Url(banner.c().a());
        if (banner.a() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        return new DashboardBannerDelegate.Model(str, value, 0, null, value2, 0, null, url, z7, null, banner, 620, null);
    }

    private final DashboardItemDelegate.Model f(String str, HomeScreenItemPayload.Title title) {
        HomeScreenItemPayload.TitleAppearanceType titleAppearanceType;
        int i8;
        Text.Value value;
        DashboardItemDelegate.Chip chip;
        Image.Url url;
        boolean z7;
        HomeScreenItemPayload.TitleAppearance e8 = title.e();
        Text.Value value2 = null;
        if (e8 != null) {
            titleAppearanceType = e8.b();
        } else {
            titleAppearanceType = null;
        }
        if (titleAppearanceType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f33632a[titleAppearanceType.ordinal()];
        }
        if (i8 == 1) {
            chip = new DashboardItemDelegate.Chip(new Text.Value(title.d()), m(title.e().a()));
            value = null;
        } else {
            value = new Text.Value(title.d());
            chip = null;
        }
        Text.Value value3 = new Text.Value(title.g());
        String f8 = title.f();
        if (f8 != null) {
            url = new Image.Url(f8);
        } else {
            url = null;
        }
        String c8 = title.c();
        if (c8 != null) {
            value2 = new Text.Value(c8);
        }
        Text.Value value4 = value2;
        List<DashboardContentItem> b8 = title.b();
        ArrayList arrayList = new ArrayList();
        for (DashboardContentItem dashboardContentItem : b8) {
            DashboardItemDelegate.ContentItem h8 = h(dashboardContentItem);
            if (h8 != null) {
                arrayList.add(h8);
            }
        }
        if (title.a() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        return new DashboardItemDelegate.Model(str, value, chip, value3, 0, value4, arrayList, url, z7, 0, 0, null, title, 3600, null);
    }

    private final DashboardItemDelegate.Badge g(ContentItemBadge contentItemBadge) {
        Image.Url url;
        Text.Value value = new Text.Value(contentItemBadge.b());
        String a8 = contentItemBadge.a();
        if (a8 != null) {
            url = new Image.Url(a8);
        } else {
            url = null;
        }
        return new DashboardItemDelegate.Badge(value, url);
    }

    private final DashboardItemDelegate.ContentItem h(DashboardContentItem dashboardContentItem) {
        int v7;
        int v8;
        int v9;
        Text.Value value = null;
        if (dashboardContentItem instanceof DashboardContentItem.Tags) {
            List<ContentItemTag> a8 = ((DashboardContentItem.Tags) dashboardContentItem).a();
            v9 = CollectionsKt__IterablesKt.v(a8, 10);
            ArrayList arrayList = new ArrayList(v9);
            for (ContentItemTag contentItemTag : a8) {
                arrayList.add(j(contentItemTag));
            }
            return new DashboardItemDelegate.ContentItem.Tags(arrayList);
        } else if (dashboardContentItem instanceof DashboardContentItem.Icon) {
            return new DashboardItemDelegate.ContentItem.Icon(new Image.Url(((DashboardContentItem.Icon) dashboardContentItem).a()));
        } else {
            if (dashboardContentItem instanceof DashboardContentItem.Counters) {
                DashboardContentItem.Counters counters = (DashboardContentItem.Counters) dashboardContentItem;
                String b8 = counters.b();
                if (b8 != null) {
                    value = new Text.Value(b8);
                }
                List<ContentItemCounter> a9 = counters.a();
                v8 = CollectionsKt__IterablesKt.v(a9, 10);
                ArrayList arrayList2 = new ArrayList(v8);
                for (ContentItemCounter contentItemCounter : a9) {
                    arrayList2.add(i(contentItemCounter));
                }
                return new DashboardItemDelegate.ContentItem.Conditions(arrayList2, value);
            } else if (dashboardContentItem instanceof DashboardContentItem.Link) {
                DashboardContentItem.Link link = (DashboardContentItem.Link) dashboardContentItem;
                return new DashboardItemDelegate.ContentItem.Link(new Text.Value(link.b()), link.a());
            } else if (dashboardContentItem instanceof DashboardContentItem.Bonus) {
                return new DashboardItemDelegate.ContentItem.Bonus(new Text.Value(((DashboardContentItem.Bonus) dashboardContentItem).a()));
            } else {
                if (dashboardContentItem instanceof DashboardContentItem.Text) {
                    return new DashboardItemDelegate.ContentItem.SimpleText(new Text.Value(((DashboardContentItem.Text) dashboardContentItem).a()));
                }
                if (dashboardContentItem instanceof DashboardContentItem.Separator) {
                    return new DashboardItemDelegate.ContentItem.Separator();
                }
                if (dashboardContentItem instanceof DashboardContentItem.BadgeGroup) {
                    List<ContentItemBadge> a10 = ((DashboardContentItem.BadgeGroup) dashboardContentItem).a();
                    v7 = CollectionsKt__IterablesKt.v(a10, 10);
                    ArrayList arrayList3 = new ArrayList(v7);
                    for (ContentItemBadge contentItemBadge : a10) {
                        arrayList3.add(g(contentItemBadge));
                    }
                    return new DashboardItemDelegate.ContentItem.BadgeGroup(arrayList3);
                } else if (dashboardContentItem instanceof DashboardContentItem.Button) {
                    DashboardContentItem.Button button = (DashboardContentItem.Button) dashboardContentItem;
                    return new DashboardItemDelegate.ContentItem.Button(new Text.Value(button.c()), a(button.b()), button.a());
                } else if (dashboardContentItem instanceof DashboardContentItem.Unknown) {
                    return null;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    private final DashboardItemDelegate.Condition i(ContentItemCounter contentItemCounter) {
        return new DashboardItemDelegate.Condition(new Text.Value(contentItemCounter.b()), b(contentItemCounter.a()), c(contentItemCounter.a()));
    }

    private final DashboardItemDelegate.DashboardTag j(ContentItemTag contentItemTag) {
        return new DashboardItemDelegate.DashboardTag(new Text.Value(contentItemTag.b()), l(contentItemTag.a()));
    }

    private final ListModel k(HomeScreenItemPayload homeScreenItemPayload, String str) {
        if (homeScreenItemPayload instanceof HomeScreenItemPayload.Banner) {
            return e(str, (HomeScreenItemPayload.Banner) homeScreenItemPayload);
        }
        if (homeScreenItemPayload instanceof HomeScreenItemPayload.Title) {
            return f(str, (HomeScreenItemPayload.Title) homeScreenItemPayload);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Color l(TagSeverity tagSeverity) {
        int i8 = WhenMappings.f33633b[tagSeverity.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return new Color.Attr(R.attr.accentOrange);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new Color.Attr(R.attr.contentCritical);
        }
        return new Color.Attr(R.attr.accentPurple);
    }

    private final Color m(HomeScreenItemPayload.TitleAppearanceColor titleAppearanceColor) {
        if (titleAppearanceColor == null) {
            titleAppearanceColor = HomeScreenItemPayload.TitleAppearanceColor.ACTION;
        }
        int i8 = WhenMappings.f33635d[titleAppearanceColor.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return new Color.Attr(R.attr.dynamicPurple02);
            }
            throw new NoWhenBranchMatchedException();
        }
        return new Color.Attr(R.attr.dynamicOrange);
    }

    public final DashboardState.Dynamic d(DriverHomeScreenResponse response) {
        int v7;
        Intrinsics.f(response, "response");
        int b8 = response.b().b();
        int a8 = response.b().a() + 1;
        List<HomeScreenItem> a9 = response.a();
        v7 = CollectionsKt__IterablesKt.v(a9, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (HomeScreenItem homeScreenItem : a9) {
            int c8 = homeScreenItem.a().c();
            int a10 = homeScreenItem.a().a();
            int d8 = homeScreenItem.a().d();
            int b9 = homeScreenItem.a().b();
            HomeScreenItemPayload b10 = homeScreenItem.b();
            int c9 = homeScreenItem.a().c();
            int a11 = homeScreenItem.a().a();
            arrayList.add(new LayoutListModel(c8, a10, d8, b9, k(b10, "row: " + c9 + " col: " + a11)));
        }
        return new DashboardState.Dynamic(arrayList, b8, a8);
    }
}
