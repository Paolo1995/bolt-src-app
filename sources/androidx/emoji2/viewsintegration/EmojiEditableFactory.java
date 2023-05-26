package androidx.emoji2.viewsintegration;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.emoji2.text.SpannableBuilder;

/* loaded from: classes.dex */
final class EmojiEditableFactory extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f6528a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile Editable.Factory f6529b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f6530c;

    @SuppressLint({"PrivateApi"})
    private EmojiEditableFactory() {
        try {
            f6530c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f6529b == null) {
            synchronized (f6528a) {
                if (f6529b == null) {
                    f6529b = new EmojiEditableFactory();
                }
            }
        }
        return f6529b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@NonNull CharSequence charSequence) {
        Class<?> cls = f6530c;
        if (cls != null) {
            return SpannableBuilder.c(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
