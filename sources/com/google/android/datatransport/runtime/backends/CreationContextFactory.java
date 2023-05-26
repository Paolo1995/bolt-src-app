package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Inject;

/* loaded from: classes.dex */
class CreationContextFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12139a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f12140b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f12141c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public CreationContextFactory(Context context, Clock clock, Clock clock2) {
        this.f12139a = context;
        this.f12140b = clock;
        this.f12141c = clock2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreationContext a(String str) {
        return CreationContext.a(this.f12139a, this.f12140b, this.f12141c, str);
    }
}
