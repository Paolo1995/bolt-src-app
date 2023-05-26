package eu.bolt.driver.core.ui.common.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoToolbarAppearance.kt */
/* loaded from: classes5.dex */
public final class NoToolbarAppearance implements ToolbarAppearance {
    @Override // eu.bolt.driver.core.ui.common.activity.ToolbarAppearance
    public void a(Toolbar toolbar, AppCompatActivity host) {
        Intrinsics.f(toolbar, "toolbar");
        Intrinsics.f(host, "host");
        toolbar.setVisibility(8);
    }
}
