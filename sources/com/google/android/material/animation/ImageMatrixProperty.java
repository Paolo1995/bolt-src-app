package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f12729a;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.f12729a = new Matrix();
    }

    @Override // android.util.Property
    @NonNull
    /* renamed from: a */
    public Matrix get(@NonNull ImageView imageView) {
        this.f12729a.set(imageView.getImageMatrix());
        return this.f12729a;
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
