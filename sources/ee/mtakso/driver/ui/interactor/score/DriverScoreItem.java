package ee.mtakso.driver.ui.interactor.score;

import ee.mtakso.driver.network.client.score.DriverScoreLabel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreItem.kt */
/* loaded from: classes3.dex */
public final class DriverScoreItem {

    /* renamed from: a  reason: collision with root package name */
    private final String f26842a;

    /* renamed from: b  reason: collision with root package name */
    private final double f26843b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26844c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverScoreLabel f26845d;

    public DriverScoreItem(String formattedScore, double d8, boolean z7, DriverScoreLabel driverScoreLabel) {
        Intrinsics.f(formattedScore, "formattedScore");
        this.f26842a = formattedScore;
        this.f26843b = d8;
        this.f26844c = z7;
        this.f26845d = driverScoreLabel;
    }

    public final String a() {
        return this.f26842a;
    }

    public final DriverScoreLabel b() {
        return this.f26845d;
    }

    public final boolean c() {
        return this.f26844c;
    }

    public final double d() {
        return this.f26843b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverScoreItem) {
            DriverScoreItem driverScoreItem = (DriverScoreItem) obj;
            return Intrinsics.a(this.f26842a, driverScoreItem.f26842a) && Double.compare(this.f26843b, driverScoreItem.f26843b) == 0 && this.f26844c == driverScoreItem.f26844c && Intrinsics.a(this.f26845d, driverScoreItem.f26845d);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f26842a.hashCode() * 31) + q1.a.a(this.f26843b)) * 31;
        boolean z7 = this.f26844c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        DriverScoreLabel driverScoreLabel = this.f26845d;
        return i9 + (driverScoreLabel == null ? 0 : driverScoreLabel.hashCode());
    }

    public String toString() {
        String str = this.f26842a;
        double d8 = this.f26843b;
        boolean z7 = this.f26844c;
        DriverScoreLabel driverScoreLabel = this.f26845d;
        return "DriverScoreItem(formattedScore=" + str + ", score=" + d8 + ", new=" + z7 + ", label=" + driverScoreLabel + ")";
    }
}
