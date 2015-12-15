package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.VehicleRealm;
import com.arturogutierrez.swcompanion.domain.model.Vehicle;
import io.realm.Realm;

public class VehicleRealmCreator {

  public VehicleRealm createOrUpdateVehicleRealmFromVehicle(Realm realm, Vehicle vehicle) {
    VehicleRealm vehicleRealm = getOrCreateEmptyVehicleRealm(realm, vehicle.getVehicleId());
    copyPropertiesToVehicleRealm(vehicleRealm, vehicle);
    copyRelationshipsToVehicleRealm(vehicleRealm, vehicle);
    return vehicleRealm;
  }

  private VehicleRealm getOrCreateEmptyVehicleRealm(Realm realm, String vehicleId) {
    VehicleRealm vehicleRealm =
        realm.where(VehicleRealm.class).equalTo("vehicleId", vehicleId).findFirst();
    if (vehicleRealm == null) {
      vehicleRealm = realm.createObject(VehicleRealm.class);
      vehicleRealm.setDirty(true);
    }
    return vehicleRealm;
  }

  private void copyPropertiesToVehicleRealm(VehicleRealm vehicleRealm, Vehicle vehicle) {
    vehicleRealm.setVehicleId(vehicle.getVehicleId());

    if (!vehicle.isDirty()) {
      // TODO:
    }
  }

  private void copyRelationshipsToVehicleRealm(VehicleRealm vehicleRealm, Vehicle vehicle) {
    if (vehicle.isDirty()) {
      return;
    }

    // TODO:
  }
}
