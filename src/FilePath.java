public class FilePath {

    public String filePathForEncoded(String path){
        StringBuilder build = new StringBuilder(path);
        int length = build.length();
        return String.valueOf(build.insert(length-4,"_encoded"));
    }
    public String filePathForDecoded(String path){
        StringBuilder build = new StringBuilder(path);
        int length = build.length();
        return String.valueOf(build.insert(length-4,"_decoded"));
    }

    public String filePathForBruteForce(String path){
        StringBuilder build = new StringBuilder(path);
        int length = build.length();
        return String.valueOf(build.insert(length-4,"_bruteforce"));
    }
}
