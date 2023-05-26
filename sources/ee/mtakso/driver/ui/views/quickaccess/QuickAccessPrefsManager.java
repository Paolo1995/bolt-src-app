package ee.mtakso.driver.ui.views.quickaccess;

import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.field.IntSettingsField;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessPrefsManager.kt */
/* loaded from: classes5.dex */
public final class QuickAccessPrefsManager {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f34486c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f34487a;

    /* renamed from: b  reason: collision with root package name */
    private final IntSettingsField f34488b;

    /* compiled from: QuickAccessPrefsManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public QuickAccessPrefsManager(final DriverProvider prefs) {
        Lazy b8;
        Intrinsics.f(prefs, "prefs");
        b8 = LazyKt__LazyJVMKt.b(new Function0<BoltPrefsStorage>() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessPrefsManager$prefsStorage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BoltPrefsStorage invoke() {
                return DriverProvider.this.s();
            }
        });
        this.f34487a = b8;
        this.f34488b = new IntSettingsField("WAITING_TOOLTIP_SHOW_COUNT", 3, a());
    }

    private final BoltPrefsStorage a() {
        return (BoltPrefsStorage) this.f34487a.getValue();
    }

    public final IntSettingsField b() {
        return this.f34488b;
    }
}
