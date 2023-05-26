package androidx.emoji.widget;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class EmojiEditableFactory extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f6396a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile Editable.Factory f6397b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f6398c;

    @SuppressLint({"PrivateApi"})
    private EmojiEditableFactory() {
        try {
            f6398c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f6397b == null) {
            synchronized (f6396a) {
                if (f6397b == null) {
                    f6397b = new EmojiEditableFactory();
                }
            }
        }
        return f6397b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@NonNull CharSequence charSequence) {
        Class<?> cls = f6398c;
        if (cls != null) {
            return SpannableBuilder.c(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
