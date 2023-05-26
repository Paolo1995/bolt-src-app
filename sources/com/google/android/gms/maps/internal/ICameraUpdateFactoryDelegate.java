package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public interface ICameraUpdateFactoryDelegate extends IInterface {
    @NonNull
    IObjectWrapper newCameraPosition(@NonNull CameraPosition cameraPosition) throws RemoteException;

    @NonNull
    IObjectWrapper newLatLng(@NonNull LatLng latLng) throws RemoteException;

    @NonNull
    IObjectWrapper newLatLngBounds(@NonNull LatLngBounds latLngBounds, int i8) throws RemoteException;

    @NonNull
    IObjectWrapper newLatLngBoundsWithSize(@NonNull LatLngBounds latLngBounds, int i8, int i9, int i10) throws RemoteException;

    @NonNull
    IObjectWrapper newLatLngZoom(@NonNull LatLng latLng, float f8) throws RemoteException;

    @NonNull
    IObjectWrapper scrollBy(float f8, float f9) throws RemoteException;

    @NonNull
    IObjectWrapper zoomBy(float f8) throws RemoteException;

    @NonNull
    IObjectWrapper zoomByWithFocus(float f8, int i8, int i9) throws RemoteException;

    @NonNull
    IObjectWrapper zoomIn() throws RemoteException;

    @NonNull
    IObjectWrapper zoomOut() throws RemoteException;

    @NonNull
    IObjectWrapper zoomTo(float f8) throws RemoteException;
}
