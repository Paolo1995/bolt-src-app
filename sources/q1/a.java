package q1;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ int a(double d8) {
        long doubleToLongBits = Double.doubleToLongBits(d8);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
