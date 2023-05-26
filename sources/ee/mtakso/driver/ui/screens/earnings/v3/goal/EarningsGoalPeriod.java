package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalPeriod.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalPeriod {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f29194f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f29195a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29196b;

    /* renamed from: c  reason: collision with root package name */
    private final Text f29197c;

    /* renamed from: d  reason: collision with root package name */
    private final Text f29198d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f29199e;

    /* compiled from: EarningsGoalPeriod.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EarningsGoalPeriod(String type, String title, Text editHint, Text editError, boolean z7) {
        Intrinsics.f(type, "type");
        Intrinsics.f(title, "title");
        Intrinsics.f(editHint, "editHint");
        Intrinsics.f(editError, "editError");
        this.f29195a = type;
        this.f29196b = title;
        this.f29197c = editHint;
        this.f29198d = editError;
        this.f29199e = z7;
    }

    public static /* synthetic */ EarningsGoalPeriod b(EarningsGoalPeriod earningsGoalPeriod, String str, String str2, Text text, Text text2, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = earningsGoalPeriod.f29195a;
        }
        if ((i8 & 2) != 0) {
            str2 = earningsGoalPeriod.f29196b;
        }
        String str3 = str2;
        if ((i8 & 4) != 0) {
            text = earningsGoalPeriod.f29197c;
        }
        Text text3 = text;
        if ((i8 & 8) != 0) {
            text2 = earningsGoalPeriod.f29198d;
        }
        Text text4 = text2;
        if ((i8 & 16) != 0) {
            z7 = earningsGoalPeriod.f29199e;
        }
        return earningsGoalPeriod.a(str, str3, text3, text4, z7);
    }

    public final EarningsGoalPeriod a(String type, String title, Text editHint, Text editError, boolean z7) {
        Intrinsics.f(type, "type");
        Intrinsics.f(title, "title");
        Intrinsics.f(editHint, "editHint");
        Intrinsics.f(editError, "editError");
        return new EarningsGoalPeriod(type, title, editHint, editError, z7);
    }

    public final Text c() {
        return this.f29198d;
    }

    public final Text d() {
        return this.f29197c;
    }

    public final String e() {
        return this.f29196b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoalPeriod) {
            EarningsGoalPeriod earningsGoalPeriod = (EarningsGoalPeriod) obj;
            return Intrinsics.a(this.f29195a, earningsGoalPeriod.f29195a) && Intrinsics.a(this.f29196b, earningsGoalPeriod.f29196b) && Intrinsics.a(this.f29197c, earningsGoalPeriod.f29197c) && Intrinsics.a(this.f29198d, earningsGoalPeriod.f29198d) && this.f29199e == earningsGoalPeriod.f29199e;
        }
        return false;
    }

    public final String f() {
        return this.f29195a;
    }

    public final boolean g() {
        return this.f29199e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.f29195a.hashCode() * 31) + this.f29196b.hashCode()) * 31) + this.f29197c.hashCode()) * 31) + this.f29198d.hashCode()) * 31;
        boolean z7 = this.f29199e;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f29195a;
        String str2 = this.f29196b;
        Text text = this.f29197c;
        Text text2 = this.f29198d;
        boolean z7 = this.f29199e;
        return "EarningsGoalPeriod(type=" + str + ", title=" + str2 + ", editHint=" + text + ", editError=" + text2 + ", isSelected=" + z7 + ")";
    }
}
