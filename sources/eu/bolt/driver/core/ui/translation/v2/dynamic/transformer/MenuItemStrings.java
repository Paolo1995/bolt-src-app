package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AttributeUtils.kt */
/* loaded from: classes5.dex */
public final class MenuItemStrings {

    /* renamed from: a  reason: collision with root package name */
    private int f41261a;

    /* renamed from: b  reason: collision with root package name */
    private int f41262b;

    public MenuItemStrings() {
        this(0, 0, 3, null);
    }

    public MenuItemStrings(int i8, int i9) {
        this.f41261a = i8;
        this.f41262b = i9;
    }

    public final int a() {
        return this.f41261a;
    }

    public final int b() {
        return this.f41262b;
    }

    public final void c(int i8) {
        this.f41261a = i8;
    }

    public final void d(int i8) {
        this.f41262b = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MenuItemStrings) {
            MenuItemStrings menuItemStrings = (MenuItemStrings) obj;
            return this.f41261a == menuItemStrings.f41261a && this.f41262b == menuItemStrings.f41262b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f41261a * 31) + this.f41262b;
    }

    public String toString() {
        int i8 = this.f41261a;
        int i9 = this.f41262b;
        return "MenuItemStrings(title=" + i8 + ", titleCondensed=" + i9 + ")";
    }

    public /* synthetic */ MenuItemStrings(int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0 : i8, (i10 & 2) != 0 ? 0 : i9);
    }
}
