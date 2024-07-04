package utility;

public class ExtractLanguage {
	public static String extractLanguageFromHref(String href) {
		// Extract the language from the URL
		String[] parts = href.split("/");
		if (parts.length > 2) {
			return parts[parts.length - 1];
		} else {
			return null;
		}
	}
}
