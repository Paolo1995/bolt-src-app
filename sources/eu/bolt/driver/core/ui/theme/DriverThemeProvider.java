package eu.bolt.driver.core.ui.theme;

import eu.bolt.driver.core.theme.Theme;
import eu.bolt.driver.core.theme.ThemeManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverThemeProvider.kt */
/* loaded from: classes5.dex */
public final class DriverThemeProvider implements ThemeProvider {

    /* renamed from: a  reason: collision with root package name */
    private final ThemeManager f41182a;

    @Inject
    public DriverThemeProvider(ThemeManager themeManager) {
        Intrinsics.f(themeManager, "themeManager");
        this.f41182a = themeManager;
    }

    @Override // eu.bolt.driver.core.ui.theme.ThemeProvider
    public Theme a() {
        return this.f41182a.a();
    }
}
