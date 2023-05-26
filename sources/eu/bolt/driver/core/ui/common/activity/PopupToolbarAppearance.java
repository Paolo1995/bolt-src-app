package eu.bolt.driver.core.ui.common.activity;

import android.content.Context;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import j$.util.Spliterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupToolbarAppearance.kt */
/* loaded from: classes5.dex */
public final class PopupToolbarAppearance implements ToolbarAppearance {

    /* renamed from: a  reason: collision with root package name */
    private final int f41054a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f41055b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f41056c;

    /* renamed from: d  reason: collision with root package name */
    private final Text f41057d;

    /* renamed from: e  reason: collision with root package name */
    private final Function0<Unit> f41058e;

    /* renamed from: f  reason: collision with root package name */
    private final Color f41059f;

    /* renamed from: g  reason: collision with root package name */
    private final Image f41060g;

    /* renamed from: h  reason: collision with root package name */
    private final Function0<Unit> f41061h;

    /* renamed from: i  reason: collision with root package name */
    private final Color.Attr f41062i;

    public PopupToolbarAppearance(int i8, Text titleText, boolean z7, Text text, Function0<Unit> endActionListener, Color color, Image image, Function0<Unit> onActionIconClicked, Color.Attr attr) {
        Intrinsics.f(titleText, "titleText");
        Intrinsics.f(endActionListener, "endActionListener");
        Intrinsics.f(onActionIconClicked, "onActionIconClicked");
        this.f41054a = i8;
        this.f41055b = titleText;
        this.f41056c = z7;
        this.f41057d = text;
        this.f41058e = endActionListener;
        this.f41059f = color;
        this.f41060g = image;
        this.f41061h = onActionIconClicked;
        this.f41062i = attr;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.ToolbarAppearance
    public void a(Toolbar toolbar, AppCompatActivity host) {
        CharSequence charSequence;
        Intrinsics.f(toolbar, "toolbar");
        Intrinsics.f(host, "host");
        PopupToolbar popupToolbar = (PopupToolbar) toolbar;
        Context context = popupToolbar.getContext();
        popupToolbar.setVisibility(0);
        host.setSupportActionBar(toolbar);
        ActionBar supportActionBar = host.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(true);
        }
        popupToolbar.setBackIcon(this.f41054a);
        popupToolbar.setTitleInCenter(this.f41056c);
        host.setTitle(TextKt.a(this.f41055b, host));
        Text text = this.f41057d;
        if (text != null) {
            Intrinsics.e(context, "context");
            charSequence = TextKt.a(text, context);
        } else {
            charSequence = null;
        }
        popupToolbar.Z(charSequence, this.f41058e);
        Color color = this.f41059f;
        if (color != null) {
            ViewExtKt.b(popupToolbar, color);
        }
        popupToolbar.Y(this.f41060g, this.f41062i, this.f41061h);
    }

    public /* synthetic */ PopupToolbarAppearance(int i8, Text text, boolean z7, Text text2, Function0 function0, Color color, Image image, Function0 function02, Color.Attr attr, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? 1 : i8, text, (i9 & 4) != 0 ? true : z7, (i9 & 8) != 0 ? null : text2, (i9 & 16) != 0 ? new Function0<Unit>() { // from class: eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance.1
            public final void b() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        } : function0, (i9 & 32) != 0 ? null : color, (i9 & 64) != 0 ? null : image, (i9 & 128) != 0 ? new Function0<Unit>() { // from class: eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance.2
            public final void b() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        } : function02, (i9 & Spliterator.NONNULL) != 0 ? null : attr);
    }
}
