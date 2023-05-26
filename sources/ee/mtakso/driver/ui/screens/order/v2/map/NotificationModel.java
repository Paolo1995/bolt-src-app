package ee.mtakso.driver.ui.screens.order.v2.map;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopNotificationsDelegate.kt */
/* loaded from: classes3.dex */
public final class NotificationModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f32118a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32119b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f32120c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32121d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f32122e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f32123f;

    /* renamed from: g  reason: collision with root package name */
    private final Integer f32124g;

    /* renamed from: h  reason: collision with root package name */
    private final Function0<Unit> f32125h;

    public NotificationModel(String title, String message, Integer num, int i8, boolean z7, boolean z8, Integer num2, Function0<Unit> function0) {
        Intrinsics.f(title, "title");
        Intrinsics.f(message, "message");
        this.f32118a = title;
        this.f32119b = message;
        this.f32120c = num;
        this.f32121d = i8;
        this.f32122e = z7;
        this.f32123f = z8;
        this.f32124g = num2;
        this.f32125h = function0;
    }

    public final Integer a() {
        return this.f32124g;
    }

    public final boolean b() {
        return this.f32122e;
    }

    public final int c() {
        return this.f32121d;
    }

    public final Integer d() {
        return this.f32120c;
    }

    public final String e() {
        return this.f32119b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotificationModel) {
            NotificationModel notificationModel = (NotificationModel) obj;
            return Intrinsics.a(this.f32118a, notificationModel.f32118a) && Intrinsics.a(this.f32119b, notificationModel.f32119b) && Intrinsics.a(this.f32120c, notificationModel.f32120c) && this.f32121d == notificationModel.f32121d && this.f32122e == notificationModel.f32122e && this.f32123f == notificationModel.f32123f && Intrinsics.a(this.f32124g, notificationModel.f32124g) && Intrinsics.a(this.f32125h, notificationModel.f32125h);
        }
        return false;
    }

    public final Function0<Unit> f() {
        return this.f32125h;
    }

    public final boolean g() {
        return this.f32123f;
    }

    public final String h() {
        return this.f32118a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f32118a.hashCode() * 31) + this.f32119b.hashCode()) * 31;
        Integer num = this.f32120c;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.f32121d) * 31;
        boolean z7 = this.f32122e;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        boolean z8 = this.f32123f;
        int i10 = (i9 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        Integer num2 = this.f32124g;
        int hashCode3 = (i10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Function0<Unit> function0 = this.f32125h;
        return hashCode3 + (function0 != null ? function0.hashCode() : 0);
    }

    public String toString() {
        String str = this.f32118a;
        String str2 = this.f32119b;
        Integer num = this.f32120c;
        int i8 = this.f32121d;
        boolean z7 = this.f32122e;
        boolean z8 = this.f32123f;
        Integer num2 = this.f32124g;
        Function0<Unit> function0 = this.f32125h;
        return "NotificationModel(title=" + str + ", message=" + str2 + ", iconRes=" + num + ", duration=" + i8 + ", clickToDismiss=" + z7 + ", swipeToDismiss=" + z8 + ", backgroundRes=" + num2 + ", onDismissListener=" + function0 + ")";
    }

    public /* synthetic */ NotificationModel(String str, String str2, Integer num, int i8, boolean z7, boolean z8, Integer num2, Function0 function0, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i9 & 4) != 0 ? null : num, (i9 & 8) != 0 ? -2 : i8, (i9 & 16) != 0 ? true : z7, (i9 & 32) != 0 ? true : z8, (i9 & 64) != 0 ? null : num2, (i9 & 128) != 0 ? null : function0);
    }
}
