package preprocessor;

public class PreProcessorToLower implements PreProcessor {
    @Override
    public String preprocess(String message) {
        return message.toLowerCase();
    }
}
