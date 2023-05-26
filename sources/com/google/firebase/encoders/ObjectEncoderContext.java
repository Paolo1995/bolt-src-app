package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext a(@NonNull FieldDescriptor fieldDescriptor, boolean z7) throws IOException;

    @NonNull
    ObjectEncoderContext b(@NonNull FieldDescriptor fieldDescriptor, long j8) throws IOException;

    @NonNull
    ObjectEncoderContext c(@NonNull FieldDescriptor fieldDescriptor, int i8) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext d(@NonNull String str, int i8) throws IOException;

    @NonNull
    ObjectEncoderContext f(@NonNull FieldDescriptor fieldDescriptor, Object obj) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext h(@NonNull String str, Object obj) throws IOException;
}
