package car.rent;

import org.apache.commons.codec.digest.DigestUtils;

public class App2 {
    public static void main(String[] args) {


        System.out.println(DigestUtils.md5Hex("admin123"));
        System.out.println(DigestUtils.md5Hex("janusz123"));

    }


}
