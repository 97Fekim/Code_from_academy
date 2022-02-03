package Interface_excercise;

public interface I4 {
    private static String getPrefic(String p){
        return p.equals("male") ? "Mr. " : "Ms. ";
    }

    public static String getName(String n, String p){
        return getPrefic(p) + n;
    }

}
