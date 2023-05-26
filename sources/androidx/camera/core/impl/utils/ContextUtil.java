package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ContextUtil {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        static Context a(@NonNull Context context, String str) {
            Context createAttributionContext;
            createAttributionContext = context.createAttributionContext(str);
            return createAttributionContext;
        }

        static String b(@NonNull Context context) {
            String attributionTag;
            attributionTag = context.getAttributionTag();
            return attributionTag;
        }
    }

    private ContextUtil() {
    }

    @NonNull
    public static Context a(@NonNull Context context) {
        String b8;
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 30 && (b8 = Api30Impl.b(context)) != null) {
            return Api30Impl.a(applicationContext, b8);
        }
        return applicationContext;
    }

    public static Application b(@NonNull Context context) {
        for (Context a8 = a(context); a8 instanceof ContextWrapper; a8 = c((ContextWrapper) a8)) {
            if (a8 instanceof Application) {
                return (Application) a8;
            }
        }
        return null;
    }

    @NonNull
    public static Context c(@NonNull ContextWrapper contextWrapper) {
        String b8;
        Context baseContext = contextWrapper.getBaseContext();
        if (Build.VERSION.SDK_INT >= 30 && (b8 = Api30Impl.b(contextWrapper)) != null) {
            return Api30Impl.a(baseContext, b8);
        }
        return baseContext;
    }
}
