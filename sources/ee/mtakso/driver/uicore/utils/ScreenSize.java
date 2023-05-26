package ee.mtakso.driver.uicore.utils;

/* compiled from: ScreenSize.kt */
/* loaded from: classes5.dex */
public final class ScreenSize {

    /* renamed from: a  reason: collision with root package name */
    private final int f35735a;

    /* renamed from: b  reason: collision with root package name */
    private final int f35736b;

    public ScreenSize(int i8, int i9) {
        this.f35735a = i8;
        this.f35736b = i9;
    }

    public final int a() {
        return this.f35736b;
    }

    public final int b() {
        return this.f35735a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScreenSize) {
            ScreenSize screenSize = (ScreenSize) obj;
            return this.f35735a == screenSize.f35735a && this.f35736b == screenSize.f35736b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f35735a * 31) + this.f35736b;
    }

    public String toString() {
        int i8 = this.f35735a;
        int i9 = this.f35736b;
        return "ScreenSize(width=" + i8 + ", height=" + i9 + ")";
    }
}
