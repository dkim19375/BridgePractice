package me.dkim19375.bridgepractice.func;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.UUID;

public class BridgingRegion {
    private Region boundaries;
    private Region blockEditing;
    private Location spawn;
    private Region end;
    private UUID player;

    public BridgingRegion(Region regionOfBoundary, Region regionOfBlockEditing, Location spawn, Region end, UUID player) {
        boundaries = regionOfBoundary;
        blockEditing = regionOfBlockEditing;
        this.spawn = spawn;
        this.end = end;
        this.player = player;
    }
    
    public Location getPos1OfBoundary() {
        return boundaries.getPos1();
    }

    public Location getPos2OfBoundary() {
        return boundaries.getPos2();
    }

    public Location getPos1OfBlockEditing() {
        return blockEditing.getPos1();
    }

    public Location getPos2OfBlockEditing() {
        return blockEditing.getPos2();
    }
    
    public void setPos1OfBoundary(Location loc) {
        boundaries = new Region(loc, boundaries.getPos2());
    }

    public void setPos2OfBoundary(Location loc) {
        boundaries = new Region(boundaries.getPos1(), loc);
    }

    public void setPos1OfBlockEditing(Location loc) {
        blockEditing = new Region(loc, blockEditing.getPos2());
    }

    public void setPos2OfBlockEditing(Location loc) {
        blockEditing = new Region(blockEditing.getPos1(), loc);
    }

    public void setPositions(Region boundaries, Region blockEditing) {
        this.boundaries = boundaries;
        this.blockEditing = blockEditing;
    }

    public void setPositions(Location pos1OfBoundary, Location pos2OfBoundary, Location pos1OfBlockEditing, Location pos2OfBlockEditing) {
        boundaries = new Region(pos1OfBoundary, pos2OfBoundary);
        blockEditing = new Region(pos1OfBlockEditing, pos2OfBlockEditing);
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public Region getEnd() {
        return end;
    }

    public void setEnd(Region end) {
        this.end = end;
    }
    
    public UUID getPlayer() {
        return player;
    }
    
    public void setPlayer(UUID player) {
        this.player = player;
    }

    public boolean playerAtEnd(UUID player) {
        return end.contains(Bukkit.getPlayer(player).getLocation());
    }

    public boolean playerInBoundary(UUID player) {
        return boundaries.contains(Bukkit.getPlayer(player).getLocation());
    }

    public boolean playerInBlockEditing(UUID player) {
        return blockEditing.contains(Bukkit.getPlayer(player).getLocation());
    }

    @Override
    public String toString() {
        return "{\"boundaries\":" + boundaries + ", \"blockEditing\":" + blockEditing + ", \"spawn\":" + spawn
                + ", \"end\":" + end + ", \"player\":" + player + "}";
    }
}
