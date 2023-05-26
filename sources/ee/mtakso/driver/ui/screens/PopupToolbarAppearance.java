package ee.mtakso.driver.ui.screens;

import android.app.Activity;
import androidx.appcompat.widget.Toolbar;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupToolbarAppearance.kt */
/* loaded from: classes3.dex */
public final class PopupToolbarAppearance implements ToolbarAppearance {

    /* renamed from: a  reason: collision with root package name */
    private final int f27001a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f27002b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f27003c;

    public PopupToolbarAppearance() {
        this(0, null, false, 7, null);
    }

    public PopupToolbarAppearance(int i8, Text text, boolean z7) {
        this.f27001a = i8;
        this.f27002b = text;
        this.f27003c = z7;
    }

    @Override // ee.mtakso.driver.ui.screens.ToolbarAppearance
    public void a(Toolbar toolbar, Activity activity) {
        PopupToolbar popupToolbar;
        CharSequence a8;
        Intrinsics.f(toolbar, "toolbar");
        Intrinsics.f(activity, "activity");
        if (toolbar instanceof PopupToolbar) {
            popupToolbar = (PopupToolbar) toolbar;
        } else {
            popupToolbar = null;
        }
        if (popupToolbar != null) {
            popupToolbar.setBackIcon(this.f27001a);
            popupToolbar.setTitleInCenter(this.f27003c);
            Text text = this.f27002b;
            if (text == null) {
                a8 = "";
            } else {
                a8 = TextKt.a(text, activity);
            }
            activity.setTitle(a8);
        }
    }

    public /* synthetic */ PopupToolbarAppearance(int i8, Text text, boolean z7, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? 1 : i8, (i9 & 2) != 0 ? new Text.Value("") : text, (i9 & 4) != 0 ? true : z7);
    }
}
