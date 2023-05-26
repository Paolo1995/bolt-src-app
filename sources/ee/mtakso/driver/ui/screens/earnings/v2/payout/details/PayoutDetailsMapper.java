package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.earnings.PayoutResponce;
import ee.mtakso.driver.network.client.earnings.ProgressItem;
import ee.mtakso.driver.network.client.earnings.ProgressItemStatus;
import ee.mtakso.driver.network.client.generic.GenericItem;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ProgressItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.VerticalKeyValueDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Background;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.StyledText;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.util.StringUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutDetailsMapper.kt */
/* loaded from: classes3.dex */
public final class PayoutDetailsMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f28673a = new Companion(null);

    /* compiled from: PayoutDetailsMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PayoutDetailsMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28674a;

        static {
            int[] iArr = new int[ProgressItemStatus.values().length];
            try {
                iArr[ProgressItemStatus.FUTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProgressItemStatus.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProgressItemStatus.CURRENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProgressItemStatus.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f28674a = iArr;
        }
    }

    private final ListModel a(GenericItem genericItem, boolean z7, boolean z8) {
        float f8;
        int i8;
        Integer num;
        boolean z9;
        if (z8 && z7) {
            f8 = 24.0f;
        } else {
            f8 = 1.0f;
        }
        float c8 = Dimens.c(f8);
        if (z8 && z7) {
            i8 = R.color.neutral900;
        } else {
            i8 = R.color.neutral800;
        }
        String str = genericItem.c() + genericItem.d();
        String c9 = genericItem.c();
        String d8 = genericItem.d().d();
        if (genericItem.a() != null) {
            num = Integer.valueOf((int) R.drawable.ic_info);
        } else {
            num = null;
        }
        Integer num2 = num;
        if (z7 && (!z7 || !z8)) {
            z9 = false;
        } else {
            z9 = true;
        }
        return new VerticalKeyValueDelegate.Model(str, c9, d8, num2, 0, null, genericItem, z9, false, false, new Color.Res(i8), new Color.Res(R.color.neutral900), Float.valueOf(c8), 48, null);
    }

    private final InfoBlockDelegate.Model b(String str) {
        return new InfoBlockDelegate.Model("LISTID_ERROR", new Text.Resource(R.string.payout_status_failed_title, null, 2, null), null, null, null, new Text.Value(str), null, new Color.Res(R.color.neutral900), new Background.Res(R.drawable.message_error_back), null, new Image.Res(R.drawable.ic_common_alert), null, Dimens.d(24), (int) Dimens.c(24.0f), null, 19036, null);
    }

    private final ListModel c(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) SpannableStringBuilderUtils.b(new SpannableString(context.getString(R.string.payout_problem)), new ForegroundColorSpan(ContextCompat.getColor(context, R.color.white))));
        spannableStringBuilder.append((CharSequence) SpannableStringBuilderUtils.b(new SpannableString(context.getString(R.string.get_help)), new StyleSpan(1), new ForegroundColorSpan(ContextCompat.getColor(context, R.color.white))));
        return new TextCenteredDelegate.Model("LISTID_HELP_LINK", spannableStringBuilder, 0, null, false, new Color.Res(R.color.neutral900), null, Dimens.c(24.0f), false, true, true, 348, null);
    }

    private final ButtonItemDelegate.Model<String> g(String str) {
        Text.Resource resource = new Text.Resource(R.string.payout_receipt, null, 2, null);
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36164n;
        float c8 = Dimens.c(24.0f);
        return new ButtonItemDelegate.Model<>("LISTID_RECEIPT", resource, null, null, null, uiKitRoundButtonType, new Color.Attr(R.attr.backPrimary), null, true, null, null, str, true, new Color.Res(R.color.neutral900), null, c8, false, true, 83612, null);
    }

    private final ButtonItemDelegate.Model<String> h(String str) {
        Text.Resource resource = new Text.Resource(R.string.payout_review_details, null, 2, null);
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36164n;
        float c8 = Dimens.c(24.0f);
        return new ButtonItemDelegate.Model<>("LISTID_REVIEW_DETAILS", resource, null, null, null, uiKitRoundButtonType, new Color.Attr(R.attr.backPrimary), null, true, null, null, str, true, new Color.Res(R.color.neutral900), null, c8, false, true, 83612, null);
    }

    public final List<ListModel> d(PayoutResponce details, Context context) {
        InfoBlockDelegate.Model model;
        ButtonItemDelegate.Model<String> model2;
        ButtonItemDelegate.Model<String> model3;
        int v7;
        List o8;
        List n02;
        List p8;
        List<ListModel> n03;
        boolean z7;
        Intrinsics.f(details, "details");
        Intrinsics.f(context, "context");
        String a8 = details.c().a();
        ListModel listModel = null;
        if (a8 != null) {
            model = b(a8);
        } else {
            model = null;
        }
        String e8 = details.e();
        if (e8 != null) {
            model2 = g(e8);
        } else {
            model2 = null;
        }
        String g8 = details.g();
        if (g8 != null) {
            model3 = h(g8);
        } else {
            model3 = null;
        }
        if (details.f() != null) {
            listModel = c(context);
        }
        List<GenericItem> b8 = details.c().b();
        v7 = CollectionsKt__IterablesKt.v(b8, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<T> it = b8.iterator();
        int i8 = 0;
        while (true) {
            boolean z8 = true;
            if (it.hasNext()) {
                Object next = it.next();
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                GenericItem genericItem = (GenericItem) next;
                if (i8 == details.c().b().size() - 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (model2 == null && model3 == null && listModel == null) {
                    z8 = false;
                }
                arrayList.add(a(genericItem, z7, z8));
                i8 = i9;
            } else {
                o8 = CollectionsKt__CollectionsKt.o(model);
                n02 = CollectionsKt___CollectionsKt.n0(o8, arrayList);
                p8 = CollectionsKt__CollectionsKt.p(model2, model3, listModel);
                n03 = CollectionsKt___CollectionsKt.n0(n02, p8);
                return n03;
            }
        }
    }

    public final ListModel e(ProgressItem item, boolean z7) {
        Color.Attr attr;
        int i8;
        Color.Attr attr2;
        Intrinsics.f(item, "item");
        String str = "progress-" + item.hashCode();
        String a8 = item.a();
        StyledText styledText = new StyledText(new Text.Value((a8 == null || (r2 = StringUtilsKt.a(a8)) == null) ? "" : ""), null, null, 6, null);
        Text.Value value = new Text.Value(item.b());
        ProgressItemStatus c8 = item.c();
        int[] iArr = WhenMappings.f28674a;
        if (iArr[c8.ordinal()] == 1) {
            attr = new Color.Attr(R.attr.contentSecondary);
        } else {
            attr = new Color.Attr(R.attr.contentPrimary);
        }
        StyledText styledText2 = new StyledText(value, null, attr, 2, null);
        int i9 = iArr[item.c().ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 == 4) {
                        i8 = R.drawable.ic_banned;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i8 = R.drawable.ic_active;
                }
            } else {
                i8 = R.drawable.ic_check_green_outline_24dp;
            }
        } else {
            i8 = R.drawable.ic_inactive;
        }
        Image.Res res = new Image.Res(i8);
        if (z7) {
            attr2 = null;
        } else {
            attr2 = new Color.Attr(R.attr.contentSecondary);
        }
        return new ProgressItemDelegate.Model(str, styledText, styledText2, attr2, res, null, 32, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00cf, code lost:
        if (r3 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<ee.mtakso.driver.uikit.recyclerview.ListModel> f(ee.mtakso.driver.network.client.earnings.PayoutResponce r30, android.content.Context r31) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsMapper.f(ee.mtakso.driver.network.client.earnings.PayoutResponce, android.content.Context):java.util.List");
    }
}
