package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CompoundTrimPathContent {

    /* renamed from: a  reason: collision with root package name */
    private final List<TrimPathContent> f9037a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TrimPathContent trimPathContent) {
        this.f9037a.add(trimPathContent);
    }

    public void b(Path path) {
        for (int size = this.f9037a.size() - 1; size >= 0; size--) {
            Utils.b(path, this.f9037a.get(size));
        }
    }
}
