package androidx.work;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class InputMergerFactory {
    @NonNull
    public static InputMergerFactory c() {
        return new InputMergerFactory() { // from class: androidx.work.InputMergerFactory.1
            @Override // androidx.work.InputMergerFactory
            public InputMerger a(@NonNull String str) {
                return null;
            }
        };
    }

    public abstract InputMerger a(@NonNull String str);

    public final InputMerger b(@NonNull String str) {
        InputMerger a8 = a(str);
        if (a8 == null) {
            return InputMerger.a(str);
        }
        return a8;
    }
}
