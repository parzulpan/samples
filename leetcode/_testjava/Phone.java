package _testjava;

public class Phone {
    public static void main(String[] args) {
        System.out.println(standardizedPhoneNumber(" 13261427436"));
        System.out.println(standardizedPhoneNumber("+ 13261427436"));
        System.out.println(standardizedPhoneNumber("+132 61427436"));
        System.out.println(standardizedPhoneNumber("CN,+86,15210821277"));
    }

    public static String standardizedPhoneNumber(String phoneNumber) {

        return phoneNumber.replaceAll("\\D", "");
    }
}
