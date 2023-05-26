package ee.mtakso.driver.uikit.utils.html;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import ee.mtakso.driver.uikit.utils.image.ImageSize;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HtmlImageGetter.kt */
/* loaded from: classes5.dex */
public final class HtmlImageGetter implements Html.ImageGetter {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f36066d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final TextView f36067a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36068b;

    /* renamed from: c  reason: collision with root package name */
    private final Drawable f36069c;

    /* compiled from: HtmlImageGetter.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HtmlImageGetter(TextView textView, String text, Drawable drawable) {
        Intrinsics.f(textView, "textView");
        Intrinsics.f(text, "text");
        this.f36067a = textView;
        this.f36068b = text;
        this.f36069c = drawable;
    }

    private final ImageSize a(String str) {
        boolean L;
        boolean L2;
        List<String> h8 = new Regex("\\s").h(str, 0);
        ImageSize imageSize = new ImageSize(Dimens.c(20), Dimens.c(20));
        for (String str2 : h8) {
            L = StringsKt__StringsJVMKt.L(str2, "width=", false, 2, null);
            if (L) {
                StringBuilder sb = new StringBuilder();
                int length = str2.length();
                for (int i8 = 0; i8 < length; i8++) {
                    char charAt = str2.charAt(i8);
                    if (Character.isDigit(charAt)) {
                        sb.append(charAt);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.e(sb2, "filterTo(StringBuilder(), predicate).toString()");
                imageSize = ImageSize.b(imageSize, Dimens.c(Integer.parseInt(sb2)), 0, 2, null);
            } else {
                L2 = StringsKt__StringsJVMKt.L(str2, "height=", false, 2, null);
                if (L2) {
                    StringBuilder sb3 = new StringBuilder();
                    int length2 = str2.length();
                    for (int i9 = 0; i9 < length2; i9++) {
                        char charAt2 = str2.charAt(i9);
                        if (Character.isDigit(charAt2)) {
                            sb3.append(charAt2);
                        }
                    }
                    String sb4 = sb3.toString();
                    Intrinsics.e(sb4, "filterTo(StringBuilder(), predicate).toString()");
                    imageSize = ImageSize.b(imageSize, 0, Dimens.c(Integer.parseInt(sb4)), 1, null);
                }
            }
        }
        return imageSize;
    }

    private final String b(String str) {
        MatchResult b8 = Regex.b(new Regex("<img[^>]*>"), str, 0, 2, null);
        if (b8 == null) {
            return null;
        }
        return b8.getValue();
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String source) {
        Intrinsics.f(source, "source");
        String b8 = b(this.f36068b);
        if (b8 == null) {
            b8 = "";
        }
        ImageSize a8 = a(b8);
        Resources resources = this.f36067a.getResources();
        Intrinsics.e(resources, "textView.resources");
        HtmlImageGetterTarget htmlImageGetterTarget = new HtmlImageGetterTarget(resources, a8);
        ImageManager.Companion.b(ImageManager.f36075b, null, 1, null).b(new ImageRequest(source, a8, this.f36069c, null, 8, null), this.f36067a, htmlImageGetterTarget);
        return htmlImageGetterTarget;
    }
}
