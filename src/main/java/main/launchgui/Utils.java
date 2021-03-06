package main.launchgui;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Utils {

	public static boolean isUpdateAvailable() {
		return !ConfigHandler.currentPackVersion.equals(getRemoteVersion());
	}

	public static boolean browse(URI uri) {
		return browseDESKTOP(uri);
	}

	public static String getRemoteVersion() {
		try {
			URL url = new URL(ConfigHandler.updateCheckerURL);
			Scanner scanner = new Scanner(url.openStream());
			return scanner.nextLine();
		} catch (IOException e) {
			LaunchGui.logger.info("Error returned while attempting to check for an update.");
			e.printStackTrace();
		}

		return "";
	}

	private static boolean browseDESKTOP(URI uri) {

		LaunchGui.logger.info("Attempting to open the page at " + uri.toString());
		try {
			if (!Desktop.isDesktopSupported()) {
				LaunchGui.logger.error("Sorry, it appears that your platform is not supported.");
				return false;
			}

			if (!Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				LaunchGui.logger.error("Sorry, it appears that the BROWSE action is not supported.");
				return false;
			}

			Desktop.getDesktop().browse(uri);
			LaunchGui.logger.info("Attempt successful!");
			return true;

		} catch (Throwable throwable) {
			LaunchGui.logger.error("Error using desktop browse.", throwable);
			throwable.printStackTrace();
			return false;
		}
	}
}
