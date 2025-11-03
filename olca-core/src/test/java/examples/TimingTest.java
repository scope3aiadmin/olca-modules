package examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TimingTest {

	public static void main(String[] args) {
		System.out.println("Testing native configuration JSON file reading...");
        long startTime = System.nanoTime();
		
		try {
			var configFile = new File(System.getProperty("user.home") + "/openLCA-data-1.4/olca-native/0.0.1/arm64/olca-native.json");
			System.out.println("Looking for config file at: " + configFile.getAbsolutePath());
			
			if (configFile.exists()) {
				var content = Files.readString(configFile.toPath());
				System.out.println("SUCCESS: Found and read native config file");
				System.out.println("Native config content:");
				System.out.println(content);
			} else {
				System.out.println("WARNING: Config file does not exist at expected location");
			}
		} catch (IOException e) {
			System.err.println("ERROR: Could not read native config file: " + e.getMessage());
		}

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;
        System.out.println("Test completed in " + durationMs + " ms");
		
		System.out.println("Test completed!");
	}
}
