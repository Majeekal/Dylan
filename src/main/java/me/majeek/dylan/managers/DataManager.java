package me.majeek.dylan.managers;

import me.majeek.dylan.Dylan;
import me.majeek.dylan.data.PlaneData;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.UUID;

public class DataManager {
    private Dylan instance;

    private HashMap<UUID, Entity> entityData = new HashMap<>();
    private HashMap<UUID, PlaneData> planeData = new HashMap<>();

    public DataManager(Dylan instance){
        this.instance = instance;
    }

    public HashMap<UUID, Entity> getEntityData() {
        return entityData;
    }

    public void setEntityData(HashMap<UUID, Entity> data) {
        this.entityData = data;
    }

    public void addEntityData(UUID uuid, Entity entity){
        entityData.putIfAbsent(uuid, entity);
    }

    public void removeEntityData(UUID uuid){
        entityData.remove(uuid);
    }

    public HashMap<UUID, PlaneData> getPlaneData() {
        return planeData;
    }

    public void setPlaneData(HashMap<UUID, PlaneData> data) {
        this.planeData = data;
    }

    public void addPlaneData(UUID uuid, PlaneData data){
        planeData.putIfAbsent(uuid, data);
    }

    public void removePlaneData(UUID uuid){
        planeData.remove(uuid);
    }
}
