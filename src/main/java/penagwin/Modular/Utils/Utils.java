package penagwin.Modular.Utils;

/**
 * Created by Penagwin on 12/29/2014.
 */
public class Utils {
    public static Boolean XOR(Boolean base, Boolean second){
        return ((base && !second) || (!base && second));
    }
}
