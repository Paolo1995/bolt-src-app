package ee.mtakso.driver.uikit.dialog;

import android.graphics.Rect;
import android.view.ViewGroup;
import ee.mtakso.driver.uikit.R$layout;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UiKitRoundButtonFactory.kt */
/* loaded from: classes5.dex */
public final class UiKitRoundButtonFactory extends BaseItemViewFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final UiKitRoundButtonFactory f35926a = new UiKitRoundButtonFactory();

    /* compiled from: UiKitRoundButtonFactory.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35927a;

        static {
            int[] iArr = new int[UiKitRoundButtonType.values().length];
            try {
                iArr[UiKitRoundButtonType.f36161k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UiKitRoundButtonType.f36162l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UiKitRoundButtonType.f36163m.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UiKitRoundButtonType.f36164n.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UiKitRoundButtonType.f36166p.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UiKitRoundButtonType.f36165o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[UiKitRoundButtonType.f36167q.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f35927a = iArr;
        }
    }

    private UiKitRoundButtonFactory() {
    }

    public final RoundButton c(ViewGroup parent, CharSequence text, Rect rect, RoundButtonStyle style) {
        int i8;
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        Intrinsics.f(style, "style");
        if (style.a() == UiKitRoundButtonSize.f36156j) {
            switch (WhenMappings.f35927a[style.b().ordinal()]) {
                case 1:
                    i8 = R$layout.f35761d;
                    break;
                case 2:
                    i8 = R$layout.f35767j;
                    break;
                case 3:
                    i8 = R$layout.f35763f;
                    break;
                case 4:
                    i8 = R$layout.f35771n;
                    break;
                case 5:
                    i8 = R$layout.f35769l;
                    break;
                case 6:
                    i8 = R$layout.f35773p;
                    break;
                case 7:
                    i8 = R$layout.f35765h;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.f35927a[style.b().ordinal()]) {
                case 1:
                    i8 = R$layout.f35760c;
                    break;
                case 2:
                    i8 = R$layout.f35766i;
                    break;
                case 3:
                    i8 = R$layout.f35762e;
                    break;
                case 4:
                    i8 = R$layout.f35770m;
                    break;
                case 5:
                    i8 = R$layout.f35768k;
                    break;
                case 6:
                    i8 = R$layout.f35772o;
                    break;
                case 7:
                    i8 = R$layout.f35764g;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        RoundButton roundButton = (RoundButton) BaseItemViewFactory.b(this, parent, i8, rect, 0, 0, null, 28, null);
        UiKitRoundButtonTypeKt.b(roundButton, style.b());
        roundButton.setText(text);
        return roundButton;
    }
}
