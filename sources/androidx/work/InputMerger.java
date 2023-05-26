package androidx.work;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
public abstract class InputMerger {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8279a = Logger.f("InputMerger");

    public static InputMerger a(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e8) {
            Logger c8 = Logger.c();
            String str2 = f8279a;
            c8.b(str2, "Trouble instantiating + " + str, e8);
            return null;
        }
    }

    @NonNull
    public abstract Data b(@NonNull List<Data> list);
}
