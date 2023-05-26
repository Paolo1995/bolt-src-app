package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes5.dex */
public final class ScreenFloatValueRegEx {

    /* renamed from: a  reason: collision with root package name */
    public static final ScreenFloatValueRegEx f51166a = new ScreenFloatValueRegEx();

    /* renamed from: b  reason: collision with root package name */
    public static final Regex f51167b;

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f51167b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private ScreenFloatValueRegEx() {
    }
}
