package j$.time;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class b {
    public static StringBuilder a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static /* synthetic */ String b(int i8) {
        return i8 == 1 ? "REFERENCE" : i8 == 2 ? "INT_VALUE" : i8 == 3 ? "LONG_VALUE" : i8 == 4 ? "DOUBLE_VALUE" : "null";
    }
}
