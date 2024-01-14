package de.dylogix.skywars.methods;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import de.dylogix.skywars.main.Main;

// taken from https://github.com/mnzasa-files/mapreset/

public class MapresetHandler implements Listener {
	
	public MapresetHandler(de.dylogix.skywars.main.Main Main) {
		MapresetHandler.pl = Main;
	}

	private static de.dylogix.skywars.main.Main pl;

    private static final long COOLDOWN_SECONDS = 3;
    public static boolean resetInProgress;
	
	public static void runMapreset() {
        File mapsFolder = new File(pl.getDataFolder(), "maps");
        File[] worldFolders = mapsFolder.listFiles();

        if (worldFolders == null || worldFolders.length == 0) {
            Bukkit.getConsoleSender().sendMessage("§c[SkyWars] No world folder found in the 'maps' directory. Please add your world folder to the 'maps' directory located in the plugin's data folder.");
            return;
        }
        
        Bukkit.getConsoleSender().sendMessage("§c[SkyWars] Resetting the map...");

        new BukkitRunnable() {
            private int secondsLeft = (int) COOLDOWN_SECONDS;

            @Override
            public void run() {
                if (secondsLeft > 0) {
                    Bukkit.getConsoleSender().sendMessage("§c[SkyWars] Map reset in " + secondsLeft + " seconds...");
                    secondsLeft--;
                } else {
                    resetMap();
                    resetInProgress = false;
                    Bukkit.getConsoleSender().sendMessage("§c[SkyWars] Map reset complete!");
                    restartServer();
                    cancel(); // Cancel the task after the cooldown is finished
                }
            }
        }.runTaskTimer(pl, 0, 20); // Run the task every second (20 ticks)
        resetInProgress = true;
        return;
	}
	
    private static void resetMap() {
        File worldFolder = new File(pl.getServer().getWorldContainer(), Main.cfg.getString("config.mapfolder"));
        File mapsFolder = new File(pl.getDataFolder(), "maps");
        File[] worldFolders = mapsFolder.listFiles();

        if (worldFolders != null && worldFolders.length > 0) {
            File userWorldFolder = worldFolders[0];

            // Delete the existing "world" folder
            deleteDirectory(worldFolder);

            // Copy the user's world folder to replace the "world" folder
            try {
                copyDirectory(userWorldFolder, worldFolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void restartServer() {
        pl.getServer().shutdown();
    }

    private static void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
            directory.delete();
        }
    }

    private static void copyDirectory(File sourceDirectory, File destinationDirectory) throws IOException {
        Files.walk(sourceDirectory.toPath())
                .forEach(source -> {
                    try {
                        Files.copy(source, destinationDirectory.toPath().resolve(sourceDirectory.toPath().relativize(source)),
                                StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}