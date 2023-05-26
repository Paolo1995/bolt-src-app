package ee.mtakso.driver.ui.common.generictreeviewstate;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.ValueMark;
import ee.mtakso.driver.network.client.generic.ValueStyle;
import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.StringUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericViewStateItem.kt */
/* loaded from: classes3.dex */
public final class GenericViewStateItem implements GenericViewState {

    /* renamed from: a  reason: collision with root package name */
    private final GenericViewState.Divider f26345a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f26346b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26347c;

    /* renamed from: d  reason: collision with root package name */
    private final String f26348d;

    /* renamed from: e  reason: collision with root package name */
    private final String f26349e;

    /* renamed from: f  reason: collision with root package name */
    private final String f26350f;

    /* renamed from: g  reason: collision with root package name */
    private final ValueStyle f26351g;

    /* renamed from: h  reason: collision with root package name */
    private final ValueMark f26352h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f26353i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f26354j;

    public GenericViewStateItem(GenericViewState.Divider divider, boolean z7, String titleText, String str, String str2, String valueText, ValueStyle valueStyle, ValueMark valueMark, boolean z8) {
        Intrinsics.f(titleText, "titleText");
        Intrinsics.f(valueText, "valueText");
        Intrinsics.f(valueStyle, "valueStyle");
        Intrinsics.f(valueMark, "valueMark");
        this.f26345a = divider;
        this.f26346b = z7;
        this.f26347c = titleText;
        this.f26348d = str;
        this.f26349e = str2;
        this.f26350f = valueText;
        this.f26351g = valueStyle;
        this.f26352h = valueMark;
        this.f26353i = z8;
        this.f26354j = true;
    }

    private final Color.Attr e(int i8) {
        if (i8 == 0) {
            return new Color.Attr(R.attr.contentPrimary);
        }
        return new Color.Attr(R.attr.contentSecondary);
    }

    private final int f(int i8) {
        return i8 == 0 ? R.dimen.text_size_16 : R.dimen.text_size_14;
    }

    private final GenericItemDelegate.PopupInfo g() {
        CharSequence charSequence;
        boolean z7;
        boolean z8;
        String str = this.f26348d;
        if (str != null) {
            charSequence = StringUtilsKt.a(str);
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                String str2 = this.f26347c;
                String str3 = this.f26350f;
                int b8 = GenericViewStateItemKt.b(this.f26352h);
                if (this.f26353i) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                return new GenericItemDelegate.PopupInfo(str2, str3, b8, charSequence, null, z8, 16, null);
            }
        }
        return null;
    }

    private final GenericItemDelegate.ChevronState h(int i8) {
        boolean z7;
        if (i8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return null;
        }
        if (d()) {
            return GenericItemDelegate.ChevronState.COLLAPSED;
        }
        return GenericItemDelegate.ChevronState.OPENED;
    }

    @Override // ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState
    public boolean a() {
        return this.f26346b;
    }

    @Override // ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState
    public ListModel b(String id, int i8, int i9) {
        Text.Value value;
        boolean z7;
        boolean z8;
        boolean z9;
        Color color;
        Float f8;
        CharSequence a8;
        Intrinsics.f(id, "id");
        Text.Value value2 = new Text.Value(this.f26347c);
        int f9 = f(i8);
        Color.Attr e8 = e(i8);
        Text.Value value3 = new Text.Value(this.f26350f);
        GenericItemDelegate.PopupInfo g8 = g();
        int f10 = f(i8);
        Color.Attr a9 = GenericViewStateItemKt.a(this.f26352h);
        GenericItemDelegate.TextStyle c8 = GenericViewStateItemKt.c(this.f26351g);
        String str = this.f26349e;
        if (str != null && (a8 = StringUtilsKt.a(str)) != null) {
            value = new Text.Value(a8);
        } else {
            value = null;
        }
        Color.Attr attr = new Color.Attr(R.attr.backPrimary);
        GenericItemDelegate.ChevronState h8 = h(i9);
        if (i() != null && (i().f() || d())) {
            z7 = true;
        } else {
            z7 = false;
        }
        GenericViewState.Divider i10 = i();
        if (i10 != null) {
            z8 = i10.h();
        } else {
            z8 = false;
        }
        GenericViewState.Divider i11 = i();
        if (i11 != null) {
            z9 = i11.h();
        } else {
            z9 = false;
        }
        GenericViewState.Divider i12 = i();
        if (i12 != null) {
            color = i12.c();
        } else {
            color = null;
        }
        Color.Res res = new Color.Res(R.color.transparent);
        GenericViewState.Divider i13 = i();
        if (i13 != null) {
            f8 = Float.valueOf(i13.e());
        } else {
            f8 = null;
        }
        return new GenericItemDelegate.Model(id, value2, f9, e8, value3, f10, a9, attr, value, h8, c8, g8, i8, z7, z8, z9, color, res, f8);
    }

    @Override // ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState
    public void c(boolean z7) {
        this.f26354j = z7;
    }

    @Override // ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState
    public boolean d() {
        return this.f26354j;
    }

    public GenericViewState.Divider i() {
        return this.f26345a;
    }

    public /* synthetic */ GenericViewStateItem(GenericViewState.Divider divider, boolean z7, String str, String str2, String str3, String str4, ValueStyle valueStyle, ValueMark valueMark, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : divider, (i8 & 2) != 0 ? true : z7, str, str2, str3, str4, valueStyle, valueMark, z8);
    }
}
