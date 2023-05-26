package eu.bolt.driver.core.ui.translation.v2.dynamic;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicTranslatedContext.kt */
/* loaded from: classes5.dex */
public final class DynamicTranslatedContext extends ContextWrapper {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f41243b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DynamicTranslatedResources f41244a;

    /* compiled from: DynamicTranslatedContext.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Context a(Context base) {
            Intrinsics.f(base, "base");
            return new DynamicTranslatedContext(base);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicTranslatedContext(Context base) {
        super(base);
        Intrinsics.f(base, "base");
        Resources resources = base.getResources();
        Intrinsics.e(resources, "base.resources");
        this.f41244a = new DynamicTranslatedResources(resources);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.f(name, "name");
        if (Intrinsics.a("layout_inflater", name)) {
            LayoutInflater from = LayoutInflater.from(getBaseContext());
            Intrinsics.e(from, "from(baseContext)");
            return new DynamicTranslatedLayoutInflater(from, this, this.f41244a);
        }
        return super.getSystemService(name);
    }
}
