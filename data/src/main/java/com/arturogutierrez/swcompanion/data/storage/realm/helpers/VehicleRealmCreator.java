package com.arturogutierrez.swcompanion.data.storage.realm.helpers;

import com.arturogutierrez.swcompanion.data.storage.realm.model.FilmRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.PeopleRealm;
import com.arturogutierrez.swcompanion.data.storage.realm.model.VehicleRealm;
import com.arturogutierrez.swcompanion.domain.model.Film;
import com.arturogutierrez.swcompanion.domain.model.People;
import com.arturogutierrez.swcompanion.domain.model.Vehicle;
import io.realm.Realm;
import io.realm.RealmList;
import java.util.List;

public class VehicleRealmCreator {

  public VehicleRealm createOrUpdateVehicleRealmFromVehicle(Realm realm, Vehicle vehicle) {
    VehicleRealm vehicleRealm = getOrCreateEmptyVehicleRealm(realm, vehicle.getVehicleId());
    copyPropertiesToVehicleRealm(vehicleRealm, vehicle);
    copyRelationshipsToVehicleRealm(realm, vehicleRealm, vehicle);
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
      vehicleRealm.setName(vehicle.getName());
      vehicleRealm.setModel(vehicle.getModel());
      vehicleRealm.setVehicleClass(vehicle.getVehicleClass());
      vehicleRealm.setManufacturer(vehicle.getManufacturer());
      vehicleRealm.setLength(vehicle.getLength());
      vehicleRealm.setCrewNumber(vehicle.getCrewNumber());
      vehicleRealm.setPassengersNumber(vehicle.getPassengersNumber());
      vehicleRealm.setMediaURL(vehicle.getMediaURL());
      vehicleRealm.setDirty(vehicle.isDirty());
      vehicleRealm.setCreatedAt(vehicle.getCreatedAt());
      vehicleRealm.setUpdatedAt(vehicle.getUpdatedAt());
    }
  }

  private void copyRelationshipsToVehicleRealm(Realm realm, VehicleRealm vehicleRealm,
      Vehicle vehicle) {
    if (vehicle.isDirty()) {
      return;
    }

    copyFilmsRelationshipsToVehicleRealm(realm, vehicleRealm, vehicle.getFilms());
    copyPeopleRelationshipsToVehicleRealm(realm, vehicleRealm, vehicle.getPilots());
  }

  private void copyFilmsRelationshipsToVehicleRealm(Realm realm, VehicleRealm vehicleRealm,
      List<Film> films) {
    FilmRealmCreator filmRealmCreator = new FilmRealmCreator();
    RealmList<FilmRealm> filmRealmList = vehicleRealm.getFilms();
    for (Film film : films) {
      FilmRealm filmRealm = filmRealmCreator.createOrUpdateFilmRealmFromFilm(realm, film);
      filmRealmList.add(filmRealm);
    }
  }

  private void copyPeopleRelationshipsToVehicleRealm(Realm realm, VehicleRealm vehicleRealm,
      List<People> peopleList) {
    PeopleRealmCreator peopleRealmCreator = new PeopleRealmCreator();
    RealmList<PeopleRealm> peopleRealmList = vehicleRealm.getPilots();
    for (People people : peopleList) {
      PeopleRealm peopleRealm =
          peopleRealmCreator.createOrUpdatePeopleRealmFromPeople(realm, people);
      peopleRealmList.add(peopleRealm);
    }
  }
}
