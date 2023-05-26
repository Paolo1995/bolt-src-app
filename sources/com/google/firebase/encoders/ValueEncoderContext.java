package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext e(String str) throws IOException;

    @NonNull
    ValueEncoderContext g(boolean z7) throws IOException;
}
