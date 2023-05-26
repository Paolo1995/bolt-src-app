package eu.bolt.driver.core.ui.translation;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatedContext.kt */
/* loaded from: classes5.dex */
public final class TranslatedContext extends ContextWrapper {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f41187b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final TranslatedResources f41188a;

    /* compiled from: TranslatedContext.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Context a(Context baseContext) {
            Intrinsics.f(baseContext, "baseContext");
            return new TranslatedContext(baseContext, null);
        }
    }

    private TranslatedContext(Context context) {
        super(context);
        Resources resources = context.getResources();
        Intrinsics.e(resources, "baseContext.resources");
        this.f41188a = new TranslatedResources(resources);
    }

    public /* synthetic */ TranslatedContext(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final Context a(Context context) {
        return f41187b.a(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.f(name, "name");
        if (Intrinsics.a("layout_inflater", name)) {
            LayoutInflater from = LayoutInflater.from(getBaseContext());
            Intrinsics.e(from, "from(baseContext)");
            return new TranslatedLayoutInflater(from, this, this.f41188a);
        }
        return super.getSystemService(name);
    }
}
